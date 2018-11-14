package com.hwkp.model;

public class AuctionRound {
    private Integer no;
    private String roundId;//轮次id
    private String auctionId;//拍卖位ID
    private String productId;//拍卖产品ID
    private float curBid;//当前出价
    private String beginTime;//拍卖开始时间
    private String endTime;//拍卖结束时间
    private String bidTimes;//出价次数
    private Integer bidNum;//出价人数
    private Integer vendeeId;//买受人ID
    private String vendeeName;//买受人昵称
    private String vendeeHead;//买受人头像url
    private Integer isPass;//是否流拍
    private Integer isEnd;//答题是否结束
    private Integer isActive;//是否删除
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

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public float getCurBid() {
        return curBid;
    }

    public void setCurBid(float curBid) {
        this.curBid = curBid;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBidTimes() {
        return bidTimes;
    }

    public void setBidTimes(String bidTimes) {
        this.bidTimes = bidTimes;
    }

    public Integer getBidNum() {
        return bidNum;
    }

    public void setBidNum(Integer bidNum) {
        this.bidNum = bidNum;
    }

    public Integer getVendeeId() {
        return vendeeId;
    }

    public void setVendeeId(Integer vendeeId) {
        this.vendeeId = vendeeId;
    }

    public String getVendeeName() {
        return vendeeName;
    }

    public void setVendeeName(String vendeeName) {
        this.vendeeName = vendeeName;
    }

    public String getVendeeHead() {
        return vendeeHead;
    }

    public void setVendeeHead(String vendeeHead) {
        this.vendeeHead = vendeeHead;
    }

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    public Integer getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Integer isEnd) {
        this.isEnd = isEnd;
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