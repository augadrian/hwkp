package com.hwkp.model;

public class withdraw {
    private Integer id;
    private  String raise_id;//
    private  float previous_money;//
    private  float money;//
    private  String user_id;//
    private  String wx_openid;//
    private  String raised_time;//
    private  String nonce_str;//
    private  Integer success;//是否成功
    private  String reason;//失败原因
    private  Integer replacement_order;//是否已补单 失败时有效
    private  Integer is_active;//
    private String created_user;//
    private String created_time;//
    private String modified_user;//
    private String modified_time;//

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

    public String getCreated_user() {
        return created_user;
    }

    public void setCreated_user(String created_user) {
        this.created_user = created_user;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getModified_user() {
        return modified_user;
    }

    public void setModified_user(String modified_user) {
        this.modified_user = modified_user;
    }

    public String getModified_time() {
        return modified_time;
    }

    public void setModified_time(String modified_time) {
        this.modified_time = modified_time;
    }
}
