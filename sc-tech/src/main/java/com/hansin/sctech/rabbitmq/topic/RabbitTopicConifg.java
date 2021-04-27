package com.hansin.sctech.rabbitmq.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Date 15:50 2021/1/14
 **/
@Configuration
public class RabbitTopicConifg {

    @Bean
    public Queue messageQueue() {
        return new Queue("topic.personal");
    }

    @Bean
    public Queue msgQueue() {
        return new Queue("topic.man");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic");
    }

    /**
     * @description 绑定能匹配routing-key(topic.personal)的队列到交换机
     **/
    @Bean
    public Binding bindExchangeMessage(Queue messageQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(messageQueue).to(topicExchange).with("topic.personal");
    }

    /**
     * @description 绑定能匹配 routing-key(topic.#) 的队列到交换机
     **/
    @Bean
    public Binding bindExchangeMsg(Queue msgQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(msgQueue).to(topicExchange).with("topic.#");
    }
}
