package com.hwkp.model;

public class bidLog {
    private  Integer id;
    private String round_id;//轮次ID
    private float bid_price;//出价价格
    private float bid_increment;//加价幅度
    private Integer is_active;
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

    public String getRound_id() {
        return round_id;
    }

    public void setRound_id(String round_id) {
        this.round_id = round_id;
    }

    public float getBid_price() {
        return bid_price;
    }

    public void setBid_price(float bid_price) {
        this.bid_price = bid_price;
    }

    public float getBid_increment() {
        return bid_increment;
    }

    public void setBid_increment(float bid_increment) {
        this.bid_increment = bid_increment;
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
