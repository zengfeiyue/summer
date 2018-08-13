package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.Member;
import com.summer.school.api.service.MemberService;
/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = MemberService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class MemberServiceImpl extends BaseServiceImpl<Member,Integer> implements MemberService {
}
