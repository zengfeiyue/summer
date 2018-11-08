package com.summer.gateway.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.summer.gateway.core.base.common.ResponseBean;
import com.summer.gateway.core.base.service.BaseServiceImpl;
import com.summer.gateway.dao.ActivityMapper;
import com.summer.gateway.dao.ActivityVoteItemMapper;
import com.summer.gateway.dao.ActivityVoteMapper;
import com.summer.gateway.dao.ActivityVoteResultMapper;
import com.summer.gateway.entity.Activity;
import com.summer.gateway.entity.ActivityVote;
import com.summer.gateway.entity.ActivityVoteItem;
import com.summer.gateway.entity.ActivityVoteResult;
import com.summer.gateway.model.ActivityVoteModel;
import com.summer.gateway.model.ActivityVoteModelDetail;
import com.summer.gateway.model.QueryModel;
import com.summer.gateway.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author zengfeiyue
 */
@Service
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
    public ResponseBean create(ActivityVoteModel activityVoteModel, Integer memberId) {
        Activity activity = activityVoteModel.getBase();
        activity.setCreateTime(new Date());
        activity.setMemberId(memberId);
        ActivityVote activityVote = activityVoteModel.getInfo();
        List<ActivityVoteItem> activityVoteItem = activityVoteModel.getItem();
        if (activityVote.getId()!=null){
            activityVoteMapper.updateByPrimaryKeySelective(activityVote);
        }else{
            activityVoteMapper.insertSelective(activityVote);
        }
        activity.setExtendId(activityVote.getId());
        if (activity.getId()!=null){
            activityMapper.updateByPrimaryKeySelective(activity);
        }else{
            activityMapper.insertSelective(activity);
        }

        activityVoteItem.stream().forEach(x->{
            if (x.getId()!=null){
                x.setActivityId(activity.getId());
                activityVoteItemMapper.updateByPrimaryKeySelective(x);
            }else{
                x.setActivityId(activity.getId());
                x.setCreateTime(new Date());
                activityVoteItemMapper.insertSelective(x);
            }

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
        activity_.setViewTotal(Optional.ofNullable(activity.getViewTotal()).orElse(0)+1);
        activityMapper.updateByPrimaryKeySelective(activity_);
        return activityVoteModelDetail;
    }

    @Override
    public ResponseBean activityVote(Integer itemId,Integer memberId) {
        ResponseBean responseBean = null;
        ActivityVoteItem item = activityVoteItemMapper.selectByPrimaryKey(itemId);
        Activity activity = activityMapper.selectByPrimaryKey(item.getActivityId());
        ActivityVote activityVote = activityVoteMapper.selectByPrimaryKey(activity.getExtendId());
        Map voteResult = activityVoteResultMapper.queryMemberVoteResult(activity.getId(),memberId);
        if (voteResult==null){
            voteResult = new HashMap();
            voteResult.put("totalCount",0);
            voteResult.put("todayCount",0);
        }
        ActivityVoteResult voteRecord = activityVoteResultMapper.queryLastVoteRecord(memberId);
        Date now = new Date();
        if (item==null){
            responseBean = new ResponseBean(500,"投票项目不存在",null);
        }else{
            if (activity.getIsStart()==0){
                responseBean = new ResponseBean(500,"报名未开始",null);
            }
            else if (!now.after(activity.getStartTime())||!now.before(activity.getEndTime())){
                responseBean = new ResponseBean(500,"活动已结束",null);
            }
            else if (activityVote.getLimitTotal()!=null&&Integer.valueOf(Optional.ofNullable(voteResult.get("totalCount")).orElse("0").toString())
                    >=activityVote.getLimitTotal()){
                responseBean = new ResponseBean(500,"您的投票次数已达到上限",null);
            }
            else if (Integer.valueOf(Optional.ofNullable(voteResult.get("todayCount")).orElse("0").toString())
                    >=activityVote.getLimitDay()){
                responseBean = new ResponseBean(500,"您今天投票次数已达到上限",null);
            }
            else if (voteRecord!=null&&voteRecord.getItemId()==itemId&&activityVote.getIsRepeat()==0){
                responseBean = new ResponseBean(500,"不可以重复投同一个！",null);
            } else{
                item.setTotalNumber(item.getTotalNumber()+1);
                ActivityVoteResult result = new ActivityVoteResult();
                result.setActivityId(activity.getId());
                result.setCreateTime(new Date());
                result.setItemId(itemId);
                result.setMemberId(memberId);
                activityVoteResultMapper.insertSelective(result);
                activityVoteItemMapper.updateByPrimaryKey(item);
                responseBean = new ResponseBean(200,"投票成功！",null);
            }

        }
        return responseBean;
    }

    @Override
    public ResponseBean start(QueryModel queryModel) {
        ResponseBean responseBean = null;
        Activity activity = activityMapper.selectByPrimaryKey(queryModel.getId());
        if (activity!=null){
            Activity activity_ = new Activity();
            activity_.setId(activity.getId());
            activity_.setIsStart(1);
            activityMapper.updateByPrimaryKeySelective(activity_);
            responseBean = new ResponseBean(200,"操作成功！",null);
        }else{
            responseBean = new ResponseBean(500,"操作失败！",null);
        }

        return responseBean;
    }

    @Override
    public ResponseBean stop(QueryModel queryModel) {
        ResponseBean responseBean = null;
        Activity activity = activityMapper.selectByPrimaryKey(queryModel.getId());
        if (activity!=null){
            Activity activity_ = new Activity();
            activity_.setId(activity.getId());
            activity_.setIsStart(0);
            activityMapper.updateByPrimaryKeySelective(activity_);
            responseBean = new ResponseBean(200,"操作成功！",null);
        }else{
            responseBean = new ResponseBean(500,"操作失败！",null);
        }

        return responseBean;
    }

    @Override
    public PageInfo<Activity> findByPageJoin(Map search, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        PageInfo<Activity> pageInfo = new PageInfo<>(activityMapper.findByPageJoin(search));
        return pageInfo;
    }

    @Override
    public ResponseBean createJoin(ActivityVoteItem item) {
        try {
            activityVoteItemMapper.insertSelective(item);
            return new ResponseBean(200,"报名成功！",null);
        }catch (Exception e){
            return new ResponseBean(500,"报名失败！",null);
        }

    }
}
