package com.hansin.sctech.rabbitmq.direct;

import com.hansin.sctech.RabbitConst;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date 10:28 2021/1/14 消息生产者s
 **/
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * @description 发送消息至hello队列
     **/
    public void sender(String msg) {
        amqpTemplate.convertAndSend(RabbitConst.Q_U, "say");
    }

}
