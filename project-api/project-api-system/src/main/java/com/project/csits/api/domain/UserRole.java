package com.project.csits.api.domain;

public class UserRole {
  private String roleId;
  private String roleName;
  private String roleCode;
  private String description;
  private String appSysCode;

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAppSysCode() {
    return appSysCode;
  }

  public void setAppSysCode(String appSysCode) {
    this.appSysCode = appSysCode;
  }
}
