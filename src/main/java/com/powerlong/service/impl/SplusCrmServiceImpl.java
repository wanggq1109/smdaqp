package com.powerlong.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.plocc.kafka.KafkaLocator;
import com.plocc.kafka.model.ParkingEnterMsg;
import com.plocc.kafka.producter.MsgSender;
import com.plocc.kafka.support.TopicHelper;
import com.powerlong.common.DateUtility;
import com.powerlong.common.Paginator;
import com.powerlong.common.StringUtils;
import com.powerlong.mapper.*;
import com.powerlong.model.*;
import com.powerlong.service.SplusCrmService;
import com.powerlong.support.websocket.InboundContainer;
import com.powerlong.vo.DataBoxIndexParkingVo;
import com.powerlong.vo.DataBoxIndexVo;
import com.powerlong.vo.SplusStreamNewVo;
import com.powerlong.vo.SplusStreamVo;
import com.powerlong.webService.client.WebServiceForPay;
import com.powerlong.webService.client.WebServiceForPaySoap;
import org.apache.catalina.websocket.MessageInbound;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Angus on 2015/5/30.
 */
@Service("splusCrmService")
public class SplusCrmServiceImpl implements SplusCrmService {

    private static final Logger logger = Logger.getLogger(SplusCrmServiceImpl.class);
    @Resource
    private SplusIndexMapper splusIndexMapper;
    @Resource
    private WifiMaxGustMapper wifiMaxGustMapper;
    @Resource
    private ParkingDetailMapper parkingDetailMapper;
    @Resource
    private TrafficMallMapper trafficMallMapper;
    @Resource
    private ScreenvideoMapper screenvideoMapper;
    @Resource
    private AuthMallMapper authMallMapper;
    @Resource
    private ReceiptMapper receiptMapper;
    @Resource
    private IbeanconLogMapper ibeanconLogMapper;
    @Resource
    private IbeanconInfoMapper ibeanconInfoMapper;
    @Resource
    private DataboxUserMapper databoxUserMapper;


    private static MsgSender<ParkingEnterMsg> wechatSender = KafkaLocator.buildSender(TopicHelper.PARKING_ENTER_WECHAT);

    private static final String delimiter = "#";
    /**
     * 获取crm+首页pos数据
     * @param paginator
     * @return
     */
    @Override
    public Paginator getSplusIndexData(Paginator paginator){
        try {
            paginator.setResults(splusIndexMapper.selectSplusIndexData(paginator));
            Long count =splusIndexMapper.selectSplusIndexDataCount(paginator);
            if (count!=null&&count>0){
                paginator.setItems(Integer.parseInt(count.toString()));
            }
            return paginator;
        }catch (Exception e){
            logger.error("getSplusIndexData查询出错！",e);
        }
        return null;
    }
    /**
     * 获取crm+首页wifi数据
     * @param paginator
     * @return
     */
    @Override
    public Paginator getSplusWifiData(Paginator paginator){
        try {
            paginator.setResults(wifiMaxGustMapper.selectSplusWifiData(paginator));
            Long count =wifiMaxGustMapper.selectSplusWifiDataCount(paginator);
            if (count!=null&&count>0){
                paginator.setItems(Integer.parseInt(count.toString()));
            }
            return paginator;
        }catch (Exception e){
            logger.error("getSplusWifiData！查询失败",e);
        }
        return null;
    }

    /**
     * 获取crm+首页 停车场记录
     * @param page
     * @return
     */
    @Override
    public Paginator getSplusParkingData(Paginator page) {
        try {
            page.setResults(parkingDetailMapper.selectSplusParingData(page));
            Long count =parkingDetailMapper.selectSplusParingDataCount(page);
            if (count!=null&&count>0){
                page.setItems(Integer.parseInt(count.toString()));
            }
            return page;
        }catch (Exception e){
            logger.error("getSplusParkingData查询失败！",e);
        }
        return null;
    }

