package com.powerlong.model;


import com.powerlong.common.DateUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
    private Long id;

    private String receiptnum;

    private String cptid;

    private Date tsdate;

    private String tsdateStr;

    private Double totalamount;

    private String qrcode;

    private String tsid;

    private String merchantid;

    private Double enteramount;

    private String productif;

    private Date createtime;

    private String receiptname;

    private String imageurl;

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
        this.receiptnum = receiptnum == null ? null : receiptnum.trim();
    }

    public String getCptid() {
        return cptid;
    }

    public void setCptid(String cptid) {
        this.cptid = cptid == null ? null : cptid.trim();
    }

    public Date getTsdate() {
        return tsdate;
    }

    public void setTsdate(Date tsdate) {
        this.tsdate = tsdate;
        this.tsdateStr = DateUtility.format(DateUtility.FORMAT_FULL, tsdate);
        ;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public String getTsid() {
        return tsid;
    }

    public void setTsid(String tsid) {
        this.tsid = tsid == null ? null : tsid.trim();
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
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
        this.productif = productif == null ? null : productif.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getReceiptname() {
        return receiptname;
    }

    public void setReceiptname(String receiptname) {
        this.receiptname = receiptname == null ? null : receiptname.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public String getTsdateStr() {
        return tsdateStr;
    }


}