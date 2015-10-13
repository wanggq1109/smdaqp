package com.powerlong.support.websocket;

import org.apache.catalina.websocket.MessageInbound;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by z8242_000 on 2015/6/7.
 * 会话管理、关系
 */
public class InboundContainer {
    private static Map<String, MessageInbound> mappings = new HashMap<String, MessageInbound>();

    public static void addInbound(String session, MessageInbound messageInbound) {
        mappings.put(session, messageInbound);
        System.out.println(session + ":" + messageInbound + "，" + mappings.size());
    }

    public static MessageInbound removeInbound(String session) {
        return mappings.remove(session);
    }

    public static MessageInbound getInbound(String session) {
        return mappings.get(session);
    }

    public static void eachInbound(Callback callback) {
        for (Map.Entry<String, MessageInbound> entry : mappings.entrySet()) {
            callback.execute(entry.getKey(), entry.getValue());
        }
    }

    public interface Callback {
        public void execute(String session, MessageInbound inbound);
    }

    public static void writeTextMessage(String session, String message) {
        try {
            MessageInbound inbound = getInbound(session);
            if (null != inbound) {
                inbound.getWsOutbound().writeTextMessage(CharBuffer.wrap(message));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Set<String> getSessionList() {
        return mappings.keySet();
    }
}
