package com.example.demo.service;

import com.example.demo.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

//@Service
public class WebSocketService {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    public void sendMessage() throws Exception{
        for(int i=0;i<10;i++)
        {
            Thread.sleep(1000);
            simpMessagingTemplate.convertAndSend("/topic/getResponse",new Response("Welcome!"+i));
            System.out.println("----------------------"+i);
        }
    }
}
