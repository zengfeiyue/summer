package com.summer.school.api.model;

import com.summer.common.base.model.BaseModel;

/**
 * 请求cos token
 */
public class CosSecurityToken extends BaseModel {

    private String type;
    private String path;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
