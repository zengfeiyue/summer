package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.common.ResponseBean;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.Activity;
import com.summer.school.api.entity.ActivityVote;
import com.summer.school.api.entity.ActivityVoteItem;
import com.summer.school.api.entity.ActivityVoteResult;
import com.summer.school.api.model.ActivityVoteModel;
import com.summer.school.api.model.ActivityVoteModelDetail;
import com.summer.school.api.service.ActivityService;
import com.summer.school.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    @Autowired
    private ActivityVoteResultMapper activityVoteResultMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean create(ActivityVoteModel activityVoteModel) {
        Activity activity = activityVoteModel.getBase();
        activity.setCreateTime(new Date());
        ActivityVote activityVote = activityVoteModel.getInfo();
        List<ActivityVoteItem> activityVoteItem = activityVoteModel.getItem();
        activityVoteMapper.insertSelective(activityVote);
        activity.setExtendId(activityVote.getId());
        activityMapper.insertSelective(activity);
        activityVoteItem.stream().forEach(x->{
            x.setActivityId(activity.getId());
            x.setCreateTime(new Date());
            activityVoteItemMapper.insertSelective(x);
        });
        ResponseBean responseBean = new ResponseBean(200,"创建成功",null);
        return responseBean;
    }

    @Override
    public ActivityVoteModelDetail queryVoteDetail(Integer activityId) {
        Activity activity = activityMapper.selectByPrimaryKey(activityId);
        ActivityVote activityVote = activityVoteMapper.selectByPrimaryKey(activity.getExtendId());
        List<ActivityVoteItem> activityVoteItem = activityVoteItemMapper.findByActivityId(activity.getId());
        ActivityVoteModelDetail activityVoteModelDetail = new ActivityVoteModelDetail();
        activityVoteModelDetail.setBase(activity);
        activityVoteModelDetail.setInfo(activityVote);
        activityVoteModelDetail.setItem(activityVoteItem);
        activityVoteModelDetail.setTotalItem(activityVoteItem.size());
        activityVoteModelDetail.setTotalView(activity.getViewTotal());
        activityVoteModelDetail.setTotalVoteCount(activityVoteItem.stream().mapToInt(ActivityVoteItem::getTotalNumber).sum());
        Activity activity_ = new Activity();
        activity_.setId(activity.getId());
        activity_.setViewTotal(activity.getViewTotal()+1);
        activityMapper.updateByPrimaryKeySelective(activity_);
        return activityVoteModelDetail;
    }

    @Override
    public ResponseBean activityVote(Integer itemId) {
        ResponseBean responseBean = null;
        ActivityVoteItem item = activityVoteItemMapper.selectByPrimaryKey(itemId);
        Activity activity = activityMapper.selectByPrimaryKey(item.getActivityId());
        ActivityVote activityVote = activityVoteMapper.selectByPrimaryKey(activity.getExtendId());
        ActivityVoteResult activityVoteResult = activityVoteResultMapper.queryLastVoteRecord("");
        if (item==null){
            responseBean = new ResponseBean(500,"投票项目不存在",null);
        }else{

            item.setTotalNumber(item.getTotalNumber()+1);
            ActivityVoteResult result = new ActivityVoteResult();
            result.setActivityId(activity.getId());
            result.setCreateTime(new Date());
            result.setItemId(itemId);
            result.setMemberId(2);//todo memberId
            activityVoteResultMapper.insertSelective(result);
            activityVoteItemMapper.updateByPrimaryKey(item);
            responseBean = new ResponseBean(200,"投票成功！",null);
        }
        return responseBean;
    }
}
