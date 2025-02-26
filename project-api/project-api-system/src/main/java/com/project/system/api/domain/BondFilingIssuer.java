package com.project.system.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 非公债首次备案发行人对象 t_zzbj_bond_filing_issuer
 *
 * @author qshj
 * @date 2022-05-25
 */
public class BondFilingIssuer
{
    private static final long serialVersionUID = 1L;

    /** 序号-不需要录入数据库 */
    private Integer serialNumber;

    /** 主键id（自增长） */
    private Long bfiId;

    /** 备案时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "备案时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date filingDate;

    /** 发行人统一编码 */
    private Long comUniCode;

    /** 发行人名称 */
    @Excel(name = "发行人")
    private String issName;

    /** 省份编码 */
    private Long regionCode;

    /** 省份名 */
    @Excel(name = "省份")
    private String regionName;

    /** 发行规模（亿元） */
    @Excel(name = "发行规模（亿元）")
    private BigDecimal happenAmount;

    /** 所有制 */
    @Excel(name = "所有制")
    private String ownership;

    /** 所有制 */
    @Excel(name = "是否城投", readConverterExp = "0=否,1=是")
    private String isCityAnnex;

    /** 创建人 */
    private Long createUser;

    /** 修改人 */
    private Long updateUser;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public void setBfiId(Long bfiId)
    {
        this.bfiId = bfiId;
    }

    public Long getBfiId()
    {
        return bfiId;
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
    public void setFilingDate(Date filingDate)
    {
        this.filingDate = filingDate;
    }

    public Date getFilingDate()
    {
        return filingDate;
    }
    public void setRegionCode(Long regionCode)
    {
        this.regionCode = regionCode;
    }

    public Long getRegionCode()
    {
        return regionCode;
    }
    public void setRegionName(String regionName)
    {
        this.regionName = regionName;
    }

    public String getRegionName()
    {
        return regionName;
    }
    public void setHappenAmount(BigDecimal happenAmount)
    {
        this.happenAmount = happenAmount;
    }

    public BigDecimal getHappenAmount()
    {
        return happenAmount;
    }
    public void setOwnership(String ownership)
    {
        this.ownership = ownership;
    }

    public String getOwnership()
    {
        return ownership;
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

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getIsCityAnnex() {
        return isCityAnnex;
    }

    public void setIsCityAnnex(String isCityAnnex) {
        this.isCityAnnex = isCityAnnex;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bfiId", getBfiId())
            .append("comUniCode", getComUniCode())
            .append("issName", getIssName())
            .append("filingDate", getFilingDate())
            .append("regionCode", getRegionCode())
            .append("regionName", getRegionName())
            .append("happenAmount", getHappenAmount())
            .append("ownership", getOwnership())
            .append("isCityAnnex", getIsCityAnnex())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateUser", getUpdateUser())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
