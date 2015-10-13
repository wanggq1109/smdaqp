package com.powerlong.service;

import com.powerlong.model.TrafficMall;
import com.powerlong.model.TrafficShop;
import com.powerlong.vo.TrafficVo;

import java.util.List;

/**
 * Created by admin on 2015/5/7.
 */
public interface TrafficService {
    int insertTrafficInfo(TrafficMall trafficMall,List<TrafficShop> trafficShopList) throws Exception;
    TrafficVo getTrafficInfo(TrafficMall trafficMall) throws Exception;
}
