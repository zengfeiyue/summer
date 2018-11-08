package com.summer.gateway.model;


import com.summer.gateway.core.base.model.BaseModel;

/**
 * @author zengfeiyue
 */
public class QueryModel extends BaseModel {
    private Integer memberId;
    private Integer id;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
