package com.powerlong.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.powerlong.common.Util;
import com.powerlong.model.TrafficMall;
import com.powerlong.service.TrafficService;
import com.powerlong.vo.TrafficVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/trafficController")
public class TrafficController {
    private static final Logger logger = Logger.getLogger(TrafficController.class);

    @Resource
    private TrafficService trafficService;

    /**
     * 获取traffic信息
     *
     * @param request
     * @param map
     * @param data
     * @return json
     * @throws Exception
     */
    @RequestMapping("getTrafficData")
    public ModelAndView getTrafficData(HttpServletRequest request, ModelMap map, String data) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = (JSONObject) JSON.parse(data);
            Map<String, Object> paramData = jsonObject.getJSONObject("data");
            if (paramData != null && paramData.get("mallId") != null) {
                int mallId = (Integer) paramData.get("mallId");
                TrafficMall trafficMall = new TrafficMall();
                trafficMall.setMallId((long) mallId);
                TrafficVo trafficVo = this.trafficService.getTrafficInfo(trafficMall);
                resultMap.put("resMsg", "success");
                resultMap.put("resCode", "0");
                resultMap.put("data", trafficVo);
            } else {
                resultMap.put("resMsg", "maxAddres不能为空！");
                resultMap.put("resCode", "1");
            }
        } catch (Exception e) {
            logger.error("获取wifi接入认证查询信息出错", e);
            resultMap.put("msg", "失败");
            resultMap.put("code", "FAIL");
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }

    /**
     * 获取traffic数据
     *
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("sendTrafficData")
    public ModelAndView sendTrafficData(HttpServletRequest request, ModelMap map, String data) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            if (StringUtils.isBlank(data)) {
                data = request.getParameter("data");
            }

            JSONObject jsonObject = (JSONObject) JSON.parse(data);
            TrafficVo trafficVo = jsonObject.getObject("data", TrafficVo.class);
            Map<String, Object> valitade = this.validateParams(trafficVo);

            if ((Boolean) valitade.get("isNotNull")) {
                int i = this.trafficService.insertTrafficInfo(trafficVo.getTrafficMall(), trafficVo.getTrafficShops());
                resultMap.put("resMsg", "success");
                resultMap.put("resCode", "0");
            } else {
                resultMap.put("resMsg", "必填不能为空:" + valitade.get("msg"));
                resultMap.put("resCode", "1");
            }

        } catch (Exception e) {
            logger.error("插入wifi接入认证查询信息出错", e);
            resultMap.put("msg", "失败");
            resultMap.put("code", "FAIL");
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }

    /**
     * 校验数据非空
     *
     * @param trafficVo
     * @return
     */
    private Map<String, Object> validateParams(TrafficVo trafficVo) {
        Map<String, Object> map = new HashMap<String, Object>();
        String msg = "";
        boolean isNotNull = true;
        if (trafficVo == null) {
            isNotNull = false;
            msg += "data不能为空！";
        } else {
            if (trafficVo.getTrafficMall() == null) {
                isNotNull = false;
                msg += "商场客流数据不能为空！";
            }
            if (trafficVo.getTrafficShops() == null || trafficVo.getTrafficShops().size() == 0) {
                isNotNull = false;
                msg += "店铺客流数据不能为空！";
            }
        }
        map.put("msg", msg);
        map.put("isNotNull", isNotNull);
        return map;
    }


}
