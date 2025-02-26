package com.project.system.api.domain.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;


/**
 * 非公债备案数量及规模趋势对象 t_zzbj_bond_filing
 *
 * @author qshj
 * @date 2022-05-24
 */
public class BondFilingVo
{
    private static final long serialVersionUID = 1L;

    /** 序号-不需要录入数据库 */
    private Integer serialNumber;

    /** 主键id（自增长） */
    private Long bfId;

    /** 备案类型(0周，1月) */
    @Excel(name = "备案类型(0周，1月)", readConverterExp = "0=周,1=月")
    private String filingFlag;

    /** 备案年份 */
    @Excel(name = "备案年份", cellType = Excel.ColumnType.NUMERIC)
    private Long filingYear;

    /** 备案期数 */
    @Excel(name = "备案期数", cellType = Excel.ColumnType.NUMERIC)
    private Long filingDate;

    /** 备案规模（亿元） */
    @Excel(name = "备案规模（亿元）")
    private String filingAmount;

    /** 备案数量（只） */
    @Excel(name = "备案数量（只）")
    private Long filingNumber;

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

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setBfId(Long bfId)
    {
        this.bfId = bfId;
    }

    public Long getBfId()
    {
        return bfId;
    }
    public void setFilingNumber(Long filingNumber)
    {
        this.filingNumber = filingNumber;
    }

    public Long getFilingNumber()
    {
        return filingNumber;
    }
    public void setFilingFlag(String filingFlag)
    {
        this.filingFlag = filingFlag;
    }

    public String getFilingFlag()
    {
        return filingFlag;
    }
    public void setFilingAmount(String filingAmount)
    {
        this.filingAmount = filingAmount;
    }

    public String getFilingAmount()
    {
        return filingAmount;
    }
    public void setFilingYear(Long filingYear)
    {
        this.filingYear = filingYear;
    }

    public Long getFilingYear()
    {
        return filingYear;
    }
    public void setFilingDate(Long filingDate)
    {
        this.filingDate = filingDate;
    }

    public Long getFilingDate()
    {
        return filingDate;
    }
    public void setCreateUser(Long createUser)
    {
        this.createUser = createUser;
    }

    public Long getCreateUser()
    {
        return createUser;
    }
    public void setUpdateUser(Long updateUser)
    {
        this.updateUser = updateUser;
    }

    public Long getUpdateUser()
    {
        return updateUser;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bfId", getBfId())
            .append("filingNumber", getFilingNumber())
            .append("filingFlag", getFilingFlag())
            .append("filingAmount", getFilingAmount())
            .append("filingYear", getFilingYear())
            .append("filingDate", getFilingDate())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateUser", getUpdateUser())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
