package com.powerlong.controller;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.powerlong.common.*;
import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.powerlong.model.AuthMall;
import com.powerlong.model.WifiMaxGust;
import com.powerlong.service.SplusCrmService;
import com.powerlong.vo.DataBoxIndexParkingVo;
import com.powerlong.vo.DataBoxIndexPassengerVo;
import com.powerlong.vo.DataBoxIndexScreenVo;
import com.powerlong.vo.DataBoxIndexVo;
import com.powerlong.vo.DataBoxIndexWifiVo;

/**
 * Created by Angus on 2015/5/27.
 */
@Controller
@RequestMapping("/splus")
public class SplusCrmController {
    private static final Logger logger = Logger.getLogger(SplusCrmController.class);
    @Resource
    private SplusCrmService splusCrmService;

    /**
     * 首页
     * @param request
     * @param response
     * @param map
     * @param page
     * @param dataBoxIndexVo
     * @return
     * @throws Exception
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request,
                        HttpServletResponse response,ModelMap map,
                        Paginator page,DataBoxIndexVo dataBoxIndexVo) throws Exception{
    	
    	if(StringUtils.isNotBlank(dataBoxIndexVo.getStartTimeStr())){
    		dataBoxIndexVo.setStartTime(DateUtility.parse("yyyy-MM-dd HH:mm:ss", dataBoxIndexVo.getStartTimeStr()));
    	}
    	if(StringUtils.isNotBlank(dataBoxIndexVo.getEndTimeStr())){
    		dataBoxIndexVo.setEndTime(DateUtility.parse("yyyy-MM-dd HH:mm:ss", dataBoxIndexVo.getEndTimeStr()));
    	}
    	
        //封装请求参数
        page.setParams(checkDataBoxIndex(dataBoxIndexVo));
        Paginator paginator =splusCrmService.getSplusIndexData(page);
        if (paginator!=null){
            //封装mall和商户名称
            Map<String,String> shopMap = new HashMap<String, String>();
            for (int i = 0; i <paginator.getResults().size() ; i++) {
                DataBoxIndexVo box =(DataBoxIndexVo)paginator.getResults().get(i);
                if (StringUtils.isNotBlank(box.getMerchantid())&&StringUtils.isNotBlank(box.getMerchantname())){
                    shopMap.put(box.getMerchantid(),box.getMerchantname());
                }
            }
            setAuthMallInRequest(request);
            request.setAttribute("shopMap",shopMap);
            request.setAttribute("paginator",paginator);
        }
        request.setAttribute("dataBoxIndexVo", dataBoxIndexVo);
//        splusCrmService.getWebServiceParking();
        return "sPindex";
    }


    @RequestMapping("wifi")
    public String wifi(HttpServletRequest request,
                       HttpServletResponse response,ModelMap map,
                       Paginator page,DataBoxIndexWifiVo indexWifiVo) throws Exception{
        page.setParams(checkDataBoxWifi(indexWifiVo));
        Paginator paginator =splusCrmService.getSplusWifiData(page);
        if (paginator!=null){
            //封装mall和商户名称
            Map<String,String> shopMap = new HashMap<String, String>();
            for (int i = 0; i <paginator.getResults().size() ; i++) {
                WifiMaxGust box =(WifiMaxGust)paginator.getResults().get(i);

                if (StringUtils.isNotBlank(box.getShopName())&&box.getShopId()!=null){
                    shopMap.put(box.getShopId().toString(),box.getShopName());
                }
            }
            setAuthMallInRequest(request);
            request.setAttribute("shopMap", shopMap);
            request.setAttribute("paginator", paginator);
        }
        return "sPwifi";
    }

    /**
     * crm+首页 停车场
     * @param request
     * @param response
     * @param map
     * @param page
     * @param parkingVo
     * @return
     * @throws Exception
     */
    @RequestMapping("parking")
     public String parking(HttpServletRequest request,
                            HttpServletResponse response,ModelMap map,
                            Paginator page,DataBoxIndexParkingVo parkingVo) throws Exception{
        page.setParams(checkDataBoxParing(parkingVo));
        Paginator paginator =splusCrmService.getSplusParkingData(page);
        if (paginator!=null){
            setAuthMallInRequest(request);
            request.setAttribute("paginator", paginator);
            request.setAttribute("parkingVo", parkingVo);
        }
        return "sPparking";
    }

