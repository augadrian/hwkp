package com.hwkp.entity;

public class AuctionSite {
    private Integer no;
    private String auctionId;//拍卖位ID
    private String title;//标题
    private String shareTitle;//前端分享标题
    private String shareImg;//前端分享图片
    private String productId;//奖品编号
    private Integer totalRound;//总轮次 总共拍卖多少轮
    private Integer curRound;//当前轮次，第几轮拍卖
    private String curRoundId;//当前轮次id
    private Integer bidIncrement;//加价幅度
    private float beginPrice;//起拍价
    private float minPrice;//最低价，保留价
    private float maxPrice;//封顶价
    private float deposit;//保证金
    private Integer priorityLev;//优先级 降序
    private Integer type;//1：新人专享 2：热拍
    private Integer roundInterval;//单轮间隔时间 毫秒数
    private Integer roundDuration;//单轮持续时间 毫秒数
    private Integer isClose;//拍卖位是否关闭
    private Integer isPublished;//是否发布
    private String publishTime;//
    private Integer isActive;//是否删除
    private String createdUser;//
    private String createdTime;//
    private String modifiedTime;//

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareImg() {
        return shareImg;
    }

    public void setShareImg(String shareImg) {
        this.shareImg = shareImg;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getTotalRound() {
        return totalRound;
    }

    public void setTotalRound(Integer totalRound) {
        this.totalRound = totalRound;
    }

    public Integer getCurRound() {
        return curRound;
    }

    public void setCurRound(Integer curRound) {
        this.curRound = curRound;
    }

    public String getCurRoundId() {
        return curRoundId;
    }

    public void setCurRoundId(String curRoundId) {
        this.curRoundId = curRoundId;
    }

    public Integer getBidIncrement() {
        return bidIncrement;
    }

    public void setBidIncrement(Integer bidIncrement) {
        this.bidIncrement = bidIncrement;
    }

    public float getBeginPrice() {
        return beginPrice;
    }

    public void setBeginPrice(float beginPrice) {
        this.beginPrice = beginPrice;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public Integer getPriorityLev() {
        return priorityLev;
    }

    public void setPriorityLev(Integer priorityLev) {
        this.priorityLev = priorityLev;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRoundInterval() {
        return roundInterval;
    }

    public void setRoundInterval(Integer roundInterval) {
        this.roundInterval = roundInterval;
    }

    public Integer getRoundDuration() {
        return roundDuration;
    }

    public void setRoundDuration(Integer roundDuration) {
        this.roundDuration = roundDuration;
    }

    public Integer getIsClose() {
        return isClose;
    }

    public void setIsClose(Integer isClose) {
        this.isClose = isClose;
    }

    public Integer getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
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

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}