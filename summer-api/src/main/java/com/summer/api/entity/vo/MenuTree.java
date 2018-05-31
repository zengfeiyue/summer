package com.summer.api.entity.vo;

import java.util.List;

/**
 * 菜单bean
 * @author zengfeiyue
 */
public class MenuTree {
    /**
     * 菜单路径
     */
    private String path;
    /**
     * 菜单icon
     */
    private String icon;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单title
     */
    private String title;
    /**
     * children list
     */
    private List<MenuTree> children;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }
}
