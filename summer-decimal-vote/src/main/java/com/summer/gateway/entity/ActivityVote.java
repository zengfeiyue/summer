package com.summer.gateway.entity;

import java.io.Serializable;

public class ActivityVote implements Serializable {
    private Integer id;

    private Integer limitTotal;

    private Integer limitDay;

    private Integer isRepeat;

    private Integer displayBallot;

    private Integer displayResult;

    private Integer userCreate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLimitTotal() {
        return limitTotal;
    }

    public void setLimitTotal(Integer limitTotal) {
        this.limitTotal = limitTotal;
    }

    public Integer getLimitDay() {
        return limitDay;
    }

    public void setLimitDay(Integer limitDay) {
        this.limitDay = limitDay;
    }

    public Integer getIsRepeat() {
        return isRepeat;
    }

    public void setIsRepeat(Integer isRepeat) {
        this.isRepeat = isRepeat;
    }

    public Integer getDisplayBallot() {
        return displayBallot;
    }

    public void setDisplayBallot(Integer displayBallot) {
        this.displayBallot = displayBallot;
    }

    public Integer getDisplayResult() {
        return displayResult;
    }

    public void setDisplayResult(Integer displayResult) {
        this.displayResult = displayResult;
    }

    public Integer getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(Integer userCreate) {
        this.userCreate = userCreate;
    }

    
}