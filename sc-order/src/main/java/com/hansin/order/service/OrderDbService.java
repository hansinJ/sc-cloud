package com.hansin.order.service;

import com.hansin.order.mapper.OrderMapper;
import com.hansin.order.model.Order;
import com.hansin.order.model.OrderCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Hans
 * @Date 16:07 2020/4/22
 **/
@Service
public class OrderDbService  {
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getList(){
        OrderCriteria orderCriteria = new OrderCriteria();
        return orderMapper.selectByExample(orderCriteria);
    }

}
