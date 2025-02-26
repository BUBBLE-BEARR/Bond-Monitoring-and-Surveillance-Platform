package com.project.npddm.api.domain;


import com.project.common.core.annotation.Excel;

/**
 * 城投后台管理系统对象
 */
public class CtzSystemInfo {

    /**
     * id
     */
    private Long id;

    /**
     * 平台名称
     */
    @Excel(name = "平台名称")
    private String comChiName;

    /**
     * 行政级别id
     */
    @Excel(name = "行政级别id")
    private Integer areaLevelId;

    /**
     * 行政级别名称
     */
    private String areaLevelName;

    /**
     * 城投评分
     */
    private String calTotalScore;

    /**
     * 主体评级
     */
    private String issCredLevel  ;

    /**
     * 债券余额(亿)
     */
    private String comDebtBalance;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 实际控制人
     */
    private String realCtrlName;

    /**
     * 直接控制 1 直接控制 0 间接控制
     */
    private String directCtrl;

    /**
     * 控制人背景
     */
    private String newName;

    private Integer areaLevelFlag;

    public Integer getAreaLevelFlag() {
        return areaLevelFlag;
    }

    public void setAreaLevelFlag(Integer areaLevelFlag) {
        this.areaLevelFlag = areaLevelFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAreaLevelId() {
        return areaLevelId;
    }

    public void setAreaLevelId(Integer areaLevelId) {
        this.areaLevelId = areaLevelId;
    }

    public String getAreaLevelName() {
        return areaLevelName;
    }

    public void setAreaLevelName(String areaLevelName) {
        this.areaLevelName = areaLevelName;
    }

    public String getComChiName() {
        return comChiName;
    }

    public void setComChiName(String comChiName) {
        this.comChiName = comChiName;
    }

    public String getCalTotalScore() {
        return calTotalScore;
    }

    public void setCalTotalScore(String calTotalScore) {
        this.calTotalScore = calTotalScore;
    }

    public String getIssCredLevel() {
        return issCredLevel;
    }

    public void setIssCredLevel(String issCredLevel) {
        this.issCredLevel = issCredLevel;
    }

    public String getComDebtBalance() {
        return comDebtBalance;
    }

    public void setComDebtBalance(String comDebtBalance) {
        this.comDebtBalance = comDebtBalance;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getRealCtrlName() {
        return realCtrlName;
    }

    public void setRealCtrlName(String realCtrlName) {
        this.realCtrlName = realCtrlName;
    }

    public String getDirectCtrl() {
        return directCtrl;
    }

    public void setDirectCtrl(String directCtrl) {
        this.directCtrl = directCtrl;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
