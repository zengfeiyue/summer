package com.summer.school.api.entity;

import java.io.Serializable;

public class ActivityVote implements Serializable {
    private Integer id;

    private Integer limitTotal;

    private Integer limitDay;

    private Integer repeat;

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

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ActivityVote other = (ActivityVote) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLimitTotal() == null ? other.getLimitTotal() == null : this.getLimitTotal().equals(other.getLimitTotal()))
            && (this.getLimitDay() == null ? other.getLimitDay() == null : this.getLimitDay().equals(other.getLimitDay()))
            && (this.getRepeat() == null ? other.getRepeat() == null : this.getRepeat().equals(other.getRepeat()))
            && (this.getDisplayBallot() == null ? other.getDisplayBallot() == null : this.getDisplayBallot().equals(other.getDisplayBallot()))
            && (this.getDisplayResult() == null ? other.getDisplayResult() == null : this.getDisplayResult().equals(other.getDisplayResult()))
            && (this.getUserCreate() == null ? other.getUserCreate() == null : this.getUserCreate().equals(other.getUserCreate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLimitTotal() == null) ? 0 : getLimitTotal().hashCode());
        result = prime * result + ((getLimitDay() == null) ? 0 : getLimitDay().hashCode());
        result = prime * result + ((getRepeat() == null) ? 0 : getRepeat().hashCode());
        result = prime * result + ((getDisplayBallot() == null) ? 0 : getDisplayBallot().hashCode());
        result = prime * result + ((getDisplayResult() == null) ? 0 : getDisplayResult().hashCode());
        result = prime * result + ((getUserCreate() == null) ? 0 : getUserCreate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", limitTotal=").append(limitTotal);
        sb.append(", limitDay=").append(limitDay);
        sb.append(", repeat=").append(repeat);
        sb.append(", displayBallot=").append(displayBallot);
        sb.append(", displayResult=").append(displayResult);
        sb.append(", userCreate=").append(userCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}