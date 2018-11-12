package com.hwkp.model;

public class vendee {
    private Integer id;//
    private String round_id;//轮次ID
    private String bid_name;//买受人昵称
    private String bid_head;//买受人头像
    private String product_id;//商品id
    private String order_id;//
    private float bid_price;//成交价
    private Integer is_pay;//是否支付/领取
    private String pay_time;//
    private String end_time;//截止时间
    private Integer is_send;//
    private Integer is_receive;//是否收货
    private Integer is_overdue;//是否过期
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

    public String getBid_name() {
        return bid_name;
    }

    public void setBid_name(String bid_name) {
        this.bid_name = bid_name;
    }

    public String getBid_head() {
        return bid_head;
    }

    public void setBid_head(String bid_head) {
        this.bid_head = bid_head;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public float getBid_price() {
        return bid_price;
    }

    public void setBid_price(float bid_price) {
        this.bid_price = bid_price;
    }

    public Integer getIs_pay() {
        return is_pay;
    }

    public void setIs_pay(Integer is_pay) {
        this.is_pay = is_pay;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Integer getIs_send() {
        return is_send;
    }

    public void setIs_send(Integer is_send) {
        this.is_send = is_send;
    }

    public Integer getIs_receive() {
        return is_receive;
    }

    public void setIs_receive(Integer is_receive) {
        this.is_receive = is_receive;
    }

    public Integer getIs_overdue() {
        return is_overdue;
    }

    public void setIs_overdue(Integer is_overdue) {
        this.is_overdue = is_overdue;
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
