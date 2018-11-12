package com.hwkp.model;

public class auctionSite {
    private  Integer no;
    private  String auction_id;//拍卖位ID
    private  String title;//标题
    private  String share_title;//前端分享标题
    private  String share_img;//前端分享图片
    private  String product_id;//奖品编号
    private  Integer total_round;//总轮次 总共拍卖多少轮
    private  Integer cur_round;//当前轮次，第几轮拍卖
    private  String cur_round_id;//当前轮次id
    private  Integer bid_increment;//加价幅度
    private  float begin_price;//起拍价
    private  float min_price;//最低价，保留价
    private  float max_price;//封顶价
    private  float deposit;//保证金
    private  Integer priority_lev;//优先级 降序
    private  Integer type;//1：新人专享 2：热拍
    private  Integer round_interval;//单轮间隔时间 毫秒数
    private  Integer round_duration;//单轮持续时间 毫秒数
    private  Integer is_close;//拍卖位是否关闭
    private  Integer is_published;//是否发布
    private  String publish_time;//
    private  Integer is_active;//是否删除
    private  String created_user;//
    private  String modified_user;//
    private  String modified_time;//

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShare_title() {
        return share_title;
    }

    public void setShare_title(String share_title) {
        this.share_title = share_title;
    }

    public String getShare_img() {
        return share_img;
    }

    public void setShare_img(String share_img) {
        this.share_img = share_img;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Integer getTotal_round() {
        return total_round;
    }

    public void setTotal_round(Integer total_round) {
        this.total_round = total_round;
    }

    public Integer getCur_round() {
        return cur_round;
    }

    public void setCur_round(Integer cur_round) {
        this.cur_round = cur_round;
    }

    public String getCur_round_id() {
        return cur_round_id;
    }

    public void setCur_round_id(String cur_round_id) {
        this.cur_round_id = cur_round_id;
    }

    public Integer getBid_increment() {
        return bid_increment;
    }

    public void setBid_increment(Integer bid_increment) {
        this.bid_increment = bid_increment;
    }

    public float getBegin_price() {
        return begin_price;
    }

    public void setBegin_price(float begin_price) {
        this.begin_price = begin_price;
    }

    public float getMin_price() {
        return min_price;
    }

    public void setMin_price(float min_price) {
        this.min_price = min_price;
    }

    public float getMax_price() {
        return max_price;
    }

    public void setMax_price(float max_price) {
        this.max_price = max_price;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public Integer getPriority_lev() {
        return priority_lev;
    }

    public void setPriority_lev(Integer priority_lev) {
        this.priority_lev = priority_lev;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRound_interval() {
        return round_interval;
    }

    public void setRound_interval(Integer round_interval) {
        this.round_interval = round_interval;
    }

    public Integer getRound_duration() {
        return round_duration;
    }

    public void setRound_duration(Integer round_duration) {
        this.round_duration = round_duration;
    }

    public Integer getIs_close() {
        return is_close;
    }

    public void setIs_close(Integer is_close) {
        this.is_close = is_close;
    }

    public Integer getIs_published() {
        return is_published;
    }

    public void setIs_published(Integer is_published) {
        this.is_published = is_published;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
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
