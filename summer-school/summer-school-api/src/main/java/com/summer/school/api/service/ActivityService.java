package com.summer.school.api.service;

import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.service.BaseService;
import com.summer.school.api.entity.Activity;
import com.summer.school.api.model.ActivityVoteModel;

public interface ActivityService extends BaseService<Activity,Integer> {

    /**
     * 创建投票活动
     * @param activityVoteModel
     * @return
     */
    ResponseBean create(ActivityVoteModel activityVoteModel);
}
