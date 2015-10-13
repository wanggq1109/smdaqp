package com.powerlong.vo;

import java.math.BigDecimal;

/**
 * Created by admin on 2015/5/30.
 */
public class DataBoxItemTypeDataVo {
    private BigDecimal amount;
    private String itemTypeName;
    private String merchantname;
    private Long mallId;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }
}
