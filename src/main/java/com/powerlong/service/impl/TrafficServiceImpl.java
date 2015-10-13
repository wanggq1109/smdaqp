package com.powerlong.service.impl;

import com.powerlong.mapper.TrafficMallMapper;
import com.powerlong.mapper.TrafficShopMapper;
import com.powerlong.model.TrafficMall;
import com.powerlong.model.TrafficShop;
import com.powerlong.service.TrafficService;
import com.powerlong.vo.TrafficVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2015/5/7.
 */
@Service("trafficService")
public class TrafficServiceImpl implements TrafficService {
    private static final Logger logger = Logger.getLogger(TrafficServiceImpl.class);

    @Resource
    private TrafficMallMapper trafficMallMapper;
    @Resource
    private TrafficShopMapper trafficShopMapper;

    /**
     * 插入客流信息
     * @param trafficMall
     * @param trafficShopList
     * @return
     * @throws Exception
     */
    @Override
    public int insertTrafficInfo(TrafficMall trafficMall, List<TrafficShop> trafficShopList) throws Exception {
        try{
            //插入商场客流信息
            this.trafficMallMapper.insert(trafficMall);
            //插入店铺客流信息
            if(trafficShopList!=null&&trafficShopList.size()>0) {
                int n = trafficShopList.size();
                for (int i=0;i<n;i++) {
                    TrafficShop trafficShop = trafficShopList.get(i);
                    trafficShop.setTrafficMallId(trafficMall.getId());
                    this.trafficShopMapper.insert(trafficShop);
                }
            }
        }catch (Exception e){
            logger.error("插入数据库出错", e);
            throw new Exception("插入数据库出错！",e);
        }catch (Throwable t){
            logger.error("插入数据库出错", t);
            throw new Exception("插入数据库出错", t);
        }
        return 0;
    }

    /**
     * 获取traffic信息
     * @param trafficMall
     * @return
     * @throws Exception
     */
    @Override
    public TrafficVo getTrafficInfo(TrafficMall trafficMall) throws Exception {
        TrafficVo trafficVo = new TrafficVo();
        try {
            //获取商场客流信息
            List<TrafficMall> trafficMalls = this.trafficMallMapper.selectBySelective(trafficMall);
            if(trafficMalls!=null&&trafficMalls.size()>0){
                trafficVo.setTrafficMall(trafficMalls.get(0));
                TrafficShop trafficShop = new TrafficShop();
                trafficShop.setTrafficMallId(trafficMalls.get(0).getId());
                List<TrafficShop> trafficShops = this.trafficShopMapper.selectBySelective(trafficShop);
                trafficVo.setTrafficShops(trafficShops);
            }
        }catch (Exception e){
            logger.error("查询数据库出错", e);
            throw new Exception("查询数据库出错！",e);
        }
        return trafficVo;
    }
}
