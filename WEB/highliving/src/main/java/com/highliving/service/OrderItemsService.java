package com.highliving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highliving.dao.OrderItemsMapper;
import com.highliving.pojo.OrderItems;
@Service
public class OrderItemsService{
	@Autowired
	private OrderItemsMapper orderItemsMapper;
	public int deleteOrderItem(Integer orderitemid) {
		return orderItemsMapper.deleteByPrimaryKey(orderitemid);
	}

	public int insertOrderItem(OrderItems record) {
		return orderItemsMapper.insert(record);
	}

	public int insertOrderItemSelective(OrderItems record) {
		return insertOrderItemSelective(record);
	}

	public OrderItems selectOrderItem(Integer orderitemid) {
		return orderItemsMapper.selectByPrimaryKey(orderitemid);
	}

	public int updateOrderItemSelective(OrderItems record) {
		return orderItemsMapper.updateByPrimaryKeySelective(record);
	}

	public int updateOrderItem(OrderItems record) {
		return orderItemsMapper.updateByPrimaryKey(record);
	}
	
	public List<OrderItems> findItemsByOrderId(Integer orderid) {
		return orderItemsMapper.findItemsByOrderId(orderid);
	}
	
	public OrderItems findOrderItem(String goodid) {
		return orderItemsMapper.findItemsByGoodId(goodid);
	}

}
