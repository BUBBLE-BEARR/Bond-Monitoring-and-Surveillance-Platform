package com.project.system.api.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 发行区域占比信息
 *
 * @author zhujiang
 */
public class IssueAreaRatioVo {
    /** 主键 */
    private Long id;

    /** 报备周期 */
    private String reportPeriod;

    /** 报备周期名称 */
    @Excel(name = "报备周期")
    private String reportPeriodCn;

    /** 发行人地区 */
    @Excel(name = "发行人地区")
    private String issArea;

    /** 占比 */
    @Excel(name = "占比")
    private BigDecimal ratio;

    /** 新增备案规模(亿元) */
    @Excel(name = "新增备案规模(亿元)")
    private BigDecimal incrReportAmount;

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

    public String getReportPeriod() {
        return reportPeriod;
    }

    public void setReportPeriod(String reportPeriod) {
        this.reportPeriod = reportPeriod;
    }

    public String getIssArea() {
        return issArea;
    }

    public void setIssArea(String issArea) {
        this.issArea = issArea;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public BigDecimal getIncrReportAmount() {
        return incrReportAmount;
    }

    public void setIncrReportAmount(BigDecimal incrReportAmount) {
        this.incrReportAmount = incrReportAmount;
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

    public String getReportPeriodCn() {
        return reportPeriodCn;
    }

    public void setReportPeriodCn(String reportPeriodCn) {
        this.reportPeriodCn = reportPeriodCn;
    }
}
