package com.test.summer.admin.core.security;

import com.alibaba.fastjson.JSON;
import com.test.summer.admin.core.base.ResponseBean;
import com.test.summer.admin.entity.sys.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录成功处理器
 * @author zengfeiyue
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String token = (String) request.getAttribute("token");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(2000);
        responseBean.setMsg(token);
        //user
        SysUser user= (SysUser) authentication.getPrincipal();
        responseBean.setData(user);
        response.getWriter().write(JSON.toJSONString(responseBean));
    }

}
