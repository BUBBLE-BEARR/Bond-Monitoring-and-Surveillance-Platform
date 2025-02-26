package com.project.system.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;


/**
 * 非公债主承销商承销排名对象 t_zzbj_bond_lead_underwriter_ranking
 *
 * @author qshj
 * @date 2022-05-25
 */
public class BondLeadUnderwriterRanking
{
    private static final long serialVersionUID = 1L;

    /** 主键id（自增长） */
    private Long blurId;

    /** 序号 */
    @Excel(name = "序号", cellType = Excel.ColumnType.NUMERIC)
    private Long serialNumber;

    /** 主承销商编码 */
    private String leadUnderwriterCode;

    /** 主承销商名称 */
    @Excel(name = "主承销商")
    private String leadUnderwriterName;

    /** 备案数量（只） */
    @Excel(name = "备案数量（只）", cellType = Excel.ColumnType.NUMERIC)
    private Long underwritingNumber;

    /** 备案规模（亿元） */
    @Excel(name = "备案规模（亿元）", cellType = Excel.ColumnType.NUMERIC)
    private Double underwritingAmount;

    /** 备案规模（亿元） */
    @Excel(name = "规模占比", cellType = Excel.ColumnType.NUMERIC)
    private Double underwritingAmountProportion;

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

    public void setBlurId(Long blurId)
    {
        this.blurId = blurId;
    }

    public Long getBlurId()
    {
        return blurId;
    }
    public void setSerialNumber(Long serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public Long getSerialNumber()
    {
        return serialNumber;
    }
    public void setLeadUnderwriterCode(String leadUnderwriterCode)
    {
        this.leadUnderwriterCode = leadUnderwriterCode;
    }

    public String getLeadUnderwriterCode()
    {
        return leadUnderwriterCode;
    }
    public void setLeadUnderwriterName(String leadUnderwriterName)
    {
        this.leadUnderwriterName = leadUnderwriterName;
    }

    public String getLeadUnderwriterName()
    {
        return leadUnderwriterName;
    }
    public void setUnderwritingNumber(Long underwritingNumber)
    {
        this.underwritingNumber = underwritingNumber;
    }

    public Long getUnderwritingNumber()
    {
        return underwritingNumber;
    }
    public void setUnderwritingAmount(Double underwritingAmount)
    {
        this.underwritingAmount = underwritingAmount;
    }

    public Double getUnderwritingAmount()
    {
        return underwritingAmount;
    }
    public void setUnderwritingAmountProportion(Double underwritingAmountProportion)
    {
        this.underwritingAmountProportion = underwritingAmountProportion;
    }

    public Double getUnderwritingAmountProportion()
    {
        return underwritingAmountProportion;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("blurId", getBlurId())
            .append("serialNumber", getSerialNumber())
            .append("leadUnderwriterCode", getLeadUnderwriterCode())
            .append("leadUnderwriterName", getLeadUnderwriterName())
            .append("underwritingNumber", getUnderwritingNumber())
            .append("underwritingAmount", getUnderwritingAmount())
            .append("underwritingAmountProportion", getUnderwritingAmountProportion())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateUser", getUpdateUser())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
