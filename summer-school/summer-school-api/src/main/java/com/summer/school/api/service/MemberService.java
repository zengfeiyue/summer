package com.summer.school.api.service;

import com.summer.common.base.service.BaseService;
import com.summer.school.api.entity.Member;

public interface MemberService extends BaseService<Member,Integer> {
    /**
     * 根据openId查找用户
     * @param openid
     * @return
     */
    Member selectByOpenId(String openid);
}
