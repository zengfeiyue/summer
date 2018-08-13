package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.ActivityMember;
import com.summer.school.api.service.ActivityMemberService;
/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = ActivityMemberService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class ActivityMemberServiceImpl extends BaseServiceImpl<ActivityMember,Integer> implements ActivityMemberService {
}
