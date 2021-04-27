package com.hansin.sctech.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date 16:16 2021/1/14
 **/
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        amqpTemplate.convertAndSend("topic","topic.personal","topic.personal");
    }

    public void send1(){
        amqpTemplate.convertAndSend("topic","topic.man","topic.man");
    }

    public void send2(){
        amqpTemplate.convertAndSend("topic","topic.111","topic.1");
    }
}
