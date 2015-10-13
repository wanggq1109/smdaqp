package com.powerlong.mapper;

import com.powerlong.model.TrafficShop;
import com.powerlong.vo.TrafficShopUserTimeVo;

import java.util.List;

public interface TrafficShopMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TrafficShop record);

    int insertSelective(TrafficShop record);

    TrafficShop selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TrafficShop record);

    int updateByPrimaryKey(TrafficShop record);

    List<TrafficShop> selectBySelective(TrafficShop record);

    List<TrafficShop> selectShopByUser(TrafficShop record);

    List<TrafficShopUserTimeVo> selectShopTimeByUser(TrafficShop record);

    List<TrafficShopUserTimeVo> selectShopDayUserCountByShopId(TrafficShop record);

    Long selectUserMonthAvgTimeByUser(TrafficShop record);
}