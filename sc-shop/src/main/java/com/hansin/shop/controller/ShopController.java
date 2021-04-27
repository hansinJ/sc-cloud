package com.hansin.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Hans
 * @Date 13:45 2020/2/27
 **/
@RestController
@RequestMapping("v1/shop")
public class ShopController {

    @RequestMapping("info")
    public String shopInfo(){
        System.out.println("query-shop-info...........");
        return "query-shop-info...........";
    }
}
