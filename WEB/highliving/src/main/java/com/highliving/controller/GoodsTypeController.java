package com.highliving.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.highliving.pojo.Goods;
import com.highliving.pojo.GoodsType;
import com.highliving.pojo.TypeResult;
import com.highliving.service.GoodsService;
import com.highliving.service.GoodsTypeService;

@RestController
public class GoodsTypeController {
	@Autowired
	private GoodsTypeService goodsTypeService;
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value="/typelist",method=RequestMethod.GET)
	public TypeResult list() throws Exception{
		return goodsTypeService.findAllTypes();
	}
	
	/**
	 * 首页
	 * 根据类别查询商品
	 * 1、先根据父类别编号查询其类别编号，在查询叶子节点编号，根据叶子节点编号查询商品
	 */
	@RequestMapping(value="/getGoodsByType")
	public List<Goods> findTypeGoods(@RequestParam Integer parentId){
		//存放查询结果
		List<Goods> goodsList = new ArrayList<Goods>();
		//查询父类别的子类别
		List<GoodsType> list1 = goodsTypeService.findByParent(parentId);
		for(int i=0; i < list1.size(); i++) {
			int parent = list1.get(i).getGoodtypeid();//得到中间节点typeId
			List<GoodsType> list2 = goodsTypeService.findByParent(parent);
			int children = list2.get(0).getGoodtypeid();//得到叶子节点id
			List<Goods> goods = goodsService.findByGoodTypeId(children);//根据叶子节点id查商品

			String defaultPic = goods.get(0).getDefaultpic();
			String picPath="http://192.168.8.2:8080/highliving/img/"+ defaultPic;
			goods.get(0).setDefaultpic(picPath);
			goodsList.add(goods.get(0));
			if(goodsList.size() >= 6) {
				break;
			}
		}
		return goodsList;	
	}
	/**
	 * 类型
	 */
	@RequestMapping(value="/getTypeName")
	public List<GoodsType> findTypeName(@RequestParam Integer parentId){
		List<GoodsType> nameList = new ArrayList<GoodsType>();
		List<GoodsType> list1 = goodsTypeService.findByParent(parentId);
		for(int i=0; i < list1.size(); i++) {
			int parent = list1.get(i).getGoodtypeid();//得到中间节点typeId
			List<GoodsType> list2 = goodsTypeService.findByParent(parent);
			nameList.add(list2.get(0));
			if (nameList.size()>10) {
				break;
			}
		}
		return nameList;
	}

}
