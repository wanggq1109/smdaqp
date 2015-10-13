package com.powerlong.vo;

import java.math.BigDecimal;

/**
 * Created by admin on 2015/5/30.
 */
public class DataBoxCountVo {
    private long dataCount;
    private BigDecimal dataTotal;

    public BigDecimal getDataTotal() {
        return dataTotal;
    }

    public void setDataTotal(BigDecimal dataTotal) {
        this.dataTotal = dataTotal;
    }

    public long getDataCount() {
        return dataCount;
    }

    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }
}
