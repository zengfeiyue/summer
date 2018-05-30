package com.test.summer.gateway.core.security;

import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author zengfeiyue
 * @date 17/2/15
 */
public class UrlConfigAttribute implements ConfigAttribute {

    private final HttpServletRequest httpServletRequest;

    public UrlConfigAttribute(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }


    @Override
    public String getAttribute() {
        return null;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }
}