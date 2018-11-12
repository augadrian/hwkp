package com.hwkp.model;

public class moneyLog {
    private Integer id;
    private String object_id;//
    private double money;//
    private String wx_openid;//
    private Integer type;//1.提现 2.充值 3.押金退款 4.扣除押金 5竞拍获得 6竞拍支付 7邀请获得
    private Integer is_achieved;//是否领取 默认1 已领取
    private Integer is_active;//
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

    public String getObject_id() {
        return object_id;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getWx_openid() {
        return wx_openid;
    }

    public void setWx_openid(String wx_openid) {
        this.wx_openid = wx_openid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIs_achieved() {
        return is_achieved;
    }

    public void setIs_achieved(Integer is_achieved) {
        this.is_achieved = is_achieved;
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
