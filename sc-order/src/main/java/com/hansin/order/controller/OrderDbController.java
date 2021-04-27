package com.hansin.order.controller;

import com.google.gson.Gson;
import com.hansin.order.service.OrderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Hans
 * @Date 16:07 2020/4/22
 **/
@RestController
@RequestMapping("v1/order")
public class OrderDbController {
    @Autowired
    private OrderDbService orderDbService;

    /**
     * 订单列表
     * @description
     * @param
     * @return
     **/
    @GetMapping("list")
    public String getList() {
        return new Gson().toJson(orderDbService.getList());
    }

}
