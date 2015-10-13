package com.powerlong.service;


import com.powerlong.common.Paginator;
import com.powerlong.model.*;
import com.powerlong.vo.*;

import java.util.List;

/**
 * Created by admin on 2015/5/20.
 */
public interface DataBoxService {


    List<DataBoxPosmonitor> selectDataBoxPosmonitorData(Paginator paginator) throws Exception;

    Long selectDataBoxPosmonitorDataCount(Paginator paginator) throws Exception;

    int insertDataboxUser(DataboxUser record) throws Exception;

    DataBoxReceipt selectByQRCode(DataboxUser databoxUser) throws Exception;

    List<DataBoxVo> selectDataBoxAndUserData(Paginator paginator) throws Exception;

    Long selectDataBoxAndUserDataCount(Paginator paginator) throws Exception;

    DataboxUser selectByDataBoxUserId(Long id) throws Exception;

    DataBoxCountVo selectDataBoxCountByUserId(String mobile) throws Exception;

    public List<DataBoxDetailVo> selectDataBoxToMonthDataByUserId(Long id) throws Exception ;

    List<DataBoxItemTypeDataVo> selectDataBoxToMonthTypeByUserId(String mobile) throws Exception ;

    List<WifiMaxGust> selectCountTimeOnFloor(WifiMaxGust record)throws Exception ;

    List<WifiMaxGust> selectCountTimeOnShop(WifiMaxGust record)throws Exception ;

    List<TrafficShop> selectShopByUser(TrafficShop record) throws Exception ;

    List<TrafficShopUserTimeVo> selectShopTimeByUser(TrafficShop record) throws Exception ;

    Long selectParkingUserTimeCount(String mobile) throws Exception ;

    List<ParkingDetail> selectParkingUserPayTypeCount(String mobile) throws Exception ;

    Double selectParkingUserPayCount(String mobile) throws Exception ;

    List<ParkingDetail> selectParkingEnterCount(String mobile) throws Exception ;

    List<ParkingDetail> selectParkingLeaveCount(String mobile) throws Exception ;

    List<Screenvideo> selectContentByUserMobile(Screenvideo record)throws Exception ;

    List<Screenvideo> selectContentCountByUserMobile(Screenvideo record)throws Exception ;

    Long selectDataBoxUserCount(DataBoxReceipt record);

    DataBoxPosmonitor selectMerchantByMerchantid(DataBoxPosmonitor dataBoxPosmonitor);

    AppPayData selectMerchantPayAmountByMerchantId(AppPayData record) throws Exception ;

    Double selectMerchantTotalSumPay(DataBoxPosmonitor dataBoxPosmonitor);


    List<DataBoxPosmonitor> selectMerchantPaySexCount(DataBoxPosmonitor dataBoxPosmonitor) throws Exception ;

    List<TrafficShopUserTimeVo> selectShopDayUserCountByShopId(TrafficShop record)throws Exception ;

    List<DataboxItemtype> selectDataBoxToMonthAgeTypeByMerchantId(DataboxItemtype record) throws Exception ;

    List<AppPayData> selectMallPayMonthAmountByMerchantId(AppPayData record) throws Exception ;

    List<DataBoxPosmonitor> selectMallPayPosmonitorSum(DataBoxPosmonitor record) throws Exception ;

    Long selectMallAllDataByMallId(WifiMaxGust record) throws Exception ;

    Long selectParkingMallAllDataByMallId(ParkingUser record) throws Exception ;

    Long selectMallTrafficDataByMallId(TrafficMall record) throws Exception ;

    List<WifiMaxGust> selectMallWifiMonthDataByMallId(WifiMaxGust record) throws Exception ;

    List<TrafficMall> selectMallTrafficMonthDataByMallId(TrafficMall record) throws Exception ;

    List<ParkingUser> selectParkingMallCountDataByMallId(ParkingUser record) throws Exception ;

    Long selectUserMonthAvgTimeByUser(TrafficShop record) throws Exception ;

    String selectByUserMobile(ParkingUser record) throws Exception ;

    List<DataBoxDetailVo> selectDataBoxToMonthUserCountByUserId(DataBoxReceipt record) throws Exception;

    Double selectByUserNewAndOld(DataboxUser record) throws Exception;

    Long selectDataBoxToMonthCountPayByUser(String mobile) throws Exception;

    Long selectByUserNewCount(DataboxUser record) throws Exception;

    Long selectByUserToMonthNewAndOldCount(DataboxUser record) throws Exception;

    List<DataBoxPosmonitor> selectMerchantPaySexCountBySex(DataBoxPosmonitor dataBoxPosmonitor) throws Exception;

    List<DataboxUser> selectByUserToMonthOldList(DataboxUser record) throws Exception;

    List<DataboxUser> selectByUserToMonthNewList(DataboxUser record) throws Exception;

    List<DataboxItemtype> selectDataBoxToMonthAgeList(DataboxItemtype record) throws Exception;

    Long selectIbeanconLogToMonthCount(IbeanconLog record) throws Exception;

    List<IbeanconLog> selectIbeanconLogToMonthCountByDay(IbeanconLog record) throws Exception;


}
