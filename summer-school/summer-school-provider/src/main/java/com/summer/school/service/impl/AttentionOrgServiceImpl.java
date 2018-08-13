package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.AttentionOrg;
import com.summer.school.api.service.AttentionOrgService;
/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = AttentionOrgService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class AttentionOrgServiceImpl extends BaseServiceImpl<AttentionOrg,Integer> implements AttentionOrgService {
}
