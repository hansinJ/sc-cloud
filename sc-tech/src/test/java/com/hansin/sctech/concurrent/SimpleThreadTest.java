package com.hansin.sctech.concurrent;

import com.hansin.sctech.ScTechApplication;
import com.hansin.sctech.concurrent.thread.SimpleThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Date 18:11 2021/1/15
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ScTechApplication.class)
public class SimpleThreadTest {

    @Test
    public void simple() {
        for (int i = 0; i < 10; i++) {
            SimpleThread simpleThread = new SimpleThread();
            simpleThread.start();
        }
    }
}
