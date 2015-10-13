package com.powerlong.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.powerlong.common.Paginator;
import com.powerlong.common.Util;
import com.powerlong.model.*;
import com.powerlong.service.DataBoxService;
import com.powerlong.service.DataboxUserService;
import com.powerlong.service.IbeaconService;
import com.powerlong.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by admin on 2015/5/20.
 */
@Controller
@RequestMapping("/smdaqpController")
public class SmdaqpController {

    private static final Logger logger = Logger.getLogger(SmdaqpController.class);

    @Resource
    private DataBoxService dataBoxService;

    @Resource
    private DataboxUserService databoxUserService;

    @Resource
    private IbeaconService ibeaconService;
    /**
     * 数据盒子数据展示
     * @param sPage
     * @param rows
     * @param request
     * @param response
     * @param map
     * @param page
     * @return
     * @throws Exception
     */
    @RequestMapping(value="selectDataBoxDataList")
    @ResponseBody
    public Map selectDataBoxDataList(@RequestParam("page") String sPage,
                                     @RequestParam("rows")String rows,
                                     HttpServletRequest request,
                                     HttpServletResponse response,ModelMap map,
                                     Paginator page) throws Exception {
        List<DataBoxPosmonitor> resultList = new ArrayList<DataBoxPosmonitor>();
        Map<String, Object> datas = new HashMap<String, Object>();
        if (true) {
            DataBoxPosmonitor dataBoxPosmonitor = new DataBoxPosmonitor();
            page.setPage(Integer.parseInt(sPage));
            page.setItemsPerPage(Integer.parseInt(rows));
            dataBoxPosmonitor.setMerchantid("08877");
            page.setParams(dataBoxPosmonitor);
            //数据盒子计算总数
            Long countSize = this.dataBoxService.selectDataBoxPosmonitorDataCount(page);
            //数据盒子数据
            resultList = this.dataBoxService.selectDataBoxPosmonitorData(page);
            //总条数
            page.setItems(countSize==null?0:countSize.intValue());

            datas.put("total",countSize);
            datas.put("rows", resultList);
            return datas;
        }
        datas.put("total",0);
        datas.put("rows", resultList);
        return datas;
    }

