package com.powerlong.model;

public class IbeanconInfo {
    private Long id;

    private String ibeaconno;

    private String remark;

    private String area;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIbeaconno() {
        return ibeaconno;
    }

    public void setIbeaconno(String ibeaconno) {
        this.ibeaconno = ibeaconno == null ? null : ibeaconno.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}