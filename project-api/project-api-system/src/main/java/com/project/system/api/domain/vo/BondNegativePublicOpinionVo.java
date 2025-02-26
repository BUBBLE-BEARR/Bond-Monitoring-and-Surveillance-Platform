package com.project.system.api.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 负面舆情对象 t_zzbj_bond_negative_public_opinion
 *
 * @author qshj
 * @date 2022-05-23
 */
public class BondNegativePublicOpinionVo
{
    private static final long serialVersionUID = 1L;

    /** 序号-不需要录入数据库 */
    private Integer serialNumber;

    /** 主键id（自增长） */
    private Long id;

    /** 预警日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预警时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fstDate;
    private String fstDateStart;
    private String fstDateEnd;

    /** 发行人统一编码 */
    private Long comUniCode;

    /** 发行人名称 */
    @Excel(name = "发行人名称")
    private String issName;

    /** 预警标签 */
    @Excel(name = "预警标签")
    private String fstTagName;

    /** 舆情 */
    @Excel(name = "舆情")
    private String sentiment;

    /** 创建人 */
    private Long createUser;

    /** 修改人 */
    private Long updateUser;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String createTimeStart;
    private String createTimeEnd;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String updateTimeStart;
    private String updateTimeEnd;
    
    
    /** 管控辖区 */
    private int jurisdictionIds;
    
    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setComUniCode(Long comUniCode)
    {
        this.comUniCode = comUniCode;
    }

    public Long getComUniCode()
    {
        return comUniCode;
    }
    public void setIssName(String issName)
    {
        this.issName = issName;
    }

    public String getIssName()
    {
        return issName;
    }
    public void setFstTagName(String fstTagName)
    {
        this.fstTagName = fstTagName;
    }

    public String getFstTagName()
    {
        return fstTagName;
    }
    public void setFstDate(Date fstDate)
    {
        this.fstDate = fstDate;
    }

    public Date getFstDate()
    {
        return fstDate;
    }
    public void setSentiment(String sentiment)
    {
        this.sentiment = sentiment;
    }

    public String getSentiment()
    {
        return sentiment;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFstDateStart() {
        return fstDateStart;
    }

    public void setFstDateStart(String fstDateStart) {
        this.fstDateStart = fstDateStart;
    }

    public String getFstDateEnd() {
        return fstDateEnd;
    }

    public void setFstDateEnd(String fstDateEnd) {
        this.fstDateEnd = fstDateEnd;
    }

    public String getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getUpdateTimeStart() {
        return updateTimeStart;
    }

    public void setUpdateTimeStart(String updateTimeStart) {
        this.updateTimeStart = updateTimeStart;
    }

    public String getUpdateTimeEnd() {
        return updateTimeEnd;
    }

    public void setUpdateTimeEnd(String updateTimeEnd) {
        this.updateTimeEnd = updateTimeEnd;
    }

    public int getJurisdictionIds() {
		return jurisdictionIds;
	}

	public void setJurisdictionIds(int jurisdictionIds) {
		this.jurisdictionIds = jurisdictionIds;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("comUniCode", getComUniCode())
            .append("issName", getIssName())
            .append("fstTagName", getFstTagName())
            .append("fstDate", getFstDate())
            .append("sentiment", getSentiment())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateUser", getUpdateUser())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
