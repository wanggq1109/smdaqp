package com.powerlong.service.impl;

import com.powerlong.mapper.WifiMaxGustMapper;
import com.powerlong.model.WifiMaxGust;
import com.powerlong.service.WifiMaxGustService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2015/5/6.
 */
@Service("wifiMaxGustService")
public class WifiMaxGustServiceImpl implements WifiMaxGustService {

    private static final Logger logger = Logger.getLogger(WifiMaxGustServiceImpl.class);

    @Resource
    private WifiMaxGustMapper wifiMaxGustMapper;

    /**
     * 获取wifiMaxGust列表信息
     * @param wifiMaxGust
     * @return
     */
    @Override
    public List<WifiMaxGust> getWifiMaxGustList(WifiMaxGust wifiMaxGust) throws Exception {
        List<WifiMaxGust> wifiMaxGustList = wifiMaxGustMapper.selectBySelective(wifiMaxGust);
        return wifiMaxGustList;
    }

    /**
     * 插入wifi数据
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public int insertWifiData(WifiMaxGust record) throws Exception {
        return this.wifiMaxGustMapper.insert(record);
    }
}
