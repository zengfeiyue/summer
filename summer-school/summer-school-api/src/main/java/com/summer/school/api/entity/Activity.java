package com.summer.school.api.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {

    @ApiModelProperty(hidden = true)
    private Integer id;
    @ApiModelProperty(value = "主题")
    private String theme;
    @ApiModelProperty(value = "活动类型")
    private Integer type;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "海报url")
    private String placardUrl;
    @ApiModelProperty(value = "活动描述")
    private String introduction;
    @ApiModelProperty(hidden = true)
    private Integer orgId;
    @ApiModelProperty(hidden = true)
    private String orgName;
    @ApiModelProperty(hidden = true)
    private Date createTime;
    @ApiModelProperty(value = "选择的计费策略")
    private Integer costStrategyId;
    @ApiModelProperty(value = "表单设置")
    private Integer formSettingId;
    @ApiModelProperty(value = "联系方式")
    private String contactInformation;
    /**
     * org logo
     */
    @ApiModelProperty(hidden = true)
    private String logoUrl;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCostStrategyId() {
        return costStrategyId;
    }

    public void setCostStrategyId(Integer costStrategyId) {
        this.costStrategyId = costStrategyId;
    }

    public Integer getFormSettingId() {
        return formSettingId;
    }

    public void setFormSettingId(Integer formSettingId) {
        this.formSettingId = formSettingId;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation == null ? null : contactInformation.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
        Activity other = (Activity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTheme() == null ? other.getTheme() == null : this.getTheme().equals(other.getTheme()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPlacardUrl() == null ? other.getPlacardUrl() == null : this.getPlacardUrl().equals(other.getPlacardUrl()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCostStrategyId() == null ? other.getCostStrategyId() == null : this.getCostStrategyId().equals(other.getCostStrategyId()))
            && (this.getFormSettingId() == null ? other.getFormSettingId() == null : this.getFormSettingId().equals(other.getFormSettingId()))
            && (this.getContactInformation() == null ? other.getContactInformation() == null : this.getContactInformation().equals(other.getContactInformation()));
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
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPlacardUrl() == null) ? 0 : getPlacardUrl().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCostStrategyId() == null) ? 0 : getCostStrategyId().hashCode());
        result = prime * result + ((getFormSettingId() == null) ? 0 : getFormSettingId().hashCode());
        result = prime * result + ((getContactInformation() == null) ? 0 : getContactInformation().hashCode());
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
        sb.append(", address=").append(address);
        sb.append(", placardUrl=").append(placardUrl);
        sb.append(", introduction=").append(introduction);
        sb.append(", orgId=").append(orgId);
        sb.append(", createTime=").append(createTime);
        sb.append(", costStrategyId=").append(costStrategyId);
        sb.append(", formSettingId=").append(formSettingId);
        sb.append(", contactInformation=").append(contactInformation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}