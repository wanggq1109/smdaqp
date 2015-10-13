package com.powerlong.vo;


import com.powerlong.common.DateUtility;

import java.util.Date;

/**
 * Created by Angus on 2015/5/30.
 */
public class DataBoxIndexVo {
    /**
     * 小票图片
     */
    private String imageurl;
    /**
     * 最小金额
     */
    private Double minAmount;
    /**
     * 最大金额
     */
    private Double maxAmount;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 自己生成的单号   商户号+设备号+流水号 （商户待宝龙提供）
     */
    private String tsid;
    /**
     * 二维码编号
     */
    private String qrcode;
    /**
     * 性别
     */
    private String sex;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 身份证号
     */
    private String ide;
    /*
     *邮箱
     */
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 手输金额
     */
    private Double enteramount;
    /**
     * 商户号
     */
    private String merchantid;
    /**
     * 水单号
     */
    private String receiptnum;

    /**
     * 设备ID
     */
    private String cptid;
    /**
     * 商户名称
     */
    private String merchantname;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 会员卡号
     */
    private String memberNo;
    /**
     * 消费时间
     */
    private Date tsdate;
    /**
     * 消费时间字符串
     */
    private String tsdateStr;
    /**
     * 会员级别
     */
    private String mlevel;
    /**
     * 实际消费金额
     */
    private Double totalamount;
    /**
     * mallId
     */
    private Long mallId;
    /**
     * 商场名称
     */
    private String mallName;
    /**
     * 类型
     */
    private String productif;
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
    
    private String startTimeStr;
    
    private String endTimeStr;
    
    private String consumer;

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public Date getTsdate() {
        return tsdate;
    }

    public void setTsdate(Date tsdate) {
        this.tsdate = tsdate;
        this.tsdateStr = DateUtility.format(DateUtility.FORMAT_FULL, tsdate);;
    }

    public String getMlevel() {
        return mlevel;
    }

    public void setMlevel(String mlevel) {
        this.mlevel = mlevel;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
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
    public String getTsdateStr() {
        return tsdateStr;
    }

    public Double getEnteramount() {
        return enteramount;
    }


    public void setEnteramount(Double enteramount) {
        this.enteramount = enteramount;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTsid() {
        return tsid;
    }

    public void setTsid(String tsid) {
        this.tsid = tsid;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getProductif() {
        return productif;
    }

    public void setProductif(String productif) {
        this.productif = productif;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public void setTsdateStr(String tsdateStr) {
		this.tsdateStr = tsdateStr;
	}
    
}