    @Override
    public Paginator getSplusPassengerData(Paginator page) {
        try {
            page.setResults(trafficMallMapper.selectSplusPassengerData(page));
            Long count =trafficMallMapper.selectSplusPassengerDataCount(page);
            if (count!=null&&count>0){
                page.setItems(Integer.parseInt(count.toString()));
            }
            return page;
        }catch (Exception e){
            logger.error("getSplusPassengerData！查询失败",e);
        }

        return null;
    }

    @Override
    public Paginator getSplusScreenVoData(Paginator page) {
        try {
            page.setResults(screenvideoMapper.selectSplusrScreenData(page));
            Long count =screenvideoMapper.selectSplusScreenDataCount(page);
            if (count!=null&&count>0){
                page.setItems(Integer.parseInt(count.toString()));
            }
            return page;
        }catch (Exception e){
            logger.error("getSplusScreenVoData！查询失败",e);
        }
        return null;
    }

    @Override
    public List<AuthMall> getAuthMallList() {
        return authMallMapper.selectAuthMallList();
    }

    /**
     * 获取跳动显示屏所需数据
     * @return
     */
    @Override
    public Map getSplusInfoStream() {
        Map map = new HashMap();
        map.put("data1", getPostStream());
        map.put("data2", getWifiStream());
        map.put("data3", getParkingStream());
        map.put("data4", getIbconStream());
        map.put("data5", getScreenStream());
        map.put("data6", getUserStream());
        return map;
    }

    /**
     *从webservice接口获取车辆数据
     */
    @Override
    public void getWebServiceParking()  {
        WebServiceForPay webServiceFrPay = new WebServiceForPay();
        WebServiceForPaySoap webs =webServiceFrPay.getWebServiceForPaySoap();
        List<String> parkNo = new ArrayList<String>();
        parkNo.add("BK3F19");
        parkNo.add("Y06018");
        parkNo.add("B885E8");
        for (int i = 0; i <parkNo.size() ; i++) {
            String data =webs.getFuzzyCarInfo(parkNo.get(i),1,10);
            if (StringUtils.isNotBlank(data)){
                JSONObject dataJson=new JSONObject();
                JSONObject jsonObject = JSONObject.parseObject(data);
                //获取相应代码
                String resCode =jsonObject.getString("resCode");
                //判断返回状态
                if ("0".equals(resCode)){
                            JSONArray parkings=jsonObject.getJSONArray("data");
                            for (int j = 0; j <parkings.size() ; j++) {

                                ParkingDetail parkingDetail=getParkingDetail(parkings.getJSONObject(j));
                                if (StringUtils.isNotBlank(parkingDetail.getPlateNo())){
                                    ParkingDetail pa =parkingDetailMapper.selectByKtId(parkingDetail.getKtId());
                                    if (pa ==null){
                                        int con =parkingDetailMapper.insertSelective(parkingDetail);
                                        if (con>0){
                                            SplusStreamVo splusStreamVo =getParkingStream();
                                            List<Map<String,String>> msgs =splusStreamVo.getMsg();
                                            if (msgs.size()>0){
                                                execute("3",msgs.get(0).get("content"),"");
                                            }
                                        }

                                    }
                                }

                            }
                }else {
                    //获取错误信息
                    String resMsg =jsonObject.getString("resMsg");
                    logger.error("getCarInOutInfoByVoucher---执行出错:" + resMsg);
                }
            }

        }
    }

