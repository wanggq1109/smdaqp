package com.powerlong.mapper;

import com.powerlong.common.Paginator;
import com.powerlong.model.Screenvideo;
import com.powerlong.vo.ScreenVideoDataVo;
import com.powerlong.vo.ScreenVideoVo;

import java.util.List;

public interface ScreenvideoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Screenvideo record);

    int insertSelective(Screenvideo record);

    Screenvideo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Screenvideo record);

    int updateByPrimaryKey(Screenvideo record);

    List<Screenvideo> selectContentByUserMobile(Screenvideo record);

    List<Screenvideo> selectContentCountByUserMobile(Screenvideo record);
    
    ScreenVideoVo selectContentGroupBy(Screenvideo record);
    
    List<ScreenVideoVo> selectContentGroupByList(Screenvideo record);

    List<Screenvideo> selectSplusrScreenData(Paginator page);

    Long selectSplusScreenDataCount(Paginator page);

    List<Screenvideo> selectInfoStreamList();

    List<ScreenVideoDataVo> selectGroupByList(Screenvideo record);
}