package com.summer.school.api.model;

import com.summer.common.base.model.BaseModel;

/**
 * 请求cos token
 */
public class CosSecurityToken extends BaseModel {

    private String method;
    private String path;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
