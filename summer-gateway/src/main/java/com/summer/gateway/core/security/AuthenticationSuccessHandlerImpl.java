package com.summer.gateway.core.security;

import com.alibaba.fastjson.JSON;
import com.summer.gateway.core.base.ResponseBean;
import com.summer.gateway.entity.sys.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

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
        //用户信息
        SysUser user= (SysUser) authentication.getPrincipal();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(2000);
        responseBean.setMsg("");
        //登录token 个人信息
        HashMap map = new HashMap(2);
        map.put("token",token);
        map.put("principal",user);
        responseBean.setData(map);
        response.getWriter().write(JSON.toJSONString(responseBean));
    }

}
