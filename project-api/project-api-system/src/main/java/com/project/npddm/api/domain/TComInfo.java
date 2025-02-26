package com.project.npddm.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;
import com.project.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 债券发行人信息对象 t_com_infoF
 * 
 * @author project
 * @date 2022-02-17
 */
public class TComInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String id;

    /** 是否存在 */
    @Excel(name = "是否存在")
    private Long isvalid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date ccxeid;

    /** 公司统一编码 */
    @Excel(name = "公司统一编码")
    private Long comUniCode;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String comChiName;

    /** 公司简称 */
    @Excel(name = "公司简称")
    private String comChiShortName;

    /** 公司英文名称 */
    @Excel(name = "公司英文名称")
    private String comEngName;

    /** 公司英文简称 */
    @Excel(name = "公司英文简称")
    private String comEngShortName;

    /** 公司拼音简称 */
    @Excel(name = "公司拼音简称")
    private String comSpeShortName;

    /** 证监会行业名称 */
    @Excel(name = "证监会行业名称")
    private String induUniCodeZ;

    /** 统计局行业名称 */
    @Excel(name = "统计局行业名称")
    private Long induUniCodeS;

    /** 全球行业代码 */
    @Excel(name = "全球行业代码")
    private Long induUniCodeQ;

    /** 注册资本 */
    @Excel(name = "注册资本")
    private BigDecimal regCap;

    /** 货币类型 */
    @Excel(name = "货币类型")
    private Long curyTypePar;

    /** 公司注册地址 */
    @Excel(name = "公司注册地址")
    private String regAddr;

    /** 注册地所在市/区 */
    @Excel(name = "注册地所在市/区")
    private Long areaUniCode;

    /** 公司注册地址邮编 */
    @Excel(name = "公司注册地址邮编")
    private String regAddrPost;

    /** 公司办公地址 */
    @Excel(name = "公司办公地址")
    private String offiAddr;

    /** 公司办公地址邮编 */
    @Excel(name = "公司办公地址邮编")
    private String offiAddrPost;

    /** 公司联系地址 */
    @Excel(name = "公司联系地址")
    private String comAddr;

    /** 公司联系地址邮编 */
    @Excel(name = "公司联系地址邮编")
    private String comAddrPost;

    /** 公司网址 */
    @Excel(name = "公司网址")
    private String comWeb;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String legPer;

    /** 总经理 */
    @Excel(name = "总经理")
    private String genMan;

    /** 公司电话 */
    @Excel(name = "公司电话")
    private String comTel;

    /** 客服联系电话 */
    @Excel(name = "客服联系电话")
    private String cusConTel;

    /** 公司传真 */
    @Excel(name = "公司传真")
    private String comFax;

    /** 公司电子邮件地址 */
    @Excel(name = "公司电子邮件地址")
    private String mailAddr;

    /** 公司成立日期 */
    @Excel(name = "公司成立日期")
    private String estDate;

    /** 工商登记号_营业执照注册号 */
    @Excel(name = "工商登记号_营业执照注册号")
    private String icRegCode;

    /** 国税税务登记号 */
    @Excel(name = "国税税务登记号")
    private String natTaxRegCode;

    /** 地税税务登记号 */
    @Excel(name = "地税税务登记号")
    private String locTaxRegCode;

    /** 公司类型 */
    @Excel(name = "公司类型")
    private Long typeBigPar;

    /** 公司类型中类 */
    @Excel(name = "公司类型中类")
    private Long typeMidPar;

    /** 公司类型小类 */
    @Excel(name = "公司类型小类")
    private Long typeSmaPar;

    /** 公司状态 */
    @Excel(name = "公司状态")
    private Long staPar;

    /** 母公司码 */
    @Excel(name = "母公司码")
    private Long pareComCode;

    /** 顶级机构代码 */
    @Excel(name = "顶级机构代码")
    private Long topOrgCode;

    /** 上一级机构代码 */
    @Excel(name = "上一级机构代码")
    private Long highLevelOrgCode;

    /** 层级码 */
    @Excel(name = "层级码")
    private Long hieCode;

    /** 公司经营范围 */
    @Excel(name = "公司经营范围")
    private String mainBus;

    /** 公司兼营业务 */
    @Excel(name = "公司兼营业务")
    private String sidBus;

    /** 公司简介 */
    @Excel(name = "公司简介")
    private String comPro;

    /** 成立情况与历史沿革 */
    @Excel(name = "成立情况与历史沿革")
    private String comHis;

    /** 员工总数 */
    @Excel(name = "员工总数")
    private Long staffSum;

    /** 境内会计师事务所 */
    @Excel(name = "境内会计师事务所")
    private Long terAccOffiCode;

    /** 境内会计师 */
    @Excel(name = "境内会计师")
    private String terAcc;

    /** 律师事务所 */
    @Excel(name = "律师事务所")
    private Long lawerOffiCode;

    /** 经办律师 */
    @Excel(name = "经办律师")
    private String comLawer;

    /** 资产评估机构 */
    @Excel(name = "资产评估机构")
    private Long capEstiOrgCode;

    /** 经办评估人员 */
    @Excel(name = "经办评估人员")
    private String estiStaff;

    /** 解散日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "解散日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date disDate;

    /** 解散原因 */
    @Excel(name = "解散原因")
    private String disReas;

    /** 董事会秘书 */
    @Excel(name = "董事会秘书")
    private String comStp;

    /** 董秘联系电话 */
    @Excel(name = "董秘联系电话")
    private String stpTel;

    /** 董秘传真 */
    @Excel(name = "董秘传真")
    private String stpTax;

    /** 董秘联系地址 */
    @Excel(name = "董秘联系地址")
    private String stpConAddr;

    /** 董秘电子邮件地址 */
    @Excel(name = "董秘电子邮件地址")
    private String stpMail;

    /** 证券事务代表姓名 */
    @Excel(name = "证券事务代表姓名")
    private String secReprName;

    /** 证券事务代表电话 */
    @Excel(name = "证券事务代表电话")
    private String secReprTel;

    /** 证券事务代表传真 */
    @Excel(name = "证券事务代表传真")
    private String secReprTax;

    /** 证券事务代表联系地址 */
    @Excel(name = "证券事务代表联系地址")
    private String secReprConAddr;

    /** 证券事务代表电子邮件地址 */
    @Excel(name = "证券事务代表电子邮件地址")
    private String secReprMail;

    /** 信息披露人 */
    @Excel(name = "信息披露人")
    private String infoDiscPer;

    /** 信息披露报纸 */
    @Excel(name = "信息披露报纸")
    private String infoDiscPap;

    /** 信息披露网站 */
    @Excel(name = "信息披露网站")
    private String infoDiscWeb;

    /** 公司联系人 */
    @Excel(name = "公司联系人")
    private String comConPer;

    /** 企业组织形式 */
    @Excel(name = "企业组织形式")
    private Long comOrgaFormPar;

    /** 注册地所属省/直辖市 */
    @Excel(name = "注册地所属省/直辖市")
    private Long areaUniCode1;

    /** 是否上市公司 */
    @Excel(name = "是否上市公司")
    private Long isListPar;

    /** 公司性质 */
    @Excel(name = "公司性质")
    private Long comAttrPar;

    /** A股代码 */
    @Excel(name = "A股代码")
    private Long stkUniCodeA;

    /** B股代码 */
    @Excel(name = "B股代码")
    private Long stkUniCodeB;

    /** H股代码 */
    @Excel(name = "H股代码")
    private Long stkUniCodeH;

    /** 1:中诚信 2:万得 3:财汇 99:DM */
    @Excel(name = "1:中诚信 2:万得 3:财汇 99:DM")
    private Long dataSource;

    /** 是否城投公司 0:否 1:是 */
    @Excel(name = "是否城投公司 0:否 1:是")
    private Long isCityAnnex;

    /** 发行人状态（1：通过，2：待审核，3：不通过） */
    @Excel(name = "发行人状态", readConverterExp = "1=：通过，2：待审核，3：不通过")
    private Long infoState;

    /** 社会信用代码 */
    @Excel(name = "社会信用代码")
    private String societyCode;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUser;

    /** 发行人所属机构：只适用于用户自增加的发行人 */
    @Excel(name = "发行人所属机构：只适用于用户自增加的发行人")
    private Long orgId;

    /** 0:手动新增状态  */
    @Excel(name = "0:手动新增状态 ")
    private Long entryStatus;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setIsvalid(Long isvalid) 
    {
        this.isvalid = isvalid;
    }

    public Long getIsvalid() 
    {
        return isvalid;
    }
    public void setCcxeid(Date ccxeid) 
    {
        this.ccxeid = ccxeid;
    }

    public Date getCcxeid() 
    {
        return ccxeid;
    }
    public void setComUniCode(Long comUniCode) 
    {
        this.comUniCode = comUniCode;
    }

    public Long getComUniCode() 
    {
        return comUniCode;
    }
    public void setComChiName(String comChiName) 
    {
        this.comChiName = comChiName;
    }

    public String getComChiName() 
    {
        return comChiName;
    }
    public void setComChiShortName(String comChiShortName) 
    {
        this.comChiShortName = comChiShortName;
    }

    public String getComChiShortName() 
    {
        return comChiShortName;
    }
    public void setComEngName(String comEngName) 
    {
        this.comEngName = comEngName;
    }

    public String getComEngName() 
    {
        return comEngName;
    }
    public void setComEngShortName(String comEngShortName) 
    {
        this.comEngShortName = comEngShortName;
    }

    public String getComEngShortName() 
    {
        return comEngShortName;
    }
    public void setComSpeShortName(String comSpeShortName) 
    {
        this.comSpeShortName = comSpeShortName;
    }

    public String getComSpeShortName() 
    {
        return comSpeShortName;
    }
    public void setInduUniCodeZ(String induUniCodeZ) 
    {
        this.induUniCodeZ = induUniCodeZ;
    }

    public String getInduUniCodeZ() 
    {
        return induUniCodeZ;
    }
    public void setInduUniCodeS(Long induUniCodeS) 
    {
        this.induUniCodeS = induUniCodeS;
    }

    public Long getInduUniCodeS() 
    {
        return induUniCodeS;
    }
    public void setInduUniCodeQ(Long induUniCodeQ) 
    {
        this.induUniCodeQ = induUniCodeQ;
    }

    public Long getInduUniCodeQ() 
    {
        return induUniCodeQ;
    }
    public void setRegCap(BigDecimal regCap) 
    {
        this.regCap = regCap;
    }

    public BigDecimal getRegCap() 
    {
        return regCap;
    }
    public void setCuryTypePar(Long curyTypePar) 
    {
        this.curyTypePar = curyTypePar;
    }

    public Long getCuryTypePar() 
    {
        return curyTypePar;
    }
    public void setRegAddr(String regAddr) 
    {
        this.regAddr = regAddr;
    }

    public String getRegAddr() 
    {
        return regAddr;
    }
    public void setAreaUniCode(Long areaUniCode) 
    {
        this.areaUniCode = areaUniCode;
    }

    public Long getAreaUniCode() 
    {
        return areaUniCode;
    }
    public void setRegAddrPost(String regAddrPost) 
    {
        this.regAddrPost = regAddrPost;
    }

    public String getRegAddrPost() 
    {
        return regAddrPost;
    }
    public void setOffiAddr(String offiAddr) 
    {
        this.offiAddr = offiAddr;
    }

    public String getOffiAddr() 
    {
        return offiAddr;
    }
    public void setOffiAddrPost(String offiAddrPost) 
    {
        this.offiAddrPost = offiAddrPost;
    }

    public String getOffiAddrPost() 
    {
        return offiAddrPost;
    }
    public void setComAddr(String comAddr) 
    {
        this.comAddr = comAddr;
    }

    public String getComAddr() 
    {
        return comAddr;
    }
    public void setComAddrPost(String comAddrPost) 
    {
        this.comAddrPost = comAddrPost;
    }

    public String getComAddrPost() 
    {
        return comAddrPost;
    }
    public void setComWeb(String comWeb) 
    {
        this.comWeb = comWeb;
    }

    public String getComWeb() 
    {
        return comWeb;
    }
    public void setLegPer(String legPer) 
    {
        this.legPer = legPer;
    }

    public String getLegPer() 
    {
        return legPer;
    }
    public void setGenMan(String genMan) 
    {
        this.genMan = genMan;
    }

    public String getGenMan() 
    {
        return genMan;
    }
    public void setComTel(String comTel) 
    {
        this.comTel = comTel;
    }

    public String getComTel() 
    {
        return comTel;
    }
    public void setCusConTel(String cusConTel) 
    {
        this.cusConTel = cusConTel;
    }

    public String getCusConTel() 
    {
        return cusConTel;
    }
    public void setComFax(String comFax) 
    {
        this.comFax = comFax;
    }

    public String getComFax() 
    {
        return comFax;
    }
    public void setMailAddr(String mailAddr) 
    {
        this.mailAddr = mailAddr;
    }

    public String getMailAddr() 
    {
        return mailAddr;
    }
    public void setEstDate(String estDate) 
    {
        this.estDate = estDate;
    }

    public String getEstDate() 
    {
        return estDate;
    }
    public void setIcRegCode(String icRegCode) 
    {
        this.icRegCode = icRegCode;
    }

    public String getIcRegCode() 
    {
        return icRegCode;
    }
    public void setNatTaxRegCode(String natTaxRegCode) 
    {
        this.natTaxRegCode = natTaxRegCode;
    }

    public String getNatTaxRegCode() 
    {
        return natTaxRegCode;
    }
    public void setLocTaxRegCode(String locTaxRegCode) 
    {
        this.locTaxRegCode = locTaxRegCode;
    }

    public String getLocTaxRegCode() 
    {
        return locTaxRegCode;
    }
    public void setTypeBigPar(Long typeBigPar) 
    {
        this.typeBigPar = typeBigPar;
    }

    public Long getTypeBigPar() 
    {
        return typeBigPar;
    }
    public void setTypeMidPar(Long typeMidPar) 
    {
        this.typeMidPar = typeMidPar;
    }

    public Long getTypeMidPar() 
    {
        return typeMidPar;
    }
    public void setTypeSmaPar(Long typeSmaPar) 
    {
        this.typeSmaPar = typeSmaPar;
    }

    public Long getTypeSmaPar() 
    {
        return typeSmaPar;
    }
    public void setStaPar(Long staPar) 
    {
        this.staPar = staPar;
    }

    public Long getStaPar() 
    {
        return staPar;
    }
    public void setPareComCode(Long pareComCode) 
    {
        this.pareComCode = pareComCode;
    }

    public Long getPareComCode() 
    {
        return pareComCode;
    }
    public void setTopOrgCode(Long topOrgCode) 
    {
        this.topOrgCode = topOrgCode;
    }

    public Long getTopOrgCode() 
    {
        return topOrgCode;
    }
    public void setHighLevelOrgCode(Long highLevelOrgCode) 
    {
        this.highLevelOrgCode = highLevelOrgCode;
    }

    public Long getHighLevelOrgCode() 
    {
        return highLevelOrgCode;
    }
    public void setHieCode(Long hieCode) 
    {
        this.hieCode = hieCode;
    }

    public Long getHieCode() 
    {
        return hieCode;
    }
    public void setMainBus(String mainBus) 
    {
        this.mainBus = mainBus;
    }

    public String getMainBus() 
    {
        return mainBus;
    }
    public void setSidBus(String sidBus) 
    {
        this.sidBus = sidBus;
    }

    public String getSidBus() 
    {
        return sidBus;
    }
    public void setComPro(String comPro) 
    {
        this.comPro = comPro;
    }

    public String getComPro() 
    {
        return comPro;
    }
    public void setComHis(String comHis) 
    {
        this.comHis = comHis;
    }

    public String getComHis() 
    {
        return comHis;
    }
    public void setStaffSum(Long staffSum) 
    {
        this.staffSum = staffSum;
    }

    public Long getStaffSum() 
    {
        return staffSum;
    }
    public void setTerAccOffiCode(Long terAccOffiCode) 
    {
        this.terAccOffiCode = terAccOffiCode;
    }

    public Long getTerAccOffiCode() 
    {
        return terAccOffiCode;
    }
    public void setTerAcc(String terAcc) 
    {
        this.terAcc = terAcc;
    }

    public String getTerAcc() 
    {
        return terAcc;
    }
    public void setLawerOffiCode(Long lawerOffiCode) 
    {
        this.lawerOffiCode = lawerOffiCode;
    }

    public Long getLawerOffiCode() 
    {
        return lawerOffiCode;
    }
    public void setComLawer(String comLawer) 
    {
        this.comLawer = comLawer;
    }

    public String getComLawer() 
    {
        return comLawer;
    }
    public void setCapEstiOrgCode(Long capEstiOrgCode) 
    {
        this.capEstiOrgCode = capEstiOrgCode;
    }

    public Long getCapEstiOrgCode() 
    {
        return capEstiOrgCode;
    }
    public void setEstiStaff(String estiStaff) 
    {
        this.estiStaff = estiStaff;
    }

    public String getEstiStaff() 
    {
        return estiStaff;
    }
    public void setDisDate(Date disDate) 
    {
        this.disDate = disDate;
    }

    public Date getDisDate() 
    {
        return disDate;
    }
    public void setDisReas(String disReas) 
    {
        this.disReas = disReas;
    }

    public String getDisReas() 
    {
        return disReas;
    }
    public void setComStp(String comStp) 
    {
        this.comStp = comStp;
    }

    public String getComStp() 
    {
        return comStp;
    }
    public void setStpTel(String stpTel) 
    {
        this.stpTel = stpTel;
    }

    public String getStpTel() 
    {
        return stpTel;
    }
    public void setStpTax(String stpTax) 
    {
        this.stpTax = stpTax;
    }

    public String getStpTax() 
    {
        return stpTax;
    }
    public void setStpConAddr(String stpConAddr) 
    {
        this.stpConAddr = stpConAddr;
    }

    public String getStpConAddr() 
    {
        return stpConAddr;
    }
    public void setStpMail(String stpMail) 
    {
        this.stpMail = stpMail;
    }

    public String getStpMail() 
    {
        return stpMail;
    }
    public void setSecReprName(String secReprName) 
    {
        this.secReprName = secReprName;
    }

    public String getSecReprName() 
    {
        return secReprName;
    }
    public void setSecReprTel(String secReprTel) 
    {
        this.secReprTel = secReprTel;
    }

    public String getSecReprTel() 
    {
        return secReprTel;
    }
    public void setSecReprTax(String secReprTax) 
    {
        this.secReprTax = secReprTax;
    }

    public String getSecReprTax() 
    {
        return secReprTax;
    }
    public void setSecReprConAddr(String secReprConAddr) 
    {
        this.secReprConAddr = secReprConAddr;
    }

    public String getSecReprConAddr() 
    {
        return secReprConAddr;
    }
    public void setSecReprMail(String secReprMail) 
    {
        this.secReprMail = secReprMail;
    }

    public String getSecReprMail() 
    {
        return secReprMail;
    }
    public void setInfoDiscPer(String infoDiscPer) 
    {
        this.infoDiscPer = infoDiscPer;
    }

    public String getInfoDiscPer() 
    {
        return infoDiscPer;
    }
    public void setInfoDiscPap(String infoDiscPap) 
    {
        this.infoDiscPap = infoDiscPap;
    }

    public String getInfoDiscPap() 
    {
        return infoDiscPap;
    }
    public void setInfoDiscWeb(String infoDiscWeb) 
    {
        this.infoDiscWeb = infoDiscWeb;
    }

    public String getInfoDiscWeb() 
    {
        return infoDiscWeb;
    }
    public void setComConPer(String comConPer) 
    {
        this.comConPer = comConPer;
    }

    public String getComConPer() 
    {
        return comConPer;
    }
    public void setComOrgaFormPar(Long comOrgaFormPar) 
    {
        this.comOrgaFormPar = comOrgaFormPar;
    }

    public Long getComOrgaFormPar() 
    {
        return comOrgaFormPar;
    }
    public void setAreaUniCode1(Long areaUniCode1) 
    {
        this.areaUniCode1 = areaUniCode1;
    }

    public Long getAreaUniCode1() 
    {
        return areaUniCode1;
    }
    public void setIsListPar(Long isListPar) 
    {
        this.isListPar = isListPar;
    }

    public Long getIsListPar() 
    {
        return isListPar;
    }
    public void setComAttrPar(Long comAttrPar) 
    {
        this.comAttrPar = comAttrPar;
    }

    public Long getComAttrPar() 
    {
        return comAttrPar;
    }
    public void setStkUniCodeA(Long stkUniCodeA) 
    {
        this.stkUniCodeA = stkUniCodeA;
    }

    public Long getStkUniCodeA() 
    {
        return stkUniCodeA;
    }
    public void setStkUniCodeB(Long stkUniCodeB) 
    {
        this.stkUniCodeB = stkUniCodeB;
    }

    public Long getStkUniCodeB() 
    {
        return stkUniCodeB;
    }
    public void setStkUniCodeH(Long stkUniCodeH) 
    {
        this.stkUniCodeH = stkUniCodeH;
    }

    public Long getStkUniCodeH() 
    {
        return stkUniCodeH;
    }
    public void setDataSource(Long dataSource) 
    {
        this.dataSource = dataSource;
    }

    public Long getDataSource() 
    {
        return dataSource;
    }
    public void setIsCityAnnex(Long isCityAnnex) 
    {
        this.isCityAnnex = isCityAnnex;
    }

    public Long getIsCityAnnex() 
    {
        return isCityAnnex;
    }
    public void setInfoState(Long infoState) 
    {
        this.infoState = infoState;
    }

    public Long getInfoState() 
    {
        return infoState;
    }
    public void setSocietyCode(String societyCode) 
    {
        this.societyCode = societyCode;
    }

    public String getSocietyCode() 
    {
        return societyCode;
    }
    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isvalid", getIsvalid())
            .append("ccxeid", getCcxeid())
            .append("comUniCode", getComUniCode())
            .append("comChiName", getComChiName())
            .append("comChiShortName", getComChiShortName())
            .append("comEngName", getComEngName())
            .append("comEngShortName", getComEngShortName())
            .append("comSpeShortName", getComSpeShortName())
            .append("induUniCodeZ", getInduUniCodeZ())
            .append("induUniCodeS", getInduUniCodeS())
            .append("induUniCodeQ", getInduUniCodeQ())
            .append("regCap", getRegCap())
            .append("curyTypePar", getCuryTypePar())
            .append("regAddr", getRegAddr())
            .append("areaUniCode", getAreaUniCode())
            .append("regAddrPost", getRegAddrPost())
            .append("offiAddr", getOffiAddr())
            .append("offiAddrPost", getOffiAddrPost())
            .append("comAddr", getComAddr())
            .append("comAddrPost", getComAddrPost())
            .append("comWeb", getComWeb())
            .append("legPer", getLegPer())
            .append("genMan", getGenMan())
            .append("comTel", getComTel())
            .append("cusConTel", getCusConTel())
            .append("comFax", getComFax())
            .append("mailAddr", getMailAddr())
            .append("estDate", getEstDate())
            .append("icRegCode", getIcRegCode())
            .append("natTaxRegCode", getNatTaxRegCode())
            .append("locTaxRegCode", getLocTaxRegCode())
            .append("typeBigPar", getTypeBigPar())
            .append("typeMidPar", getTypeMidPar())
            .append("typeSmaPar", getTypeSmaPar())
            .append("staPar", getStaPar())
            .append("pareComCode", getPareComCode())
            .append("topOrgCode", getTopOrgCode())
            .append("highLevelOrgCode", getHighLevelOrgCode())
            .append("hieCode", getHieCode())
            .append("mainBus", getMainBus())
            .append("sidBus", getSidBus())
            .append("comPro", getComPro())
            .append("comHis", getComHis())
            .append("staffSum", getStaffSum())
            .append("terAccOffiCode", getTerAccOffiCode())
            .append("terAcc", getTerAcc())
            .append("lawerOffiCode", getLawerOffiCode())
            .append("comLawer", getComLawer())
            .append("capEstiOrgCode", getCapEstiOrgCode())
            .append("estiStaff", getEstiStaff())
            .append("disDate", getDisDate())
            .append("disReas", getDisReas())
            .append("comStp", getComStp())
            .append("stpTel", getStpTel())
            .append("stpTax", getStpTax())
            .append("stpConAddr", getStpConAddr())
            .append("stpMail", getStpMail())
            .append("secReprName", getSecReprName())
            .append("secReprTel", getSecReprTel())
            .append("secReprTax", getSecReprTax())
            .append("secReprConAddr", getSecReprConAddr())
            .append("secReprMail", getSecReprMail())
            .append("infoDiscPer", getInfoDiscPer())
            .append("infoDiscPap", getInfoDiscPap())
            .append("infoDiscWeb", getInfoDiscWeb())
            .append("comConPer", getComConPer())
            .append("comOrgaFormPar", getComOrgaFormPar())
            .append("areaUniCode1", getAreaUniCode1())
            .append("isListPar", getIsListPar())
            .append("comAttrPar", getComAttrPar())
            .append("stkUniCodeA", getStkUniCodeA())
            .append("stkUniCodeB", getStkUniCodeB())
            .append("stkUniCodeH", getStkUniCodeH())
            .append("dataSource", getDataSource())
            .append("isCityAnnex", getIsCityAnnex())
            .append("infoState", getInfoState())
            .append("societyCode", getSocietyCode())
            .append("updateUser", getUpdateUser())
            .append("orgId", getOrgId())
            .append("entryStatus", getEntryStatus())
            .toString();
    }
}
