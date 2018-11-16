package com.hwkp.entity;

import javax.persistence.*;

@Entity
@Table(name="b_adv")
public class AdvEntity {
     private Integer id;//
     private String type;//0 首页轮播 1 财富榜广告 2 我的界面底部广告 3 钱包金额界面广告 4 保证金界面广告 5 退款界面广告
     private  String advertise;//
     private  String position;//广告位置
     private Integer isActive;//
     private  String createdUser;//
     private  String createdTime;//
     private  String modifiedUser;//
     private  String modifiedTime;//

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type", unique = true, nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "advertise", unique = true, nullable = false)
    public String getAdvertise() {
        return advertise;
    }

    public void setAdvertise(String advertise) {
        this.advertise = advertise;
    }
    @Column(name = "position", unique = true, nullable = false)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
