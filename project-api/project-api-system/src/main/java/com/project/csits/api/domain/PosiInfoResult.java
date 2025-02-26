package com.project.csits.api.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息-用户职位
 */
public class PosiInfoResult {

  @ApiModelProperty(value = "职位Id")
  private String posiId;

  @ApiModelProperty(value = "职位名称")
  private String posiName;

  @ApiModelProperty(value = "职位编码")
  private String posiCode;

  @ApiModelProperty(value = "职位级别")
  private String posiLvlCode;

  @ApiModelProperty(value = "描述")
  private String posiDescrib;

  @ApiModelProperty(value = "组织Id")
  private String orgId;

  public String getPosiId() {
    return posiId;
  }

  public void setPosiId(String posiId) {
    this.posiId = posiId;
  }

  public String getPosiName() {
    return posiName;
  }

  public void setPosiName(String posiName) {
    this.posiName = posiName;
  }

  public String getPosiCode() {
    return posiCode;
  }

  public void setPosiCode(String posiCode) {
    this.posiCode = posiCode;
  }

  public String getPosiLvlCode() {
    return posiLvlCode;
  }

  public void setPosiLvlCode(String posiLvlCode) {
    this.posiLvlCode = posiLvlCode;
  }

  public String getPosiDescrib() {
    return posiDescrib;
  }

  public void setPosiDescrib(String posiDescrib) {
    this.posiDescrib = posiDescrib;
  }

  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }
}
