package com.project.system.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统信息表 sys_system
 * 
 * @author project
 */
public class SysSystem implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 系统ID */
    private Long systemId;
    /** 系统名称 */
    private String systemName;
    /** 系统代码 */
    private String systemCode;
    /** 最大分配人数 */
    private Integer maxAssUserNum;
    /** 创建者ID */
    private Long createId;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /** 更新者ID */
    private Long updateId;
    /** 更新者 */
    private String updateBy;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /** 备注 */
    private String remark;
    /** 是否删除(Y:是|N：否) */
    private String isDelete;
    /** 是否隐藏(Y:是|N：否) */
    private String isHide;
    /** 是否置顶(Y:是|N：否) */
    private String isHead;
    /** 是否发布(Y:是|N：否) */
    private String isPublish;
    /** 排序字段 */
    private Integer sortNum;
    /** 系统地址 */
    private String systemUrl;
    /** 系统负责人 */
    private String systemManager;

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public Integer getMaxAssUserNum() {
        return maxAssUserNum;
    }

    public void setMaxAssUserNum(Integer maxAssUserNum) {
        this.maxAssUserNum = maxAssUserNum;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getIsHide() {
        return isHide;
    }

    public void setIsHide(String isHide) {
        this.isHide = isHide;
    }

    public String getIsHead() {
        return isHead;
    }

    public void setIsHead(String isHead) {
        this.isHead = isHead;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getSystemUrl() {
        return systemUrl;
    }

    public void setSystemUrl(String systemUrl) {
        this.systemUrl = systemUrl;
    }

    public String getSystemManager() {
        return systemManager;
    }

    public void setSystemManager(String systemManager) {
        this.systemManager = systemManager;
    }

    @Override
    public String toString() {
        return "SysSystem{" +
                "systemId=" + systemId +
                ", systemName='" + systemName + '\'' +
                ", systemCode='" + systemCode + '\'' +
                ", maxAssUserNum=" + maxAssUserNum +
                ", createId=" + createId +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateId=" + updateId +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", isHide='" + isHide + '\'' +
                ", isHead='" + isHead + '\'' +
                ", isPublish='" + isPublish + '\'' +
                ", sortNum=" + sortNum +
                ", systemUrl=" + systemUrl +
                ", systemManager=" + systemManager +
                '}';
    }
}
