package com.hansin.order.service;

import com.hansin.order.iservice.IscOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author Hans
 * @Date 13:21 2020/2/27
 **/
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ScOrderService implements IscOrderService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String SC_SHOP = "sc-shop";
    @Autowired
    private RestTemplate restTemplate;

    /**
     * @description order项目启动时会从注册中心拉取服务列表（ip+端口+项目别名）缓存在本地
     * 服务调用时根据负载均衡的策略(常用策略:随机，轮询，权重，最少连接)来选择具体调用的服务
     **/
    @Override
    public String queryOrder() {
        String forObject = restTemplate.getForObject ("http://"+SC_SHOP+"/v1/shop/info", String.class);
        return forObject;
    }

    /**
     * @description 秒杀系统由于并发大可能引起服务雪崩，需要用hystrix做服务隔离，限制秒杀接口只能使用固定的连接资源
     * 原理:请求先到hystrix，由hystrix决定请求是否到达接收请求的接口
     * 隔离策略两种:
     * 1.THREAD hystrix连接池，默认策略
     *      连接池默认是10个连接资源，占用内存，请求快
     * 2.SEMAPHORE信号量
     *      全局计数器，类似automicInteger,使用轻量锁，非jvm锁，比第一种请求稍微慢一些
     * 服务降级: 如果并发请求大于设置的数量，这些失败的请求需要做服务降级，eg: 友好提示"服务器繁忙，请稍后再试"
     *
     * @note hystrixCommand的相关配置在hystrixCommandProperties类中
     */
    @HystrixCommand(fallbackMethod = "createOrderFall",
            commandKey = "createOrder",
            groupKey = "group-one",
            commandProperties = {
                //@HystrixProperty(name="execution.isolation.semaphore.maxConcurrentRequests",value = "100"),
                //@HystrixProperty(name="execution.isolation.strategy",value = "SEMAPHORE"),
                @HystrixProperty(name="execution.isolation.strategy",value = "THREAD"),
                @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
            },
            threadPoolKey = "createOrderPool",
            threadPoolProperties = {@HystrixProperty(name="coreSize",value = "10")}
    )
    @Override
    public String createOrder() {
        logger.info(Thread.currentThread().getName()+"=="+1);
        return "success";
    }

    /**
     * @description 服务降级的方法需要与原方法返回值类型保持一致
     **/
    public String createOrderFall(){
        return "系统繁忙，请稍后再试";
    }

    @HystrixCommand
    @Override
    public String error() {
        String forObject = null;
        try {
            forObject = restTemplate.getForObject ("http://"+SC_SHOP+"/v1/shop/info", String.class);
            int i = 1/0;
            return forObject;
        }catch (Exception e){
            throw  e;
        }
    }

}
