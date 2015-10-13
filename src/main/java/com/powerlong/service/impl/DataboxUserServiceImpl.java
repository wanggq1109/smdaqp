package com.powerlong.service.impl;


import com.powerlong.common.Paginator;
import com.powerlong.mapper.DataboxUserMapper;
import com.powerlong.model.DataboxUser;
import com.powerlong.service.DataboxUserService;
import com.powerlong.vo.UserInfoVo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Angus on 2015/5/28.
 */
@Service("databoxUserService")
public class DataboxUserServiceImpl implements DataboxUserService {
    private static final Logger logger = Logger.getLogger(DataboxUserServiceImpl.class);
    @Resource
    private DataboxUserMapper databoxUserMapper;
    @Override
    public int insert(DataboxUser databoxUser){
        try {
            List<DataboxUser> databoxUsers =databoxUserMapper.selectByMobileAndQrcode(databoxUser);
            if (databoxUsers!=null&&databoxUsers.size()>0){
                return 0;
            }
            return databoxUserMapper.insertSelective(databoxUser);
        }catch (Exception e){
            logger.error("databoxuser插入数据库出错！",e);
        }
        return 0;
    }
    @Override
    public List<DataboxUser> selectByMobile(String mobile){
        try {
            return databoxUserMapper.selectByMobile(mobile);
        }catch (Exception e){
            logger.error("selectByMobile查询数据库出错！",e);
        }
        return null;
    }

    
    public Paginator selectUserInfo(Paginator paginator){
    try {
        paginator.setResults(databoxUserMapper.selectUserInfo(paginator));
        Long count =databoxUserMapper.selectUserInfoCount(paginator);
        if (count!= null && count>0){
            paginator.setItems(Integer.parseInt(count.toString()));
        }
        return paginator;
    }catch (Exception e){
        logger.error("selectUserInfo查询出错！",e);
    }
    return null;
}
}
