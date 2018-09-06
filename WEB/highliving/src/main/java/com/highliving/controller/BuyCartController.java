package com.highliving.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.highliving.pojo.Address;
import com.highliving.pojo.Goods;
import com.highliving.pojo.ItemParams;
import com.highliving.pojo.OrderItems;
import com.highliving.pojo.Orders;
import com.highliving.pojo.Result;
import com.highliving.pojo.UserInfo;
import com.highliving.service.AddressService;
import com.highliving.service.GoodsService;
import com.highliving.service.ItemParamsService;
import com.highliving.service.OrderItemsService;
import com.highliving.service.OrdersService;

@RestController
@RequestMapping("/car")
public class BuyCartController {
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private OrderItemsService orderItemsService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ItemParamsService itemParamsService;
	
	/**
	 * 加入购物车
	 * 参数传入为商品id和用户选择数量
	 * 1、登录后才可以加购物车
	 * 2、数据直接插入进订单项，订单外键为空
	 * 
	 * 首先获取该用户的购物车列表，判断购物车里面是否存在该商品，如果存在该商品，直接goodnum+num
	 * 否则新增一条订单Item纪录
	 * 
	 * 订单状态
	 * 0表示购物车
	 * 1待付款
	 * 2已付款，待收货
	 * 3已完成
	 * 4取消
	 */
	
    @RequestMapping("/addToCar")
    public Result addCart(@RequestParam String goodid, @RequestParam(defaultValue = "1") Integer num, @RequestParam String params,HttpServletRequest request, HttpServletResponse response) {
    	System.out.println(params);
    	// 获取商品列表 - 根据userId和订单状态查询 对应的所有订单项
    	ItemParams itemParams = new ItemParams();
    	UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
    	Integer userid = user.getUserid();
//    	Integer userid = 6;
    	List<Orders> orders = ordersService.findOrderByUserIdAndState(userid, 0);
    	Goods good = goodsService.findGoodByGoodId(goodid);
    	Integer orderid;
    	Orders order = null; //购物车订单
    	if(orders.size() == 0) {//该用户没有购物车信息
    		//新建一个order并insert orders
    		Orders o = new Orders();
    		o.setUserid(userid);
    		o.setAddressid(1);
    		o.setOrdersum(new BigDecimal(0));
    		o.setOrderstate(0);
    		o.setOrdercreatedate(new Date());
    		ordersService.insertOrders(o);
    		order = ordersService.findOrderByUserIdAndState(userid, 0).get(0);
    	} else {
    		order = orders.get(0);
    	}
		// 该用户有购物车信息（查购物车信息）
		orderid = order.getOrderid();
		// 获得购物车列表
		List<OrderItems> itemList = orderItemsService.findItemsByOrderId(orderid);
		boolean flag = false; // 判断商品是否在购物车
		for (OrderItems i : itemList) {
			if (i.getGoodid().equals(goodid)) {// 在
				//判断该商品的订单项存在后，根据itemid和parame在itemparam中查该商品参数是否存在，若不存在
				//建立新的订单项和itemparam
				ItemParams itemParams2 = itemParamsService.findByIdAndParams(i.getOrderitemid(), params);
				//System.out.println(itemParams2);
				if (itemParams2 == null) {
					OrderItems oItems = new OrderItems();
					oItems.setGoodid(goodid);
					oItems.setOrderid(orderid);
					oItems.setGoodnum(num);
					oItems.setOrderitemsum(good.getGoodprice().multiply(new BigDecimal(num)));
					orderItemsService.insertOrderItem(oItems);
					//System.out.println(oItems.getOrderitemid());
					
					//OrderItems items = orderItemsService.findOrderItem(goodid);
					itemParams.setItemid(oItems.getOrderitemid());
					itemParams.setItemparams(params);
//					System.out.println(oItems.getOrderitemid());
					itemParamsService.inser(itemParams);
				}else {
					/*itemParams = itemParamsService.findParam(i.getOrderitemid());
					itemParams.setItemid(i.getOrderitemid());
					itemParams.setItemparams(params);
					itemParamsService.updataParam(itemParams);*/
					// 更改该item的数量
					i.setGoodnum(i.getGoodnum() + num);
					i.setOrderitemsum(i.getOrderitemsum().add(good.getGoodprice().multiply(new BigDecimal(num))));
					orderItemsService.updateOrderItemSelective(i);
				}
//				System.out.println(i.getOrderitemid());
				flag = true;
				break;
			}
		}
		
		if (!flag) {// 不在
			// 新建orderItem并insert orderItems
			OrderItems oItems = new OrderItems();
			oItems.setGoodid(goodid);
			oItems.setOrderid(orderid);
			oItems.setGoodnum(num);
			oItems.setOrderitemsum(good.getGoodprice().multiply(new BigDecimal(num)));
			orderItemsService.insertOrderItem(oItems);
			
			//OrderItems items = orderItemsService.findOrderItem(goodid);
			itemParams.setItemid(oItems.getOrderitemid());
			itemParams.setItemparams(params);
			//System.out.println(items.getOrderitemid());
			itemParamsService.inser(itemParams);
		}
    
    	//更新order
    	order.setOrdersum(order.getOrdersum().add(good.getGoodprice().multiply(new BigDecimal(num))));
    	ordersService.updateOrders(order);
    	return new Result(1, "添加成功");
    }
    
