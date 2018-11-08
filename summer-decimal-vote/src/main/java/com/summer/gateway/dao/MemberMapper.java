package com.summer.gateway.dao;


import com.summer.gateway.core.base.dao.BaseMapper;
import com.summer.gateway.entity.Member;

public interface MemberMapper extends BaseMapper<Member,Integer> {

    Member selectByOpenId(String openId);
}