package com.hwkp.model;

public class roundBidUser {
    private Integer id;
    private String round_id;//轮次ID
    private String product_id;//产品Id
    private String bidder_name;//竞拍者昵称
    private String bidder_url;//竞拍者头像
    private Integer bid_times;//出价次数
    private float bid_price;//当前出价
    private float commission;//加价获得佣金奖励
    private Integer is_grant;//是否发放 可能流拍
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

    public String getRound_id() {
        return round_id;
    }

    public void setRound_id(String round_id) {
        this.round_id = round_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getBidder_name() {
        return bidder_name;
    }

    public void setBidder_name(String bidder_name) {
        this.bidder_name = bidder_name;
    }

    public String getBidder_url() {
        return bidder_url;
    }

    public void setBidder_url(String bidder_url) {
        this.bidder_url = bidder_url;
    }

    public Integer getBid_times() {
        return bid_times;
    }

    public void setBid_times(Integer bid_times) {
        this.bid_times = bid_times;
    }

    public float getBid_price() {
        return bid_price;
    }

    public void setBid_price(float bid_price) {
        this.bid_price = bid_price;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public Integer getIs_grant() {
        return is_grant;
    }

    public void setIs_grant(Integer is_grant) {
        this.is_grant = is_grant;
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
