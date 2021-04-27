package com.hansin.sctech.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Date 16:37 2021/1/14
 **/
@Component
@RabbitListener(queues = "topic.man")
public class TopicReceiverCopy {

    @RabbitHandler
    public void process(String msg){
        System.out.println("topic.man receive = " + msg);
    }
}
