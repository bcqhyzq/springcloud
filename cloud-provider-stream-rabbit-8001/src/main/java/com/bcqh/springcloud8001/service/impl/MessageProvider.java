package com.bcqh.springcloud8001.service.impl;

import com.bcqh.springcloud8001.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Description:定义消息的推送管道
 *
 * @author yzq
 * @date 2020/6/30
 */
@EnableBinding(Source.class)
public class MessageProvider implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        return null;
    }
}