    /**
     * crm+首页 客流
     * @param request
     * @param response
     * @param map
     * @param page
     * @param passengerVo
     * @return
     * @throws Exception
     */
        @RequestMapping("passenger")
     public String sPpassenger (HttpServletRequest request,
                            HttpServletResponse response,ModelMap map,
                            Paginator page,DataBoxIndexPassengerVo passengerVo) throws Exception{
        page.setParams(checkDataBoxpassenger(passengerVo));
        Paginator paginator =splusCrmService.getSplusPassengerData(page);
        if (paginator!=null){
            request.setAttribute("paginator",paginator);
        }
            setAuthMallInRequest(request);
        return "sPpassenger";
    }

    /**
     * crm+ 首页 导视频
     * @param request
     * @param response
     * @param map
     * @param page
     * @param screenVo
     * @return
     * @throws Exception
     */
    @RequestMapping("screen")
     public String screen (HttpServletRequest request,
                            HttpServletResponse response,ModelMap map,
                            Paginator page,DataBoxIndexScreenVo screenVo,String mallId) throws Exception{
        page.setParams(checkDataBoxScreen(screenVo, mallId));
        Paginator paginator =splusCrmService.getSplusScreenVoData(page);
        if (paginator!=null){
            request.setAttribute("paginator",paginator);
        }
        setAuthMallInRequest(request);
        return "sPscreen";
    }
    @RequestMapping("infos")
     public String infos (HttpServletRequest request,
                            HttpServletResponse response,ModelMap map,
                            Paginator page,DataBoxIndexScreenVo screenVo,String mallId) throws Exception{
        return "infos";
    }

    @RequestMapping(value = "/getInfoData")
    @ResponseBody
    public Object getInfoData(ModelMap map,HttpServletRequest request) {
        List list = new ArrayList();
//        list.add("string1<img src='http://static.powerlong.com/group1/M00/03/B0/wKi0d1QGHOmAZItVAAFgXEFgAiQ083.png'/>");
        Map map1 =splusCrmService.getSplusInfoStream();

        return map1;
    }
    /**
     * 向request里面放入mall
     * @param request
     */
    private void setAuthMallInRequest(HttpServletRequest request){
        Map<String,String> mallMap = new HashMap<String, String>();
        List<AuthMall> authMalls =splusCrmService.getAuthMallList();
        if (authMalls!=null&&authMalls.size()>0){
            for (int i = 0; i <authMalls.size() ; i++) {
                AuthMall mall = authMalls.get(i);
                if (mall.getNumber()!=null&&mall.getNumber()!=0&&StringUtils.isNotBlank(mall.getShortName())){
                    mallMap.put(mall.getNumber().toString(),mall.getShortName());
                }
            }
            request.setAttribute("mallMap", mallMap);
        }
    }
    /**
     * 导视频数据校验
     * @param screenVo
     * @return
     */
    private DataBoxIndexScreenVo checkDataBoxScreen(DataBoxIndexScreenVo screenVo,String mallId) {
        if (StringUtils.isNotBlank(screenVo.getCheckTime())&&!"all".equals(screenVo.getCheckTime())){
            if ("年".equals(screenVo.getCheckTime())){
                screenVo.setStartTime(DateUtility.parse(new DateThisUtils().thisYear()));
            }else if ("月".equals(screenVo.getCheckTime())){
                screenVo.setStartTime(DateUtility.parse(new DateThisUtils().thisMonth()));
            }else if ("日".equals(screenVo.getCheckTime())){
                screenVo.setStartTime(DateUtility.parse(new DateThisUtils().today()));
            }
        }
        if (StringUtils.isNotBlank(mallId)&&!"0".equals(mallId)){
            screenVo.setMallid(mallId);
        }
        if (StringUtils.isBlank(screenVo.getMobile())){
            screenVo.setMobile(null);
        }
        if (StringUtils.isBlank(screenVo.getMallid())||"0".equals(screenVo.getMallid())){
            screenVo.setMallid(null);
        }
        return screenVo;
    }

    /**
     * 校验客流请求数据
     * @param passengerVo
     * @return
     */
    private DataBoxIndexPassengerVo checkDataBoxpassenger(DataBoxIndexPassengerVo passengerVo) {
        if (StringUtils.isNotBlank(passengerVo.getCheckTime())&&!"all".equals(passengerVo.getCheckTime())){
            if ("年".equals(passengerVo.getCheckTime())){
                passengerVo.setStartTime(DateUtility.parse(new DateThisUtils().thisYear()));
            }else if ("月".equals(passengerVo.getCheckTime())){
                passengerVo.setStartTime(DateUtility.parse(new DateThisUtils().thisMonth()));
            }else if ("日".equals(passengerVo.getCheckTime())){
                passengerVo.setStartTime(DateUtility.parse(new DateThisUtils().today()));
            }
        }
        if (passengerVo.getMallId()!=null&&passengerVo.getMallId()==0){
            passengerVo.setMallId(null);
        }
        if (StringUtils.isBlank(passengerVo.getTarget())){
            passengerVo.setTarget(null);
        }
        return passengerVo;
    }

