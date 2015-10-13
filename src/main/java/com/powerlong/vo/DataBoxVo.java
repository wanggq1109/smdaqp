package com.powerlong.vo;

import java.util.Date;

/**
 * Created by admin on 2015/5/21.
 */
public class DataBoxVo {

    private Long id;

    private String receiptnum;

    private String cptid;

    private Date tsdate;

    private Double totalamount;

    private String tsid;

    private String merchantid;

    private Double enteramount;

    private String productif;

    private Date createtime;

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

    private String qrcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiptnum() {
        return receiptnum;
    }

    public void setReceiptnum(String receiptnum) {
        this.receiptnum = receiptnum;
    }

    public String getCptid() {
        return cptid;
    }

    public void setCptid(String cptid) {
        this.cptid = cptid;
    }

    public Date getTsdate() {
        return tsdate;
    }

    public void setTsdate(Date tsdate) {
        this.tsdate = tsdate;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public String getTsid() {
        return tsid;
    }

    public void setTsid(String tsid) {
        this.tsid = tsid;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public Double getEnteramount() {
        return enteramount;
    }

    public void setEnteramount(Double enteramount) {
        this.enteramount = enteramount;
    }

    public String getProductif() {
        return productif;
    }

    public void setProductif(String productif) {
        this.productif = productif;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMlevel() {
        return mlevel;
    }

    public void setMlevel(String mlevel) {
        this.mlevel = mlevel;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
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
        this.mallName = mallName;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    @Override
    public String toString() {
        return "DataBoxVo{" +
                "id=" + id +
                ", receiptnum='" + receiptnum + '\'' +
                ", cptid='" + cptid + '\'' +
                ", tsdate=" + tsdate +
                ", totalamount=" + totalamount +
                ", tsid='" + tsid + '\'' +
                ", merchantid='" + merchantid + '\'' +
                ", enteramount=" + enteramount +
                ", productif='" + productif + '\'' +
                ", createtime=" + createtime +
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
                ", qrcode='" + qrcode + '\'' +
                '}';
    }
}
