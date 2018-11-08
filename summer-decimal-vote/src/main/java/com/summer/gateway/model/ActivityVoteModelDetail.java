package com.summer.gateway.model;

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
