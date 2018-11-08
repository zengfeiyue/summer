package com.summer.gateway.core.base.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 分页查找模型
 * @author zengfeiyue
 */
public class PageSearchModel implements Serializable {
    private Integer currentPage;
    private Integer PageSize;
    private Map search;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public Map getSearch() {
        return search;
    }

    public void setSearch(Map search) {
        this.search = search;
    }
}
