package com.powerlong.controller;

import com.alibaba.fastjson.JSON;
import com.powerlong.support.websocket.InboundContainer;
import com.powerlong.vo.SplusStreamNewVo;
import org.apache.catalina.websocket.MessageInbound;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by z8242_000 on 2015/6/7.
 */
@Controller
@RequestMapping("/notification")
public class NotificationController {
    /*@RequestMapping
    public void execute(@RequestParam("msg_type") final String msg_type, @RequestParam("is_all") boolean is_all, @RequestParam("session") String session) {
        if (is_all) {
            InboundContainer.eachInbound(new InboundContainer.Callback() {
                public void execute(String session, MessageInbound inbound) {
                    InboundContainer.writeTextMessage(session, "{msg_type:" + msg_type + "}");
                }
            });
        } else {
            InboundContainer.writeTextMessage(session, "{msg_type:" + msg_type + "}");
        }
    }*/
    @RequestMapping
    public void execute(@RequestParam("msgType") final String msgType, @RequestParam("content") final String content, @RequestParam("img") final String img) {
            InboundContainer.eachInbound(new InboundContainer.Callback() {
                public void execute(String session, MessageInbound inbound) {

                    SplusStreamNewVo splusStreamNewVo = new SplusStreamNewVo();
                    try {
                        splusStreamNewVo.setContent(URLDecoder.decode(content, "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    splusStreamNewVo.setImg(img);
                    splusStreamNewVo.setMsgType(msgType);
                    InboundContainer.writeTextMessage(session, JSON.toJSONString(splusStreamNewVo));
                }
            });
    }
}
