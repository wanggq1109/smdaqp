package com.powerlong.mapper;

import com.powerlong.common.Paginator;
import com.powerlong.model.ParkingDetail;
import com.powerlong.vo.DataBoxIndexParkingVo;

import java.util.List;

public interface ParkingDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ParkingDetail record);

    int insertSelective(ParkingDetail record);

    ParkingDetail selectByPrimaryKey(Long id);

    ParkingDetail selectByKtId(String ktId);

    List<ParkingDetail> selectByCashTimeAtToday(ParkingDetail parkingDetail);

    int updateByPrimaryKeySelective(ParkingDetail record);

    int updateByPrimaryKey(ParkingDetail record);

    Long selectParkingUserTimeCount(String mobile);

    List<ParkingDetail> selectParkingUserPayTypeCount(String mobile);

    Double selectParkingUserPayCount(String mobile);

    List<ParkingDetail> selectParkingEnterCount(String mobile);

    List<ParkingDetail> selectParkingLeaveCount(String mobile);

    List<DataBoxIndexParkingVo> selectSplusParingData(Paginator page);

    Long selectSplusParingDataCount(Paginator page);

    List<DataBoxIndexParkingVo> selectInfoStreamList();
}