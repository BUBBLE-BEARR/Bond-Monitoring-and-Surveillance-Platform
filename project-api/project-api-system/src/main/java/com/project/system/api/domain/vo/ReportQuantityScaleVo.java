package com.project.system.api.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 报备数量及规模信息
 *
 * @author zhujiang
 */
public class ReportQuantityScaleVo {
    /** 主键 */
    private Long id;

    /** 报备周期类型，1：按周统计，2：按月统计 */
    private Integer reportPeriodType;

    /** 报备周期 */
    private String reportPeriod;

    /** 报备周期 */
    @Excel(name = "报备周期")
    private String reportPeriodCn;

    /** 报备数量 */
    @Excel(name = "报备数量")
    private Integer reportQuantity;

    /** 报备金额(亿元) */
    @Excel(name = "报备金额(亿元)")
    private BigDecimal reportAmount;

    /** 创建人 */
    private Long createBy;

    /** 修改人 */
    private Long updateBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReportPeriodType() {
        return reportPeriodType;
    }

    public void setReportPeriodType(Integer reportPeriodType) {
        this.reportPeriodType = reportPeriodType;
    }

    public String getReportPeriod() {
        return reportPeriod;
    }

    public void setReportPeriod(String reportPeriod) {
        this.reportPeriod = reportPeriod;
    }

    public String getReportPeriodCn() {
        return reportPeriodCn;
    }

    public void setReportPeriodCn(String reportPeriodCn) {
        this.reportPeriodCn = reportPeriodCn;
    }

    public Integer getReportQuantity() {
        return reportQuantity;
    }

    public void setReportQuantity(Integer reportQuantity) {
        this.reportQuantity = reportQuantity;
    }

    public BigDecimal getReportAmount() {
        return reportAmount;
    }

    public void setReportAmount(BigDecimal reportAmount) {
        this.reportAmount = reportAmount;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
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
}
