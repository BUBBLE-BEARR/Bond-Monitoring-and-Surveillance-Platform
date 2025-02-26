package com.project.csits.api.domain;

import java.util.List;

public class UserRoleResult {
  private List<UserRole> userRoleList;

  public List<UserRole> getUserRoleList() {
    return userRoleList;
  }

  public void setUserRoleList(List<UserRole> userRoleList) {
    this.userRoleList = userRoleList;
  }
}
