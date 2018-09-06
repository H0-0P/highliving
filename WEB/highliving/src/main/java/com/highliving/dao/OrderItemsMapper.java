package com.highliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.highliving.pojo.OrderItems;
@Repository
public interface OrderItemsMapper {
    int deleteByPrimaryKey(Integer orderitemid);

    int insert(OrderItems record);

    int insertSelective(OrderItems record);

    OrderItems selectByPrimaryKey(Integer orderitemid);

    int updateByPrimaryKeySelective(OrderItems record);

    int updateByPrimaryKey(OrderItems record);
    
    List<OrderItems> findItemsByOrderId(Integer orderid);
    
    OrderItems findItemsByGoodId(String goodid);
}