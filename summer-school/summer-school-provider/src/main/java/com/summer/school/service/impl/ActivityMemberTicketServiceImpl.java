package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.ActivityMemberTicket;
import com.summer.school.api.service.ActivityMemberTicketService;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = ActivityMemberTicketService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class ActivityMemberTicketServiceImpl extends BaseServiceImpl<ActivityMemberTicket,Integer> implements ActivityMemberTicketService {
}
