package com.project.csits.api.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 用户信息
 * @author zkk
 */
public class UserInfoResult {

  @ApiModelProperty(value = "用户Id")
  public String userId;

  @ApiModelProperty(value = "用户名称")
  public String userName;

  @ApiModelProperty(value = "性别")
  public String sex;
  @ApiModelProperty(value = "出生日期")
  public String birthdate;
  @ApiModelProperty(value = "xxxx")
  public String signature;

  @ApiModelProperty(value = "级别")
  public String secretLevel;
  @ApiModelProperty(value = "状态")
  public String status;
  @ApiModelProperty(value = "门牌号码")
  public String roomNumber;
  @ApiModelProperty(value = "用户工作电话")
  private String workPhone;
  @ApiModelProperty(value = "电话")
  public String mobileTelephone;

  @ApiModelProperty(value = "邮箱")
  public String email;


  //组织信息
  @ApiModelProperty(value = "组织信息")
  private List<OrgUnitResult> orgUnitResults;

  //职位信息
  @ApiModelProperty(value = "职位信息")
  private List<PosiInfoResult> posiInfoResults;

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

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public String getSecretLevel() {
    return secretLevel;
  }

  public void setSecretLevel(String secretLevel) {
    this.secretLevel = secretLevel;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getMobileTelephone() {
    return mobileTelephone;
  }

  public void setMobileTelephone(String mobileTelephone) {
    this.mobileTelephone = mobileTelephone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  public List<OrgUnitResult> getOrgUnitResults() {
    return orgUnitResults;
  }

  public void setOrgUnitResults(List<OrgUnitResult> orgUnitResults) {
    this.orgUnitResults = orgUnitResults;
  }

  public List<PosiInfoResult> getPosiInfoResults() {
    return posiInfoResults;
  }

  public void setPosiInfoResults(List<PosiInfoResult> posiInfoResults) {
    this.posiInfoResults = posiInfoResults;
  }
}
