package com.powerlong.model;

import java.util.Date;

public class DataboxUser {
    private Long id;

    private Long userId;

    private String userName;

    private String sex;

    private String birthday;

    private String mobile;

    private String ide;

    private String email;

    private String address;

    private String mlevel;

    private String memberNo;

    private Long mallId;

    private String mallName;

    private Date createdDate;

    private Date updatedDate;

    private String qrcode;

    private String receiptnum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide == null ? null : ide.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMlevel() {
        return mlevel;
    }

    public void setMlevel(String mlevel) {
        this.mlevel = mlevel == null ? null : mlevel.trim();
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName == null ? null : mallName.trim();
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

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public String getReceiptnum() {
        return receiptnum;
    }

    public void setReceiptnum(String receiptnum) {
        this.receiptnum = receiptnum == null ? null : receiptnum.trim();
    }

    @Override
    public String toString() {
        return "DataboxUser{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", mobile='" + mobile + '\'' +
                ", ide='" + ide + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", mlevel='" + mlevel + '\'' +
                ", memberNo='" + memberNo + '\'' +
                ", mallId=" + mallId +
                ", mallName='" + mallName + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", qrcode='" + qrcode + '\'' +
                ", receiptnum='" + receiptnum + '\'' +
                '}';
    }
}