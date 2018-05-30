package com.test.summer.gateway.controller;

import com.test.summer.gateway.entity.sys.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 基类controller
 * @author zengfeiyue
 */
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    /**
     * request
     */
    protected HttpServletRequest request;
    /**
     * response
     */
    protected HttpServletResponse response;

    /**
     * 初始化request response
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request,HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 获取登录用户
     * @return
     */
    @ModelAttribute
    public SysUser getUser() {
        return (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
