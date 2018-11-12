package com.hwkp.model;

public class product {
    private Integer no;
    private String  product_id;
    private String cover;
    private String pro_name;
    private String pro_abstract;//摘要
    private String pro_introduction;//json介绍
    private float pro_original_price;//原价
    private float express_fee;//快递费
    private Integer is_active;
    private String created_user;//
    private String created_time;//
    private String modified_user;//
    private String modified_time;//

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_abstract() {
        return pro_abstract;
    }

    public void setPro_abstract(String pro_abstract) {
        this.pro_abstract = pro_abstract;
    }

    public String getPro_introduction() {
        return pro_introduction;
    }

    public void setPro_introduction(String pro_introduction) {
        this.pro_introduction = pro_introduction;
    }

    public float getPro_original_price() {
        return pro_original_price;
    }

    public void setPro_original_price(float pro_original_price) {
        this.pro_original_price = pro_original_price;
    }

    public float getExpress_fee() {
        return express_fee;
    }

    public void setExpress_fee(float express_fee) {
        this.express_fee = express_fee;
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
