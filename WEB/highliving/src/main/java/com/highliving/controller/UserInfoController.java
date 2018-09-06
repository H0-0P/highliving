package com.highliving.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.sql.visitor.functions.Insert;
import com.highliving.pojo.Address;
import com.highliving.pojo.Result;
import com.highliving.pojo.UserInfo;
import com.highliving.service.AddressService;
import com.highliving.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	AddressService addressService;
	/**
	 * 登录成功返回true，否则返回false
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Result login(HttpServletRequest request,@RequestParam String loginName, @RequestParam String password){
		UserInfo user = userInfoService.loginCheck(loginName, password);
		if(user != null) {
			request.getSession().setAttribute("loginUser", user);
			return new Result(1, "登录成功");
		} else {
			return new Result(0, "登录失败");
		}
	}
	
	/**
	 * 注册, 返回受影响行数
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public Result regist(UserInfo userInfo){
		userInfo.setUsertype(1);//买家默认设置1
		userInfo.setScore(0);//积分默认为0
		userInfo.setIsvalid(true);
		userInfo.setCreatetime(new Date());
		// 受影响的行数
		Integer status = (Integer) userInfoService.save(userInfo);
		if(status > 0) {
			return new Result(status, "插入成功");
		} else {
			return new Result(status, "插入失败");
		}
	}
	/**
	 * 判断是否登录
	 */
	@RequestMapping(value = "/islogin", method = RequestMethod.GET)
	public Result isLogin(HttpServletRequest request){
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
		if(user != null) {
			return new Result(1, "已登录", user);
		} else {
			return new Result(0, "未登录");
		}
	}
	
	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public Result logout(HttpServletRequest request){
		request.getSession().removeAttribute("loginUser");
		return new Result(1, "success");
	}
	
	/**	
	 * 修改用户信息 
	 */
	@RequestMapping(value="/updateuser")
	public Result updateUser(UserInfo userInfo){
		System.out.println("123");
		System.out.println(userInfo.toString());
		int result = userInfoService.updateUser(userInfo);
		return new Result(result, "success",userInfo);
	}
	
	/**
	 * 根据用户名（loginName）查询
	 */
	@RequestMapping(value = "/findUserByLoginName", method = RequestMethod.GET)
	public Result findUserByLoginName(@RequestParam String loginname) {
		UserInfo userInfo = userInfoService.findUserByName(loginname);
		return new Result(1, "success", userInfo);
	}
	/**
	 * 查找地址信息
	 */
	@RequestMapping(value="/findDeaultAddress", method = RequestMethod.GET)
	public Result findAddressByUserId(HttpServletRequest request){
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
		Address address = new Address();
		address = null;
		address = addressService.findFristAddress(user.getUserid());
		address.setUserid(user.getUserid());
		Result result = new Result(1, "success", address);
		return new Result(1, "success", address);	
	}
	/**
	 * 添加地址
	 */
	@RequestMapping(value="/inserAddress", method = RequestMethod.POST)
	public Result inserAddress(Address address) {
		Integer status = (Integer) addressService.insert(address);
		if (status == 1) {
			return new Result(status, "插入成功");
		}else {
			return new Result(status, "插入失败");
		}
	}
	
	/**
	 * 验证用户是否存在
	 */
	@RequestMapping(value="/checkUserName", method = RequestMethod.GET)
	public Result cheackUserName(@RequestParam String userName) throws Exception{
		UserInfo userInfo =null;
		userInfo = userInfoService.findUserByName(userName);
		if (userInfo == null) {
			return new Result(1, "success");
		}else {
			return new Result(0, "error");
		}
	}
}
