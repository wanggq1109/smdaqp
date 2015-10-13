package com.powerlong.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.powerlong.common.Paginator;
import com.powerlong.service.IbeaconService;
import com.powerlong.vo.IbeanconDataVo;

@Controller
@RequestMapping("ibea")
public class IbeaController {
	private static final Logger logger = Logger
            .getLogger(IbeaController.class);
	@Resource	 
	private IbeaconService ibeaconService;
	
	@RequestMapping("Ibeacon")
	public String ibeaManager (HttpServletRequest request,
				    HttpServletResponse response,ModelMap map,
				    Paginator page,IbeanconDataVo record) throws Exception{
		page.setParams(record);
		try {
			Paginator paginator =ibeaconService.getIbeanconLog(page);
	        if (paginator!=null){
	            request.setAttribute("paginator",paginator);
	        }	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("ibeaManager异常"+e);
		}		 
		return "Ibeacon";
	}
}
