package com.powerlong.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.plocc.kafka.consumer.MsgHandler;
import com.plocc.kafka.model.PosReceiptMsg;
import com.plocc.kafka.model.PosTxnMsg;
import com.plocc.kafka.model.QrcodeScanOrderMsg;
import com.plocc.kafka.support.Topic;
import com.plocc.kafka.support.TopicHelper;
import com.powerlong.common.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by wgq on 2015/09/29.
 */
public class PosReceiptMsgHandler implements MsgHandler<QrcodeScanOrderMsg> {

    private static final Logger logger = Logger.getLogger(PosReceiptMsgHandler.class);


    @Override
    public Topic getTopic() {
        return TopicHelper.QRCODE_SCAN_ORDER;
    }

    @Override
    public void execute(QrcodeScanOrderMsg qrcodeScanOrderMsg) {

        logger.info("收到的收银数据：" + "设备号***" + qrcodeScanOrderMsg.getDeviceId() + "单号***" + qrcodeScanOrderMsg.getOrderNo() + "支付金额***" + qrcodeScanOrderMsg.getAmount());

        JSONObject json = new JSONObject();

        String mobiel = qrcodeScanOrderMsg.getMobile();

        if(StringUtils.isNotEmpty(mobiel)){
            json.put("mobile",mobiel);
        }else{
            json.put("mobile","13472661648");
        }

        json.put("receiptnum", qrcodeScanOrderMsg.getOrderNo());
        json.put("totalamount",qrcodeScanOrderMsg.getAmount());
        json.put("userName","欣姐");
        json.put("mallName","悦商实验室");
        json.put("mallId", "1");
        json.put("birthday","1982-11-11");
        json.put("sex","0");
        json.put("ide","3123456789xxxxxxxx");
        json.put("email","abc@163.com");
        json.put("address","闵行区万源路2158号");
        json.put("mlevel","v8");
        json.put("memberNo","7788");


        try {
            String url ="http://localhost:8081/smdaqp/app/scanNum.do?data="+URLEncoder.encode(json.toString(), "utf-8")+"";
            httpGet(url);

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }


    }




    /**
     * 发送get请求
     *
     * @param url
     *            路径
     * @return
     */
    public static JSONObject httpGet(String url) {
        // get请求返回结果
        JSONObject jsonResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();

            // 发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /** 请求发送成功，并得到响应 **/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /** 读取服务器返回过来的json字符串数据 **/
                String strResult = EntityUtils.toString(response.getEntity());
                /** 把json字符串转换成json对象 **/
                // jsonResult = JSONObject.fromObject(strResult);
                jsonResult = JSON.parseObject(strResult);
                System.out.println("#############" + jsonResult);
                logger.info(jsonResult);
                url = URLDecoder.decode(url, "UTF-8");
                logger.info(url);
            } else {
                url = URLDecoder.decode(url, "UTF-8");
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        }
        return jsonResult;
    }


}
