package com.summer.school.api.entity;

import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Date;

public class Organization implements Serializable {
    private Integer id;

    private String name;

    private Integer type;

    private Integer parendId;

    private Integer memberId;

    private String schoolCode;

    private Double grade;

    private Date createTime;

    private String logoUrl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParendId() {
        return parendId;
    }

    public void setParendId(Integer parendId) {
        this.parendId = parendId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getSchoolId() {
        return schoolCode;
    }

    public void setSchoolId(String schoolId) {
        this.schoolCode = schoolCode;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
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
        Organization other = (Organization) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getParendId() == null ? other.getParendId() == null : this.getParendId().equals(other.getParendId()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getSchoolId() == null ? other.getSchoolId() == null : this.getSchoolId().equals(other.getSchoolId()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getParendId() == null) ? 0 : getParendId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getSchoolId() == null) ? 0 : getSchoolId().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", parendId=").append(parendId);
        sb.append(", memberId=").append(memberId);
        sb.append(", schoolId=").append(schoolCode);
        sb.append(", grade=").append(grade);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}