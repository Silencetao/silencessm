package com.silencetao.webscoket.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Websocket处理类
 * @author Silence
 * create time 2017年8月5日 下午12:01:33
 * @version 1.0.1
 */
public class WebsocketEndPoint extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        TextMessage returnMessage = new TextMessage(message.getPayload() + "received at server");
        session.sendMessage(returnMessage);
    }
}
