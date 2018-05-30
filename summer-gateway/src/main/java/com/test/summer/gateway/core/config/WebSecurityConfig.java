package com.test.summer.gateway.core.config;

import com.test.summer.gateway.core.filter.jwt.JwtAuthenticationFilter;
import com.test.summer.gateway.core.filter.jwt.JwtLoginFilter;
import com.test.summer.gateway.core.security.AuthenticationSuccessHandlerImpl;
import com.test.summer.gateway.core.security.UrlUserService;
import com.test.summer.gateway.core.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

/**
 *
 *
 * @author zengfeiyue
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UrlUserService urlUserService;

    @Autowired
    SessionRegistry sessionRegistry;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                /*放行的路径*/
                .antMatchers("/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/test","/test1").permitAll()
                /*其他路径都要鉴权*/
                .anyRequest().authenticated()
                //允许跨域
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .and()
                //无状态session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin()
                //指定登录页是"/login"
                .loginPage("/login")
                .successHandler(new AuthenticationSuccessHandlerImpl())
                .permitAll()
                .and()
                .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                // 添加一个过滤器验证其他请求的Token是否合法
                .addFilterBefore(new JwtAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(urlUserService).passwordEncoder(new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String) rawPassword));
            }
        });
    }

    @Bean
    public SessionRegistry getSessionRegistry(){
        SessionRegistry sessionRegistry=new SessionRegistryImpl();
        return sessionRegistry;
    }

}