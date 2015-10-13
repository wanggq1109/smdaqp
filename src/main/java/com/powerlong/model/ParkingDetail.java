package com.powerlong.model;

import java.math.BigDecimal;
import java.util.Date;

public class ParkingDetail {
    private Long id;

    private String ktId;

    private String plateNo;

    private Date entryTime;

    private String entryPlace;

    private Date leaveTime;

    private String leavePlace;

    private String imgName;

    private BigDecimal payable;

    private String voucher;

    private String cashUser;

    private Date cashTime;

    private String isDel;

    private Date createdDate;

    private Date updatedDate;

    private String payType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKtId() {
        return ktId;
    }

    public void setKtId(String ktId) {
        this.ktId = ktId == null ? null : ktId.trim();
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo == null ? null : plateNo.trim();
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getEntryPlace() {
        return entryPlace;
    }

    public void setEntryPlace(String entryPlace) {
        this.entryPlace = entryPlace == null ? null : entryPlace.trim();
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getLeavePlace() {
        return leavePlace;
    }

    public void setLeavePlace(String leavePlace) {
        this.leavePlace = leavePlace == null ? null : leavePlace.trim();
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    public BigDecimal getPayable() {
        return payable;
    }

    public void setPayable(BigDecimal payable) {
        this.payable = payable;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher == null ? null : voucher.trim();
    }

    public String getCashUser() {
        return cashUser;
    }

    public void setCashUser(String cashUser) {
        this.cashUser = cashUser == null ? null : cashUser.trim();
    }

    public Date getCashTime() {
        return cashTime;
    }

    public void setCashTime(Date cashTime) {
        this.cashTime = cashTime;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }
}