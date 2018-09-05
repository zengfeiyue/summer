package com.summer.school.api.model;

import com.summer.common.base.model.BaseModel;
import com.summer.school.api.entity.Activity;
import com.summer.school.api.entity.ActivityVote;
import com.summer.school.api.entity.ActivityVoteItem;

import java.util.List;

/**
 * 投票活动详情模型
 * @author zengfeiyue
 */
public class ActivityVoteModelDetail extends ActivityVoteModel {

    private Integer totalItem;

    private Integer totalVoteCount;

    private Integer totalView;

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Integer getTotalVoteCount() {
        return totalVoteCount;
    }

    public void setTotalVoteCount(Integer totalVoteCount) {
        this.totalVoteCount = totalVoteCount;
    }

    public Integer getTotalView() {
        return totalView;
    }

    public void setTotalView(Integer totalView) {
        this.totalView = totalView;
    }
}
