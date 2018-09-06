package com.highliving.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.highliving.pojo.GoodBrand;
import com.highliving.pojo.GoodDiscuss;
import com.highliving.pojo.UserInfo;
import com.highliving.service.GoodDiscussService;
import com.highliving.service.UserInfoService;

@RestController
public class GoodDiscussController {

	@Autowired
	private GoodDiscussService goodDiscussService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/discuss")
	public PageInfo<GoodDiscuss> findByGoodId(@RequestParam String goodId,@RequestParam int pageNum,@RequestParam int pageSize){
		
		return goodDiscussService.findByGoodId(goodId, pageNum, pageSize);
	}
	
	@RequestMapping("/discuss/avg")
	public Float avgScoreByGoodId(@RequestParam String goodId) {
		System.out.println(goodDiscussService.findAvgScoreByGoodId(goodId));
		return goodDiscussService.findAvgScoreByGoodId(goodId);
	}
	
	@RequestMapping(value="/userDiscuss")
	public PageInfo<GoodDiscuss> findByUserId(@RequestParam Integer userid,@RequestParam int pageNum,@RequestParam int pageSize) {
		return goodDiscussService.findByUserId(userid, pageNum, pageSize);
	}

}
