package com.powerlong.vo;

/**
 * Created by Angus on 2015/6/8.
 */
public class SplusStreamNewVo {
    /**
     * 显示内容
     */
    private String content;
    /**
     * 显示类型(POS: 1, WIFI: 2, CAR_PARK: 3, IBEACON: 4,SCREEN:5)
     */
    private String msgType;
    /**
     * 图片url
     */
    private String img;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
