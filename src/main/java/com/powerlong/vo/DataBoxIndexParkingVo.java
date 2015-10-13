package com.powerlong.vo;

import com.powerlong.model.ParkingDetail;
import com.powerlong.model.WifiMaxGust;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by Angus on 2015/6/2.
 */
public class DataBoxIndexParkingVo extends ParkingDetail {
    /**
     * 用户手机号
     */
    private String mobile;
    /**
     * 查询时间类型
     */
    private String checkTime;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date startTime;
    /**
     * 是否离场
     */
    private String isLeave;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date endTime;
    
    /**
     * 用户手名
     */
    private String crmUser;

    private String mallId;

    private String mallName;

    private String startTimeStr;
    
    private String endTimeStr;
    
    
    public String getStartTimeStr() {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	if(startTime==null){
    		return null;
    	}
		return df.format(startTime);
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(endTime==null){
    		return null;
    	}
		return df.format(endTime);
	}

	public void setEndTimeStr(String endTImeStr) {
		this.endTimeStr = endTImeStr;
	}

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

    public String getMallId() {
        return mallId;
    }

    public void setMallId(String mallId) {
        this.mallId = mallId;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

	public String getCrmUser() {
		return crmUser;
	}

	public void setCrmUser(String crmUser) {
		this.crmUser = crmUser;
	}

	public String getIsLeave() {
		return isLeave;
	}

	public void setIsLeave(String isLeave) {
		this.isLeave = isLeave;
	}
    
    
}
