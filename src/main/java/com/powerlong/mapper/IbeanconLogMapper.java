package com.powerlong.mapper;

import com.powerlong.common.Paginator;
import com.powerlong.model.IbeanconLog;
import com.powerlong.vo.IbeanconDataVo;

import java.util.List;

public interface IbeanconLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IbeanconLog record);

    int insertSelective(IbeanconLog record);

    IbeanconLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective();

    int updateByPrimaryKey(IbeanconLog record);

    List<IbeanconLog> selectInfoStreamList();
    
    List<IbeanconDataVo> selectIbeanconLogList(Paginator paginator);
    
    Long selectIbeanconLogCount(Paginator paginator);

    Long selectIbeanconLogToMonthCount(IbeanconLog record);

    List<IbeanconLog> selectIbeanconLogToMonthCountByDay(IbeanconLog record);
}