package com.summer.school.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {
    private Integer id;

    private String theme;

    private Boolean type;

    private Date startTime;

    private Date endTime;

    private Integer memberId;

    private Integer extendId;

    private Integer checkStatus;

    private String checkRemark;

    private Integer viewTotal;

    private Integer isStart;

    private String contactinformation;

    private String placardUrl;

    private String introduction;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getExtendId() {
        return extendId;
    }

    public void setExtendId(Integer extendId) {
        this.extendId = extendId;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark == null ? null : checkRemark.trim();
    }

    public Integer getViewTotal() {
        return viewTotal;
    }

    public void setViewTotal(Integer viewTotal) {
        this.viewTotal = viewTotal;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public String getContactinformation() {
        return contactinformation;
    }

    public void setContactinformation(String contactinformation) {
        this.contactinformation = contactinformation == null ? null : contactinformation.trim();
    }

    public String getPlacardUrl() {
        return placardUrl;
    }

    public void setPlacardUrl(String placardUrl) {
        this.placardUrl = placardUrl == null ? null : placardUrl.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
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
        Activity other = (Activity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTheme() == null ? other.getTheme() == null : this.getTheme().equals(other.getTheme()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getExtendId() == null ? other.getExtendId() == null : this.getExtendId().equals(other.getExtendId()))
            && (this.getCheckStatus() == null ? other.getCheckStatus() == null : this.getCheckStatus().equals(other.getCheckStatus()))
            && (this.getCheckRemark() == null ? other.getCheckRemark() == null : this.getCheckRemark().equals(other.getCheckRemark()))
            && (this.getViewTotal() == null ? other.getViewTotal() == null : this.getViewTotal().equals(other.getViewTotal()))
            && (this.getIsStart() == null ? other.getIsStart() == null : this.getIsStart().equals(other.getIsStart()))
            && (this.getContactinformation() == null ? other.getContactinformation() == null : this.getContactinformation().equals(other.getContactinformation()))
            && (this.getPlacardUrl() == null ? other.getPlacardUrl() == null : this.getPlacardUrl().equals(other.getPlacardUrl()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTheme() == null) ? 0 : getTheme().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getExtendId() == null) ? 0 : getExtendId().hashCode());
        result = prime * result + ((getCheckStatus() == null) ? 0 : getCheckStatus().hashCode());
        result = prime * result + ((getCheckRemark() == null) ? 0 : getCheckRemark().hashCode());
        result = prime * result + ((getViewTotal() == null) ? 0 : getViewTotal().hashCode());
        result = prime * result + ((getIsStart() == null) ? 0 : getIsStart().hashCode());
        result = prime * result + ((getContactinformation() == null) ? 0 : getContactinformation().hashCode());
        result = prime * result + ((getPlacardUrl() == null) ? 0 : getPlacardUrl().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", theme=").append(theme);
        sb.append(", type=").append(type);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", memberId=").append(memberId);
        sb.append(", extendId=").append(extendId);
        sb.append(", checkStatus=").append(checkStatus);
        sb.append(", checkRemark=").append(checkRemark);
        sb.append(", viewTotal=").append(viewTotal);
        sb.append(", isStart=").append(isStart);
        sb.append(", contactinformation=").append(contactinformation);
        sb.append(", placardUrl=").append(placardUrl);
        sb.append(", introduction=").append(introduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}