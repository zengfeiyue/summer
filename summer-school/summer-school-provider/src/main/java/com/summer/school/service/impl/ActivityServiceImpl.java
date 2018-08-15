package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.model.PageSearchModel;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.Activity;
import com.summer.school.api.service.ActivityService;
import com.summer.school.dao.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = ActivityService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class ActivityServiceImpl extends BaseServiceImpl<Activity,Integer> implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public PageInfo activityPage(PageSearchModel search) {
        PageInfo<Activity> page = this.findByPage(search.getCurrentPage(),search.getPageSize());
        return page;
    }
}
