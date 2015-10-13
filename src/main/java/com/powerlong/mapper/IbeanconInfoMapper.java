package com.powerlong.mapper;

import java.util.List;

import com.powerlong.model.IbeanconInfo;
import com.powerlong.vo.IbeanconStatisticVo;

public interface IbeanconInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IbeanconInfo record);

    int insertSelective(IbeanconInfo record);

    IbeanconInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IbeanconInfo record);

    int updateByPrimaryKey(IbeanconInfo record);
    
    IbeanconInfo selectInfo(IbeanconInfo record);
    
    public List<IbeanconStatisticVo> selectBeaconStatistic();
}