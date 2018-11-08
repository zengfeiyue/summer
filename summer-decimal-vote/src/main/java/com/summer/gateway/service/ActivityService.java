package com.summer.gateway.service;

import com.github.pagehelper.PageInfo;
import com.summer.gateway.core.base.common.ResponseBean;
import com.summer.gateway.core.base.service.BaseService;
import com.summer.gateway.entity.Activity;
import com.summer.gateway.entity.ActivityVoteItem;
import com.summer.gateway.model.ActivityVoteModel;
import com.summer.gateway.model.QueryModel;


import java.util.Map;

public interface ActivityService extends BaseService<Activity,Integer> {

    /**
     * 创建投票活动
     * @param activityVoteModel
     * @return
     */
    ResponseBean create(ActivityVoteModel activityVoteModel, Integer memberId);

    /**
     * 获取投票活动详情
     * @param id
     * @return
     */
    ActivityVoteModel queryVoteDetail(Integer id);

    /**
     * 投票
     * @param itemId
     * @return
     */
    ResponseBean activityVote(Integer itemId, Integer memberId);

    /**
     * 开始活动
     * @param queryModel
     * @return
     */
    ResponseBean start(QueryModel queryModel);

    /**
     * 结束活动
     * @param queryModel
     * @return
     */
    ResponseBean stop(QueryModel queryModel);

    /**
     * 我参与的
     * @param search
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Activity> findByPageJoin(Map search, Integer currentPage, Integer pageSize);

    /**
     * 报名活动
     * @param item
     * @return
     */
    ResponseBean createJoin(ActivityVoteItem item);
}
