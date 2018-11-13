package com.hwkp.model;

public class push {
    private Integer no;
    private Integer type;//默认0:通用推送 1:竞拍预约推送
    private String wxOpenid;
    private String auctionSiteId;//拍卖位id
    private String formId;
    private Integer isActive;
    private String createdUser;
    private String createdTime;

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

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public String getAuctionSiteId() {
        return auctionSiteId;
    }

    public void setAuctionSiteId(String auctionSiteId) {
        this.auctionSiteId = auctionSiteId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
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
}