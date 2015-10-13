package com.powerlong.service;

import com.powerlong.model.ParkingDetail;
import com.powerlong.model.ParkingUser;

import java.util.List;

/**
 * Created by Angus on 2015/5/29.
 */
public interface ParkingService {

    public Integer bindingUser(ParkingUser parkingUser);

    public Integer insertParkingDetail(ParkingDetail parkingDetail);

    public List<ParkingDetail> selectByMobile(ParkingDetail parkingDetail);

    ParkingDetail selectByKtId(String ktId);
    Integer updateByPrimaryKeySelective(ParkingDetail parkingDetail);
}
