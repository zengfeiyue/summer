package com.summer.gateway.service.impl;


import com.summer.gateway.core.base.service.BaseServiceImpl;
import com.summer.gateway.dao.MemberMapper;
import com.summer.gateway.entity.Member;
import com.summer.gateway.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zengfeiyue
 */
@Service
public class MemberServiceImpl extends BaseServiceImpl<Member,Integer> implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Override
    public Member selectByOpenId(String openId) {
        return  memberMapper.selectByOpenId(openId);
    }
}
