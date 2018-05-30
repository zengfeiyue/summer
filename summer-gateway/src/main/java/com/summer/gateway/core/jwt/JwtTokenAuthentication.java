package com.summer.gateway.core.jwt;
import com.alibaba.fastjson.JSON;
import com.summer.gateway.core.base.ResponseBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * JwtTokenAuthentication token授权类
 * @author zengfeiyue
 */
public class JwtTokenAuthentication {
    /**
     * 5天
     */
    static final long EXPIR_ATION_TIME = 432_000_000;
    /**
     * JWT密码
     */
    static final String SECRET = "P@ssw02d";
    /**
     * Token前缀
     */
    static final String TOKEN_PREFIX = "Bearer";
    /**
     * 存放Token的Header Key
     */
    static final String HEADER_STRING = "Authorization";

    /**
     * JWT生成方法
     * @param response
     * @param username
     */
    public static void getJwtToken(HttpServletResponse response, String username,List<GrantedAuthority> grantedAuthorities) {

        // 生成JWT
        String JWT = Jwts.builder()
                // 保存权限（角色）
                .claim("authorities", grantedAuthorities)
                // 用户名写入标题
                .setSubject(username)
                // 有效期设置
                .setExpiration(new Date(System.currentTimeMillis() + EXPIR_ATION_TIME))
                // 签名设置
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        // 将 JWT 写入 body
        try {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getOutputStream().println(JSON.toJSONString(new ResponseBean(HttpServletResponse.SC_OK,"ok",JWT)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * JWT生成方法
     * @param username
     */
    public static String getJwtToken(String username,Authentication auth) {
        // 生成JWT
        String JwtToken = Jwts.builder()
                // 保存权限（角色）
                .claim("authorities", auth.getPrincipal())
                // 用户名写入标题
                .setSubject(username)
                // 有效期设置
                .setExpiration(new Date(System.currentTimeMillis() + EXPIR_ATION_TIME))
                // 签名设置
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return JwtToken;
    }

    /**
     * JWT验证方法
     * @param request
     * @return
     */
    public static Authentication getAuthentication(HttpServletRequest request) {
        // 从Header中拿到token
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // 解析 Token
            Claims claims = Jwts.parser()
                    // 验签
                    .setSigningKey(SECRET)
                    // 去掉 Bearer
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            // 拿用户名
            String user = claims.getSubject();
            // 得到 权限（角色）
            //ArrayList<UrlGrantedAuthority> authorities = JSON.parseObject(JSON.toJSONString(claims.get("authorities")), new TypeReference<ArrayList<UrlGrantedAuthority>>() {});

            List<GrantedAuthority> authorities =  AuthorityUtils.createAuthorityList(JSON.toJSONString(claims.get("authorities")));
            // 返回验证令牌
            return user != null ? new UsernamePasswordAuthenticationToken(user, null, authorities) : null;
        }
        return null;
    }
}
