package com.powerlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.powerlong.mapper.ScreenvideoMapper;
import com.powerlong.model.Screenvideo;
import com.powerlong.service.ScreenVideoService;
import com.powerlong.vo.ScreenVideoDataVo;
import com.powerlong.vo.ScreenVideoVo;

@Service("screenVideoService")
public class ScreenVideoServiceImpl implements ScreenVideoService{
	
	@Resource
	private ScreenvideoMapper screenvideoMapper;
	
	public ScreenVideoVo selectContentGroupBy(Screenvideo record){
		return screenvideoMapper.selectContentGroupBy(record);
	}	
	
	public List<ScreenVideoVo> selectContentGroupByList(Screenvideo record){
		return screenvideoMapper.selectContentGroupByList(record);
	}	
	
	public List<ScreenVideoDataVo> selectGroupByList(Screenvideo record){
		return screenvideoMapper.selectGroupByList(record);
	}	
}
