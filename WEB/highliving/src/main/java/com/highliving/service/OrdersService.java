package com.highliving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.highliving.dao.OrdersMapper;
import com.highliving.pojo.Orders;
@Service
public class OrdersService{
	@Autowired
	private OrdersMapper ordersMapper;
	public int deleteOrders(Integer orderid) {
		return ordersMapper.deleteByPrimaryKey(orderid);
	}

	public int insertOrders(Orders record) {
		return ordersMapper.insert(record);
	}

	public int insertOrdersSelective(Orders record) {
		return ordersMapper.insertSelective(record);
	}

	public Orders selectOrders(Integer orderid) {
		return ordersMapper.selectByPrimaryKey(orderid);
	}

	public int updateOrdersSelective(Orders record) {
		return ordersMapper.updateByPrimaryKeySelective(record);
	}

	public int updateOrders(Orders record) {
		return ordersMapper.updateByPrimaryKey(record);
	}
	//
	public List<Orders> findByUserId(Integer userid) {
		return ordersMapper.selectByUserId(userid);
	}
	public List<Orders> findByOrderState(Integer orderstate){
		return ordersMapper.selectByOrderState(orderstate);
	}
	
	public Orders findItemByOrderId(Integer orderid) {
		return ordersMapper.selectItemsByOrderId(orderid);
	}
	
	public List<Orders> findOrderByUserIdAndState(Integer userid, Integer orderstate) {
		return ordersMapper.selectOrderByUserIdAndState(userid, orderstate);		
	}
	
	public PageInfo<Orders> PagefindByUserId(Integer userid, Integer currentPage, Integer size) {
		PageHelper.startPage(currentPage, size);
		List<Orders> list = ordersMapper.selectByUserId(userid);
		PageInfo<Orders> pageInfo = new PageInfo<>(list);
		System.err.println(pageInfo);
		return pageInfo;
	}

}
