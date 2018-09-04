package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.ActivityVoteItem;
import com.summer.school.api.service.ActivityVoteItemService;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = ActivityVoteItemService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class ActivityVoteItemServiceImpl extends BaseServiceImpl<ActivityVoteItem,Integer> implements ActivityVoteItemService {


}
