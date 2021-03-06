package com.summer.school.dao;

import com.summer.common.base.dao.BaseMapper;
import com.summer.school.api.entity.Member;

public interface MemberMapper extends BaseMapper<Member,Integer> {

    Member selectByOpenId(String openId);
}