    /*
     * 查看购物车
     * 返回Result对象
     */
    @RequestMapping("/showCar")
    public Result showCar(HttpServletRequest request) {
    	UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
    	Integer userid = user.getUserid();
//    	Integer userid = 6;
		//查订单编号
    	List<Orders> orders = ordersService.findOrderByUserIdAndState(userid, 0);
    	if(orders.size() == 0 || orders == null) {
    		return new Result(0, "购物车里面没有商品");
    	}
    	
    	Orders order = orders.get(0);
    	//System.out.println(order);
    	if(order == null || order.getOrderid() == null) {
    		return new Result(1, "查询成功，购物车没有商品");
    	} else {
    		//List<OrderItems> itemList = orderItemsService.findItemsByOrderId(order.getOrderid());
    		List<OrderItems> itemList = ordersService.findItemByOrderId(order.getOrderid()).getOrderItems();
    		//System.out.println(itemList.size());
    		return new Result(1, "查询成功", itemList);
    	}
    }
    
    /*
     * 将购物车里面的物品加入到订单（未付款状态）
     * 先insert一条状态为1的订单，并获得该订单id
     * 然后更新用户选择的订单项的外键
     * 更新订单金额（新insert的订单 和 购物车订单）
     */
    @RequestMapping("/addToOrder/{idstr}")
    public Result addToOrder(@PathVariable String idstr, HttpServletRequest request) {
    	UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
    	Integer userid = user.getUserid();
//    	Integer userid = 6;
    	//先判断用户地址是否存在
    	List<Address> address = addressService.findByUserId(userid);
    	if(address == null || address.size() == 0) {
    		return new Result(0, "还没有地址信息");
    	}
    	
//    	System.out.println(idstr);
    	String[] itemIdList = idstr.split(",");

    	// 先插入订单状态为1的order
    	Orders o = new Orders();
    	o.setUserid(userid);
    	o.setAddressid(1);
    	o.setOrderstate(1);
		o.setOrdercreatedate(new Date());
		ordersService.insertOrders(o);
		//System.out.println("插入的订单id " + o.getOrderid());
		Integer newOrderId = o.getOrderid();
		BigDecimal sum = new BigDecimal(0.0);
    	
		//查购物车订单
    	Orders order = ordersService.findOrderByUserIdAndState(userid, 0).get(0);
    	
    	//查询购物车订单对应的订单项
    	List<OrderItems> itemList = ordersService.findItemByOrderId(order.getOrderid()).getOrderItems();
		for(OrderItems item : itemList) {
			for(String i : itemIdList) {
				if (i.equals(item.getOrderitemid().toString())) {
					// 更新订单项关联订单的外键id
					item.setOrderid(newOrderId);
					sum = item.getOrderitemsum().add(sum);
					orderItemsService.updateOrderItemSelective(item);
				}
			}
		}
		//更新订单金额
		o.setOrdersum(sum);
		ordersService.updateOrdersSelective(o);
		//更新购物车金额
		order.setOrdersum(order.getOrdersum().subtract(sum));
		ordersService.updateOrdersSelective(order);
    	return new Result(1, "提交成功");
    }
    
