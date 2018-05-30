package com.test.summer.gateway.core.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Created by zengfeiyue on 17/2/15.
 */
public class UrlGrantedAuthority implements GrantedAuthority {

    private String url;
    private String method;

    public UrlGrantedAuthority(String url,String method){
        this.url = url;
        this.method = method;
    }
    public UrlGrantedAuthority(){

    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getAuthority() {
        return this.url + ";"+this.method;
    }
}
