package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.Activity;
import com.summer.school.api.entity.ActivityVote;
import com.summer.school.api.entity.ActivityVoteItem;
import com.summer.school.api.model.ActivityVoteModel;
import com.summer.school.api.service.ActivityService;
import com.summer.school.dao.ActivityMapper;
import com.summer.school.dao.ActivityVoteItemMapper;
import com.summer.school.dao.ActivityVoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zengfeiyue
 */
@Service(version = "0.1",interfaceClass = ActivityService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class ActivityServiceImpl extends BaseServiceImpl<Activity,Integer> implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityVoteMapper activityVoteMapper;
    @Autowired
    private ActivityVoteItemMapper activityVoteItemMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean create(ActivityVoteModel activityVoteModel) {
        Activity activity = activityVoteModel.getBase();
        ActivityVote activityVote = activityVoteModel.getInfo();
        List<ActivityVoteItem> activityVoteItem = activityVoteModel.getItem();
        activityVoteMapper.insertSelective(activityVote);
        activity.setExtendId(activityVote.getId());
        activityMapper.insertSelective(activity);
        ResponseBean responseBean = new ResponseBean(200,"创建成功",null);
        return responseBean;
    }
}