    /*
     * 查看当前订单信息（未付款）
     */
    @RequestMapping("/showCurrentOrders")
    public Result showCurrentOrders(HttpServletRequest request) {
    	UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
    	Integer userid = user.getUserid();
//    	Integer userid = 6;
		//查未付款订单编号
    	List<Orders> orders = ordersService.findOrderByUserIdAndState(userid, 1);
    	//List<OrderItems> itemList = orders.get(orders.size() - 1).getOrderItems();
    	Orders order = orders.get(orders.size() - 1);
    	// System.out.println(order);
    	return new Result(1, "success", order);
    }
    
    /* 
     * 删除订单项 
     */
    @RequestMapping(value = "/deleteItem")
    public Result deleteItem(@RequestParam Integer itemid, @RequestParam BigDecimal itemsum, @RequestParam Integer orderid) {
    	//System.out.println(itemid + " " + itemsum + " " + orderid);
    	//删除订单项
    	orderItemsService.deleteOrderItem(itemid);
    	//修改订单的钱
    	Orders order = ordersService.selectOrders(orderid);
    	order.setOrdersum(order.getOrdersum().subtract(itemsum));
    	ordersService.updateOrdersSelective(order);
    	
		return new Result(1, "success");
	}
    
    /*
     * 查看所有订单信息（未付款）
     */
/*    @RequestMapping("/showOrders")
    public Result showOrders() {
//    	UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
//    	Integer userid = user.getUserid();
    	Integer userid = 6;
		//查未付款订单编号
    	List<Orders> orders = ordersService.findOrderByUserIdAndState(userid, 1);
		return new Result(1, "success", orders);
    }*/
    
    
    /*
     * 当购物车里面的信息发生变化时
     * 删除对应的商品
     */
    @RequestMapping("updateCar")
    public Result updateCar(@RequestParam Integer itemid, @RequestParam Integer flag) {
//    	System.out.println(itemid + " " + flag);
    	OrderItems item = orderItemsService.selectOrderItem(itemid);
    	
    	Goods good = goodsService.findGoodByGoodId(item.getGoodid());
    	Orders order = ordersService.selectOrders(item.getOrderid());
    	if(flag == -1) {
    		item.setGoodnum(item.getGoodnum() - 1);
        	item.setOrderitemsum(item.getOrderitemsum().subtract(good.getGoodprice()));
        	order.setOrdersum(order.getOrdersum().subtract(good.getGoodprice()));
    	} else if(flag == 1) {
    		item.setGoodnum(item.getGoodnum() + 1);
        	item.setOrderitemsum(item.getOrderitemsum().add(good.getGoodprice()));
        	order.setOrdersum(order.getOrdersum().add(good.getGoodprice()));
    	}
    	// 先修改订单项
    	orderItemsService.updateOrderItemSelective(item);
    	// 再修改订单价格
    	ordersService.updateOrdersSelective(order);
    	
		return new Result(1, "修改成功", good);
    }
    
    /**
     * 确认付款
     * @param idstr
     * @return
     */
    @RequestMapping("/makeSureOrder/{orderid}")
    public Result makeSureOrder(@PathVariable Integer orderid, HttpServletRequest request) {
    	UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
    	Integer userid = user.getUserid();
    	//更改订单状态为2
    	Orders order = ordersService.selectOrders(orderid);
    	order.setOrderstate(2);
    	ordersService.updateOrdersSelective(order);
    	
    	return new Result(1, "提交成功");
    }
    
    
    /**
     * 得到购物车里面商品的数量
     */
    @RequestMapping("/getGoodNumAtCar")
    public Result getGoodNumAtCar(HttpServletRequest request) {
    	UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
    	Integer userid = user.getUserid();
    	//
    	List<Orders> orders = ordersService.findOrderByUserIdAndState(userid, 0);
    	if(orders == null || orders.size() == 0) {
    		return new Result(1, "提交成功", 0);
    	} else {
    		Orders order = orders.get(0);
    		//System.out.println(order);
    		if(order.getOrderid() == null) {
    			return new Result(1, "提交成功", 0);
    		} else {
    			return new Result(1, "提交成功", orderItemsService.findItemsByOrderId(order.getOrderid()).size());
    		}
    	}
    }
    
}
