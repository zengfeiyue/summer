package com.summer.gateway.model;


import com.summer.gateway.core.base.model.BaseModel;
import com.summer.gateway.entity.Activity;
import com.summer.gateway.entity.ActivityVote;
import com.summer.gateway.entity.ActivityVoteItem;

import java.util.List;

/**
 * 投票活动模型
 * @author zengfeiyue
 */
public class ActivityVoteModel extends BaseModel {
    private Activity base;
    private List<ActivityVoteItem> item;
    private ActivityVote info;

    public Activity getBase() {
        return base;
    }

    public void setBase(Activity base) {
        this.base = base;
    }

    public List<ActivityVoteItem> getItem() {
        return item;
    }

    public void setItem(List<ActivityVoteItem> item) {
        this.item = item;
    }

    public ActivityVote getInfo() {
        return info;
    }

    public void setInfo(ActivityVote info) {
        this.info = info;
    }
}