    /**
     * 数据校验停车场
     * @param parkingVo
     * @return
     */
    private DataBoxIndexParkingVo checkDataBoxParing(DataBoxIndexParkingVo parkingVo) {
        if (StringUtils.isNotBlank(parkingVo.getCheckTime())&&!"all".equals(parkingVo.getCheckTime())){
            if ("年".equals(parkingVo.getCheckTime())){
                parkingVo.setStartTime(DateUtility.parse(new DateThisUtils().thisYear()));
            }else if ("月".equals(parkingVo.getCheckTime())){
                parkingVo.setStartTime(DateUtility.parse(new DateThisUtils().thisMonth()));
            }else if ("日".equals(parkingVo.getCheckTime())){
                parkingVo.setStartTime(DateUtility.parse(new DateThisUtils().today()));
            }
        }
        if (StringUtils.isBlank(parkingVo.getMallId())||"0".equals(parkingVo.getMallId())){
            parkingVo.setMallId(null);
        }
        if (StringUtils.isBlank(parkingVo.getKtId())){
            parkingVo.setKtId(null);
        }
        if (StringUtils.isBlank(parkingVo.getPlateNo())){
            parkingVo.setPlateNo(null);
        }
        return parkingVo;
    }

    /**
     * 数据校验wifi
     * @param indexWifiVo
     * @return
     */
    private DataBoxIndexWifiVo checkDataBoxWifi(DataBoxIndexWifiVo indexWifiVo) {
        if (StringUtils.isNotBlank(indexWifiVo.getCheckTime())&&!"all".equals(indexWifiVo.getCheckTime())){
            if ("年".equals(indexWifiVo.getCheckTime())){
                indexWifiVo.setStartTime(DateUtility.parse(new DateThisUtils().thisYear()));
            }else if ("月".equals(indexWifiVo.getCheckTime())){
                indexWifiVo.setStartTime(DateUtility.parse(new DateThisUtils().thisMonth()));
            }else if ("日".equals(indexWifiVo.getCheckTime())){
                indexWifiVo.setStartTime(DateUtility.parse(new DateThisUtils().today()));
            }
        }
        if (StringUtils.isBlank(indexWifiVo.getShopName())){
            indexWifiVo.setShopName(null);
        }
        if (StringUtils.isBlank(indexWifiVo.getMobile())){
            indexWifiVo.setMobile(null);
        }
        if (indexWifiVo.getMallId()!=null&&indexWifiVo.getMallId()==0){
            indexWifiVo.setMallId(null);
        }
        return indexWifiVo;
    }

    /**
     * 数据校验pos
     * @param dataBoxIndexVo
     * @return
     */
    public DataBoxIndexVo checkDataBoxIndex(DataBoxIndexVo dataBoxIndexVo){
        if (StringUtils.isNotBlank(dataBoxIndexVo.getCheckTime())&&!"all".equals(dataBoxIndexVo.getCheckTime())){
            if ("年".equals(dataBoxIndexVo.getCheckTime())){
                dataBoxIndexVo.setStartTime(DateUtility.parse(new DateThisUtils().thisYear()));
            }else if ("月".equals(dataBoxIndexVo.getCheckTime())){
                dataBoxIndexVo.setStartTime(DateUtility.parse(new DateThisUtils().thisMonth()));
            }else if ("日".equals(dataBoxIndexVo.getCheckTime())){
                dataBoxIndexVo.setStartTime(DateUtility.parse(new DateThisUtils().today()));
            }
        }

        if (StringUtils.isEmpty(dataBoxIndexVo.getMerchantname())){
            dataBoxIndexVo.setMerchantname(null);
        }
        if (dataBoxIndexVo.getMallId()!=null&&dataBoxIndexVo.getMallId()==0){
            dataBoxIndexVo.setMallId(null);
        }
        return dataBoxIndexVo;
    }
    
    @InitBinder  
    //此处的参数也可以是ServletRequestDataBinder类型  
    public void initBinder(WebDataBinder binder) throws Exception {  
        //注册自定义的属性编辑器  
        //1、日期  Dat
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);  
        //表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换  
        binder.registerCustomEditor(Date.class, dateEditor);      
        //自定义的电话号码编辑器(和【4.16.1、数据类型转换】一样)  
        
    }
}
