package com.powerlong.common;

import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * Created by Angus on 2015/5/30.
 */

public class MobileJsonVo implements Serializable {
    private static final Logger LOG = Logger.getLogger(MobileJsonVo.class);
    private int code;
    private String msg;
    private String type;
    private Object data;
    private static final long serialVersionUID = 1L;

    public MobileJsonVo() {
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(String code) {
        try {
            this.code = Integer.parseInt(code);
        } catch (Exception var3) {
            LOG.error("code转换异常", var3);
            this.code = -1;
        }

    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}