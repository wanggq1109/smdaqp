package com.powerlong.vo;

import java.util.List;
import java.util.Map;

/**
 * 用于滚动屏数据封装
 * Created by Angus on 2015/6/4.
 */
public class SplusStreamVo {
    private String subtitle;
    private List msg;

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List getMsg() {
        return msg;
    }

    public void setMsg(List msg) {
        this.msg = msg;
    }
}
