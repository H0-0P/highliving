package com.highliving.dao;

import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import com.highliving.pojo.Orders;
@Repository
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
    //根据userId查订单
    List<Orders> selectByUserId(Integer userid);
    //根据订单状态查订单
    List<Orders> selectByOrderState(Integer orderstate);
    //
    Orders selectItemsByOrderId(Integer orderid);
    
    List<Orders> selectOrderByUserIdAndState(Integer userid, Integer orderstate);
}