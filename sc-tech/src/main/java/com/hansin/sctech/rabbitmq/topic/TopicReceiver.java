package com.hansin.sctech.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Date 16:17 2021/1/14
 **/
@Component
@RabbitListener(queues = "topic.personal")
public class TopicReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("topic.personal receive = " + msg);
    }

}
