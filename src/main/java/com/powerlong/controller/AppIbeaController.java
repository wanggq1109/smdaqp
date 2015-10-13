package com.powerlong.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.powerlong.common.*;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.powerlong.model.IbeanconInfo;
import com.powerlong.model.IbeanconLog;
import com.powerlong.service.IbeaconService;
import com.powerlong.service.SplusCrmService;



@Controller
@RequestMapping("/appIbea")
public class AppIbeaController {
	private static final Logger logger = Logger
            .getLogger(AppIbeaController.class);
	
	@Resource	 
	private IbeaconService ibeaconService;
	@Resource
	private SplusCrmService splusCrmService;
	
	@RequestMapping(value = "/receiveInfo", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Object receiveInfo(ModelMap map, String data, HttpServletRequest request){
//		Map<String,Object> dataMap=new HashMap<String,Object>();
		MobileJsonVo mobileJsonVo = new MobileJsonVo();

		IbeanconLog record=new IbeanconLog();
		IbeanconInfo param=new IbeanconInfo();
		Enterprise mapJson;
		try {
			mapJson = new Enterprise((Map<String, Object>) JSON.parse(XssHtmlUtility.decode(data)));
			record.setCreadedDate(new Date());
			record.setMobile(mapJson.getString("mobile"));
			record.setIbeaconno(mapJson.getString("ibeaconno"));
			record.setResource(mapJson.getString("resource"));
			record.setDeviceno(mapJson.getString("deviceno"));
			param.setIbeaconno(mapJson.getString("ibeaconno").toLowerCase());
		} catch (Exception e) {
			logger.error("ibeacon获取参数失败" + ":" + e);
		}
		try {
			
			if(null!= param && StringUtils.isNotBlank(param.getIbeaconno())){
				param=ibeaconService.getIbeaconInfo(param);
				if(param!=null){
					record.setIbeaconid(param.getId());
					if(StringUtils.isBlank(param.getArea())){
						param.setArea("");
					}
					ibeaconService.insertLog(record);	
					splusCrmService.execute("4", DateUtility.format(DateUtility.FORMAT_HH_MM,new  Date())+"#"+record.getMobile()+"#"+param.getArea(),"");
				}
				else{
					logger.error("ibaeacon设备不存在");
				}
			}
			else{
				logger.error("ibaeacon设备号为空");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("获取区域失败" + ":" + e);
		}
		mobileJsonVo.setCode(MobileParamsEnum.RETURN_CODE_SUCCESS.key);
        mobileJsonVo.setMsg(MobileParamsEnum.RETURN_CODE_SUCCESS.value);
        return mobileJsonVo;
    }
}
