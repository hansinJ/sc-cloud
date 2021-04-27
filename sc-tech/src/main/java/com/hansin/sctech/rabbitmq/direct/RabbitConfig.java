package com.hansin.sctech.rabbitmq.direct;

import com.hansin.sctech.RabbitConst;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 10:05 2021/1/14
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue(RabbitConst.Q_U);
    }
}
