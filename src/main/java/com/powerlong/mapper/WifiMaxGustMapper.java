package com.powerlong.mapper;

import com.powerlong.common.Paginator;
import com.powerlong.model.WifiMaxGust;

import java.util.List;

public interface WifiMaxGustMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WifiMaxGust record);

    int insertSelective(WifiMaxGust record);

    WifiMaxGust selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WifiMaxGust record);

    int updateByPrimaryKey(WifiMaxGust record);

    List<WifiMaxGust> selectBySelective(WifiMaxGust record);

    List<WifiMaxGust> selectCountTimeOnFloor(WifiMaxGust record);
    
    List<WifiMaxGust> selectCountTimeOnShop(WifiMaxGust record);

    Long selectSplusWifiDataCount(Paginator paginator);

    List<WifiMaxGust> selectSplusWifiData(Paginator paginator);


    List<WifiMaxGust> selectInfoStreamList();


    Long selectMallAllDataByMallId(WifiMaxGust record);

    List<WifiMaxGust> selectMallWifiMonthDataByMallId(WifiMaxGust record);

}