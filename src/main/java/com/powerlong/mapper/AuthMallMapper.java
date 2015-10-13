package com.powerlong.mapper;

import com.powerlong.model.AuthMall;

import java.util.List;

public interface AuthMallMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthMall record);

    int insertSelective(AuthMall record);

    AuthMall selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthMall record);

    int updateByPrimaryKey(AuthMall record);

    List<AuthMall> selectAuthMallList();
}