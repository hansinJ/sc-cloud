package com.hansin.sctech;

import com.hansin.sctech.rabbitmq.direct.Sender;
import com.hansin.sctech.rabbitmq.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 11:01 2021/1/14
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ScTechApplication.class)
public class RabbitTest {
    @Autowired
    private Sender sender;

    @Test
    public void msgPass(){
        sender.sender("strong and stronger");
    }


    @Autowired
    private TopicSender topicSender;

    @Test
    public void topicTest(){
        topicSender.send();
        topicSender.send1();
        topicSender.send2();
    }
}
