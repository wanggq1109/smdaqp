package com.powerlong.mapper;


import com.powerlong.model.Receipt;

import java.util.List;

public interface ReceiptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Receipt record);

    int insertSelective(Receipt record);

    Receipt selectByPrimaryKey(Long id);

    Receipt selectByQRCode(String qrcode);

    int updateByPrimaryKeySelective(Receipt record);

    int updateByPrimaryKey(Receipt record);


}