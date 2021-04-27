package com.hansin.order.controller;

import com.hansin.order.iservice.IscOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Hans
 * @Date 13:17 2020/2/27
 **/
@RestController
@RequestMapping("v1/order")
public class OrderController {
    @Autowired
    private IscOrderService iscOrderService;

    /**
     * @description rpc:下订单调shop项目的接口
     **/
    @GetMapping
    public String queryOrder(){
        return iscOrderService.queryOrder();
    }

    /**
     * @description 订单秒杀
     **/
    @PostMapping
    public String seckill(){
        return iscOrderService.createOrder();
    }

    /**
     * @description 模拟hystrix熔断场景
     * 一段时间内，用户请求到达n次，请求失败率达到一定比率，hystrix熔断将会开启
     * 熔断开启后，服务提供方接口将不能被调用；
     * 一段时间后，hystrix将会放一个用户请求尝试着去调用提供方接口
     * 如果调用成功则关闭熔断；失败则开启熔断功能
     * hystrix默认是5s内请求20次，失败调用达到50%则开启熔断功能
     * @note 本接口5s内请求达到20次，失败率会达到100%，之后再调用会一直失败，所以熔断会一直开启,
     * 但是接口返回的信息不再是定义的算数异常，而是error short-circuited and fallback failed.
     * 可以看出代理对象没有去调用提供方的接口，直接返回熔断信息
     */
    @PostMapping("error")
    public String error(){
        try {
            return iscOrderService.error();
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }

    }
}
