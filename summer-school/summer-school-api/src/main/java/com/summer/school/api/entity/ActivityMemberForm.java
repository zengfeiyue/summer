package com.summer.school.api.entity;

import java.io.Serializable;

public class ActivityMemberForm implements Serializable {
    private Integer id;

    private Integer activityId;

    private Integer activityFormId;

    private String formName;

    private String formValue;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getActivityFormId() {
        return activityFormId;
    }

    public void setActivityFormId(Integer activityFormId) {
        this.activityFormId = activityFormId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName == null ? null : formName.trim();
    }

    public String getFormValue() {
        return formValue;
    }

    public void setFormValue(String formValue) {
        this.formValue = formValue == null ? null : formValue.trim();
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
        ActivityMemberForm other = (ActivityMemberForm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getActivityFormId() == null ? other.getActivityFormId() == null : this.getActivityFormId().equals(other.getActivityFormId()))
            && (this.getFormName() == null ? other.getFormName() == null : this.getFormName().equals(other.getFormName()))
            && (this.getFormValue() == null ? other.getFormValue() == null : this.getFormValue().equals(other.getFormValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getActivityFormId() == null) ? 0 : getActivityFormId().hashCode());
        result = prime * result + ((getFormName() == null) ? 0 : getFormName().hashCode());
        result = prime * result + ((getFormValue() == null) ? 0 : getFormValue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityId=").append(activityId);
        sb.append(", activityFormId=").append(activityFormId);
        sb.append(", formName=").append(formName);
        sb.append(", formValue=").append(formValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}