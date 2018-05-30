package com.test.summer.gateway.entity.security;

/**
 *
 * @author zengfeiyue
 */
public class SysPermission {
    private Integer id;
    private String name;
    private String url;
    private String method;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", name=" + name +
                ", url=" + url +
                ", method=" + method +
                ", description=" + description +
                '}';
    }
}