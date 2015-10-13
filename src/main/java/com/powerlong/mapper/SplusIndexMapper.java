package com.powerlong.mapper;

import com.powerlong.common.Paginator;
import com.powerlong.model.Receipt;
import com.powerlong.vo.DataBoxIndexVo;
import com.powerlong.vo.DataBoxVo;

import java.util.List;

/**
 * Created by Angus on 2015/5/30.
 */
public interface SplusIndexMapper {
    /**
     * crm+首页数据个数
     * @param paginator
     * @return
     */
    Long selectSplusIndexDataCount(Paginator paginator);

    /**
     * crm+首页数据列表
     * @param paginator
     * @return
     */
    List<DataBoxIndexVo> selectSplusIndexData(Paginator paginator);

    /**
     * 获取滚动屏pos记录
     * @return
     */
    List<DataBoxIndexVo> selectInfoStreamList();

}
