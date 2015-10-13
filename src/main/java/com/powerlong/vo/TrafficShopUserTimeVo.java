package com.powerlong.vo;

/**
 * Created by admin on 2015/6/1.
 */
public class TrafficShopUserTimeVo {
    private String shopId;
    private String shopName;
    private Long dataYear;
    private Long dataMonth;
    private Long dataDay;
    private String enterTime;
    private String leaveTime;

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
        this.shopName = shopName;
    }

    public Long getDataYear() {
        return dataYear;
    }

    public void setDataYear(Long dataYear) {
        this.dataYear = dataYear;
    }

    public Long getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(Long dataMonth) {
        this.dataMonth = dataMonth;
    }

    public Long getDataDay() {
        return dataDay;
    }

    public void setDataDay(Long dataDay) {
        this.dataDay = dataDay;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }
}