    /**
     *插入车辆入场数据
     */
    @Override
    public void setWebServiceParking(ParkingDetail parkingDetail) throws Exception{
        try {
//                ParkingDetail pa = parkingDetailMapper.selectByKtId(parkingDetail.getKtId());
//                if (pa == null) {
            sendParkingInfo2kafka(parkingDetail);
            int con = parkingDetailMapper.insertSelective(parkingDetail);
            if (con > 0) {
                SplusStreamVo splusStreamVo = getParkingStream();
                List<Map<String, String>> msgs = splusStreamVo.getMsg();
                if (msgs.size() > 0) {
                    execute("3", msgs.get(0).get("content"), "");
                }
            }
//                }
        }catch (Exception e){
            logger.error("获取车辆入场信息出错",e);
        }
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
            parking.setEntryTime(DateUtility.parse("yyyy/MM/dd HH:mm:ss", j.getString("entryTime")));
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
    /**
     * 滚屏ibcon数据
     * @return
     */
    public SplusStreamVo getIbconStream(){
        SplusStreamVo stream = new SplusStreamVo();
        List<IbeanconLog> ibeanconLogs =ibeanconLogMapper.selectInfoStreamList();
        List list = new ArrayList();
        for (int i = 0; i <ibeanconLogs.size() ; i++) {
            Map icMap = new HashMap();
            IbeanconLog ibeanconLog =ibeanconLogs.get(i);
            IbeanconInfo ibeanconInfo = ibeanconInfoMapper.selectByPrimaryKey(ibeanconLog.getIbeaconid());
            String content = DateUtility.format(DateUtility.FORMAT_HH_MM, ibeanconLog.getCreadedDate()) + delimiter + ibeanconLog.getMobile() + delimiter + ibeanconInfo.getArea();
            icMap.put("content", content);
            list.add(icMap);
        }
        stream.setMsg(list);
        stream.setSubtitle("120");
        return stream;
    }
    /**
     * 滚屏用户数据
     * @return
     */
    public SplusStreamVo getUserStream(){
        SplusStreamVo stream = new SplusStreamVo();
        List<DataboxUser> databoxUsers =databoxUserMapper.selectInfoStreamList();
        List list = new ArrayList();
        for (int i = 0; i <databoxUsers.size() ; i++) {
            Map icMap = new HashMap();
            DataboxUser user =databoxUsers.get(i);
            if (StringUtils.isNotBlank(user.getMobile())){
                icMap.put("content", DateUtility.format(DateUtility.FORMAT_HH_MM, user.getCreatedDate()) +delimiter+user.getMobile());
            }
            list.add(icMap);
        }
        stream.setMsg(list);
        stream.setSubtitle("120");
        return stream;
    }
    /**
     * 滚屏导视频数据
     * @return
     */
    public SplusStreamVo getScreenStream(){
        SplusStreamVo stream = new SplusStreamVo();
        List<Screenvideo> ibeanconLogs =screenvideoMapper.selectInfoStreamList();
        List list = new ArrayList();
        for (int i = 0; i <ibeanconLogs.size() ; i++) {
            Map icMap = new HashMap();
            Screenvideo screenvideo =ibeanconLogs.get(i);
            if (StringUtils.isNotBlank(screenvideo.getClicktime())){
                String content = DateUtility.format(DateUtility.FORMAT_HH_MM, DateUtility.parse(screenvideo.getClicktime())) + delimiter;
                if ("1".equals(screenvideo.getTouchid())){
                    content += "门口:点击#";
                    icMap.put("content", content + screenvideo.getContent());

                } else if ("2".equals(screenvideo.getTouchid())){
                    content += "办公室:点击#";
                    icMap.put("content", content + screenvideo.getContent());
                }
            }
            list.add(icMap);
        }
        stream.setMsg(list);
        stream.setSubtitle("120");
        return stream;
    }
    /**
     * 获取滚动屏park数据
     * @return
     */
    @Override
    public SplusStreamVo getParkingStream(){
        SplusStreamVo stream = new SplusStreamVo();
        List<DataBoxIndexParkingVo> parkings =parkingDetailMapper.selectInfoStreamList();
        List list = new ArrayList();
        for (int i = 0; i <parkings.size() ; i++) {
            Map receiptMap = new HashMap();
            DataBoxIndexParkingVo parkingDetail =parkings.get(i);
            String content = DateUtility.format(DateUtility.FORMAT_HH_MM, parkingDetail.getEntryTime())+delimiter+parkingDetail.getPlateNo()+delimiter;
            if (parkingDetail.getCashTime()==null){
                if (StringUtils.isBlank(parkingDetail.getCrmUser())){
                    content += "入场";

                }else {
                    content += "["+parkingDetail.getCrmUser()+"]入场";
                }
            }else if (parkingDetail.getCashTime()!=null){
                String amount =parkingDetail.getPayable().divide(new BigDecimal(100)).toString();
                amount=amount.substring(0, amount.indexOf("."));
                if (StringUtils.isBlank(parkingDetail.getCrmUser())){
                    content += "出场  " +"车费"+amount+"元";
                }else {
                    content += "["+parkingDetail.getCrmUser()+"]"+"出场  " +"车费"+amount+"元";
                }
            }
            receiptMap.put("content",content);
            list.add(receiptMap);
        }
        stream.setMsg(list);
        stream.setSubtitle("110");
        return stream;
    }
    /**
     * 获取滚动屏pos数据
     * @return
     */
    @Override
    public SplusStreamVo getPostStream(){
        SplusStreamVo stream = new SplusStreamVo();
        List<DataBoxIndexVo> dataBoxIndex =splusIndexMapper.selectInfoStreamList();
        List list = new ArrayList();
        for (int i = 0; i <dataBoxIndex.size() ; i++) {
            Map receiptMap = new HashMap();
            DataBoxIndexVo box =dataBoxIndex.get(i);
            StringBuilder builder = new StringBuilder();
            builder.append(DateUtility.format(DateUtility.FORMAT_HH_MM, box.getTsdate())+delimiter);
            builder.append(box.getMobile()+delimiter);
            if(StringUtils.isNotBlank(box.getMallName())){
                builder.append(box.getMallName() + delimiter);
            }else{
                builder.append(delimiter);
            }
            builder.append(box.getTotalamount());
            receiptMap.put("content", builder.toString());
            receiptMap.put("img", "http://10.254.1.57:8081/databox" + box.getImageurl());
            list.add(receiptMap);
        }
        stream.setMsg(list);
        stream.setSubtitle("110");
        return stream;
    }

    /**
     * 获取滚动屏wifi数据
     * @return
     */
    public SplusStreamVo getWifiStream(){
        SplusStreamVo stream = new SplusStreamVo();
        List<WifiMaxGust> wfs =wifiMaxGustMapper.selectInfoStreamList();
        List list = new ArrayList();
        for (int i = 0; i <wfs.size() ; i++) {
            Map wifiMap = new HashMap();
            WifiMaxGust wf =wfs.get(i);

            wifiMap.put("content", DateUtility.format(DateUtility.FORMAT_HH_MM, wf.getLoginTime()) +delimiter+ wf.getAppType() + delimiter +wf.getMobile());
            list.add(wifiMap);
        }
        stream.setMsg(list);
        stream.setSubtitle("120");
        return stream;
    }

    /**
     * 推送到滚动屏的方法
     * @param msgType
     * @param content
     * @param img
     */
    @Override
    public void execute( final String msgType, final String content,  final String img) {
        InboundContainer.eachInbound(new InboundContainer.Callback() {
            public void execute(String session, MessageInbound inbound) {
                SplusStreamNewVo splusStreamNewVo = new SplusStreamNewVo();
                splusStreamNewVo.setContent(content);
                splusStreamNewVo.setImg(img);
                splusStreamNewVo.setMsgType(msgType);
                InboundContainer.writeTextMessage(session, JSON.toJSONString(splusStreamNewVo));
            }
        });
    }


    public void sendParkingInfo2kafka(ParkingDetail parkingDetail){

        try {
            List<Long> userList = new ArrayList<Long>();
            userList.add(297L);
            userList.add(406681L);
            userList.add(304L);
            userList.add(1289L);
            ParkingEnterMsg enterMsg = new ParkingEnterMsg();
            enterMsg.setMallName("曹路宝龙");
            enterMsg.setMallId("3");
            enterMsg.setPlateNo(parkingDetail.getPlateNo());
            enterMsg.setEntryTime(parkingDetail.getEntryTime());
            for(int i=0;i<userList.size();i++){
                enterMsg.setUserId(userList.get(i));
                logger.info("车场推送消息至kafka");
                wechatSender.sendMessage(enterMsg);
                logger.info("车场推送消息至kafka成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.info("车场推送消息至kafka" + e.getMessage());
        }


    }
}
