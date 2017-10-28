package com.sep.michaelhochleitner.SimpleChatServer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class MyWebSocketConfigurer implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        WebSocketHandler handler = new MySocketHandler();
        registry.addHandler(handler, "/chat").addInterceptors(new HttpSessionHandshakeInterceptor());
    }
}
