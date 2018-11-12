package com.hwkp.model;

public class auctionRound {
    private Integer no;
    private  String round_id;//轮次id
    private  String auction_id;//拍卖位ID
    private  String product_id;//拍卖产品ID
    private  float cur_bid;//当前出价
    private  String begin_time;//拍卖开始时间
    private  String end_time;//拍卖结束时间
    private  String bid_times;//出价次数
    private  Integer bid_num;//出价人数
    private  Integer vendee_id;//买受人ID
    private  String vendee_name;//买受人昵称
    private  String vendee_head;//买受人头像url
    private  Integer is_pass;//是否流拍
    private  Integer is_end;//答题是否结束
    private  Integer is_active;//是否删除
    private  String created_user;//
    private  String created_time;//
    private  String modified_user;//
    private  String modified_time;//

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getRound_id() {
        return round_id;
    }

    public void setRound_id(String round_id) {
        this.round_id = round_id;
    }

    public String getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public float getCur_bid() {
        return cur_bid;
    }

    public void setCur_bid(float cur_bid) {
        this.cur_bid = cur_bid;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getBid_times() {
        return bid_times;
    }

    public void setBid_times(String bid_times) {
        this.bid_times = bid_times;
    }

    public Integer getBid_num() {
        return bid_num;
    }

    public void setBid_num(Integer bid_num) {
        this.bid_num = bid_num;
    }

    public Integer getVendee_id() {
        return vendee_id;
    }

    public void setVendee_id(Integer vendee_id) {
        this.vendee_id = vendee_id;
    }

    public String getVendee_name() {
        return vendee_name;
    }

    public void setVendee_name(String vendee_name) {
        this.vendee_name = vendee_name;
    }

    public String getVendee_head() {
        return vendee_head;
    }

    public void setVendee_head(String vendee_head) {
        this.vendee_head = vendee_head;
    }

    public Integer getIs_pass() {
        return is_pass;
    }

    public void setIs_pass(Integer is_pass) {
        this.is_pass = is_pass;
    }

    public Integer getIs_end() {
        return is_end;
    }

    public void setIs_end(Integer is_end) {
        this.is_end = is_end;
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
