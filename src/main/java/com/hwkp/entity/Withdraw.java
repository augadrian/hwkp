package com.hwkp.entity;

public class Withdraw {
    private Integer id;
    private String raise_id;//
    private float previous_money;//
    private float money;//
    private String user_id;//
    private String wx_openid;//
    private String raised_time;//
    private String nonce_str;//
    private Integer success;//是否成功
    private String reason;//失败原因
    private Integer replacement_order;//是否已补单 失败时有效
    private Integer is_active;//
    private String createdUser;//
    private String createdTime;//
    private String modifiedUser;//
    private String modifiedTime;//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaise_id() {
        return raise_id;
    }

    public void setRaise_id(String raise_id) {
        this.raise_id = raise_id;
    }

    public float getPrevious_money() {
        return previous_money;
    }

    public void setPrevious_money(float previous_money) {
        this.previous_money = previous_money;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getWx_openid() {
        return wx_openid;
    }

    public void setWx_openid(String wx_openid) {
        this.wx_openid = wx_openid;
    }

    public String getRaised_time() {
        return raised_time;
    }

    public void setRaised_time(String raised_time) {
        this.raised_time = raised_time;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getReplacement_order() {
        return replacement_order;
    }

    public void setReplacement_order(Integer replacement_order) {
        this.replacement_order = replacement_order;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}