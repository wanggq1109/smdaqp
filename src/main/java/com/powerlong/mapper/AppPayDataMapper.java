package com.powerlong.mapper;

import com.powerlong.model.AppPayData;

import java.util.List;

public interface AppPayDataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppPayData record);

    int insertSelective(AppPayData record);

    AppPayData selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppPayData record);

    int updateByPrimaryKey(AppPayData record);

    AppPayData selectMerchantPayAmountByMerchantId(AppPayData record);

    List<AppPayData> selectMallMonthPaySumByMallId(AppPayData record);
}