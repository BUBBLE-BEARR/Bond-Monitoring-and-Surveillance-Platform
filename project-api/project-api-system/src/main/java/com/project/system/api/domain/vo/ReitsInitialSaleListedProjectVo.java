package com.project.system.api.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Reits监管首次发售项目-已上市项目
 *
 * @author zhujiang
 */
public class ReitsInitialSaleListedProjectVo {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 代码 */
    @Excel(name = "代码")
    private String productCode;

    /** 修改之前的代码 */
    //private String  productCodeLast;

    /** 名称 */
    @Excel(name = "名称")
    private String productName;

    /** 证券简称 */
    @Excel(name = "证券简称")
    private String bondShortName;

    /** 分类 */
    @Excel(name = "分类")
    private String projectType;

    /** 原始权益人所属证监局 */
    @Excel(name = "原始权益人所属辖区")
    private String originatorSrb;

    /** 资产类型 */
    @Excel(name = "资产类型")
    private String assetsType;

    /** 交易场所 */
    @Excel(name = "交易场所")
    private String exchangeSite;

    /** 上市日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上市日期",dateFormat = "yyyy-MM-dd")
    private Date publicDate;

    /** 发行规模(亿元) */
    @Excel(name = "发行规模(亿元)")
    private BigDecimal issueScale;

    /** 债券类型 */
    @Excel(name = "原始权益人")
    private String originator;

    /** 管理公司 */
    @Excel(name = "管理公司")
    private String manageCompy;

    /** ABS管理人 */
    @Excel(name="ABS管理人")
    private String absManager;

    /** 项目公司 */
    @Excel(name = "项目公司")
    private String projectCompy;

    /** 托管行 */
    @Excel(name = "托管行")
    private String trusteeBank;

    /** 财务顾问 */
    @Excel(name = "财务顾问")
    private String fdConsultant;

    /** 资产名称 */
    @Excel(name = "资产名称")
    private String assetsName;

    /** 资产所在地 */
    @Excel(name = "资产所在地")
    private String assetsSite;

    /** 资产估值(亿元) */
    @Excel(name = "资产估值(亿元)")
    private BigDecimal assetsssessMent;

    /** IRR(内部收益率) */
    @Excel(name = "IRR(内部收益率)")
    private String irrYieldRate;

    /** cap rate(资本化率) */
    @Excel(name = "cap rate(资本化率)")
    private String capRate;

    /** 是否删除 */
    //@Excel(name = "是否删除")
    private String isDelete;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 创建人 */
    //@Excel(name = "创建人")
    private Long createBy;

    /** 更新日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 更新人 */
    private Long updateBy;

    /** 名称、原始权益人、资产名称 */
    private String productCodeOrNameOrOrigOrassName;

    /** 项目数量 */
    private String originatorSrbCount;

    /** 资产数量 */
    private String assetsCount;

    /** 占比 */
    private String  ratio;

    /** 带动投资额(亿元) */
    @Excel(name = "带动投资额(亿元)")
    private BigDecimal driveInvest;

    //public String getProductCodeLast() {
    //    return productCodeLast;
    //}
    //
    //public void setProductCodeLast(String productCodeLast) {
    //    this.productCodeLast = productCodeLast;
    //}


    public BigDecimal getDriveInvest() {
        return driveInvest;
    }

    public void setDriveInvest(BigDecimal driveInvest) {
        this.driveInvest = driveInvest;
    }

    public String getProductCodeOrNameOrOrigOrassName() {
        return productCodeOrNameOrOrigOrassName;
    }

    public void setProductCodeOrNameOrOrigOrassName(String productCodeOrNameOrOrigOrassName) {
        this.productCodeOrNameOrOrigOrassName = productCodeOrNameOrOrigOrassName;
    }

    public String getAssetsCount() {
        return assetsCount;
    }

    public void setAssetsCount(String assetsCount) {
        this.assetsCount = assetsCount;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getOriginatorSrbCount() {
        return originatorSrbCount;
    }

    public void setOriginatorSrbCount(String originatorSrbCount) {
        this.originatorSrbCount = originatorSrbCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBondShortName() {
        return bondShortName;
    }

    public void setBondShortName(String bondShortName) {
        this.bondShortName = bondShortName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getOriginatorSrb() {
        return originatorSrb;
    }

    public void setOriginatorSrb(String originatorSrb) {
        this.originatorSrb = originatorSrb;
    }

    public String getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(String assetsType) {
        this.assetsType = assetsType;
    }

    public String getExchangeSite() {
        return exchangeSite;
    }

    public void setExchangeSite(String exchangeSite) {
        this.exchangeSite = exchangeSite;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public BigDecimal getIssueScale() {
        return issueScale;
    }

    public void setIssueScale(BigDecimal issueScale) {
        this.issueScale = issueScale;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getManageCompy() {
        return manageCompy;
    }

    public void setManageCompy(String manageCompy) {
        this.manageCompy = manageCompy;
    }

    public String getAbsManager() {
        return absManager;
    }

    public void setAbsManager(String absManager) {
        this.absManager = absManager;
    }

    public String getProjectCompy() {
        return projectCompy;
    }

    public void setProjectCompy(String projectCompy) {
        this.projectCompy = projectCompy;
    }

    public String getTrusteeBank() {
        return trusteeBank;
    }

    public void setTrusteeBank(String trusteeBank) {
        this.trusteeBank = trusteeBank;
    }

    public String getFdConsultant() {
        return fdConsultant;
    }

    public void setFdConsultant(String fdConsultant) {
        this.fdConsultant = fdConsultant;
    }

    public String getAssetsName() {
        return assetsName;
    }

    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName;
    }

    public String getAssetsSite() {
        return assetsSite;
    }

    public void setAssetsSite(String assetsSite) {
        this.assetsSite = assetsSite;
    }

    public BigDecimal getAssetsssessMent() {
        return assetsssessMent;
    }

    public void setAssetsssessMent(BigDecimal assetsssessMent) {
        this.assetsssessMent = assetsssessMent;
    }

    public String getIrrYieldRate() {
        return irrYieldRate;
    }

    public void setIrrYieldRate(String irrYieldRate) {
        this.irrYieldRate = irrYieldRate;
    }

    public String getCapRate() {
        return capRate;
    }

    public void setCapRate(String capRate) {
        this.capRate = capRate;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        ReitsInitialSaleListedProjectVo that = (ReitsInitialSaleListedProjectVo) o;
        return Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode);
    }
}
