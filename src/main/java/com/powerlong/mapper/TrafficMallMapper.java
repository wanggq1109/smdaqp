package com.powerlong.mapper;

import com.powerlong.common.Paginator;
import com.powerlong.model.TrafficMall;

import java.util.List;

public interface TrafficMallMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TrafficMall record);

    int insertSelective(TrafficMall record);

    TrafficMall selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TrafficMall record);

    int updateByPrimaryKey(TrafficMall record);

    List<TrafficMall> selectBySelective(TrafficMall record);

    Long selectSplusPassengerDataCount(Paginator page);

    List<TrafficMall> selectSplusPassengerData(Paginator page);

    Long selectMallTrafficDataByMallId(TrafficMall record);

    List<TrafficMall> selectMallTrafficMonthDataByMallId(TrafficMall record);
}