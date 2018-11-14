package com.hwkp.model;

public class RoundBidUser {
    private Integer id;
    private String roundId;//轮次ID
    private String productId;//产品Id
    private String bidderName;//竞拍者昵称
    private String bidderUrl;//竞拍者头像
    private Integer bidTimes;//出价次数
    private float bidPrice;//当前出价
    private float commission;//加价获得佣金奖励
    private Integer isGrant;//是否发放 可能流拍
    private Integer isActive;//
    private String createdUser;//
    private String createdTime;//
    private String modifiedUser;//
    private String modifiedTime;//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public String getBidderUrl() {
        return bidderUrl;
    }

    public void setBidderUrl(String bidderUrl) {
        this.bidderUrl = bidderUrl;
    }

    public Integer getBidTimes() {
        return bidTimes;
    }

    public void setBidTimes(Integer bidTimes) {
        this.bidTimes = bidTimes;
    }

    public float getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(float bidPrice) {
        this.bidPrice = bidPrice;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public Integer getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(Integer isGrant) {
        this.isGrant = isGrant;
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