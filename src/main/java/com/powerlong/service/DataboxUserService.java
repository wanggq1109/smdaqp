package com.powerlong.service;

import com.powerlong.common.Paginator;
import com.powerlong.model.DataboxUser;
import com.powerlong.vo.UserInfoVo;

import java.util.List;

/**
 * Created by Angus on 2015/5/28.
 */
public interface DataboxUserService {

    int insert(DataboxUser databoxUser);

    List<DataboxUser> selectByMobile(String mobile);
    
    public Paginator selectUserInfo(Paginator paginator);
}
