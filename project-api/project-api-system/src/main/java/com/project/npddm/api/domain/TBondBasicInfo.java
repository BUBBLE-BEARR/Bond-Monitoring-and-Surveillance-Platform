package com.project.npddm.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;
import com.project.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 【请填写功能名称】对象 t_bond_basic_info
 * 
 * @author project
 * @date 2022-01-05
 */
public class TBondBasicInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id（自增长） */
    private Long id;

    /** 债券统一编码 */
    @Excel(name = "债券统一编码")
    private Long bondUniCode;

    /** 债券代码 */
    @Excel(name = "债券代码")
    private String bondCode;

    /** 债券简称 */
    @Excel(name = "债券简称")
    private String bondShortName;

    /** 债券全称 */
    @Excel(name = "债券全称")
    private String bondFullName;

    /** 发行人统一编码 */
    @Excel(name = "发行人统一编码")
    private Long comUniCode;

    /** 发行人名称 */
    @Excel(name = "发行人名称")
    private String issName;

    /** 发行起始日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发行起始日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date issStartDate;

    /** 发行截止日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发行截止日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date issEndDate;

    /** 每年付息日 */
    @Excel(name = "每年付息日")
    private String yearPayDate;

    /** 每年付息期限(文字描述) */
    @Excel(name = "每年付息期限(文字描述)")
    private String yearPayMatu;

    /** 起息日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "起息日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inteStartDate;

    /** 理论到期日（同实际到期日）  */
    @Excel(name = "理论到期日", readConverterExp = "同=实际到期日")
    private Date theoEndDate;

    /** 付息频率 */
    @Excel(name = "付息频率")
    private Long intePayFreq;

    /** 付息方式 */
    @Excel(name = "付息方式")
    private Long intePayClsPar;

    /** 行权兑付日 */
    @Excel(name = "行权兑付日")
    private String exerPayDate;

    /** 计划发行总额(含增发) */
    @Excel(name = "计划发行总额(含增发)")
    private BigDecimal planIssAmut;

    /** 实际发行总额(含增发) */
    @Excel(name = "实际发行总额(含增发)")
    private BigDecimal actuIssAmut;

    /** 债券期限 */
    @Excel(name = "债券期限")
    private BigDecimal bondMatu;

    /** 债券类型 */
    @Excel(name = "债券类型")
    private Long bondTypePar;

    /** 评级机构 */
    @Excel(name = "评级机构")
    private Long credUniCode;

    /** 利率类型 */
    @Excel(name = "利率类型")
    private Long rateTypePar;

    /** 利率简述 */
    @Excel(name = "利率简述")
    private String rateDes;

    /** 票面利率 */
    @Excel(name = "票面利率")
    private BigDecimal issCoupRate;

    /** 浮息基准 */
    @Excel(name = "浮息基准")
    private String baseRatePar;

    /** 上市日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上市日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date listDate;

    /** 上市公告日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上市公告日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date listDeclDate;

    /** 流通市场 */
    @Excel(name = "流通市场")
    private String secMarPar;

    /** 募集资金用途 */
    @Excel(name = "募集资金用途")
    private String collCapPurp;

    /** 主承销商 */
    @Excel(name = "主承销商")
    private String undeName;

    /** 承销方式 */
    @Excel(name = "承销方式")
    private Long undeClsPar;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String issCls;

    /** 发行方式简述(dm新增) */
    @Excel(name = "发行方式简述(dm新增)")
    private String issClsDes;

    /** 发行价格 */
    @Excel(name = "发行价格")
    private BigDecimal issPri;

    /** 发行状态:0-发行中 1-已上市 2-延迟发行 3-取消发行 */
    @Excel(name = "发行状态:0-发行中 1-已上市 2-延迟发行 3-取消发行")
    private String issStatus;

    /** 是否是新债：0-否 1-是 */
    @Excel(name = "是否是新债：0-否 1-是")
    private String isNew;

    /** 债券发行年度 */
    @Excel(name = "债券发行年度")
    private String bondIssYear;

    /** 发行公告日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发行公告日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date issDeclDate;

    /** 发行对象 */
    @Excel(name = "发行对象")
    private String issObj;

    /** 是否公开发行:0-否 1-是 */
    @Excel(name = "是否公开发行:0-否 1-是")
    private String isPublicIss;

    /** 发行手续费率 */
    @Excel(name = "发行手续费率")
    private BigDecimal issFeeRate;

    /** 簿记建档日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "簿记建档日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bokepDate;

    /** 债权债务登记日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "债权债务登记日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date debtRegDate;

    /** 当前债券规模 */
    @Excel(name = "当前债券规模")
    private BigDecimal newSize;

    /** 认购单位(元) */
    @Excel(name = "认购单位(元)")
    private BigDecimal subsUnit;

    /** 最小认购数量 */
    @Excel(name = "最小认购数量")
    private BigDecimal leastSubsUnit;

    /** 货币类型 */
    @Excel(name = "货币类型")
    private Long curyTypePar;

    /** 是否流通 */
    @Excel(name = "是否流通")
    private Long isListPar;

    /** 交易单位 */
    @Excel(name = "交易单位")
    private String tradeUnit;

    /** 流通总额 */
    @Excel(name = "流通总额")
    private BigDecimal circuAmut;

    /** 是否跨市场交易:0-否 1-是 */
    @Excel(name = "是否跨市场交易:0-否 1-是")
    private String isCrosMarPar;

    /** 跨市场说明 */
    @Excel(name = "跨市场说明")
    private String crosMarDes;

    /** 上市板块 */
    @Excel(name = "上市板块")
    private Long listSectPar;

    /** 上市状态 */
    @Excel(name = "上市状态")
    private Long listStaPar;

    /** 理论退市日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "理论退市日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date theoDelistDate;

    /** 最后交易日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后交易日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastTradeDate;

    /** 摘牌日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "摘牌日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actuDelistDate;

    /** 拼音简称 */
    @Excel(name = "拼音简称")
    private String speShortName;

    /** 英文全称 */
    @Excel(name = "英文全称")
    private String engFullName;

    /** 英文简称 */
    @Excel(name = "英文简称")
    private String engShortName;

    /** ISIN代码 */
    @Excel(name = "ISIN代码")
    private String isinCode;

    /** 当前存续状态 */
    @Excel(name = "当前存续状态")
    private Long currStatus;

    /** 债券面值 */
    @Excel(name = "债券面值")
    private BigDecimal bondParVal;

    /** 特殊债券类型 */
    @Excel(name = "特殊债券类型")
    private Long isTypePar;

    /** 债券形态 */
    @Excel(name = "债券形态")
    private Long bondFormPar;

    /** 实际到期日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际到期日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actuEndDate;

    /** 计息说明 */
    @Excel(name = "计息说明")
    private String inteDes;

    /** 最新票面利率 */
    @Excel(name = "最新票面利率")
    private BigDecimal newCoupRate;

    /** 贴现债参考收益率 */
    @Excel(name = "贴现债参考收益率")
    private BigDecimal refYield;

    /** 首期利率基准日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "首期利率基准日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date initBaseRateDate;

    /** 首期基准利率 */
    @Excel(name = "首期基准利率")
    private BigDecimal baseRate;

    /** 含权额外利差 */
    @Excel(name = "含权额外利差")
    private BigDecimal optExtraSpr;

    /** 额外利差启用期次 */
    @Excel(name = "额外利差启用期次")
    private Long extraSprSeqNum;

    /** 利率浮动上限 */
    @Excel(name = "利率浮动上限")
    private BigDecimal rateCeil;

    /** 利率浮动下限 */
    @Excel(name = "利率浮动下限")
    private BigDecimal rateFloor;

    /** 利息计算方式 */
    @Excel(name = "利息计算方式")
    private Long inteCalcuClsPar;

    /** 是否分段计息 */
    @Excel(name = "是否分段计息")
    private Long isSegmPar;

    /** 利息支付方式说明 */
    @Excel(name = "利息支付方式说明")
    private String intePayMeth;

    /** 单利或复利 */
    @Excel(name = "单利或复利")
    private Long simpCompIntePar;

    /** 偿还方式 */
    @Excel(name = "偿还方式")
    private Long repayClsPayPar;

    /** 兑付日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "兑付日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date matuPayDate;

    /** 兑付手续费率 */
    @Excel(name = "兑付手续费率")
    private BigDecimal payFeeRate;

    /** 兑付期限 */
    @Excel(name = "兑付期限")
    private String payMatu;

    /** 兑付方式说明 */
    @Excel(name = "兑付方式说明")
    private String payClsDes;

    /** 含权说明 */
    @Excel(name = "含权说明")
    private String optDes;

    /** 是否有担保 */
    @Excel(name = "是否有担保")
    private Long isGuarPar;

    /** 是否可回购 */
    @Excel(name = "是否可回购")
    private Long isRepuPar;

    /** 质押券代码 */
    @Excel(name = "质押券代码")
    private String pledgeCode;

    /** 质押券简称 */
    @Excel(name = "质押券简称")
    private String pledgeName;

    /** 是否可赎回 */
    @Excel(name = "是否可赎回")
    private Long isRedemPar;

    /** 是否可回售 */
    @Excel(name = "是否可回售")
    private Long isResaPar;

    /** 是否保值 */
    @Excel(name = "是否保值")
    private Long isHedgePar;

    /** 是否免税 */
    @Excel(name = "是否免税")
    private Long isTaxFreePar;

    /** 债券期限-单位 */
    @Excel(name = "债券期限-单位")
    private Long matuUnitPar;

    /** 担保人：二级债使用，一级债使用 */
    @Excel(name = "担保人：二级债使用，一级债使用")
    private String guraName;

    /** 再担保人:二级债使用 */
    @Excel(name = "再担保人:二级债使用")
    private String guraName1;

    /** 发行状态 */
    @Excel(name = "发行状态")
    private Long issStaPar;

    /** 债券标识(同个债跨市场bond_id相同) */
    @Excel(name = "债券标识(同个债跨市场bond_id相同)")
    private Long bondId;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createUser;

    /** 最后编辑人 */
    @Excel(name = "最后编辑人")
    private Long lastUpdateUser;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastUpdateTime;

    /** 删除状态:0-未删除 1-已删除 */
    @Excel(name = "删除状态:0-未删除 1-已删除")
    private String delStatus;

    /** 数据来源 1-中诚信 2-wind */
    @Excel(name = "数据来源 1-中诚信 2-wind")
    private Long dataSource;

    /** 原始权益人,3号子表过来的数据 */
    @Excel(name = "原始权益人,3号子表过来的数据")
    private String spomName;

    /** ccxe子表名 */
    @Excel(name = "ccxe子表名")
    private Long bondType;

    /** 债券审核状态（1：通过，2：待审核，3：不通过） */
    @Excel(name = "债券审核状态", readConverterExp = "1=：通过，2：待审核，3：不通过")
    private Long infoState;

    /** 保存状态：1.正常保存，2.暂保存 */
    @Excel(name = "保存状态：1.正常保存，2.暂保存")
    private Long saveStatus;

    /** 主体信用级别参数 */
    @Excel(name = "主体信用级别参数")
    private Long issCredLevelPar;

    /** 主体信用级别 */
    @Excel(name = "主体信用级别")
    private String issCredLevel;

    /** 债券信用级别参数 */
    @Excel(name = "债券信用级别参数")
    private Long bondCredLevelPar;

    /** 债券信用级别 */
    @Excel(name = "债券信用级别")
    private String bondCredLevel;

    /** DM量化评分 */
    @Excel(name = "DM量化评分")
    private String pd;

    /** 主体量化风险等级变化： >0上升 0持平 <0下降 */
    @Excel(name = "主体量化风险等级变化： >0上升 0持平 <0下降")
    private Long pdDiff;

    /** DM量化评分级别 */
    @Excel(name = "DM量化评分级别")
    private Long pdNum;

    /** 该债所属机构：只适用于用户自增加的债 */
    @Excel(name = "该债所属机构：只适用于用户自增加的债")
    private Long orgId;

    /** 0:手动新增状态 */
    @Excel(name = "0:手动新增状态")
    private Long entryStatus;

    /** 剩余期限 */
    @Excel(name = "剩余期限")
    private String remainingTenor;

    /** 计划管理人 */
    @Excel(name = "计划管理人")
    private String planManager;

    /** 计划管理code */
    @Excel(name = "计划管理code")
    private String planCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setIssStartDate(Date issStartDate) 
    {
        this.issStartDate = issStartDate;
    }

    public Date getIssStartDate() 
    {
        return issStartDate;
    }
    public void setIssEndDate(Date issEndDate) 
    {
        this.issEndDate = issEndDate;
    }

    public Date getIssEndDate() 
    {
        return issEndDate;
    }
    public void setYearPayDate(String yearPayDate) 
    {
        this.yearPayDate = yearPayDate;
    }

    public String getYearPayDate() 
    {
        return yearPayDate;
    }
    public void setYearPayMatu(String yearPayMatu) 
    {
        this.yearPayMatu = yearPayMatu;
    }

    public String getYearPayMatu() 
    {
        return yearPayMatu;
    }
    public void setInteStartDate(Date inteStartDate) 
    {
        this.inteStartDate = inteStartDate;
    }

    public Date getInteStartDate() 
    {
        return inteStartDate;
    }
    public void setTheoEndDate(Date theoEndDate) 
    {
        this.theoEndDate = theoEndDate;
    }

    public Date getTheoEndDate() 
    {
        return theoEndDate;
    }
    public void setIntePayFreq(Long intePayFreq) 
    {
        this.intePayFreq = intePayFreq;
    }

    public Long getIntePayFreq() 
    {
        return intePayFreq;
    }
    public void setIntePayClsPar(Long intePayClsPar) 
    {
        this.intePayClsPar = intePayClsPar;
    }

    public Long getIntePayClsPar() 
    {
        return intePayClsPar;
    }
    public void setExerPayDate(String exerPayDate) 
    {
        this.exerPayDate = exerPayDate;
    }

    public String getExerPayDate() 
    {
        return exerPayDate;
    }
    public void setPlanIssAmut(BigDecimal planIssAmut) 
    {
        this.planIssAmut = planIssAmut;
    }

    public BigDecimal getPlanIssAmut() 
    {
        return planIssAmut;
    }
    public void setActuIssAmut(BigDecimal actuIssAmut) 
    {
        this.actuIssAmut = actuIssAmut;
    }

    public BigDecimal getActuIssAmut() 
    {
        return actuIssAmut;
    }
    public void setBondMatu(BigDecimal bondMatu) 
    {
        this.bondMatu = bondMatu;
    }

    public BigDecimal getBondMatu() 
    {
        return bondMatu;
    }
    public void setBondTypePar(Long bondTypePar) 
    {
        this.bondTypePar = bondTypePar;
    }

    public Long getBondTypePar() 
    {
        return bondTypePar;
    }
    public void setCredUniCode(Long credUniCode) 
    {
        this.credUniCode = credUniCode;
    }

    public Long getCredUniCode() 
    {
        return credUniCode;
    }
    public void setRateTypePar(Long rateTypePar) 
    {
        this.rateTypePar = rateTypePar;
    }

    public Long getRateTypePar() 
    {
        return rateTypePar;
    }
    public void setRateDes(String rateDes) 
    {
        this.rateDes = rateDes;
    }

    public String getRateDes() 
    {
        return rateDes;
    }
    public void setIssCoupRate(BigDecimal issCoupRate) 
    {
        this.issCoupRate = issCoupRate;
    }

    public BigDecimal getIssCoupRate() 
    {
        return issCoupRate;
    }
    public void setBaseRatePar(String baseRatePar) 
    {
        this.baseRatePar = baseRatePar;
    }

    public String getBaseRatePar() 
    {
        return baseRatePar;
    }
    public void setListDate(Date listDate) 
    {
        this.listDate = listDate;
    }

    public Date getListDate() 
    {
        return listDate;
    }
    public void setListDeclDate(Date listDeclDate) 
    {
        this.listDeclDate = listDeclDate;
    }

    public Date getListDeclDate() 
    {
        return listDeclDate;
    }
    public void setSecMarPar(String secMarPar) 
    {
        this.secMarPar = secMarPar;
    }

    public String getSecMarPar() 
    {
        return secMarPar;
    }
    public void setCollCapPurp(String collCapPurp) 
    {
        this.collCapPurp = collCapPurp;
    }

    public String getCollCapPurp() 
    {
        return collCapPurp;
    }
    public void setUndeName(String undeName) 
    {
        this.undeName = undeName;
    }

    public String getUndeName() 
    {
        return undeName;
    }
    public void setUndeClsPar(Long undeClsPar) 
    {
        this.undeClsPar = undeClsPar;
    }

    public Long getUndeClsPar() 
    {
        return undeClsPar;
    }
    public void setIssCls(String issCls) 
    {
        this.issCls = issCls;
    }

    public String getIssCls() 
    {
        return issCls;
    }
    public void setIssClsDes(String issClsDes) 
    {
        this.issClsDes = issClsDes;
    }

    public String getIssClsDes() 
    {
        return issClsDes;
    }
    public void setIssPri(BigDecimal issPri) 
    {
        this.issPri = issPri;
    }

    public BigDecimal getIssPri() 
    {
        return issPri;
    }
    public void setIssStatus(String issStatus) 
    {
        this.issStatus = issStatus;
    }

    public String getIssStatus() 
    {
        return issStatus;
    }
    public void setIsNew(String isNew) 
    {
        this.isNew = isNew;
    }

    public String getIsNew() 
    {
        return isNew;
    }
    public void setBondIssYear(String bondIssYear) 
    {
        this.bondIssYear = bondIssYear;
    }

    public String getBondIssYear() 
    {
        return bondIssYear;
    }
    public void setIssDeclDate(Date issDeclDate) 
    {
        this.issDeclDate = issDeclDate;
    }

    public Date getIssDeclDate() 
    {
        return issDeclDate;
    }
    public void setIssObj(String issObj) 
    {
        this.issObj = issObj;
    }

    public String getIssObj() 
    {
        return issObj;
    }
    public void setIsPublicIss(String isPublicIss) 
    {
        this.isPublicIss = isPublicIss;
    }

    public String getIsPublicIss() 
    {
        return isPublicIss;
    }
    public void setIssFeeRate(BigDecimal issFeeRate) 
    {
        this.issFeeRate = issFeeRate;
    }

    public BigDecimal getIssFeeRate() 
    {
        return issFeeRate;
    }
    public void setBokepDate(Date bokepDate) 
    {
        this.bokepDate = bokepDate;
    }

    public Date getBokepDate() 
    {
        return bokepDate;
    }
    public void setDebtRegDate(Date debtRegDate) 
    {
        this.debtRegDate = debtRegDate;
    }

    public Date getDebtRegDate() 
    {
        return debtRegDate;
    }
    public void setNewSize(BigDecimal newSize) 
    {
        this.newSize = newSize;
    }

    public BigDecimal getNewSize() 
    {
        return newSize;
    }
    public void setSubsUnit(BigDecimal subsUnit) 
    {
        this.subsUnit = subsUnit;
    }

    public BigDecimal getSubsUnit() 
    {
        return subsUnit;
    }
    public void setLeastSubsUnit(BigDecimal leastSubsUnit) 
    {
        this.leastSubsUnit = leastSubsUnit;
    }

    public BigDecimal getLeastSubsUnit() 
    {
        return leastSubsUnit;
    }
    public void setCuryTypePar(Long curyTypePar) 
    {
        this.curyTypePar = curyTypePar;
    }

    public Long getCuryTypePar() 
    {
        return curyTypePar;
    }
    public void setIsListPar(Long isListPar) 
    {
        this.isListPar = isListPar;
    }

    public Long getIsListPar() 
    {
        return isListPar;
    }
    public void setTradeUnit(String tradeUnit) 
    {
        this.tradeUnit = tradeUnit;
    }

    public String getTradeUnit() 
    {
        return tradeUnit;
    }
    public void setCircuAmut(BigDecimal circuAmut) 
    {
        this.circuAmut = circuAmut;
    }

    public BigDecimal getCircuAmut() 
    {
        return circuAmut;
    }
    public void setIsCrosMarPar(String isCrosMarPar) 
    {
        this.isCrosMarPar = isCrosMarPar;
    }

    public String getIsCrosMarPar() 
    {
        return isCrosMarPar;
    }
    public void setCrosMarDes(String crosMarDes) 
    {
        this.crosMarDes = crosMarDes;
    }

    public String getCrosMarDes() 
    {
        return crosMarDes;
    }
    public void setListSectPar(Long listSectPar) 
    {
        this.listSectPar = listSectPar;
    }

    public Long getListSectPar() 
    {
        return listSectPar;
    }
    public void setListStaPar(Long listStaPar) 
    {
        this.listStaPar = listStaPar;
    }

    public Long getListStaPar() 
    {
        return listStaPar;
    }
    public void setTheoDelistDate(Date theoDelistDate) 
    {
        this.theoDelistDate = theoDelistDate;
    }

    public Date getTheoDelistDate() 
    {
        return theoDelistDate;
    }
    public void setLastTradeDate(Date lastTradeDate) 
    {
        this.lastTradeDate = lastTradeDate;
    }

    public Date getLastTradeDate() 
    {
        return lastTradeDate;
    }
    public void setActuDelistDate(Date actuDelistDate) 
    {
        this.actuDelistDate = actuDelistDate;
    }

    public Date getActuDelistDate() 
    {
        return actuDelistDate;
    }
    public void setSpeShortName(String speShortName) 
    {
        this.speShortName = speShortName;
    }

    public String getSpeShortName() 
    {
        return speShortName;
    }
    public void setEngFullName(String engFullName) 
    {
        this.engFullName = engFullName;
    }

    public String getEngFullName() 
    {
        return engFullName;
    }
    public void setEngShortName(String engShortName) 
    {
        this.engShortName = engShortName;
    }

    public String getEngShortName() 
    {
        return engShortName;
    }
    public void setIsinCode(String isinCode) 
    {
        this.isinCode = isinCode;
    }

    public String getIsinCode() 
    {
        return isinCode;
    }
    public void setCurrStatus(Long currStatus) 
    {
        this.currStatus = currStatus;
    }

    public Long getCurrStatus() 
    {
        return currStatus;
    }
    public void setBondParVal(BigDecimal bondParVal) 
    {
        this.bondParVal = bondParVal;
    }

    public BigDecimal getBondParVal() 
    {
        return bondParVal;
    }
    public void setIsTypePar(Long isTypePar) 
    {
        this.isTypePar = isTypePar;
    }

    public Long getIsTypePar() 
    {
        return isTypePar;
    }
    public void setBondFormPar(Long bondFormPar) 
    {
        this.bondFormPar = bondFormPar;
    }

    public Long getBondFormPar() 
    {
        return bondFormPar;
    }
    public void setActuEndDate(Date actuEndDate) 
    {
        this.actuEndDate = actuEndDate;
    }

    public Date getActuEndDate() 
    {
        return actuEndDate;
    }
    public void setInteDes(String inteDes) 
    {
        this.inteDes = inteDes;
    }

    public String getInteDes() 
    {
        return inteDes;
    }
    public void setNewCoupRate(BigDecimal newCoupRate) 
    {
        this.newCoupRate = newCoupRate;
    }

    public BigDecimal getNewCoupRate() 
    {
        return newCoupRate;
    }
    public void setRefYield(BigDecimal refYield) 
    {
        this.refYield = refYield;
    }

    public BigDecimal getRefYield() 
    {
        return refYield;
    }
    public void setInitBaseRateDate(Date initBaseRateDate) 
    {
        this.initBaseRateDate = initBaseRateDate;
    }

    public Date getInitBaseRateDate() 
    {
        return initBaseRateDate;
    }
    public void setBaseRate(BigDecimal baseRate) 
    {
        this.baseRate = baseRate;
    }

    public BigDecimal getBaseRate() 
    {
        return baseRate;
    }
    public void setOptExtraSpr(BigDecimal optExtraSpr) 
    {
        this.optExtraSpr = optExtraSpr;
    }

    public BigDecimal getOptExtraSpr() 
    {
        return optExtraSpr;
    }
    public void setExtraSprSeqNum(Long extraSprSeqNum) 
    {
        this.extraSprSeqNum = extraSprSeqNum;
    }

    public Long getExtraSprSeqNum() 
    {
        return extraSprSeqNum;
    }
    public void setRateCeil(BigDecimal rateCeil) 
    {
        this.rateCeil = rateCeil;
    }

    public BigDecimal getRateCeil() 
    {
        return rateCeil;
    }
    public void setRateFloor(BigDecimal rateFloor) 
    {
        this.rateFloor = rateFloor;
    }

    public BigDecimal getRateFloor() 
    {
        return rateFloor;
    }
    public void setInteCalcuClsPar(Long inteCalcuClsPar) 
    {
        this.inteCalcuClsPar = inteCalcuClsPar;
    }

    public Long getInteCalcuClsPar() 
    {
        return inteCalcuClsPar;
    }
    public void setIsSegmPar(Long isSegmPar) 
    {
        this.isSegmPar = isSegmPar;
    }

    public Long getIsSegmPar() 
    {
        return isSegmPar;
    }
    public void setIntePayMeth(String intePayMeth) 
    {
        this.intePayMeth = intePayMeth;
    }

    public String getIntePayMeth() 
    {
        return intePayMeth;
    }
    public void setSimpCompIntePar(Long simpCompIntePar) 
    {
        this.simpCompIntePar = simpCompIntePar;
    }

    public Long getSimpCompIntePar() 
    {
        return simpCompIntePar;
    }
    public void setRepayClsPayPar(Long repayClsPayPar) 
    {
        this.repayClsPayPar = repayClsPayPar;
    }

    public Long getRepayClsPayPar() 
    {
        return repayClsPayPar;
    }
    public void setMatuPayDate(Date matuPayDate) 
    {
        this.matuPayDate = matuPayDate;
    }

    public Date getMatuPayDate() 
    {
        return matuPayDate;
    }
    public void setPayFeeRate(BigDecimal payFeeRate) 
    {
        this.payFeeRate = payFeeRate;
    }

    public BigDecimal getPayFeeRate() 
    {
        return payFeeRate;
    }
    public void setPayMatu(String payMatu) 
    {
        this.payMatu = payMatu;
    }

    public String getPayMatu() 
    {
        return payMatu;
    }
    public void setPayClsDes(String payClsDes) 
    {
        this.payClsDes = payClsDes;
    }

    public String getPayClsDes() 
    {
        return payClsDes;
    }
    public void setOptDes(String optDes) 
    {
        this.optDes = optDes;
    }

    public String getOptDes() 
    {
        return optDes;
    }
    public void setIsGuarPar(Long isGuarPar) 
    {
        this.isGuarPar = isGuarPar;
    }

    public Long getIsGuarPar() 
    {
        return isGuarPar;
    }
    public void setIsRepuPar(Long isRepuPar) 
    {
        this.isRepuPar = isRepuPar;
    }

    public Long getIsRepuPar() 
    {
        return isRepuPar;
    }
    public void setPledgeCode(String pledgeCode) 
    {
        this.pledgeCode = pledgeCode;
    }

    public String getPledgeCode() 
    {
        return pledgeCode;
    }
    public void setPledgeName(String pledgeName) 
    {
        this.pledgeName = pledgeName;
    }

    public String getPledgeName() 
    {
        return pledgeName;
    }
    public void setIsRedemPar(Long isRedemPar) 
    {
        this.isRedemPar = isRedemPar;
    }

    public Long getIsRedemPar() 
    {
        return isRedemPar;
    }
    public void setIsResaPar(Long isResaPar) 
    {
        this.isResaPar = isResaPar;
    }

    public Long getIsResaPar() 
    {
        return isResaPar;
    }
    public void setIsHedgePar(Long isHedgePar) 
    {
        this.isHedgePar = isHedgePar;
    }

    public Long getIsHedgePar() 
    {
        return isHedgePar;
    }
    public void setIsTaxFreePar(Long isTaxFreePar) 
    {
        this.isTaxFreePar = isTaxFreePar;
    }

    public Long getIsTaxFreePar() 
    {
        return isTaxFreePar;
    }
    public void setMatuUnitPar(Long matuUnitPar) 
    {
        this.matuUnitPar = matuUnitPar;
    }

    public Long getMatuUnitPar() 
    {
        return matuUnitPar;
    }
    public void setGuraName(String guraName) 
    {
        this.guraName = guraName;
    }

    public String getGuraName() 
    {
        return guraName;
    }
    public void setGuraName1(String guraName1) 
    {
        this.guraName1 = guraName1;
    }

    public String getGuraName1() 
    {
        return guraName1;
    }
    public void setIssStaPar(Long issStaPar) 
    {
        this.issStaPar = issStaPar;
    }

    public Long getIssStaPar() 
    {
        return issStaPar;
    }
    public void setBondId(Long bondId) 
    {
        this.bondId = bondId;
    }

    public Long getBondId() 
    {
        return bondId;
    }
    public void setCreateUser(Long createUser) 
    {
        this.createUser = createUser;
    }

    public Long getCreateUser() 
    {
        return createUser;
    }
    public void setLastUpdateUser(Long lastUpdateUser) 
    {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Long getLastUpdateUser() 
    {
        return lastUpdateUser;
    }
    public void setLastUpdateTime(Date lastUpdateTime) 
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastUpdateTime() 
    {
        return lastUpdateTime;
    }
    public void setDelStatus(String delStatus) 
    {
        this.delStatus = delStatus;
    }

    public String getDelStatus() 
    {
        return delStatus;
    }
    public void setDataSource(Long dataSource) 
    {
        this.dataSource = dataSource;
    }

    public Long getDataSource() 
    {
        return dataSource;
    }
    public void setSpomName(String spomName) 
    {
        this.spomName = spomName;
    }

    public String getSpomName() 
    {
        return spomName;
    }
    public void setBondType(Long bondType) 
    {
        this.bondType = bondType;
    }

    public Long getBondType() 
    {
        return bondType;
    }
    public void setInfoState(Long infoState) 
    {
        this.infoState = infoState;
    }

    public Long getInfoState() 
    {
        return infoState;
    }
    public void setSaveStatus(Long saveStatus) 
    {
        this.saveStatus = saveStatus;
    }

    public Long getSaveStatus() 
    {
        return saveStatus;
    }
    public void setIssCredLevelPar(Long issCredLevelPar) 
    {
        this.issCredLevelPar = issCredLevelPar;
    }

    public Long getIssCredLevelPar() 
    {
        return issCredLevelPar;
    }
    public void setIssCredLevel(String issCredLevel) 
    {
        this.issCredLevel = issCredLevel;
    }

    public String getIssCredLevel() 
    {
        return issCredLevel;
    }
    public void setBondCredLevelPar(Long bondCredLevelPar) 
    {
        this.bondCredLevelPar = bondCredLevelPar;
    }

    public Long getBondCredLevelPar() 
    {
        return bondCredLevelPar;
    }
    public void setBondCredLevel(String bondCredLevel) 
    {
        this.bondCredLevel = bondCredLevel;
    }

    public String getBondCredLevel() 
    {
        return bondCredLevel;
    }
    public void setPd(String pd) 
    {
        this.pd = pd;
    }

    public String getPd() 
    {
        return pd;
    }
    public void setPdDiff(Long pdDiff) 
    {
        this.pdDiff = pdDiff;
    }

    public Long getPdDiff() 
    {
        return pdDiff;
    }
    public void setPdNum(Long pdNum) 
    {
        this.pdNum = pdNum;
    }

    public Long getPdNum() 
    {
        return pdNum;
    }
    public void setOrgId(Long orgId) 
    {
        this.orgId = orgId;
    }

    public Long getOrgId() 
    {
        return orgId;
    }
    public void setEntryStatus(Long entryStatus) 
    {
        this.entryStatus = entryStatus;
    }

    public Long getEntryStatus() 
    {
        return entryStatus;
    }
    public void setRemainingTenor(String remainingTenor) 
    {
        this.remainingTenor = remainingTenor;
    }

    public String getRemainingTenor() 
    {
        return remainingTenor;
    }
    public void setPlanManager(String planManager) 
    {
        this.planManager = planManager;
    }

    public String getPlanManager() 
    {
        return planManager;
    }
    public void setPlanCode(String planCode) 
    {
        this.planCode = planCode;
    }

    public String getPlanCode() 
    {
        return planCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bondUniCode", getBondUniCode())
            .append("bondCode", getBondCode())
            .append("bondShortName", getBondShortName())
            .append("bondFullName", getBondFullName())
            .append("comUniCode", getComUniCode())
            .append("issName", getIssName())
            .append("issStartDate", getIssStartDate())
            .append("issEndDate", getIssEndDate())
            .append("yearPayDate", getYearPayDate())
            .append("yearPayMatu", getYearPayMatu())
            .append("inteStartDate", getInteStartDate())
            .append("theoEndDate", getTheoEndDate())
            .append("intePayFreq", getIntePayFreq())
            .append("intePayClsPar", getIntePayClsPar())
            .append("exerPayDate", getExerPayDate())
            .append("planIssAmut", getPlanIssAmut())
            .append("actuIssAmut", getActuIssAmut())
            .append("bondMatu", getBondMatu())
            .append("bondTypePar", getBondTypePar())
            .append("credUniCode", getCredUniCode())
            .append("rateTypePar", getRateTypePar())
            .append("rateDes", getRateDes())
            .append("issCoupRate", getIssCoupRate())
            .append("baseRatePar", getBaseRatePar())
            .append("listDate", getListDate())
            .append("listDeclDate", getListDeclDate())
            .append("secMarPar", getSecMarPar())
            .append("collCapPurp", getCollCapPurp())
            .append("undeName", getUndeName())
            .append("undeClsPar", getUndeClsPar())
            .append("issCls", getIssCls())
            .append("issClsDes", getIssClsDes())
            .append("issPri", getIssPri())
            .append("issStatus", getIssStatus())
            .append("isNew", getIsNew())
            .append("bondIssYear", getBondIssYear())
            .append("issDeclDate", getIssDeclDate())
            .append("issObj", getIssObj())
            .append("isPublicIss", getIsPublicIss())
            .append("issFeeRate", getIssFeeRate())
            .append("bokepDate", getBokepDate())
            .append("debtRegDate", getDebtRegDate())
            .append("newSize", getNewSize())
            .append("subsUnit", getSubsUnit())
            .append("leastSubsUnit", getLeastSubsUnit())
            .append("curyTypePar", getCuryTypePar())
            .append("isListPar", getIsListPar())
            .append("tradeUnit", getTradeUnit())
            .append("circuAmut", getCircuAmut())
            .append("isCrosMarPar", getIsCrosMarPar())
            .append("crosMarDes", getCrosMarDes())
            .append("listSectPar", getListSectPar())
            .append("listStaPar", getListStaPar())
            .append("theoDelistDate", getTheoDelistDate())
            .append("lastTradeDate", getLastTradeDate())
            .append("actuDelistDate", getActuDelistDate())
            .append("speShortName", getSpeShortName())
            .append("engFullName", getEngFullName())
            .append("engShortName", getEngShortName())
            .append("isinCode", getIsinCode())
            .append("currStatus", getCurrStatus())
            .append("bondParVal", getBondParVal())
            .append("isTypePar", getIsTypePar())
            .append("bondFormPar", getBondFormPar())
            .append("actuEndDate", getActuEndDate())
            .append("inteDes", getInteDes())
            .append("newCoupRate", getNewCoupRate())
            .append("refYield", getRefYield())
            .append("initBaseRateDate", getInitBaseRateDate())
            .append("baseRate", getBaseRate())
            .append("optExtraSpr", getOptExtraSpr())
            .append("extraSprSeqNum", getExtraSprSeqNum())
            .append("rateCeil", getRateCeil())
            .append("rateFloor", getRateFloor())
            .append("inteCalcuClsPar", getInteCalcuClsPar())
            .append("isSegmPar", getIsSegmPar())
            .append("intePayMeth", getIntePayMeth())
            .append("simpCompIntePar", getSimpCompIntePar())
            .append("repayClsPayPar", getRepayClsPayPar())
            .append("matuPayDate", getMatuPayDate())
            .append("payFeeRate", getPayFeeRate())
            .append("payMatu", getPayMatu())
            .append("payClsDes", getPayClsDes())
            .append("optDes", getOptDes())
            .append("isGuarPar", getIsGuarPar())
            .append("isRepuPar", getIsRepuPar())
            .append("pledgeCode", getPledgeCode())
            .append("pledgeName", getPledgeName())
            .append("isRedemPar", getIsRedemPar())
            .append("isResaPar", getIsResaPar())
            .append("isHedgePar", getIsHedgePar())
            .append("isTaxFreePar", getIsTaxFreePar())
            .append("matuUnitPar", getMatuUnitPar())
            .append("guraName", getGuraName())
            .append("guraName1", getGuraName1())
            .append("issStaPar", getIssStaPar())
            .append("bondId", getBondId())
            .append("createUser", getCreateUser())
            .append("lastUpdateUser", getLastUpdateUser())
            .append("createTime", getCreateTime())
            .append("lastUpdateTime", getLastUpdateTime())
            .append("delStatus", getDelStatus())
            .append("dataSource", getDataSource())
            .append("spomName", getSpomName())
            .append("bondType", getBondType())
            .append("infoState", getInfoState())
            .append("saveStatus", getSaveStatus())
            .append("issCredLevelPar", getIssCredLevelPar())
            .append("issCredLevel", getIssCredLevel())
            .append("bondCredLevelPar", getBondCredLevelPar())
            .append("bondCredLevel", getBondCredLevel())
            .append("pd", getPd())
            .append("pdDiff", getPdDiff())
            .append("pdNum", getPdNum())
            .append("orgId", getOrgId())
            .append("entryStatus", getEntryStatus())
            .append("remainingTenor", getRemainingTenor())
            .append("planManager", getPlanManager())
            .append("planCode", getPlanCode())
            .toString();
    }
}
