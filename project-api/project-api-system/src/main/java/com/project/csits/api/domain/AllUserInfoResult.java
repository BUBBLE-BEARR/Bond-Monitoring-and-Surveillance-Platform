package com.project.csits.api.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 所有用户信息
 * @author zkk
 */
public class AllUserInfoResult {

  @ApiModelProperty(value = "用户Id")
  private String userId;

  @ApiModelProperty(value = "用户名称")
  private String userName;

  @ApiModelProperty(value = "用户账号")
  private String accountNbr;

  @ApiModelProperty(value = "用户状态")
  private String status;

  @ApiModelProperty(value = "主组织Id")
  private String masterOrgId;

  //组织信息
  @ApiModelProperty(value = "用户组织Id")
  private String[] orgIds;

  //职位信息
  @ApiModelProperty(value = "用户职位id")
  private List<String> posiIds;


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAccountNbr() {
    return accountNbr;
  }

  public void setAccountNbr(String accountNbr) {
    this.accountNbr = accountNbr;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMasterOrgId() {
    return masterOrgId;
  }

  public void setMasterOrgId(String masterOrgId) {
    this.masterOrgId = masterOrgId;
  }

  public String[] getOrgIds() {
    return orgIds;
  }

  public void setOrgIds(String[] orgIds) {
    this.orgIds = orgIds;
  }

  public List<String> getPosiIds() {
    return posiIds;
  }

  public void setPosiIds(List<String> posiIds) {
    this.posiIds = posiIds;
  }
}
