package com.powerlong.vo;

import com.powerlong.model.ParkingDetail;
import com.powerlong.model.TrafficMall;

import java.util.Date;

/**
 * Created by Angus on 2015/6/2.
 */
public class DataBoxIndexPassengerVo extends TrafficMall {
    /**
     * 查询时间类型
     */
    private String checkTime;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;


    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
