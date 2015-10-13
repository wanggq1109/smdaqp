package com.powerlong.mapper;

import com.powerlong.common.Paginator;
import com.powerlong.model.DataBoxReceipt;
import com.powerlong.vo.DataBoxCountVo;
import com.powerlong.vo.DataBoxDetailVo;
import com.powerlong.vo.DataBoxVo;

import java.util.List;

public interface DataBoxReceiptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataBoxReceipt record);

    int insertSelective(DataBoxReceipt record);

    DataBoxReceipt selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataBoxReceipt record);

    int updateByPrimaryKey(DataBoxReceipt record);

    DataBoxReceipt selectByReceiptnum(String QRCode);

    Long selectDataBoxAndUserDataCount(Paginator paginator);

    List<DataBoxVo> selectDataBoxAndUserData(Paginator paginator);

    DataBoxCountVo selectDataBoxCountByUserId(String mobile);

    List<DataBoxDetailVo> selectDataBoxToMonthDataByUserId(long id);

    Long selectDataBoxUserCount(DataBoxReceipt record);

    List<DataBoxDetailVo> selectDataBoxToMonthUserCountByUserId(DataBoxReceipt record);
}