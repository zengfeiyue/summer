package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.Organization;
import com.summer.school.api.service.OrganiztionService;
/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = OrganiztionService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class OrganiztionServiceImpl extends BaseServiceImpl<Organization,Integer> implements OrganiztionService {
}
