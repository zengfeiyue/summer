package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.Activity;
import com.summer.school.api.service.ActivityService;
/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = ActivityService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class ActivityServiceImpl extends BaseServiceImpl<Activity,Integer> implements ActivityService {
}
