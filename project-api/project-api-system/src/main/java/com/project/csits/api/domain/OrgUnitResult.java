package com.project.csits.api.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息-组织信息
 */
public class OrgUnitResult {



  @ApiModelProperty(value = "组织名称")
  private String orgName;

  @ApiModelProperty(value = "组织类型")
  private String orgTypeCode;

  @ApiModelProperty(value = "组织编码")
  private String orgCode;

  @ApiModelProperty(value = "父Id")
  private String parentId;
  @ApiModelProperty(value = "父名称")
  private String parentName;

  @ApiModelProperty(value = "组织简称")
  private String orgAbbr;

  @ApiModelProperty(value = "组织级别代码")
  private String orgLvlCode;

  @ApiModelProperty(value = "证监会组织机构类别代码")
  private String csrcOrgTypeCode;

  @ApiModelProperty(value = "当前组织所属局级ids")
  private String dimnOrgPath;

  @ApiModelProperty(value = "当前组织所属局级名称")
  private String dimnOrgName;


  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

  public String getOrgTypeCode() {
    return orgTypeCode;
  }

  public void setOrgTypeCode(String orgTypeCode) {
    this.orgTypeCode = orgTypeCode;
  }

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode;
  }

  public String getOrgAbbr() {
    return orgAbbr;
  }

  public void setOrgAbbr(String orgAbbr) {
    this.orgAbbr = orgAbbr;
  }

  public String getOrgLvlCode() {
    return orgLvlCode;
  }

  public void setOrgLvlCode(String orgLvlCode) {
    this.orgLvlCode = orgLvlCode;
  }

  public String getCsrcOrgTypeCode() {
    return csrcOrgTypeCode;
  }

  public void setCsrcOrgTypeCode(String csrcOrgTypeCode) {
    this.csrcOrgTypeCode = csrcOrgTypeCode;
  }

  public String getDimnOrgPath() {
    return dimnOrgPath;
  }

  public void setDimnOrgPath(String dimnOrgPath) {
    this.dimnOrgPath = dimnOrgPath;
  }

  public String getDimnOrgName() {
    return dimnOrgName;
  }

  public void setDimnOrgName(String dimnOrgName) {
    this.dimnOrgName = dimnOrgName;
  }
}
