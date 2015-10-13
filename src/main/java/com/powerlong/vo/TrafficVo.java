package com.powerlong.vo;

import com.powerlong.model.TrafficMall;
import com.powerlong.model.TrafficShop;

import java.util.List;

/**
 * Created by admin on 2015/5/7.
 */
public class TrafficVo{
    private TrafficMall trafficMall;

    private List<TrafficShop> trafficShops;

    public TrafficMall getTrafficMall() {
        return trafficMall;
    }

    public void setTrafficMall(TrafficMall trafficMall) {
        this.trafficMall = trafficMall;
    }

    public List<TrafficShop> getTrafficShops() {
        return trafficShops;
    }

    public void setTrafficShops(List<TrafficShop> trafficShops) {
        this.trafficShops = trafficShops;
    }
}
