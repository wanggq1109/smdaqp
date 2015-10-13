package com.powerlong.service;



import java.util.List;

import com.powerlong.common.Paginator;
import com.powerlong.model.IbeanconInfo;
import com.powerlong.model.IbeanconLog;
import com.powerlong.vo.IbeanconStatisticVo;

public interface IbeaconService {
	
	public int insertLog(IbeanconLog record);
	public IbeanconInfo getIbeaconInfo(IbeanconInfo record);
	public Paginator getIbeanconLog(Paginator paginator);
	public List<IbeanconStatisticVo> getBeaconStatistic();
}
