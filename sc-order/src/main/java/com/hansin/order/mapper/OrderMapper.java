package com.hansin.order.mapper;

import com.hansin.order.model.Order;
import com.hansin.order.model.OrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OrderMapper {
    int countByExample(OrderCriteria example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExampleWithRowbounds(OrderCriteria example, RowBounds rowBounds);

    List<Order> selectByExample(OrderCriteria example);

    Order selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderCriteria example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderCriteria example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}