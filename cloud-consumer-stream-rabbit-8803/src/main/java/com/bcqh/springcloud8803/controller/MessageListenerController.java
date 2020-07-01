package com.bcqh.springcloud8803.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/7/1
 */
@Component
@EnableBinding(Sink.class)
public class MessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者 1：" +message.getPayload() + "\t port：" +serverPort);
    }
}
