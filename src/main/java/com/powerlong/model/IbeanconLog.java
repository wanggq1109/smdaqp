package com.powerlong.model;

import java.util.Date;

public class IbeanconLog {
    private Long id;

    private String mobile;

    private String deviceno;

    private String ibeaconno;

    private Date creadedDate;

    private String resource;

    private Long ibeaconid;

    private Long mallId;
    
    private String startTime;
    
    private String endTime;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getDeviceno() {
        return deviceno;
    }

    public void setDeviceno(String deviceno) {
        this.deviceno = deviceno == null ? null : deviceno.trim();
    }

    public String getIbeaconno() {
        return ibeaconno;
    }

    public void setIbeaconno(String ibeaconno) {
        this.ibeaconno = ibeaconno == null ? null : ibeaconno.trim();
    }

    public Date getCreadedDate() {
        return creadedDate;
    }

    public void setCreadedDate(Date creadedDate) {
        this.creadedDate = creadedDate;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    public Long getIbeaconid() {
        return ibeaconid;
    }

    public void setIbeaconid(Long ibeaconid) {
        this.ibeaconid = ibeaconid;
    }

	public Long getMallId() {
		return mallId;
	}

	public void setMallId(Long mallId) {
		this.mallId = mallId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
    
	
    
}