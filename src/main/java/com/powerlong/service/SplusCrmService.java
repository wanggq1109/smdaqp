package com.powerlong.service;

import com.powerlong.common.Paginator;
import com.powerlong.model.AuthMall;
import com.powerlong.model.ParkingDetail;
import com.powerlong.vo.SplusStreamVo;

import java.util.List;
import java.util.Map;

/**
 * Created by Angus on 2015/5/30.
 */
public interface SplusCrmService {

    Paginator getSplusIndexData(Paginator paginator);

    Paginator getSplusWifiData(Paginator paginator);

    Paginator getSplusParkingData(Paginator page);

    Paginator getSplusPassengerData(Paginator page);

    Paginator getSplusScreenVoData(Paginator page);

    List<AuthMall> getAuthMallList();

    Map getSplusInfoStream();

    void getWebServiceParking() ;
    void setWebServiceParking(ParkingDetail parkingDetail) throws Exception;

        /**
         * 获取滚动屏park数据
         * @return
         */
     SplusStreamVo getParkingStream();
    /**
     * 获取滚动屏pos数据
     * @return
     */
     SplusStreamVo getPostStream();
     void execute( final String msgType, final String content,  final String img);
}
