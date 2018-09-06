package com.highliving.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.highliving.pojo.UserInfo;
import com.highliving.service.UserInfoService;

import net.sf.jsqlparser.statement.create.table.Index;

@Controller
public class PageController {
	@Autowired
	private UserInfoService userInfoService;
	/**
	 * 跳转admin
	 * @return
	 */
	@RequestMapping("/login")
	private String toAdmin() {
		return "login";
	}
	/**
	 * 
	 */
	@RequestMapping("/{page}")
	private String toAddGood(@PathVariable String page) {
		return page;
	}
	//
	@RequestMapping("/index")
	private String toIndex(@RequestParam String  loginName, @RequestParam String password, HttpServletRequest request) {
		System.out.println("登录中");
		UserInfo user = userInfoService.loginCheck(loginName, password);
		if(user!=null && user.getUsertype()==1) {
			request.getSession().setAttribute("loginUser", user);
			return "index";
		}else {
			return "login";
		}
	}
}
