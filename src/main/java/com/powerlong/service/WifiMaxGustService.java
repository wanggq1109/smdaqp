package com.powerlong.service;

import com.powerlong.model.WifiMaxGust;

import java.util.List;

/**
 * Created by admin on 2015/5/6.
 */
public interface WifiMaxGustService {
    List<WifiMaxGust> getWifiMaxGustList(WifiMaxGust wifiMaxGust) throws Exception;
    int insertWifiData(WifiMaxGust record) throws Exception;
}
