package com.hansin.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hansin.shop.ScShopApplication;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Hans
 * @Date 17:43 2020/5/25
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ScShopApplication.class)
public class BaseTest {
    public static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
//    public static Gson gson = new Gson();
    protected static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    @Autowired
    protected StringRedisTemplate stringRedisTemplate;
}
