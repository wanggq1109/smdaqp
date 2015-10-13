package com.powerlong.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.powerlong.common.Util;
import com.powerlong.model.WifiMaxGust;
import com.powerlong.service.WifiMaxGustService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/wifiMaxGustController")
public class WifiMaxGustController {
    private static final Logger logger = Logger.getLogger(WifiMaxGustController.class);

    @Resource
    private WifiMaxGustService wifiMaxGustService;

    /**
     * 获取wifi信息
     * @param request
     * @param map
     * @param data
     * @return json
     * @throws Exception
     */
	@RequestMapping("getWMGList")
	public ModelAndView getWMGList(HttpServletRequest request,ModelMap map,String data) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = (JSONObject) JSON.parse(data);
            Map<String,Object> paramData = jsonObject.getJSONObject("data");
            String maxaddress = (String)paramData.get("maxAddress");
            if(paramData!=null&&StringUtils.isNotBlank(maxaddress)) {
                WifiMaxGust wifiMaxGust = new WifiMaxGust();
                wifiMaxGust.setMaxAddress(maxaddress);
                List<WifiMaxGust> wifiMaxGustList = this.wifiMaxGustService.getWifiMaxGustList(wifiMaxGust);
                resultMap.put("resMsg", "success");
                resultMap.put("resCode", "0");
                resultMap.put("data", wifiMaxGustList);
            }else{
                resultMap.put("resMsg", "maxAddres不能为空！");
                resultMap.put("resCode", "1");
            }
        }catch (Exception e){
            logger.error("获取wifi接入认证查询信息出错",e);
            resultMap.put("msg","失败");
            resultMap.put("code","FAIL");
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
	}

    /**
     * 获取wifi数据
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("sendWifiData")
    public ModelAndView sendWifiData(HttpServletRequest request,ModelMap map,String data) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = (JSONObject) JSON.parse(data);
            WifiMaxGust wifiMaxGust = jsonObject.getObject("data",WifiMaxGust.class);
            Map<String,Object> valitade = this.validateParams(wifiMaxGust);
            if((Boolean)valitade.get("isNotNull")) {
                int i = this.wifiMaxGustService.insertWifiData(wifiMaxGust);
                resultMap.put("resMsg", "success");
                resultMap.put("resCode", "0");
            }else{
                resultMap.put("resMsg", "必填不能为空:"+valitade.get("msg"));
                resultMap.put("resCode", "1");
            }
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
            resultMap.put("msg","失败");
            resultMap.put("code","FAIL");
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * 校验输入参数不能为空
     * @param wifiMaxGust
     * @return
     */
    private Map<String,Object> validateParams(WifiMaxGust wifiMaxGust){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        String msg = "";
        boolean isNotNull = true;
        if(StringUtils.isBlank(wifiMaxGust.getAppType())){
            isNotNull =false;
            msg+="appType为空，";
        }
        if(StringUtils.isBlank(wifiMaxGust.getMaxAddress())){
            isNotNull =false;
            msg+="maxAddress为空，";
        }
        if(StringUtils.isBlank(wifiMaxGust.getIp())){
            isNotNull =false;
            msg+="ip为空，";
        }
        if(wifiMaxGust.getLoginTime()==null){
            isNotNull =false;
            msg+="loginTime为空，";
        }
        resultMap.put("msg",msg);
        resultMap.put("isNotNull",isNotNull);
        return resultMap;
    }


}
