package com.powerlong.service.impl;

import com.powerlong.mapper.ParkingDetailMapper;
import com.powerlong.mapper.ParkingUserMapper;
import com.powerlong.model.DataboxUser;
import com.powerlong.model.ParkingDetail;
import com.powerlong.model.ParkingUser;
import com.powerlong.service.ParkingService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Angus on 2015/5/29.
 */
@Service("parkingService")
public class ParkingServiceImpl implements ParkingService {

    private static final Logger logger = Logger.getLogger(ParkingServiceImpl.class);
    @Resource
    private ParkingDetailMapper parkingDetailMapper;
    @Resource
    private ParkingUserMapper parkingUserMapper;

    /**
     * 插入数据ParkingUser
     * @param parkingUser
     * @return
     */
    @Override
    public Integer bindingUser(ParkingUser parkingUser){
        try {
            List<ParkingUser> parkings =parkingUserMapper.selectByPlateNoAndMobile(parkingUser);
            if (parkings!=null&&parkings.size()>0){
                return 0;
            }
            return parkingUserMapper.insertSelective(parkingUser);
        }catch (Exception e){
            logger.error("bindingUser插入数据库出错！",e);
        }
        return null;
    }

    /**
     * 插入数据ParkingDetail
     * @param parkingDetail
     * @return
     */
    @Override
    public Integer insertParkingDetail(ParkingDetail parkingDetail){
        try {

            return parkingDetailMapper.insertSelective(parkingDetail);
        }catch (Exception e){
            logger.error("bindingUser插入数据库出错！",e);
        }
        return null;
    }
    @Override
    public Integer updateByPrimaryKeySelective(ParkingDetail parkingDetail){
        try {

            return parkingDetailMapper.updateByPrimaryKeySelective(parkingDetail);
        }catch (Exception e){
            logger.error("bindingUser插入数据库出错！",e);
        }
        return null;
    }

    /**
     * 查询今天的收费信息
     * @param parkingDetail
     * @return
     */
    @Override
    public List<ParkingDetail> selectByMobile(ParkingDetail parkingDetail){
        try {
            return parkingDetailMapper.selectByCashTimeAtToday(parkingDetail);
        }catch (Exception e){
            logger.error("selectByMobile查询数据库出错！",e);
        }
        return null;
    }

    @Override
    public ParkingDetail selectByKtId(String ktId) {
        return parkingDetailMapper.selectByKtId(ktId);
    }

}
