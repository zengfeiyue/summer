package com.summer.school.api.service;

import com.github.pagehelper.PageInfo;
import com.summer.common.base.model.PageSearchModel;
import com.summer.common.base.service.BaseService;
import com.summer.school.api.entity.Activity;

public interface ActivityService extends BaseService<Activity,Integer> {
    /**
     * 分页获取活动
     * @param search
     * @return
     */
    PageInfo activityPage(PageSearchModel search);
}
