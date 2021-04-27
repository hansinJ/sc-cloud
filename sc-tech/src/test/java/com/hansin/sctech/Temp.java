package com.hansin.sctech;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description
 * @Author Hans
 * @Date 17:48 2020/4/28
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ScTechApplication.class)
public class Temp {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    Gson gson = new Gson();

    @Test
    public void getSentinelCache() {
        System.out.println(gson.toJson(stringRedisTemplate.getConnectionFactory().getSentinelConnection().masters()));
        System.out.println(stringRedisTemplate.boundValueOps("name").get());
    }
}
