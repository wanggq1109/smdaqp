package com.powerlong.model;

import java.util.Date;

public class Screenvideo {
    private Long id;

    private String content;

    private String touchid;

    private String clicktime;

    private String url;

    private Date createtime;

    private String mobile;

    private String mallid;

    private String mallname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTouchid() {
        return touchid;
    }

    public void setTouchid(String touchid) {
        this.touchid = touchid == null ? null : touchid.trim();
    }

    public String getClicktime() {
        return clicktime;
    }

    public void setClicktime(String clicktime) {
        this.clicktime = clicktime == null ? null : clicktime.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getMallid() {
        return mallid;
    }

    public void setMallid(String mallid) {
        this.mallid = mallid == null ? null : mallid.trim();
    }

    public String getMallname() {
        return mallname;
    }

    public void setMallname(String mallname) {
        this.mallname = mallname == null ? null : mallname.trim();
    }
}