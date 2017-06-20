package com.asiainfo.ocmanager.auth;

/**
 * Created by Yulishan on 2017/6/15.
 * Page permission POJO
 * Refactor for all page permissions
 * 添加用户
 * 更新用户
 * 删除用户
 *
 * 添加服务
 * 删除服务
 *
 * 给用户授权系统管理员
 * 给用户授权子公司管理员
 * 给用户授权项目管理员
 * 给用户授权团队成员
 */
public class PagePermission {
  private boolean createUser;
  private boolean updateUser;
  private boolean deleteUser;
  private boolean addService;
  private boolean deleteService;
  private boolean grantSysManagement;
  private boolean grantChildComManagement;
  private boolean grantProjectManagement;
  private boolean grantTeamMember;

  public boolean isCreateUser() {
    return createUser;
  }

  public void setCreateUser(boolean createUser) {
    this.createUser = createUser;
  }

  public boolean isUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(boolean updateUser) {
    this.updateUser = updateUser;
  }

  public boolean isDeleteUser() {
    return deleteUser;
  }

  public void setDeleteUser(boolean deleteUser) {
    this.deleteUser = deleteUser;
  }

  public boolean isAddService() {
    return addService;
  }

  public void setAddService(boolean addService) {
    this.addService = addService;
  }

  public boolean isDeleteService() {
    return deleteService;
  }

  public void setDeleteService(boolean deleteService) {
    this.deleteService = deleteService;
  }

  public boolean isGrantSysManagement() {
    return grantSysManagement;
  }

  public void setGrantSysManagement(boolean grantSysManagement) {
    this.grantSysManagement = grantSysManagement;
  }

  public boolean isGrantChildComManagement() {
    return grantChildComManagement;
  }

  public void setGrantChildComManagement(boolean grantChildComManagement) {
    this.grantChildComManagement = grantChildComManagement;
  }

  public boolean isGrantProjectManagement() {
    return grantProjectManagement;
  }

  public void setGrantProjectManagement(boolean grantProjectManagement) {
    this.grantProjectManagement = grantProjectManagement;
  }

  public boolean isGrantTeamMember() {
    return grantTeamMember;
  }

  public void setGrantTeamMember(boolean grantTeamMember) {
    this.grantTeamMember = grantTeamMember;
  }
}