    /**
     * 数据盒子数据展示
     * @param sPage
     * @param rows
     * @param request
     * @param response
     * @param map
     * @param page
     * @return
     * @throws Exception
     */
    @RequestMapping(value="selectDataBoxAndUserList")
    @ResponseBody
    public ModelAndView selectDataBoxAndUserList(@RequestParam("page") String sPage,
                                     @RequestParam("rows")String rows,
                                     HttpServletRequest request,
                                     HttpServletResponse response,ModelMap map,
                                     Paginator page) throws Exception {
        List<DataBoxVo> resultList = new ArrayList<DataBoxVo>();
        Map<String, Object> datas = new HashMap<String, Object>();
        if (true) {
            DataboxUser databoxUser = new DataboxUser();
            page.setPage(Integer.parseInt(sPage));
            page.setItemsPerPage(Integer.parseInt(rows));
            databoxUser.setMallId(1l);
            page.setParams(databoxUser);
            //数据盒子计算总数
            Long countSize = this.dataBoxService.selectDataBoxAndUserDataCount(page);
            //数据盒子数据
            resultList = this.dataBoxService.selectDataBoxAndUserData(page);
            //总条数
            page.setItems(countSize==null?0:countSize.intValue());

            datas.put("total",countSize);
            datas.put("rows", resultList);
            ModelAndView mav = new ModelAndView();
            mav.setView(Util.getJsonView(datas));
            return mav;
        }
        datas.put("total",0);
        datas.put("rows", resultList);
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(datas));
        return mav;
    }



    /**
     * 查询水单信息根据二维码code
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("searchDataBoxByQRCode")
    @ResponseBody
    public ModelAndView searchDataBoxByQRCode(HttpServletRequest request,ModelMap map,String data) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = (JSONObject) JSON.parse(data);
            DataboxUser databoxUser = jsonObject.getObject("data",DataboxUser.class);
            Map<String,Object> valitade = this.validateParams(databoxUser);
            if((Boolean)valitade.get("isNotNull")) {
                DataBoxReceipt dataBoxReceipt = this.dataBoxService.selectByQRCode(databoxUser);
                if(dataBoxReceipt!=null) {
                    this.dataBoxService.insertDataboxUser(databoxUser);
                    resultMap.put("data",dataBoxReceipt);
                    resultMap.put("resMsg", "success");
                    resultMap.put("resCode", "0");
                }
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
     * @param databoxUser
     * @return
     */
    public Map<String,Object> validateParams(DataboxUser databoxUser){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        String msg = "";
        boolean isNotNull = true;
        if(StringUtils.isBlank(databoxUser.getReceiptnum())){
            isNotNull =false;
            msg+="水单号不能为空，";
        }
        resultMap.put("msg",msg);
        resultMap.put("isNotNull",isNotNull);
        return resultMap;
    }

    /**
     * mall
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("mall")
    public String mall(HttpServletRequest request,ModelMap map,String data,Long mallId,String date,String type) throws Exception{
        try {
            AppPayData appPayData = new AppPayData();
            if(mallId!=null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                if(StringUtils.isEmpty(date)) {
                    date = format.format(new Date());
                }else{
                    date = Util.getMonth(date, type);
                }
                appPayData.setMallId(mallId);
                DataBoxPosmonitor dataBoxPosmonitor = new DataBoxPosmonitor();
                dataBoxPosmonitor.setMallId(mallId);
                dataBoxPosmonitor.setCreateTime(format.parse(date));
                Double dataBoxPosmonitorSum = this.dataBoxService.selectMerchantTotalSumPay(dataBoxPosmonitor);
                if(dataBoxPosmonitorSum!=null) {
                    map.put("dataBoxPosmonitorSum", new BigDecimal(dataBoxPosmonitorSum / 10000).setScale(4, BigDecimal.ROUND_HALF_UP));
                }else{
                    map.put("dataBoxPosmonitorSum", "0.00");
                }
                Long parkingData = 0l ;
                Long wifiData = 0l ;
                Long trafficData = 0l ;
                Long newUserData = 0l;
                Long userData = 0l;
                //停车场
                ParkingUser parkingUser = new ParkingUser();
                parkingUser.setMallId(mallId.toString());
                parkingUser.setCreatedDate(format.parse(date));
                parkingData = this.dataBoxService.selectParkingMallAllDataByMallId(parkingUser);
                //wifi
                WifiMaxGust wifiMaxGust = new WifiMaxGust();
                wifiMaxGust.setMallId(mallId);
                wifiMaxGust.setCreatedDate(format.parse(date));
                wifiData = this.dataBoxService.selectMallAllDataByMallId(wifiMaxGust);
                //客流
                TrafficMall trafficMall = new TrafficMall();
                trafficMall.setMallId(mallId);
                trafficMall.setCreatedDate(format.parse(date));
                trafficData = this.dataBoxService.selectMallTrafficDataByMallId(trafficMall);
                //总用户
                DataboxUser databoxUser = new DataboxUser();
                databoxUser.setCreatedDate(format.parse(date));
                userData = this.dataBoxService.selectByUserToMonthNewAndOldCount(databoxUser);
                //新用户
                DataboxUser databoxUser1 = new DataboxUser();
                databoxUser1.setCreatedDate(format.parse(date));
                newUserData = this.dataBoxService.selectByUserNewCount(databoxUser1);
                IbeanconLog ibeanconLog = new IbeanconLog();
                ibeanconLog.setCreadedDate(format.parse(date));
                Long ibeanconlong = this.dataBoxService.selectIbeanconLogToMonthCount(ibeanconLog);
                map.put("ibeanconlong",new BigDecimal(ibeanconlong/5.00).setScale(2,BigDecimal.ROUND_HALF_UP));
                List<IbeanconStatisticVo> beanconList = ibeaconService.getBeaconStatistic();
                int countBeancon = 0;
                if(beanconList!=null) {
                    for (int i = 0; i < beanconList.size(); i++) {
                        countBeancon += beanconList.get(i).getCnt();
                    }
                }
                map.put("countBeancon",countBeancon);
                map.put("wifiData", wifiData==null?0:wifiData);
                map.put("trafficData", trafficData==null?0:trafficData);
                map.put("parkingData", parkingData==null?0:parkingData);
                map.put("userData", userData==null?0:userData);
                map.put("newUserData", newUserData==null?0:newUserData);
                map.put("parkingDataBi",new BigDecimal((parkingData/500.0)*100).setScale(2,BigDecimal.ROUND_HALF_UP));
                map.put("toMonth", date);
                map.put("mallId", mallId);
                map.put("type",type);
            }else{
                return "sMall";
            }
        }catch (Exception e){
            logger.error("加载mall可以页面出错！",e);
        }
        return "sMall";
    }

    /**
     * userInfo
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("userInfo")
    public String userInfo(HttpServletRequest request,ModelMap map,String data,String mobile) throws Exception{
        try {
            if(StringUtils.isNotBlank(mobile)) {
                List<DataboxUser> databoxUsers = this.databoxUserService.selectByMobile(mobile);
                DataboxUser databoxUser = new DataboxUser();
                if (databoxUsers != null && databoxUsers.size() > 0) {
                    databoxUser = databoxUsers.get(0);
                } else {
                    return "sUser";
                }
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                String toMonth = format.format(new Date());
                DataBoxCountVo dataBoxCountVo = this.dataBoxService.selectDataBoxCountByUserId(databoxUser.getMobile());
                WifiMaxGust wifiMaxGust = new WifiMaxGust();
                wifiMaxGust.setMobile(databoxUser.getMobile());
                List<WifiMaxGust> wifiMaxGusts = this.dataBoxService.selectCountTimeOnFloor(wifiMaxGust);
                List<WifiMaxGust> wifiMaxGustsShop = this.dataBoxService.selectCountTimeOnShop(wifiMaxGust);
                TrafficShop trafficShop = new TrafficShop();
                trafficShop.setMobile(databoxUser.getMobile());
                List<TrafficShop> trafficShops = this.dataBoxService.selectShopByUser(trafficShop);
                Long parkingTimecount = this.dataBoxService.selectParkingUserTimeCount(databoxUser.getMobile());
                if (parkingTimecount == null) {
                    map.put("parkingTimecount", "0");
                } else {
                    map.put("parkingTimecount", parkingTimecount);
                }
                List<ParkingDetail> parkingDetailsLeave = this.dataBoxService.selectParkingLeaveCount(databoxUser.getMobile());
                List<ParkingDetail> parkingDetailsEnter = this.dataBoxService.selectParkingEnterCount(databoxUser.getMobile());
                Screenvideo screenvideo = new Screenvideo();
                screenvideo.setMobile(databoxUser.getMobile());
                List<Screenvideo> screenvideos = this.dataBoxService.selectContentByUserMobile(screenvideo);
                List<DataBoxItemTypeDataVo> dataBoxItemTypeDataVos = this.dataBoxService.selectDataBoxToMonthTypeByUserId(databoxUser.getMobile());
                Long avgTimeUser = this.dataBoxService.selectUserMonthAvgTimeByUser(trafficShop);
                ParkingUser parkingUser = new ParkingUser();
                parkingUser.setMobile(databoxUser.getMobile());
                String parkingNo = this.dataBoxService.selectByUserMobile(parkingUser);
                Long userCountPay = this.dataBoxService.selectDataBoxToMonthCountPayByUser(mobile);
                if(userCountPay!=null&&dataBoxCountVo!=null&&dataBoxCountVo.getDataTotal()!=null){
                    map.put("userCountPay",dataBoxCountVo.getDataTotal().divide(new BigDecimal(userCountPay),4).setScale(2,BigDecimal.ROUND_HALF_UP));
                }else{
                    if(dataBoxCountVo!=null&&dataBoxCountVo.getDataTotal()!=null) {
                        map.put("userCountPay", dataBoxCountVo.getDataTotal().setScale(2, BigDecimal.ROUND_HALF_UP));
                    }else{
                        map.put("userCountPay","0.00");
                    }
                }

                map.put("parkingNo", parkingNo);
                map.put("avgTimeUser", avgTimeUser==null?0:avgTimeUser);
                map.put("dataBoxItemTypeDataVos", dataBoxItemTypeDataVos);
                map.put("screenvideos", screenvideos);
                map.put("parkingDetailsLeave", parkingDetailsLeave);
                map.put("parkingDetailsEnter", parkingDetailsEnter);
                map.put("trafficShops", trafficShops);
                map.put("wifiMaxGustsShop", wifiMaxGustsShop);
                map.put("countTime", Util.getCountTime(wifiMaxGusts));
                map.put("wifiMaxGusts", wifiMaxGusts);
                map.put("dataBoxCountVo", dataBoxCountVo);
                map.put("toMonth", toMonth);
                map.put("databoxUser", databoxUser);
                map.put("userAge", Util.getAge(databoxUser.getBirthday()));
            }else{
                return "sUser";
            }
        }catch (Exception e){
            logger.error("用户刻画页面展示数据获取失败！",e);
            throw new Exception(e);
        }
        return "sUser";
    }


    /**
     * 获取当月每天消费情况
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("searchDataBoxToMonthData")
    @ResponseBody
    public ModelAndView searchDataBoxToMonthData(HttpServletRequest request,ModelMap map,String data,Long userId) throws Exception{
        List<DataBoxDetailVo> dataBoxDetailVos= new ArrayList<DataBoxDetailVo>();
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            if(userId!=null) {
                dataBoxDetailVos = this.dataBoxService.selectDataBoxToMonthDataByUserId(userId);
            }
            resultMap.put("data",dataBoxDetailVos);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * 业态消费
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("searchDataBoxToMonthItemTypeData")
    @ResponseBody
    public ModelAndView searchDataBoxToMonthItemTypeData(HttpServletRequest request,ModelMap map,String data,String mobile) throws Exception{
        List<DataBoxItemTypeDataVo> dataBoxItemTypeDataVos= new ArrayList<DataBoxItemTypeDataVo>();
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            if(StringUtils.isNotBlank(mobile)) {
                dataBoxItemTypeDataVos = this.dataBoxService.selectDataBoxToMonthTypeByUserId(mobile);
            }
            resultMap.put("data",dataBoxItemTypeDataVos);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * 用户停留商户wifi时间
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectCountTimeOnShopData")
    @ResponseBody
    public ModelAndView selectCountTimeOnShopData(HttpServletRequest request,ModelMap map,String data,String mobile) throws Exception{
        List<WifiMaxGust>  wifiMaxGustsShop= new ArrayList<WifiMaxGust>();
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            if(StringUtils.isNotBlank(mobile)) {
                WifiMaxGust wifiMaxGust = new WifiMaxGust();
                wifiMaxGust.setMobile(mobile);
                wifiMaxGustsShop = this.dataBoxService.selectCountTimeOnShop(wifiMaxGust);
            }
            resultMap.put("data",wifiMaxGustsShop);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }

    /**
     * 用户停留商铺列表
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectTrafficShopByUser")
    @ResponseBody
    public ModelAndView selectTrafficShopByUser(HttpServletRequest request,ModelMap map,String data,String mobile) throws Exception{
        List<TrafficShop> trafficShops = new ArrayList<TrafficShop>();
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            if(StringUtils.isNotBlank(mobile)) {
                TrafficShop trafficShop = new TrafficShop();
                trafficShop.setMobile(mobile);
                trafficShops = this.dataBoxService.selectShopByUser(trafficShop);
            }
            resultMap.put("data",trafficShops);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }

    /**
     * 用户停留商户时间信息列表
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectTrafficShopByUserTime")
    @ResponseBody
    public ModelAndView selectTrafficShopByUserTime(HttpServletRequest request,ModelMap map,String data,String shopId,String mobile) throws Exception{
        List<TrafficShopUserTimeVo> trafficShopUserTimeVos= new ArrayList<TrafficShopUserTimeVo>();
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            if(StringUtils.isNotBlank(mobile)&&shopId!=null) {
                TrafficShop trafficShop = new TrafficShop();
                trafficShop.setMobile(mobile);
                trafficShop.setShopId(shopId);
                trafficShopUserTimeVos = this.dataBoxService.selectShopTimeByUser(trafficShop);
            }
            resultMap.put("data",trafficShopUserTimeVos);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }

    /**
     * 用户停车场按支付类型支付金额列表
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectParkingUserPayTypeCount")
    @ResponseBody
    public ModelAndView selectParkingUserPayTypeCount(HttpServletRequest request,ModelMap map,String data,Long shopId,String mobile) throws Exception{
        List<ParkingDetail> parkingDetailsLeave = new ArrayList<ParkingDetail>();
        List<ParkingDetail> parkingDetailsEnter = new ArrayList<ParkingDetail>();
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            if(StringUtils.isNotBlank(mobile)) {
                Double countPay = this.dataBoxService.selectParkingUserPayCount(mobile);
                List<ParkingDetail> parkingDetails = this.dataBoxService.selectParkingUserPayTypeCount(mobile);
                resultMap.put("data", parkingDetails);
                if (countPay != null) {
                    resultMap.put("countPay", countPay);
                } else {
                    resultMap.put("countPay", "0.00");
                }
                parkingDetailsLeave = this.dataBoxService.selectParkingLeaveCount(mobile);
                parkingDetailsEnter = this.dataBoxService.selectParkingEnterCount(mobile);
            }else{
                resultMap.put("countPay", "0.00");
            }
            resultMap.put("parkingDetailsLeave",parkingDetailsLeave);
            resultMap.put("parkingDetailsEnter",parkingDetailsEnter);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * 用户到视屏点击内容
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectScreenvideoCoutent")
    @ResponseBody
    public ModelAndView selectScreenvideoCoutent(HttpServletRequest request,ModelMap map,String data,String mobile) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<Screenvideo> screenvideos = new ArrayList<Screenvideo>();
        try {
            if(StringUtils.isNotBlank(mobile)) {
                Screenvideo screenvideo = new Screenvideo();
                screenvideo.setMobile(mobile);
                screenvideos = this.dataBoxService.selectContentByUserMobile(screenvideo);
            }
            resultMap.put("data",screenvideos);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }

    /**
     * 用户到视屏点击内容次数
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectScreenvideoCoutentCount")
    @ResponseBody
    public ModelAndView selectScreenvideoCoutentCount(HttpServletRequest request,ModelMap map,String data,String content,String mobile) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<Screenvideo> screenvideos = new ArrayList<Screenvideo>();
        try {
            if(StringUtils.isNotBlank(content)&&StringUtils.isNotBlank(mobile)) {
                Screenvideo screenvideo = new Screenvideo();
                screenvideo.setContent(content);
                screenvideo.setMobile(mobile);
                screenvideos = this.dataBoxService.selectContentCountByUserMobile(screenvideo);
            }
            resultMap.put("data",screenvideos);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * mall
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("shop")
    public String shop(HttpServletRequest request,ModelMap map,String data,String merchantId,String date,String type) throws Exception{
        try {
            if(StringUtils.isNotBlank(merchantId)){
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                if(StringUtils.isEmpty(date)) {
                    date = format.format(new Date());
                }else{
                    date = Util.getMonth(date, type);
                }
                String date1  = Util.getMonth(date, "-1");
                DataBoxPosmonitor dataBoxPosmonitor = new DataBoxPosmonitor();
                dataBoxPosmonitor.setMerchantid(merchantId);
                dataBoxPosmonitor.setCreateTime(format.parse(date));
                DataBoxPosmonitor dataBoxPosmonitorData = this.dataBoxService.selectMerchantByMerchantid(dataBoxPosmonitor);
                DataBoxReceipt dataBoxReceipt = new DataBoxReceipt();
                dataBoxReceipt.setMerchantid(merchantId);
                dataBoxReceipt.setCreatetime(format.parse(date));
                Long count = this.dataBoxService.selectDataBoxUserCount(dataBoxReceipt);
                DataBoxReceipt dataBoxReceipt1 = new DataBoxReceipt();
                dataBoxReceipt1.setMerchantid(merchantId);
                dataBoxReceipt1.setCreatetime(format.parse(date1));
                Long count1 = this.dataBoxService.selectDataBoxUserCount(dataBoxReceipt1);
                Double dataBoxSum = this.dataBoxService.selectMerchantTotalSumPay(dataBoxPosmonitor);
                //获取上一个月数据消费金额
                DataBoxPosmonitor dataBoxPosmonitor1 = new DataBoxPosmonitor();
                dataBoxPosmonitor1.setMerchantid(merchantId);
                dataBoxPosmonitor1.setCreateTime(format.parse(date1));
                Double dataBoxSumToMonth = this.dataBoxService.selectMerchantTotalSumPay(dataBoxPosmonitor1);
                map.put("monthStr1",date1);
                map.put("dataBoxSumToMonth",dataBoxSumToMonth==null?"0.00":dataBoxSumToMonth);
                AppPayData appPayData = new AppPayData();
                appPayData.setMerchantid(merchantId);
                AppPayData appPayData1 = this.dataBoxService.selectMerchantPayAmountByMerchantId(appPayData);
                List<DataBoxPosmonitor> dataBoxPosmonitors = this.dataBoxService.selectMerchantPaySexCount(dataBoxPosmonitor);
                TrafficShop trafficShop = new TrafficShop();
                trafficShop.setShopId(merchantId);
                trafficShop.setEnterTime(format.parse(date));
                List<TrafficShopUserTimeVo> trafficShopUserTimeVos = this.dataBoxService.selectShopDayUserCountByShopId(trafficShop);
                int countTraffic = 0;
                if (trafficShopUserTimeVos != null && trafficShopUserTimeVos.size() > 0) {
                    for (int i = 0; i < trafficShopUserTimeVos.size(); i++) {
                        countTraffic += Integer.parseInt(trafficShopUserTimeVos.get(i).getShopId());
                    }
                }
                DataboxItemtype dataBoxItemType = new DataboxItemtype();
                dataBoxItemType.setMerchantid(merchantId);
                List<DataboxItemtype> databoxItemtypes = this.dataBoxService.selectDataBoxToMonthAgeTypeByMerchantId(dataBoxItemType);
                int countAge = 0;
                if (databoxItemtypes != null && databoxItemtypes.size() > 0) {
                    for (int i = 0; i < databoxItemtypes.size(); i++) {
                        countAge += databoxItemtypes.get(i).getId();
                    }
                }

                //获取上一个月客流
                TrafficShop trafficShop1 = new TrafficShop();
                trafficShop1.setShopId(merchantId);
                trafficShop1.setEnterTime(format.parse(date1));
                List<TrafficShopUserTimeVo> trafficShopUserTimeVos1 = this.dataBoxService.selectShopDayUserCountByShopId(trafficShop1);
                int countTraffic1 = 0;
                if (trafficShopUserTimeVos1 != null && trafficShopUserTimeVos1.size() > 0) {
                    for (int i = 0; i < trafficShopUserTimeVos1.size(); i++) {
                        countTraffic1 += Integer.parseInt(trafficShopUserTimeVos1.get(i).getShopId());
                    }
                }
                List<IbeanconStatisticVo> beanconList = ibeaconService.getBeaconStatistic();
                int countBeancon = 0;
                if(beanconList!=null) {
                    for (int i = 0; i < beanconList.size(); i++) {
                        countBeancon += beanconList.get(i).getCnt();
                    }
                }
                map.put("countBeancon",countBeancon);
                map.put("countTraffic1", beanconList==null?0:beanconList.size());
                map.put("countAge", countAge);
                map.put("databoxItemtypes", databoxItemtypes);
                map.put("countTraffic", beanconList==null?0:beanconList.size());
                map.put("dataBoxPosmonitors", dataBoxPosmonitors);
                if(appPayData1!=null&&appPayData1.getAmount()!=null) {
                    map.put("appPayData1", appPayData1.getAmount());
                }else{
                    map.put("appPayData1", "0.00");
                }
                map.put("dataBoxSum", dataBoxSum==null?"0.00":dataBoxSum);
                map.put("dataBoxPosmonitorData", dataBoxPosmonitorData);
                map.put("count", count==null?0:count);
                map.put("count1", count1==null?0:count1);
                map.put("tidailu", new BigDecimal((count/(countBeancon==0?1:Double.parseDouble(String.valueOf(countBeancon))))*100).setScale(2,BigDecimal.ROUND_HALF_UP));
                map.put("tidailu1",new BigDecimal((count1/(countTraffic1==0?1:Double.parseDouble(String.valueOf(countTraffic1))))*100).setScale(2,BigDecimal.ROUND_HALF_UP));
                map.put("toMonth", date);
                map.put("type",type);
                if (appPayData1 != null && dataBoxSum != null) {
                    map.put("payCount", new BigDecimal((dataBoxSum + appPayData1.getAmount()) / 10000).setScale(4, BigDecimal.ROUND_HALF_UP));
                } else {
                    map.put("payCount", new BigDecimal(0).setScale(4, BigDecimal.ROUND_HALF_UP));
                }
            }else{
                return "sShop";
            }
        }catch (Exception e){
            logger.error("店铺刻画页面加载出错！",e);
            throw new Exception(e);
        }
        return "sShop";
    }


    /**
     * 店铺消费金额
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectShopTotalPayAmaount")
    @ResponseBody
    public ModelAndView selectShopTotalPayAmaount(HttpServletRequest request,ModelMap map,String data,String merchantId) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            AppPayData appPayData = new AppPayData();
            appPayData.setMerchantid(merchantId);
            AppPayData appPayData1 = this.dataBoxService.selectMerchantPayAmountByMerchantId(appPayData);
            map.put("appPayData1", appPayData1);
            DataBoxPosmonitor dataBoxPosmonitor = new DataBoxPosmonitor();
            dataBoxPosmonitor.setMerchantid(merchantId);
            Double dataBoxSum = this.dataBoxService.selectMerchantTotalSumPay(dataBoxPosmonitor);
            resultMap.put("dataBoxSum", dataBoxSum);
            if(appPayData1!=null) {
                resultMap.put("amount", appPayData1.getAmount());
            }else{
                resultMap.put("amount", 0);
            }
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }



    /**
     * 店铺消费人员性别比例
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectMerchantPaySexCount")
    @ResponseBody
    public ModelAndView selectMerchantPaySexCount(HttpServletRequest request,ModelMap map,String data,String merchantId,String date,String type,Long mallId) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<DataBoxPosmonitor> dataBoxPosmonitors = new ArrayList<DataBoxPosmonitor>();
        try {
            if(StringUtils.isNotBlank(merchantId)||mallId!=null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                DataBoxPosmonitor dataBoxPosmonitor = new DataBoxPosmonitor();
                if(StringUtils.isBlank(type)) {
                    date = format.format(new Date());
                }
                dataBoxPosmonitor.setCreateTime(format.parse(date));
                dataBoxPosmonitor.setMerchantid(merchantId);
                dataBoxPosmonitor.setMallId(mallId);
                dataBoxPosmonitors = this.dataBoxService.selectMerchantPaySexCount(dataBoxPosmonitor);
            }
            resultMap.put("data", dataBoxPosmonitors);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * 店铺客流信息列表
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectShopDayUserCountByMerchantId")
    @ResponseBody
    public ModelAndView selectShopDayUserCountByMerchantId(HttpServletRequest request,ModelMap map,String data,String merchantId,String date,String type) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<IbeanconLog> ibeanconLogs = new ArrayList<IbeanconLog>();
        List<DataBoxDetailVo> dataBoxDetailVos = new ArrayList<DataBoxDetailVo>();
        try {
            if(StringUtils.isNotBlank(merchantId)) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                IbeanconLog ibeanconLog = new IbeanconLog();
                if(StringUtils.isBlank(type)) {
                    date = format.format(new Date());
                }
                ibeanconLog.setCreadedDate(format.parse(date));
                ibeanconLogs = this.dataBoxService.selectIbeanconLogToMonthCountByDay(ibeanconLog);
                DataBoxReceipt dataBoxReceipt = new DataBoxReceipt();
                if(StringUtils.isBlank(type)) {
                    date = format.format(new Date());
                }
                dataBoxReceipt.setMerchantid(merchantId);
                dataBoxReceipt.setCreatetime(format.parse(date));
                dataBoxDetailVos = this.dataBoxService.selectDataBoxToMonthUserCountByUserId(dataBoxReceipt);
            }
            resultMap.put("data1", dataBoxDetailVos);
            resultMap.put("data", ibeanconLogs);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }

    /**
     * 店铺客流信息列表
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectDataBoxToMonthAgeTypeByMerchantId")
    @ResponseBody
    public ModelAndView selectDataBoxToMonthAgeTypeByMerchantId(HttpServletRequest request,ModelMap map,String data,String merchantId,String date,String type,Long mallId) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<DataboxItemtype> databoxItemtypes = new ArrayList<DataboxItemtype>();
        try {
            if(StringUtils.isNotBlank(merchantId)||mallId!=null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                DataboxItemtype dataBoxItemType = new DataboxItemtype();
                dataBoxItemType.setMerchantid(merchantId);
                if(StringUtils.isBlank(type)) {
                    date = format.format(new Date());
                }
                dataBoxItemType.setCreatedDate(format.parse(date));
                dataBoxItemType.setId(mallId);
                databoxItemtypes = this.dataBoxService.selectDataBoxToMonthAgeTypeByMerchantId(dataBoxItemType);
            }
            resultMap.put("data", databoxItemtypes);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * 获取广场当月销售额
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectMallToMonthData")
    @ResponseBody
    public ModelAndView selectMallToMonthData(HttpServletRequest request,ModelMap map,String data,Long mallId) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            if(mallId!=null) {
                AppPayData appPayData = new AppPayData();
                appPayData.setMallId(mallId);
                AppPayData appPay = this.dataBoxService.selectMerchantPayAmountByMerchantId(appPayData);
                DataBoxPosmonitor dataBoxPosmonitor = new DataBoxPosmonitor();
                dataBoxPosmonitor.setMallId(mallId);
                Double dataBoxPosmonitorSum = this.dataBoxService.selectMerchantTotalSumPay(dataBoxPosmonitor);
                if(appPay!=null) {
                    resultMap.put("amount", new BigDecimal(appPay.getAmount() / 10000).setScale(4, BigDecimal.ROUND_HALF_UP));
                }else{
                    resultMap.put("amount", new BigDecimal(0).setScale(4, BigDecimal.ROUND_HALF_UP));
                }
                if(dataBoxPosmonitorSum!=null) {
                    resultMap.put("dataBoxPosmonitorSum", new BigDecimal(dataBoxPosmonitorSum / 10000).setScale(4, BigDecimal.ROUND_HALF_UP));
                }else{
                    resultMap.put("dataBoxPosmonitorSum", new BigDecimal(0).setScale(4, BigDecimal.ROUND_HALF_UP));
                }
            }else{
                resultMap.put("amount", new BigDecimal(0).setScale(4,BigDecimal.ROUND_HALF_UP));
                resultMap.put("dataBoxPosmonitorSum", new BigDecimal(0).setScale(4,BigDecimal.ROUND_HALF_UP));
            }
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * 获取广场当月销售额信息列表
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectMallToMonthPayData")
    @ResponseBody
    public ModelAndView selectMallToMonthPayData(HttpServletRequest request,ModelMap map,String data,Long mallId,String date,String type) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<AppPayData> appPayDatas = new ArrayList<AppPayData>();
        List<DataBoxPosmonitor> dataBoxPosmonitors = new ArrayList<DataBoxPosmonitor>();
        try {
            if(mallId!=null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                if(StringUtils.isBlank(type)) {
                    date = format.format(new Date());
                }
                DataBoxPosmonitor dataBoxPosmonitor = new DataBoxPosmonitor();
                dataBoxPosmonitor.setMallId(mallId);
                dataBoxPosmonitor.setCreateTime(format.parse(date));
                dataBoxPosmonitors = this.dataBoxService.selectMallPayPosmonitorSum(dataBoxPosmonitor);
            }
            resultMap.put("dataBoxPosmonitors", dataBoxPosmonitors);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * 获取广场当天时时数据
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectMallToDayAllData")
    @ResponseBody
    public ModelAndView selectMallToDayAllData(HttpServletRequest request,ModelMap map,String data,Long mallId,String date,String type) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        Long parkingData = 0l ;
        Long wifiData = 0l ;
        Long trafficData = 0l ;
        try {
            if(mallId!=null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                if(StringUtils.isBlank(type)) {
                    date = format.format(new Date());
                }
                //停车场
                ParkingUser parkingUser = new ParkingUser();
                parkingUser.setMallId(mallId.toString());
                parkingData = this.dataBoxService.selectParkingMallAllDataByMallId(parkingUser);
                //wifi
                WifiMaxGust wifiMaxGust = new WifiMaxGust();
                wifiMaxGust.setMallId(mallId);
                wifiData = this.dataBoxService.selectMallAllDataByMallId(wifiMaxGust);
                //客流
                TrafficMall trafficMall = new TrafficMall();
                trafficMall.setMallId(mallId);
                trafficData = this.dataBoxService.selectMallTrafficDataByMallId(trafficMall);

            }
            resultMap.put("wifiData", wifiData==null?0:wifiData);
            resultMap.put("trafficData", trafficData==null?0:trafficData);
            resultMap.put("parkingData", parkingData==null?0:parkingData);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }



    /**
     * 获取广场当月数据
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectMallToMonthAllData")
    @ResponseBody
    public ModelAndView selectMallToMonthAllData(HttpServletRequest request,ModelMap map,String data,Long mallId,String date,String type) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<ParkingUser> parkingUsers = new ArrayList<ParkingUser>();
        List<WifiMaxGust> wifiMaxGusts = new ArrayList<WifiMaxGust>();
        List<IbeanconLog> ibeanconLogs = new ArrayList<IbeanconLog>();
        try {
            if(mallId!=null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                if(StringUtils.isBlank(type)) {
                    date = format.format(new Date());
                }
                //停车场
                ParkingUser parkingUser = new ParkingUser();
                parkingUser.setMallId(mallId.toString());
                parkingUser.setCreatedDate(format.parse(date));
                parkingUsers = this.dataBoxService.selectParkingMallCountDataByMallId(parkingUser);
                //wifi
                WifiMaxGust wifiMaxGust = new WifiMaxGust();
                wifiMaxGust.setMallId(mallId);
                wifiMaxGust.setCreatedDate(format.parse(date));
                wifiMaxGusts = this.dataBoxService.selectMallWifiMonthDataByMallId(wifiMaxGust);
                //客流
                IbeanconLog ibeanconLog = new IbeanconLog();
                ibeanconLog.setCreadedDate(format.parse(date));
                ibeanconLogs = this.dataBoxService.selectIbeanconLogToMonthCountByDay(ibeanconLog);
            }
            resultMap.put("wifiMaxGusts", wifiMaxGusts);
            resultMap.put("ibeanconLogs", ibeanconLogs);
            resultMap.put("parkingUsers", parkingUsers);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }

    /**
     * 店铺客流信息列表
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectByUserNewAndOld")
    @ResponseBody
    public ModelAndView selectByUserNewAndOld(HttpServletRequest request,ModelMap map,String data,String merchantId,String date,String type,Long mallId) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        Double newCount = 0.00;
        try {
            if(StringUtils.isNotBlank(merchantId)||mallId!=null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                DataboxUser databoxUser = new DataboxUser();
                if(StringUtils.isBlank(type)) {
                    date = format.format(new Date());
                }
                databoxUser.setCreatedDate(format.parse(date));
                databoxUser.setMallId(mallId);
                newCount = this.dataBoxService.selectByUserNewAndOld(databoxUser);
            }
            resultMap.put("newCount",newCount==null?0.00:newCount*100);
        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * 每天性别数
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectMerchantPaySexCountBySex")
    @ResponseBody
    public ModelAndView selectMerchantPaySexCountBySex(HttpServletRequest request,ModelMap map,String data,String merchantId,String date,String type,Long mallId) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<DataBoxPosmonitor> dataBoxPosmonitor0 = new ArrayList<DataBoxPosmonitor>();
        List<DataBoxPosmonitor> dataBoxPosmonitor1 = new ArrayList<DataBoxPosmonitor>();
        Double newCount = 0.00;
        try {
            if(StringUtils.isNotBlank(merchantId)||mallId!=null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                DataBoxPosmonitor dataBoxPosmonitor = new DataBoxPosmonitor();
                if(StringUtils.isBlank(type)) {
                    date = format.format(new Date());
                }
                dataBoxPosmonitor.setMallName("1");//男性
                dataBoxPosmonitor.setCreateTime(format.parse(date));
                dataBoxPosmonitor.setMallId(mallId);
                dataBoxPosmonitor1 = this.dataBoxService.selectMerchantPaySexCountBySex(dataBoxPosmonitor);
                dataBoxPosmonitor.setMallName("0");
                dataBoxPosmonitor0 = this.dataBoxService.selectMerchantPaySexCountBySex(dataBoxPosmonitor);

            }
            resultMap.put("dataBoxPosmonitor1",dataBoxPosmonitor1);
            resultMap.put("dataBoxPosmonitor0",dataBoxPosmonitor0);

        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * 每天性别数
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectOldAndNewUserList")
    @ResponseBody
    public ModelAndView selectOldAndNewUserList(HttpServletRequest request,ModelMap map,String data,String merchantId,String date,String type,Long mallId) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<DataboxUser> databoxUser0 = new ArrayList<DataboxUser>();
        List<DataboxUser> databoxUser1 = new ArrayList<DataboxUser>();
        try {
            if(StringUtils.isNotBlank(merchantId)||mallId!=null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                DataboxUser databoxUser = new DataboxUser();
                if(StringUtils.isBlank(type)) {
                    date = format.format(new Date());
                }
                databoxUser.setCreatedDate(format.parse(date));
                databoxUser0 = this.dataBoxService.selectByUserToMonthNewList(databoxUser);//新数据
                databoxUser1 = this.dataBoxService.selectByUserToMonthOldList(databoxUser);//老数据
            }
            resultMap.put("databoxUser0",databoxUser0);
            resultMap.put("databoxUser1",databoxUser1);

        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


    /**
     * 每天年龄列表
     * @param request
     * @param map
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("selectDataBoxToMonthAgeList")
    @ResponseBody
    public ModelAndView selectDataBoxToMonthAgeList(HttpServletRequest request,ModelMap map,String data,String merchantId,String date,String type,Long mallId) throws Exception{
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<DataboxItemtype> databoxItemtype0 = new ArrayList<DataboxItemtype>();
        List<DataboxItemtype> databoxItemtype1 = new ArrayList<DataboxItemtype>();
        List<DataboxItemtype> databoxItemtype2 = new ArrayList<DataboxItemtype>();
        List<DataboxItemtype> databoxItemtype3 = new ArrayList<DataboxItemtype>();
        try {
            if(StringUtils.isNotBlank(merchantId)||mallId!=null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                DataboxItemtype databoxItemtype = new DataboxItemtype();
                if(StringUtils.isBlank(type)) {
                    date = format.format(new Date());
                }
                databoxItemtype.setCreatedDate(format.parse(date));
                databoxItemtype.setId(30l);
                databoxItemtype0 = this.dataBoxService.selectDataBoxToMonthAgeList(databoxItemtype);//30年龄段
                databoxItemtype.setId(40l);
                databoxItemtype1 = this.dataBoxService.selectDataBoxToMonthAgeList(databoxItemtype);//40年龄段
                databoxItemtype.setId(20l);
                databoxItemtype2 = this.dataBoxService.selectDataBoxToMonthAgeList(databoxItemtype);//40年龄段
                databoxItemtype.setId(10l);
                databoxItemtype3 = this.dataBoxService.selectDataBoxToMonthAgeList(databoxItemtype);//40年龄段


            }
            resultMap.put("databoxItemtype0",databoxItemtype0);
            resultMap.put("databoxItemtype1",databoxItemtype1);
            resultMap.put("databoxItemtype2",databoxItemtype0);
            resultMap.put("databoxItemtype3",databoxItemtype1);

        }catch (Exception e){
            logger.error("插入wifi接入认证查询信息出错",e);
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(Util.getJsonView(resultMap));
        return mav;
    }


}
