package com.project.system.api.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;
import com.project.common.core.utils.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 报备债券信息
 *
 * @author zhujiang
 */
public class ReportBondInfoVo {

    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long id;

    /** 债券代码 */
    @Excel(name = "债券代码")
    private String bondCode;

    /** 债券简称 */
    @Excel(name = "债券简称")
    private String bondShortName;

    /** 债券简称（修改前） */
    private String bondShortNameOld;

    /** 债券全称 */
    @Excel(name = "债券全称")
    private String bondFullName;

    /** 债券全称（修改前） */
    private String bondFullNameOld;

    /** 发行人名称 */
    @Excel(name = "发行人名称")
    private String comFullName;

    /** 挂牌地点 */
    @Excel(name = "挂牌地点")
    private String lstPlace;

    /** 无异议函编号 */
    @Excel(name = "无异议函编号")
    private String appNum;

    /** 主承销商 */
    @Excel(name = "主承销商")
    private String leadUnderwriter;

    /** 受托管理人 */
    @Excel(name = "受托管理人")
    private String trustee;

    /** 发行规模 */
    @Excel(name = "发行规模")
    private BigDecimal issueScale;

    /** 债券类型 */
    @Excel(name = "债券类型")
    private String bondType;

    /** 票面利率[单位] % */
    @Excel(name = "票面利率")
    private BigDecimal couponRate;

    /** 起息日期 */

