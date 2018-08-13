package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.MemberOrg;
import com.summer.school.api.service.MemberOrgService;
/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = MemberOrgService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class MemberOrgServiceImpl extends BaseServiceImpl<MemberOrg,Integer> implements MemberOrgService {
}
