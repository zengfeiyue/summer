package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.ActivityVote;
import com.summer.school.api.service.ActivityVoteService;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = ActivityVoteService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class ActivityVoteServiceImpl extends BaseServiceImpl<ActivityVote,Integer> implements ActivityVoteService {


}
