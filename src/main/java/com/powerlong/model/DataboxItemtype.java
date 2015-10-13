package com.powerlong.model;

import java.util.Date;

public class DataboxItemtype {
    private Long id;

    private String merchantid;

    private String itmeType;

    private String itmeTypeName;

    private Date createdDate;

    private Date updatedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
    }

    public String getItmeType() {
        return itmeType;
    }

    public void setItmeType(String itmeType) {
        this.itmeType = itmeType == null ? null : itmeType.trim();
    }

    public String getItmeTypeName() {
        return itmeTypeName;
    }

    public void setItmeTypeName(String itmeTypeName) {
        this.itmeTypeName = itmeTypeName == null ? null : itmeTypeName.trim();
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
}