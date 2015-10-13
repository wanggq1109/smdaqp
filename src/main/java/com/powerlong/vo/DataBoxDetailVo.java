package com.powerlong.vo;

import java.math.BigDecimal;

/**
 * Created by admin on 2015/5/30.
 */
public class DataBoxDetailVo {
    private BigDecimal amount;
    private Long dataYear;
    private Long dataMonth;
    private Long dataDay;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getDataYear() {
        return dataYear;
    }

    public void setDataYear(Long dataYear) {
        this.dataYear = dataYear;
    }

    public Long getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(Long dataMonth) {
        this.dataMonth = dataMonth;
    }

    public Long getDataDay() {
        return dataDay;
    }

    public void setDataDay(Long dataDay) {
        this.dataDay = dataDay;
    }
}