    @Excel(name = "起息日期",dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date interestStartDate;

    /** 债券期限(年)[单位] 年 */
    @Excel(name = "债券期限")
    private BigDecimal bondMatu;

    /** 报备通过时间 */
    @Excel(name = "报备通过时间",dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date reportConfirmDate;

    /** 是否存在交叉违约特殊条款 */
    @Excel(name = "是否存在交叉违约特殊条款  ")
    private String isExistCrossSpecial;



    private Date reportConfirmDateStart;
    private Date reportConfirmDateEnd;

    /** 是否为新增发行人 */
    @Excel(name = "是否为新增发行人")
    private String isNewIss;

    /** 最近回售日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近回售日",dateFormat = "yyyy-MM-dd")
    private Date resaleDate;

    /** 预计到期日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计到期日",dateFormat = "yyyy-MM-dd")
    private Date antiEndDate;

    /** 募集资金用途 */
    @Excel(name = "募集资金用途")
    private String raiseFundPurpose;

    /** 主体评级 */
    @Excel(name = "主体评级")
    private String comCredLevel;

    /** 债项评级 */
    @Excel(name = "债项评级")
    private String bondCredLevel;

    /** 发行人行业类型 */
    @Excel(name = "发行人行业类型")
    private String issIndustryType;

    /** 增信方名称 */
    @Excel(name = "增信方名称")
    private String incrCredName;

    /** 增信方式 */
    @Excel(name = "增信方式")
    private String incrCredType;

    /** 增信措施 */
    @Excel(name = "增信措施")
    private String incrCredMeasure;

    /** 发行人所有制性质 */
    @Excel(name = "发行人所有制性质")
    private String issOwnership;

    /** 发行人注册地  */
    @Excel(name = "发行人注册地")
    private String issRegAddr;

    /** 发行人注册地地址（详细地址） */
//    @Excel(name = "发行人注册地地址（详细地址）")
    private String issRegDetailAddr;

    /** 总资产 */
    @Excel(name = "总资产")
    private BigDecimal totalAssets;

    /** 净资产 */
    @Excel(name = "净资产")
    private BigDecimal netAsset;

    /** 资产负债率 */
    @Excel(name = "资产负债率")
    private BigDecimal assetDebtRatio;

    /** 营业收入 */
    @Excel(name = "营业收入")
    private BigDecimal operatingIncome;

    /** 净利润 */
    @Excel(name = "净利润")
    private BigDecimal netProfit;

    /** 有息债务 */
    @Excel(name = "有息债务")
    private BigDecimal interestDebt;

    /** 是否删除 */
    private String isDelete;

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

    /** 主体或债券名称 */
    private String comOrBondName;

    public Date getReportConfirmDateStart() {
        return reportConfirmDateStart;
    }

    public void setReportConfirmDateStart(Date reportConfirmDateStart) {
        this.reportConfirmDateStart = reportConfirmDateStart;
    }

    public Date getReportConfirmDateEnd() {
        return reportConfirmDateEnd;
    }

    public void setReportConfirmDateEnd(Date reportConfirmDateEnd) {
        this.reportConfirmDateEnd = reportConfirmDateEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getBondShortName() {
        return bondShortName;
    }

    public void setBondShortName(String bondShortName) {
        this.bondShortName = bondShortName;
    }

    public String getBondShortNameOld() {
        return bondShortNameOld;
    }

    public void setBondShortNameOld(String bondShortNameOld) {
        this.bondShortNameOld = bondShortNameOld;
    }

    public String getBondFullName() {
        return bondFullName;
    }

    public void setBondFullName(String bondFullName) {
        this.bondFullName = bondFullName;
    }

    public String getBondFullNameOld() {
        return bondFullNameOld;
    }

    public void setBondFullNameOld(String bondFullNameOld) {
        this.bondFullNameOld = bondFullNameOld;
    }

    public String getComFullName() {
        return comFullName;
    }

    public void setComFullName(String comFullName) {
        this.comFullName = comFullName;
    }

    public String getLstPlace() {
        return lstPlace;
    }

    public void setLstPlace(String lstPlace) {
        this.lstPlace = lstPlace;
    }

    public String getAppNum() {
        return appNum;
    }

    public void setAppNum(String appNum) {
        this.appNum = appNum;
    }

    public String getLeadUnderwriter() {
        return leadUnderwriter;
    }

    public void setLeadUnderwriter(String leadUnderwriter) {
        this.leadUnderwriter = leadUnderwriter;
    }

    public String getTrustee() {
        return trustee;
    }

    public void setTrustee(String trustee) {
        this.trustee = trustee;
    }

    public BigDecimal getIssueScale() {
        return issueScale;
    }

    public void setIssueScale(BigDecimal issueScale) {
        this.issueScale = issueScale;
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType;
    }

    public BigDecimal getCouponRate() {
        return couponRate;
    }

    public void setCouponRate(BigDecimal couponRate) {
        this.couponRate = couponRate;
    }

    public BigDecimal getBondMatu() {
        return bondMatu;
    }

    public void setBondMatu(BigDecimal bondMatu) {
        this.bondMatu = bondMatu;
    }

    public Date getInterestStartDate() {
        return interestStartDate;
    }


    public void setInterestStartDate(Date interestStartDate) {
        this.interestStartDate = interestStartDate;
    }

    public Date getReportConfirmDate() {
        return reportConfirmDate;
    }

    public void setReportConfirmDate(Date reportConfirmDate) {
        this.reportConfirmDate = reportConfirmDate;
    }

    public String getIsExistCrossSpecial() {
        return isExistCrossSpecial;
    }

    public void setIsExistCrossSpecial(String isExistCrossSpecial) {
        this.isExistCrossSpecial = isExistCrossSpecial;
    }

    public String getIsNewIss() {
        return isNewIss;
    }

    public void setIsNewIss(String isNewIss) {
        this.isNewIss = isNewIss;
    }

    public Date getResaleDate() {
        return resaleDate;
    }

    public void setResaleDate(Date resaleDate) {
        this.resaleDate = resaleDate;
    }

    public Date getAntiEndDate() {
        return antiEndDate;
    }

    public void setAntiEndDate(Date antiEndDate) {
        this.antiEndDate = antiEndDate;
    }

    public String getRaiseFundPurpose() {
        return raiseFundPurpose;
    }

    public void setRaiseFundPurpose(String raiseFundPurpose) {
        this.raiseFundPurpose = raiseFundPurpose;
    }

    public String getComCredLevel() {
        return comCredLevel;
    }

    public void setComCredLevel(String comCredLevel) {
        this.comCredLevel = comCredLevel;
    }

    public String getBondCredLevel() {
        return bondCredLevel;
    }

    public void setBondCredLevel(String bondCredLevel) {
        this.bondCredLevel = bondCredLevel;
    }

    public String getIssIndustryType() {
        return issIndustryType;
    }

    public void setIssIndustryType(String issIndustryType) {
        this.issIndustryType = issIndustryType;
    }

    public String getIncrCredName() {
        return incrCredName;
    }

    public void setIncrCredName(String incrCredName) {
        this.incrCredName = incrCredName;
    }

    public String getIncrCredType() {
        return incrCredType;
    }

    public void setIncrCredType(String incrCredType) {
        this.incrCredType = incrCredType;
    }

    public String getIncrCredMeasure() {
        return incrCredMeasure;
    }

    public void setIncrCredMeasure(String incrCredMeasure) {
        this.incrCredMeasure = incrCredMeasure;
    }

    public String getIssOwnership() {
        return issOwnership;
    }

    public void setIssOwnership(String issOwnership) {
        this.issOwnership = issOwnership;
    }

    public String getIssRegAddr() {
        return issRegAddr;
    }

    public void setIssRegAddr(String issRegAddr) {
        this.issRegAddr = issRegAddr;
    }

    public String getIssRegDetailAddr() {
        return issRegDetailAddr;
    }

    public void setIssRegDetailAddr(String issRegDetailAddr) {
        this.issRegDetailAddr = issRegDetailAddr;
    }

    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(BigDecimal totalAssets) {
        this.totalAssets = totalAssets;
    }

    public BigDecimal getNetAsset() {
        return netAsset;
    }

    public void setNetAsset(BigDecimal netAsset) {
        this.netAsset = netAsset;
    }

    public BigDecimal getAssetDebtRatio() {
        return assetDebtRatio;
    }

    public void setAssetDebtRatio(BigDecimal assetDebtRatio) {
        this.assetDebtRatio = assetDebtRatio;
    }

    public BigDecimal getOperatingIncome() {
        return operatingIncome;
    }

    public void setOperatingIncome(BigDecimal operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public BigDecimal getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }

    public BigDecimal getInterestDebt() {
        return interestDebt;
    }

    public void setInterestDebt(BigDecimal interestDebt) {
        this.interestDebt = interestDebt;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
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

    public String getComOrBondName() {
        return comOrBondName;
    }

    public void setComOrBondName(String comOrBondName) {
        this.comOrBondName = comOrBondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        boolean flag = false;
        ReportBondInfoVo that = (ReportBondInfoVo) o;
        if(StringUtils.isBlank(bondShortName)&&StringUtils.isBlank(bondFullName)){
            flag =  StringUtils.isBlank(that.bondShortName)&&StringUtils.isBlank(that.bondFullName);
        }else if(StringUtils.isBlank(bondShortName)&&StringUtils.isNotBlank(bondFullName)){
            flag =  StringUtils.isBlank(that.bondShortName)&&bondFullName.equals(that.bondFullName);
        }else if(StringUtils.isNotBlank(bondShortName)&&StringUtils.isBlank(bondFullName)){
            flag =  bondShortName.equals(that.bondShortName) &&StringUtils.isBlank(that.bondFullName);
        }else{
            flag =  bondShortName.equals(that.bondShortName) && bondFullName.equals(that.bondFullName);
        }
        return flag ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bondShortName, bondFullName);
    }

}
