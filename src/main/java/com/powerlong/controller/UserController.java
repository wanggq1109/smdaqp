package com.powerlong.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.powerlong.common.Paginator;
import com.powerlong.service.DataboxUserService;
import com.powerlong.vo.UserInfoVo;


@Controller
@RequestMapping("/User")
public class UserController {
	private static final Logger logger = Logger
            .getLogger(UserController.class);
	
	@Resource
	private DataboxUserService databoxUserService;
	@RequestMapping("userinfo")
	public String userinfo (HttpServletRequest request,
		    HttpServletResponse response,ModelMap map,
		    Paginator page, UserInfoVo record) throws Exception{
		page.setParams(record);
		try {
			Paginator paginator =databoxUserService.selectUserInfo(page);
	        if (paginator!=null){
	            request.setAttribute("paginator",paginator);
	        }	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("ibeaManager异常"+e);
		}		 
		return "sUserInfo";
	}
}
