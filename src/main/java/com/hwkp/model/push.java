package com.hwkp.model;

public class push {
    private Integer no;
    private Integer type;//默认0:通用推送 1:竞拍预约推送
    private String wx_openid;
    private String auction_site_id;//拍卖位id
    private String form_id;
    private Integer is_active;
    private String created_user;
    private String created_time;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWx_openid() {
        return wx_openid;
    }

    public void setWx_openid(String wx_openid) {
        this.wx_openid = wx_openid;
    }

    public String getAuction_site_id() {
        return auction_site_id;
    }

    public void setAuction_site_id(String auction_site_id) {
        this.auction_site_id = auction_site_id;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
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
}
