package com.summer.gateway.service;


import com.summer.gateway.core.base.service.BaseService;
import com.summer.gateway.entity.Member;

public interface MemberService extends BaseService<Member,Integer> {
    /**
     * 根据openId查找用户
     * @param openid
     * @return
     */
    Member selectByOpenId(String openid);
}
