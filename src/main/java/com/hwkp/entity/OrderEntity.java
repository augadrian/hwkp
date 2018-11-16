package com.hwkp.entity;

import javax.persistence.*;

@Entity
@Table(name="b_order")
public class OrderEntity {
    private Integer id;
    private String orderId;//
    private String transactionId;//
    private String roundId;//轮次id
    private String productId;//
    private String zipCode;//
    private String provinceName;//
    private String cityName;//
    private String countyName;//
    private String detailInfo;//
    private String telNumber;//
    private String userName;//
    private String wxOpenid;//
    private String nonceStr;//
    private Integer isPaid;//
    private String paidTime;//
    private String payResult;//
    private String expressNum;//
    private Integer isSend;//
    private String sendTime;//
    private Integer isActive;//
    private String createdUser;//
    private String createdTime;//
    private String modifiedUser;//
    private String modifiedTime;//

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "order_id", unique = true, nullable = false)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    @Column(name = "transaction_id", unique = true, nullable = false)
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    @Column(name = "round_id", unique = true, nullable = false)
    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }
    @Column(name = "product_id", unique = true, nullable = false)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    @Column(name = "zip_code", unique = true, nullable = false)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    @Column(name = "province_name", unique = true, nullable = false)
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    @Column(name = "city_name", unique = true, nullable = false)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    @Column(name = "county_name", unique = true, nullable = false)
    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
    @Column(name = "detail_info", unique = true, nullable = false)
    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }
    @Column(name = "tel_number", unique = true, nullable = false)
    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
    @Column(name = "user_name", unique = true, nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name = "wx_openid", unique = true, nullable = false)
    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }
    @Column(name = "nonce_str", unique = true, nullable = false)
    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
    @Column(name = "is_paid", unique = true, nullable = false)
    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }
    @Column(name = "paid_time", unique = true, nullable = false)
    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }
    @Column(name = "pay_result", unique = true, nullable = true)
    public String getPayResult() {
        return payResult;
    }

    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }
    @Column(name = "express_num", unique = true, nullable = false)
    public String getExpressNum() {
        return expressNum;
    }

    public void setExpressNum(String expressNum) {
        this.expressNum = expressNum;
    }
    @Column(name = "is_send", unique = true, nullable = false)
    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }
    @Column(name = "send_time", unique = true, nullable = false)
    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
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
    @Column(name = "modified_user", unique = true, nullable = false)
    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
    @Column(name = "modified_time", unique = true, nullable = false)
    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
