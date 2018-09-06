package com.highliving.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.highliving.pojo.GoodBrand;
import com.highliving.pojo.Goods;
import com.highliving.service.GoodBrandService;

@RestController
public class GoodBrandController {
	@Autowired
	private GoodBrandService goodBrandService;
	
	@RequestMapping(value="/brand/list",method=RequestMethod.GET)
	public PageInfo<GoodBrand> findBrandInfo(int pageNum,int pageSize) throws IOException{
		PageInfo<GoodBrand> list = goodBrandService.findBrandInfo(pageNum,pageSize);
		return list;
	}
	
	@RequestMapping(value="/brand",method=RequestMethod.GET)
	public GoodBrand findBrandById(Integer brandid){
		return goodBrandService.findById(brandid);
	}
	
	@RequestMapping(value="/brandgoods",method=RequestMethod.GET)
	public PageInfo<Goods> findGoods(Integer brandid,int pageNum,int pageSize){
		return goodBrandService.findWithGoodsById(brandid,pageNum,pageSize);
	}
	
}
