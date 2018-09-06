package com.highliving.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.highliving.pojo.Address;
import com.highliving.pojo.Orders;
import com.highliving.pojo.UserInfo;
import com.highliving.service.AddressService;
import com.highliving.service.OrdersService;

@RequestMapping("/order")
@RestController
public class OrderController {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private AddressService addressService;
	@RequestMapping(value="/getorder",method=RequestMethod.GET)
	public Orders findOrder(@RequestParam Integer orderid){
		Orders order = ordersService.findItemByOrderId(orderid);
		Address address =  addressService.findDefaultAddress(order.getAddressid());
		order.setAddress(address);
		System.out.println(order.toString());
		//System.out.println(address.toString());
		return order;
	}
	
	/**
	 * 根据用户和订单状态查订单
	 */
	@RequestMapping(value="/getAllOrder",method=RequestMethod.GET)
	public List<Orders> findOrderByUserId(HttpServletRequest request) {
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
		return ordersService.findByUserId(user.getUserid());
	}
	
	@RequestMapping(value="/getUserOrder/{userId}",method=RequestMethod.GET)
	public PageInfo<Orders> findAllOrder(@PathVariable("userId") Integer userId,Integer pageNum, Integer pageSize){
		return ordersService.PagefindByUserId(userId, pageNum, pageSize);
	}

}
