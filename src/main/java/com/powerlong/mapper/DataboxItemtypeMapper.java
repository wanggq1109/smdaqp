package com.powerlong.mapper;

import com.powerlong.model.DataboxItemtype;
import com.powerlong.vo.DataBoxItemTypeDataVo;

import java.util.List;

public interface DataboxItemtypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataboxItemtype record);

    int insertSelective(DataboxItemtype record);

    DataboxItemtype selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataboxItemtype record);

    int updateByPrimaryKey(DataboxItemtype record);

    List<DataBoxItemTypeDataVo> selectDataBoxToMonthTypeByUserId(String mobile);

    List<DataboxItemtype> selectDataBoxToMonthAgeTypeByMerchantId(DataboxItemtype record);

    Long selectDataBoxToMonthCountPayByUser(String mobile);

    List<DataboxItemtype> selectDataBoxToMonthAgeList(DataboxItemtype record);
}