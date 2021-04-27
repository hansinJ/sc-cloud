package com.hansin.test;

import org.junit.Test;
import org.springframework.data.redis.core.BoundListOperations;

/**
 * @Date 15:35 2020/11/23
 **/
public class RedisTest extends BaseTest {
    public static final String STR = "str";
    public static final String LIST = "list";
    public static final String SET = "set";
    public static final String ZSET = "zset";
    public static final String HASH = "hash";

    @Test
    public void addStr() {
        stringRedisTemplate.boundValueOps(STR).set("hello world");
    }

    @Test
    public void getStr() {
        String str = stringRedisTemplate.boundValueOps(STR).get();
        System.out.println("str = " + str);
    }

    @Test
    public void setStr() {
        stringRedisTemplate.boundValueOps(STR).set("hello");
    }

    @Test
    public void delStr() {
        stringRedisTemplate.delete(STR);
    }

    @Test
    public void addList() {
        BoundListOperations<String, String> listOperations = stringRedisTemplate.boundListOps(LIST);
        listOperations.leftPush("hello");
        listOperations.leftPush("world");
        listOperations.set(0, "1");
    }
}
