package com.powerlong.mapper;

import com.powerlong.common.Paginator;
import com.powerlong.model.DataBoxPosmonitor;

import java.util.List;

public interface DataBoxPosmonitorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataBoxPosmonitor record);

    int insertSelective(DataBoxPosmonitor record);

    DataBoxPosmonitor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataBoxPosmonitor record);

    int updateByPrimaryKey(DataBoxPosmonitor record);

    List<DataBoxPosmonitor> selectDataBoxPosmonitorData(Paginator paginator);

    Long selectDataBoxPosmonitorDataCount(Paginator paginator);

    DataBoxPosmonitor selectMerchantByMerchantid(DataBoxPosmonitor dataBoxPosmonitor);

    Double selectMerchantTotalSumPay(DataBoxPosmonitor dataBoxPosmonitor);

    List<DataBoxPosmonitor> selectMerchantPaySexCount(DataBoxPosmonitor dataBoxPosmonitor);

    List<DataBoxPosmonitor> selectMallPaySum(DataBoxPosmonitor dataBoxPosmonitor);

    List<DataBoxPosmonitor> selectMerchantPaySexCountBySex(DataBoxPosmonitor dataBoxPosmonitor);

}