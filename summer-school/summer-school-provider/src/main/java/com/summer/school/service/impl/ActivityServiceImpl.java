package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.Activity;
import com.summer.school.api.entity.ActivityMemberForm;
import com.summer.school.api.service.ActivityMemberFormService;
import com.summer.school.api.service.ActivityService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Reference;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = ActivityService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class ActivityServiceImpl extends BaseServiceImpl<Activity,Integer> implements ActivityService {

    @Reference
    private ActivityMemberFormService activityMemberFormService;

    @Override
    public ResponseBean vote(ActivityMemberForm voteform) {
        try {
            voteform.setFormName("1");
            voteform.setFormValue("1");
            //todo 限制投票人数
            Integer insert = activityMemberFormService.insertSelective(voteform);
            return new ResponseBean(200,"投票成功",null);
        }catch (Exception e){
            return new ResponseBean(500,"投票失败",null);
        }

    }
}
