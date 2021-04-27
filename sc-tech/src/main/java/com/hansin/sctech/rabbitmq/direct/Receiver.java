package com.hansin.sctech.rabbitmq.direct;

import com.hansin.sctech.RabbitConst;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Date 10:49 2021/1/14
 **/
@Component
@RabbitListener(queues = RabbitConst.Q_U)
public class Receiver {

    @RabbitHandler
    public void receive(String msg){
        System.out.println("receive msg = " + msg);
    }
}
