package com.powerlong.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.powerlong.model.ParkingDetail;
import com.powerlong.service.SplusCrmService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2015/7/9.
 */
@Controller
public class SmdaqpCrmController {


    private static final Logger logger = Logger.getLogger(SmdaqpCrmController.class);

    @Resource
    private SplusCrmService splusCrmService;
    /**
     * 第三方停车场入场接口
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "parkingEnter", method= RequestMethod.POST, produces="application/xml; charset=utf-8")
    public void  selectMerchantPaySexCount(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("UTF-8"); // 避免中文乱码 POST方式提交
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
                boolean isNotBlank = true;
                String errorMsg = "";
                // 获取客户端提交的数字签名json格式数据
                StringBuilder sb = new StringBuilder();
                String s = null;
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        request.getInputStream(), "UTF-8"));
                while ((s = br.readLine()) != null) {
                    sb.append(s);
                }
                JSONObject json = JSON.parseObject
                        (sb.toString());
                ParkingDetail parkingDetail = new ParkingDetail();
                if(StringUtils.isNotBlank(json.getString("PlateNo"))){
                    parkingDetail.setPlateNo(json.getString("PlateNo"));
                }else{
                    isNotBlank = false;
                    errorMsg += " PlateNo为空, ";
                }
                if(StringUtils.isNotBlank(json.getString("EntryTime"))){
                    parkingDetail.setEntryTime(json.getDate("EntryTime"));
                }else{
                    isNotBlank = false;
                    errorMsg += " EntryTime为空, ";
                }
                if(isNotBlank){
                    this.splusCrmService.setWebServiceParking(parkingDetail);
                    jsonObject.put("msg", "成功！");
                    jsonObject.put("code", "1");
                }else{
                    jsonObject.put("msg", errorMsg);
                    jsonObject.put("code", "0");
                }
                out.write(jsonObject.toString());
        }catch (Exception e){
            logger.error("获取车辆入场信息出错",e);
            jsonObject.put("msg","获取车辆入场信息出现异常！");
            jsonObject.put("code","0");
            out.write(jsonObject.toString());
        } finally {
            out.flush();
            out.close();
        }
    }
}
