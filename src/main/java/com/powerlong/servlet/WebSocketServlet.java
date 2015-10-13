package com.powerlong.servlet;

import com.powerlong.support.websocket.InboundContainer;
import org.apache.catalina.Session;
import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WsOutbound;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by z8242_000 on 2015/6/7.
 */
public class WebSocketServlet extends org.apache.catalina.websocket.WebSocketServlet {


    @Override
    protected StreamInbound createWebSocketInbound(String subProtocol, HttpServletRequest request) {
        final HttpSession session = request.getSession();
        return new MessageInbound() {
            @Override
            protected void onOpen(WsOutbound outbound) {
                // 添加链接到容器
                InboundContainer.addInbound(session.getId(), this);
            }

            @Override
            protected void onBinaryMessage(ByteBuffer message) throws IOException {
            }

            @Override
            protected void onTextMessage(CharBuffer message) throws IOException {

            }

            @Override
            protected void onClose(int status) {
                InboundContainer.removeInbound(session.getId());
            }
        };
    }
}
