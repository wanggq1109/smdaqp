package com.powerlong.mapper;

import com.powerlong.common.Paginator;
import com.powerlong.model.DataboxUser;
import com.powerlong.vo.UserInfoVo;

import java.util.List;

public interface DataboxUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataboxUser record);

    int insertSelective(DataboxUser record);

    DataboxUser selectByPrimaryKey(Long id);

    List<DataboxUser> selectByMobile(String mobile);

    List<DataboxUser> selectByMobileAndQrcode(DataboxUser record);

    int updateByPrimaryKeySelective(DataboxUser record);

    int updateByPrimaryKey(DataboxUser record);

    Double selectByUserNewAndOld(DataboxUser record);
    
    List<UserInfoVo> selectUserInfo(Paginator paginator);
    
    Long selectUserInfoCount(Paginator paginator);

    Long selectByUserNewCount(DataboxUser record);

    Long selectByUserToMonthNewAndOldCount(DataboxUser record);

    List<DataboxUser> selectByUserToMonthOldList(DataboxUser record);

    List<DataboxUser> selectByUserToMonthNewList(DataboxUser record);

    List<DataboxUser> selectInfoStreamList();
}