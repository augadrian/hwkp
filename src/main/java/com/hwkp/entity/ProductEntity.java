package com.hwkp.entity;



import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name="b_product")
public class ProductEntity {
    private Integer no;
    private String productId;
    private String cover;
    private String proName;
    private String proAbstract;//摘要
    private String proIntroduction;//json介绍
    private BigDecimal proOriginalPrice;//原价
    private BigDecimal expressFee;//快递费
    private Integer isActive;
    private String createdUser;//
    private String createdTime;//
    private String modifiedUser;//
    private String modifiedTime;//

    @Id
    @Column(name = "no", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }


    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    @Column(name = "cover")
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Column(name = "pro_name")
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Column(name = "pro_abstract", unique = true)
    public String getProAbstract() {
        return proAbstract;
    }

    public void setProAbstract(String proAbstract) {
        this.proAbstract = proAbstract;
    }

   @Column(name="pro_introduction")
    public String getProIntroduction() {
        return proIntroduction;
    }

    public void setProIntroduction(String proIntroduction) {
        this.proIntroduction = proIntroduction;
    }

    @Column(name = "pro_original_price", unique = true)
    public BigDecimal getProOriginalPrice() {
        return proOriginalPrice;
    }

    public void setProOriginalPrice(BigDecimal proOriginalPrice) {
        this.proOriginalPrice = proOriginalPrice;
    }
    @Column(name = "express_fee", unique = true)
    public BigDecimal getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(BigDecimal expressFee) {
        this.expressFee = expressFee;
    }
    @Column(name = "is_active", unique = true)
    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
    @Column(name = "created_user", unique = true)
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }
    @Column(name = "created_time", unique = true)
    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
    @Column(name = "modified_user", unique = true)
    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
    @Column(name = "modified_time", unique = true)
    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}