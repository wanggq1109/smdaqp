package com.powerlong.model;

import java.util.Date;

public class TrafficShop {
    private Long id;

    private Long trafficMallId;

    private String shopId;

    private String shopName;

    private String floor;

    private String serviceattitude;

    private Long enteringshopnumber;

    private Long consumeamount;

    private Date createdDate;

    private Date updatedDate;

    private String mobile;

    private Date enterTime;

    private Date leaveTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrafficMallId() {
        return trafficMallId;
    }

    public void setTrafficMallId(Long trafficMallId) {
        this.trafficMallId = trafficMallId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getServiceattitude() {
        return serviceattitude;
    }

    public void setServiceattitude(String serviceattitude) {
        this.serviceattitude = serviceattitude == null ? null : serviceattitude.trim();
    }

    public Long getEnteringshopnumber() {
        return enteringshopnumber;
    }

    public void setEnteringshopnumber(Long enteringshopnumber) {
        this.enteringshopnumber = enteringshopnumber;
    }

    public Long getConsumeamount() {
        return consumeamount;
    }

    public void setConsumeamount(Long consumeamount) {
        this.consumeamount = consumeamount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }
}