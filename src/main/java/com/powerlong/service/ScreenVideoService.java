package com.powerlong.service;

import java.util.List;

import com.powerlong.model.Screenvideo;
import com.powerlong.vo.ScreenVideoDataVo;
import com.powerlong.vo.ScreenVideoVo;

public interface ScreenVideoService {
	public ScreenVideoVo selectContentGroupBy(Screenvideo record);
	
	public List<ScreenVideoVo> selectContentGroupByList(Screenvideo record);
	
	public List<ScreenVideoDataVo> selectGroupByList(Screenvideo record);
}
	
