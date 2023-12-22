package com.haiyen.rehap.service;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/server1")
class MessageService {
    @OnOpen
    public void handleOpen() {
        System.out.println("Client is now connected!");
    }

    @OnMessage
    public String handleMessage(String message) {
        System.out.println("Receive from client: " + message);
        String responseMessage = "Echo " + message;
        System.out.println("Send to client: " + responseMessage);
        return responseMessage;
    }

    @OnClose
    public void handleClose() {
        System.out.println("Client is now disconnected!");
    }

    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }
}