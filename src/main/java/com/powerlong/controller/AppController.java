package com.powerlong.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.powerlong.common.*;
import com.powerlong.model.DataboxUser;
import com.powerlong.model.ParkingDetail;
import com.powerlong.model.ParkingUser;
import com.powerlong.model.Receipt;
import com.powerlong.service.DataboxUserService;
import com.powerlong.service.ParkingService;
import com.powerlong.service.ReceiptServiceI;
import com.powerlong.service.SplusCrmService;
import com.powerlong.vo.AppEnum;
import com.powerlong.vo.SplusStreamVo;
import com.powerlong.webService.client.WebServiceForPay;
import com.powerlong.webService.client.WebServiceForPaySoap;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.*;

/**
 * 手机相关
 * Created by Angus on 2015/5/28.
 */
@Controller
@RequestMapping("/app")
public class AppController {

    private static final Logger logger = Logger
            .getLogger(AppController.class);
    @Resource
    private DataboxUserService databoxUserService;
    @Resource
    private ReceiptServiceI receiptService;
    @Resource
    private ParkingService parkingService;
    @Resource
    private SplusCrmService splusCrmService;


    /**
     * 用户绑定水单
     * @param map
     * @param data
     * @param request
     * @return
     * @throws
     * @throws SystemException
     */
    @RequestMapping(value = "/scanNum", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Object scanNum(ModelMap map, String data, HttpServletRequest request) {
        MobileJsonVo mobileJsonVo = new MobileJsonVo();
        mobileJsonVo.setCode(MobileParamsEnum.RETURN_CODE_SUCCESS.key);
        mobileJsonVo.setMsg(MobileParamsEnum.RETURN_CODE_SUCCESS.value);

        Enterprise mapJson = null;
        try {
            mapJson = new Enterprise((Map<String, Object>) JSON.parse(XssHtmlUtility.decode(data)));

        } catch (Exception e) {
            logger.error(AppEnum.APP_SCAN_NUM.getMessage() + ":" + e);
        }
        int cont =databoxUserService.insert(getDataBosxUser(mapJson));
        if (cont>0){
            mobileJsonVo.setCode(MobileParamsEnum.RETURN_CODE_SUCCESS.key);
            mobileJsonVo.setMsg(MobileParamsEnum.RETURN_CODE_SUCCESS.value);
            //信息推送到滚动屏
            SplusStreamVo splusStreamVo =splusCrmService.getPostStream();
            List<Map<String,String>> msgs =splusStreamVo.getMsg();
            if (msgs.size()>0){
                splusCrmService.execute("1", msgs.get(0).get("content"), msgs.get(0).get("img"));
            }
        }else {
            mobileJsonVo.setCode("1");
            mobileJsonVo.setMsg("绑定失败");
        }
        return mobileJsonVo;
    }

    /**
     * 解析databoxuser数据
     * @param mapJson
     * @return
     */
    private DataboxUser getDataBosxUser(Enterprise mapJson){
        DataboxUser databoxUser = new DataboxUser();
        databoxUser.setUserName(mapJson.getString("userName"));
        databoxUser.setMobile(mapJson.getString("mobile"));

        /*try {
            databoxUser.setQrcode(URLDecoder.decode(mapJson.getString("code"), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        if (StringUtils.isNotBlank((mapJson.getString("userId")))){
            databoxUser.setUserId(Long.parseLong(mapJson.getString("userId")));
        }
        databoxUser.setSex(mapJson.getString("sex"));
        databoxUser.setBirthday(mapJson.getString("birthday"));
        databoxUser.setIde(mapJson.getString("ide"));
        databoxUser.setEmail(mapJson.getString("email"));
        databoxUser.setAddress(mapJson.getString("address"));
        databoxUser.setMlevel(mapJson.getString("mlevel"));
        databoxUser.setMemberNo(mapJson.getString("memberNo"));
        if (StringUtils.isNotBlank(mapJson.getString("mallId"))){
            databoxUser.setMallId(Long.parseLong(mapJson.getString("mallId")));
        }
        databoxUser.setMallName(mapJson.getString("mallName"));
        databoxUser.setReceiptnum(mapJson.getString("receiptnum"));
        databoxUser.setCreatedDate(new Date());
        databoxUser.setUpdatedDate(new Date());
        logger.info(databoxUser.toString());
        logger.info("json:" +mapJson.toString());
        return databoxUser;
    }

    /**
     * 获取水单列表
     * @param map
     * @param data
     * @param request
     * @return
     * @throws
     * @throws SystemException
     */
    @RequestMapping(value = "/getInventory", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Object getInventory(ModelMap map, String data, HttpServletRequest request)  {
        MobileJsonVo mobileJsonVo = new MobileJsonVo();
        mobileJsonVo.setCode(MobileParamsEnum.RETURN_CODE_SUCCESS.key);
        mobileJsonVo.setMsg(MobileParamsEnum.RETURN_CODE_SUCCESS.value);
        Enterprise mapJson = null;
        try {
            mapJson = new Enterprise((Map<String, Object>) JSON.parse(XssHtmlUtility.decode(data)));
        } catch (Exception e) {
            logger.error(AppEnum.APP_GET_INVENTORY.getMessage() + ":" + e);
        }
        String mobile = mapJson.getString("mobile");
        List<DataboxUser> databoxUsers = databoxUserService.selectByMobile(mobile);
        List<Receipt> receipts = new ArrayList<Receipt>();
        if (databoxUsers!=null&&databoxUsers.size()>0){
            for (int i = 0; i <databoxUsers.size() ; i++) {
                receipts.add(receiptService.selectByQRCode(databoxUsers.get(i).getQrcode()));
            }
        }
        if (receipts.size()>0){
            HashMap hashMap = new HashMap();
            hashMap.put("array",receipts);
            mobileJsonVo.setData(hashMap);
        }
        mobileJsonVo.setCode(MobileParamsEnum.RETURN_CODE_SUCCESS.key);
        mobileJsonVo.setMsg(MobileParamsEnum.RETURN_CODE_SUCCESS.value);
        return mobileJsonVo;
    }

    /**
     * 绑定车牌号
     * @param map
     * @param data
     * @param request
     * @return
     * @throws
     * @throws SystemException
     */
    @RequestMapping(value = "/scanPlateNum", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Object scanPlateNum(ModelMap map, String data, HttpServletRequest request) {
        MobileJsonVo mobileJsonVo = new MobileJsonVo();
        mobileJsonVo.setCode(MobileParamsEnum.RETURN_CODE_SUCCESS.key);
        mobileJsonVo.setMsg(MobileParamsEnum.RETURN_CODE_SUCCESS.value);
        Enterprise mapJson = null;
        try {
            mapJson = new Enterprise((Map<String, Object>) JSON.parse(XssHtmlUtility.decode(data)));
        } catch (Exception e) {
            logger.error(AppEnum.APP_SCAN_NUM.getMessage() + ":" + e);
        }
        int cont =parkingService.bindingUser(getParkingUser(mapJson));
        if (cont>0){
            mobileJsonVo.setCode(MobileParamsEnum.RETURN_CODE_SUCCESS.key);
            mobileJsonVo.setMsg(MobileParamsEnum.RETURN_CODE_SUCCESS.value);
        }else {
            mobileJsonVo.setCode("1");
            mobileJsonVo.setMsg("请求失败");
        }
        return mobileJsonVo;
    }

    /**
     * 解析parking数据
     * @param mapJson
     * @return
     */
    private ParkingUser getParkingUser(Enterprise mapJson){
        ParkingUser parkingUser = new ParkingUser();
        parkingUser.setPlateNo(mapJson.getString("plateNo"));
        parkingUser.setMobile(mapJson.getString("mobile"));
        parkingUser.setCrmUser(mapJson.getString("crmUser"));
        parkingUser.setMallId(mapJson.getString("mallId"));
        parkingUser.setMallName(mapJson.getString("mallName"));
        parkingUser.setIsDel("0");
        parkingUser.setCreatedDate(new Date());
        return parkingUser;
    }
    /**
     * 获取支付信息
     * @param map
     * @param data
     * @param request
     * @return
     * @throws
     * @throws SystemException
     */
    @RequestMapping(value = "/sendPayDetail", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Object sendPayDetail(ModelMap map, String data, HttpServletRequest request)  {
        MobileJsonVo mobileJsonVo = new MobileJsonVo();
        mobileJsonVo.setCode(MobileParamsEnum.RETURN_CODE_SUCCESS.key);
        mobileJsonVo.setMsg(MobileParamsEnum.RETURN_CODE_SUCCESS.value);
        Enterprise mapJson = null;
        try {
            mapJson = new Enterprise((Map<String, Object>) JSON.parse(XssHtmlUtility.decode(data)));
        } catch (Exception e) {
            logger.error(AppEnum.APP_SCAN_NUM.getMessage() + ":" + e);
        }
        ParkingDetail parkingDetail = new ParkingDetail();

        parkingDetail.setPlateNo(mapJson.getString("plateNo"));
        if (StringUtils.isNotBlank(mapJson.getString("payable"))){
            parkingDetail.setPayable(new BigDecimal(mapJson.getString("payable")));
        }
        parkingDetail.setPayType(mapJson.getString("payType"));
        parkingDetail.setCreatedDate(new Date());
        parkingDetail.setCashTime(new Date());
        //请求webservice
        WebServiceForPay webServiceFrPay = new WebServiceForPay();
        WebServiceForPaySoap webs =webServiceFrPay.getWebServiceForPaySoap();
        String parks =webs.getFuzzyCarInfo(parkingDetail.getPlateNo(), 1, 10);
        if (StringUtils.isNotBlank(parks)){
            JSONObject dataJson=new JSONObject();
            JSONObject jsonObject = JSONObject.parseObject(parks);
            //获取相应代码
            String resCode =jsonObject.getString("resCode");
            //判断返回状态
            if ("0".equals(resCode)){
                JSONArray parkings=jsonObject.getJSONArray("data");
                for (int j = 0; j <parkings.size() ; j++) {
                    //解析返回数据
                    ParkingDetail detail=getParkingDetail(parkings.getJSONObject(j));
                    if (StringUtils.isNotBlank(detail.getPlateNo())){
                        //判断数据库是否存在  存在就更新 不存在就插入
                        ParkingDetail pa =parkingService.selectByKtId(detail.getKtId());
                        if (pa ==null){
                            detail.setPayable(parkingDetail.getPayable());
                            detail.setPayType(parkingDetail.getPayType());
                            detail.setCashTime(new Date());
                            detail.setUpdatedDate(new Date());
                            detail.setLeaveTime(new Date());
                            int cont= parkingService.insertParkingDetail(detail);
                            if (cont>0){
                                //推送到滚动屏
                                SplusStreamVo splusStreamVo =splusCrmService.getParkingStream();
                                List<Map<String,String>> msgs =splusStreamVo.getMsg();
                                if (msgs.size()>0){
                                    splusCrmService.execute("3", msgs.get(0).get("content"),"");
                                }
                                mobileJsonVo.setCode(MobileParamsEnum.RETURN_CODE_SUCCESS.key);
                                mobileJsonVo.setMsg(MobileParamsEnum.RETURN_CODE_SUCCESS.value);
                            }else {
                                mobileJsonVo.setCode("1");
                                mobileJsonVo.setMsg("请求失败");
                            }
                            return mobileJsonVo;
                        }else {
                            pa.setPayable(parkingDetail.getPayable());
                            pa.setPayType(parkingDetail.getPayType());
                            pa.setCashTime(new Date());
                            pa.setLeaveTime(new Date());
                            pa.setUpdatedDate(new Date());
                            int cont= parkingService.updateByPrimaryKeySelective(pa);
                            if (cont>0){
                                //推送到滚动屏
                                SplusStreamVo splusStreamVo =splusCrmService.getParkingStream();
                                List<Map<String,String>> msgs =splusStreamVo.getMsg();
                                if (msgs.size()>0){
                                    splusCrmService.execute("3", msgs.get(0).get("content"), "");
                                }
                                mobileJsonVo.setCode(MobileParamsEnum.RETURN_CODE_SUCCESS.key);
                                mobileJsonVo.setMsg(MobileParamsEnum.RETURN_CODE_SUCCESS.value);
                            }else {
                                mobileJsonVo.setCode("1");
                                mobileJsonVo.setMsg("请求失败");
                            }
                            return mobileJsonVo;
                        }
                    }

                }
            }else {
                mobileJsonVo.setCode("1");
                mobileJsonVo.setMsg("请求失败");
                //获取错误信息
                String resMsg =jsonObject.getString("jsonObject");
                logger.error("sendPayDetail---执行出错:" + resMsg);
            }
        }
        return mobileJsonVo;
    }

    /**
     * 封装对象
     * @param j
     * @return
     */
    private ParkingDetail getParkingDetail(JSONObject j){
        ParkingDetail parking = new ParkingDetail();
        parking.setKtId(j.getString("id"));
        parking.setPlateNo(j.getString("plateNo"));
        if (StringUtils.isNotBlank(j.getString("entryTime"))){
            parking.setEntryTime(DateUtility.parse("yyyy/MM/dd hh:mm:ss", j.getString("entryTime")));
        }
        parking.setImgName(j.getString("imgName"));
        parking.setCreatedDate(new Date());
        parking.setUpdatedDate(new Date());
       /* if (StringUtils.isNotBlank(j.getString("leaveTime"))){
            parking.setLeaveTime(DateUtility.parse("yyyy/MM/dd hh:mm:ss", j.getString("leaveTime")));
        }*/
        /*parking.setEntryPlace(j.getString("entryPlace"));
        parking.setLeavePlace(j.getString("leavePlace"));

        parking.setPayable(j.getBigDecimal("payable"));
        parking.setVoucher(j.getString("voucher"));
        if (StringUtils.isNotBlank(j.getString("cashTime"))){
            parking.setCashTime(DateUtility.parse("yyyy/MM/dd hh:mm:ss", j.getString("cashTime")));
        }
        parking.setCashUser(j.getString("cashUser"));*/
        return parking;
    }


}
