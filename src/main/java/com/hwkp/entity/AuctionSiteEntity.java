package com.hwkp.entity;

import javax.persistence.*;

@Entity
@Table(name="b_auction_site")
public class AuctionSiteEntity {
    private Integer no;
    private String auctionId;//拍卖位ID
    private String title;//标题
    private String shareTitle;//前端分享标题·
    private String shareImg;//前端分享图片·
    private String productId;//奖品编号
    private Integer totalRound;//总轮次 总共拍卖多少轮
    private Integer curRound;//当前轮次，第几轮拍卖
    private String curRoundId;//当前轮次id
    private Integer bidIncrement;//加价幅度
    private float beginPrice;//起拍价
    private float minPrice;//最低价，保留价
    private float maxPrice;//封顶价
    private float deposit;//保证金
    private Integer priorityLev;//优先级 降序·
    private Integer type;//1：新人专享 2：热拍
    private Integer roundInterval;//单轮间隔时间 毫秒数
    private Integer roundDuration;//单轮持续时间 毫秒数
    private Integer isClose;//拍卖位是否关闭
    private Integer isPublished;//是否发布
    private String publishTime;//发布时间
    private Integer isActive;//是否删除
    private String createdUser;//
    private String createdTime;//
    private String modifiedTime;//
    private String modifiedUser;//
    @Id
    @Column(name = "no", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
    @Column(name = "auction_id", unique = true, nullable = false)
    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }
    @Column(name = "title", unique = true, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "share_title", unique = true, nullable = false)
    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }
    @Column(name = "share_img", unique = true, nullable = false)
    public String getShareImg() {
        return shareImg;
    }

    public void setShareImg(String shareImg) {
        this.shareImg = shareImg;
    }
    @Column(name = "product_id", unique = true, nullable = false)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    @Column(name = "total_round", unique = true, nullable = false)
    public Integer getTotalRound() {
        return totalRound;
    }

    public void setTotalRound(Integer totalRound) {
        this.totalRound = totalRound;
    }
    @Column(name = "cur_round", unique = true, nullable = false)
    public Integer getCurRound() {
        return curRound;
    }

    public void setCurRound(Integer curRound) {
        this.curRound = curRound;
    }
    @Column(name = "cur_round_id", unique = true, nullable = false)
    public String getCurRoundId() {
        return curRoundId;
    }

    public void setCurRoundId(String curRoundId) {
        this.curRoundId = curRoundId;
    }
    @Column(name = "bid_increment", unique = true, nullable = false)
    public Integer getBidIncrement() {
        return bidIncrement;
    }

    public void setBidIncrement(Integer bidIncrement) {
        this.bidIncrement = bidIncrement;
    }
    @Column(name = "begin_price", unique = true, nullable = false)
    public float getBeginPrice() {
        return beginPrice;
    }

    public void setBeginPrice(float beginPrice) {
        this.beginPrice = beginPrice;
    }
    @Column(name = "min_price", unique = true, nullable = false)
    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }
    @Column(name = "max_price", unique = true, nullable = false)
    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }
    @Column(name = "deposit", unique = true, nullable = false)
    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }
    @Column(name = "priority_lev", unique = true, nullable = false)
    public Integer getPriorityLev() {
        return priorityLev;
    }

    public void setPriorityLev(Integer priorityLev) {
        this.priorityLev = priorityLev;
    }
    @Column(name = "type", unique = true, nullable = false)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "round_interval", unique = true, nullable = false)
    public Integer getRoundInterval() {
        return roundInterval;
    }

    public void setRoundInterval(Integer roundInterval) {
        this.roundInterval = roundInterval;
    }
    @Column(name = "round_duration", unique = true, nullable = false)
    public Integer getRoundDuration() {
        return roundDuration;
    }

    public void setRoundDuration(Integer roundDuration) {
        this.roundDuration = roundDuration;
    }
    @Column(name = "is_close", unique = true, nullable = false)
    public Integer getIsClose() {
        return isClose;
    }

    public void setIsClose(Integer isClose) {
        this.isClose = isClose;
    }
    @Column(name = "is_published", unique = true, nullable = false)
    public Integer getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
    }
    @Column(name = "publish_time", unique = true, nullable = false)
    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
    @Column(name = "is_active", unique = true, nullable = false)
    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
    @Column(name = "created_user", unique = true, nullable = false)
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }
    @Column(name = "created_time", unique = true, nullable = false)
    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
    @Column(name = "modified_time", unique = true, nullable = false)
    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    @Column(name = "modified_user", unique = true, nullable = false)
    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
}