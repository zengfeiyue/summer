package com.summer.school.api.service;

import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.service.BaseService;
import com.summer.school.api.entity.Activity;
import com.summer.school.api.entity.ActivityMemberForm;

public interface ActivityService extends BaseService<Activity,Integer> {
    /**
     * 投票
     * @return
     */
    ResponseBean vote(ActivityMemberForm voteform);
}
