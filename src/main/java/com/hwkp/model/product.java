package com.hwkp.model;

public class product {
    private Integer no;
    private String productId;
    private String cover;
    private String proName;
    private String proAbstract;//摘要
    private String proIntroduction;//json介绍
    private float proOriginalPrice;//原价
    private float expressFee;//快递费
    private Integer isActive;
    private String createdUser;//
    private String createdTime;//
    private String modifiedUser;//
    private String modifiedTime;//

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProAbstract() {
        return proAbstract;
    }

    public void setProAbstract(String proAbstract) {
        this.proAbstract = proAbstract;
    }

    public String getProIntroduction() {
        return proIntroduction;
    }

    public void setProIntroduction(String proIntroduction) {
        this.proIntroduction = proIntroduction;
    }

    public float getProOriginal_price() {
        return proOriginalPrice;
    }

    public void setProOriginal_price(float proOriginalPrice) {
        this.proOriginalPrice = proOriginalPrice;
    }

    public float getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(float expressFee) {
        this.expressFee = expressFee;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
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