package com.hwkp.entity;

import javax.persistence.*;

@Entity
@Table(name="sys_admin_account")
public class SysAdminAccountEntity {
    private Integer no;
    private String userId;//
    private String wxOpenid;//
    private String account;//
    private String password;//
    private String headUrl;//
    private String userName;//
    private Integer permission;
    private String lastLoginTime;//
    private Integer isBanded;//
    private Integer isActive;//
    private String createdUser;//
    private String createdTime;//
    private String modifiedUser;//
    private String modifiedTime;//
    @Id
    @Column(name = "no", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
    @Column(name = "user_id", unique = true, nullable = false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "wx_openid", unique = true, nullable = false)

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }
    @Column(name = "account", unique = true, nullable = false)

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    @Column(name = "password", unique = true, nullable = false)

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "head_url", unique = true, nullable = false)

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
    @Column(name = "user_name", unique = true, nullable = false)

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name = "last_login_time", unique = true, nullable = false)

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    @Column(name = "is_banded", unique = true, nullable = false)

    public Integer getIsBanded() {
        return isBanded;
    }

    public void setIsBanded(Integer isBanded) {
        this.isBanded = isBanded;
    }
    @Column(name = "is_active", unique = true, nullable = false)

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
    @Column(name = "created_user", unique = true, nullable = false)

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }
    @Column(name = "created_time", unique = true, nullable = false)

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
    @Column(name = "modified_user", unique = true, nullable = false)

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
    @Column(name = "modified_time", unique = true, nullable = false)

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    @Column(name = "permission", unique = true, nullable = false)

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }
}