package com.project.system.api.domain;

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
public class BondNegativePublicOpinion
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

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

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
