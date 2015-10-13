package com.powerlong.mapper;

import com.powerlong.model.ParkingUser;

import java.util.List;

public interface ParkingUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ParkingUser record);

    int insertSelective(ParkingUser record);

    ParkingUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ParkingUser record);

    int updateByPrimaryKey(ParkingUser record);

    Long selectParkingMallAllDataByMallId(ParkingUser record);

    List<ParkingUser> selectParkingMallCountDataByMallId(ParkingUser record);

    List<ParkingUser> selectByPlateNoAndMobile(ParkingUser parkingUser);

    String selectPlateNoByUserMobile(ParkingUser record);


}