package com.project.system.api.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 取消发行或推迟发行对象 t_zzbj_bond_cancellationofissue
 *
 * @author qshj
 * @date 2022-05-23
 */
public class BondCancellationofissueVo
{
    /** 序号-不需要录入数据库 */
    private Integer serialNumber;

    /** 主键id（自增长） */
    private Long bcId;

    /** 发生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date happenDate;
    private String happenDateStart;
    private String happenDateEnd;

    /** 发行人统一编码 */
    private Long comUniCode;

    /** 发行人名称 */
    @Excel(name = "发行人")
    private String issName;

    /** 债券统一编码 */
    private Long bondUniCode;

    /** 债券代码 */
    private String bondCode;

    /** 债券简称 */
    @Excel(name = "债券简称")
    private String bondShortName;

    /** 债券全称 */
    private String bondFullName;

    /** 计划发行总额(含增发) */
    @Excel(name = "计划发行规模")
    private BigDecimal planIssAmut;

    /** 上市地址 */
    @Excel(name = "上市地点")
    private String listingAddress;

    /** 发生原因 */
    @Excel(name = "发生原因")
    private String happenReason;

    /** 创建人 */
    private Long createUser;

    /** 修改人 */
    private Long updateUser;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String createTimeStart;
    private String createTimeEnd;

    /** 混合查询 */
    private String mixedName;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String updateTimeStart;
    private String updateTimeEnd;
    
    /** 管控辖区 */
    private int jurisdictionIds;

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getBcId() {
        return bcId;
    }

    public void setBcId(Long bcId) {
        this.bcId = bcId;
    }

    public void setBondUniCode(Long bondUniCode)
    {
        this.bondUniCode = bondUniCode;
    }

    public Long getBondUniCode()
    {
        return bondUniCode;
    }
    public void setBondCode(String bondCode)
    {
        this.bondCode = bondCode;
    }

    public String getBondCode()
    {
        return bondCode;
    }
    public void setBondShortName(String bondShortName)
    {
        this.bondShortName = bondShortName;
    }

    public String getBondShortName()
    {
        return bondShortName;
    }
    public void setBondFullName(String bondFullName)
    {
        this.bondFullName = bondFullName;
    }

    public String getBondFullName()
    {
        return bondFullName;
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
    public void setHappenDate(Date happenDate)
    {
        this.happenDate = happenDate;
    }

    public Date getHappenDate()
    {
        return happenDate;
    }
    public void setPlanIssAmut(BigDecimal planIssAmut)
    {
        this.planIssAmut = planIssAmut;
    }

    public BigDecimal getPlanIssAmut()
    {
        return planIssAmut;
    }
    public void setListingAddress(String listingAddress)
    {
        this.listingAddress = listingAddress;
    }

    public String getListingAddress()
    {
        return listingAddress;
    }

    public String getHappenReason() {
        return happenReason;
    }

    public void setHappenReason(String happenReason) {
        this.happenReason = happenReason;
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

    public String getMixedName() {
        return mixedName;
    }

    public void setMixedName(String mixedName) {
        this.mixedName = mixedName;
    }

    public String getHappenDateStart() {
        return happenDateStart;
    }

    public void setHappenDateStart(String happenDateStart) {
        this.happenDateStart = happenDateStart;
    }

    public String getHappenDateEnd() {
        return happenDateEnd;
    }

    public void setHappenDateEnd(String happenDateEnd) {
        this.happenDateEnd = happenDateEnd;
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
            .append("id", getBcId())
            .append("bondUniCode", getBondUniCode())
            .append("bondCode", getBondCode())
            .append("bondShortName", getBondShortName())
            .append("bondFullName", getBondFullName())
            .append("comUniCode", getComUniCode())
            .append("issName", getIssName())
            .append("happenDate", getHappenDate())
            .append("planIssAmut", getPlanIssAmut())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateUser", getUpdateUser())
            .append("updateTime", getUpdateTime())
            .append("listingAddress", getListingAddress())
            .toString();
    }
}
