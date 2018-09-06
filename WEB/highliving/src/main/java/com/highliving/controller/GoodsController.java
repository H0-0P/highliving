package com.highliving.controller;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.highliving.pojo.GoodBrand;
import com.highliving.pojo.Goods;
import com.highliving.pojo.News;
import com.highliving.pojo.Orders;
import com.highliving.pojo.Pictures;
import com.highliving.service.GoodsService;
import com.highliving.service.PictureService;

@RequestMapping("/goods")
@RestController
public class GoodsController {
	@Autowired 
	private GoodsService goodsService;
	@Autowired
	private PictureService pictureservice;
	
	/**
	 * 自动补全商品
	 */
	@RequestMapping(value="/getgoodname/{name}")
	public List<Goods> findGoodsName(@PathVariable("name") String goodname){
		return goodsService.findGoodByGoodName(goodname);
	}
	
	/**
	 * 根据输入模糊查询
	 */
	@RequestMapping(value="/getgoods/{goodname}")
	public PageInfo<Goods> getGoods(@PathVariable("goodname") String goodname, int pageNum, int pageSize){
		//System.out.println(pageNum + " " + pageSize);
		return goodsService.findGoodsByName(goodname, pageNum, pageSize);
	}
	
	@RequestMapping(value="/detail",method = RequestMethod.GET)
	public List<Goods> findPic(@RequestParam String id) {
		return goodsService.findPicByGoodId(id);
	}
	
	@RequestMapping(value = "/getGoodsByTypeId", method = RequestMethod.GET)
	public	PageInfo<Goods> getGoodsByTypeId(@RequestParam Integer typeid, int pageNum, int pageSize) {
		return goodsService.findByGoodTypeId(typeid, pageNum, pageSize);
	}

}
