package com.powerlong.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.powerlong.common.Paginator;
import com.powerlong.controller.IbeaController;
import com.powerlong.mapper.IbeanconInfoMapper;
import com.powerlong.mapper.IbeanconLogMapper;
import com.powerlong.model.IbeanconInfo;
import com.powerlong.model.IbeanconLog;
import com.powerlong.service.IbeaconService;
import com.powerlong.vo.IbeanconDataVo;
import com.powerlong.vo.IbeanconStatisticVo;

@Service("IbeaconService")
public class IbeaconServiceImpl implements IbeaconService{
	private static final Logger logger = Logger
            .getLogger(IbeaconServiceImpl.class);
	@Resource
	private IbeanconInfoMapper ibeanconInfoMapper;
	@Resource
	private IbeanconLogMapper ibeanconLogMapper;
	
	public int insertLog(IbeanconLog record){
		return ibeanconLogMapper.insertSelective(record);
	}
	
	public IbeanconInfo getIbeaconInfo(IbeanconInfo record){
		IbeanconInfo ret =new IbeanconInfo();
		ret= ibeanconInfoMapper.selectInfo(record);
		return ret;
	}
	
	public Paginator getIbeanconLog(Paginator paginator){
        try {
            paginator.setResults(ibeanconLogMapper.selectIbeanconLogList(paginator));
            Long count =ibeanconLogMapper.selectIbeanconLogCount(paginator);
            if (count!= null && count>0){
                paginator.setItems(Integer.parseInt(count.toString()));
            }
            return paginator;
        }catch (Exception e){
            logger.error("getIbeanconLog查询出错！",e);
        }
        return null;
    }

	@Override
	public List<IbeanconStatisticVo> getBeaconStatistic() {
		return ibeanconInfoMapper.selectBeaconStatistic();
	}
}
