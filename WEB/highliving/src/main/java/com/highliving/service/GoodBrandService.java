package com.highliving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.highliving.dao.GoodBrandMapper;
import com.highliving.dao.GoodsMapper;
import com.highliving.pojo.GoodBrand;
import com.highliving.pojo.Goods;

@Service
public class GoodBrandService {
	@Autowired
	private GoodBrandMapper goodBrandMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	public PageInfo<GoodBrand> findBrandInfo(int page,int rows) {
		PageHelper.startPage(page, rows);
		List<GoodBrand> list =  goodBrandMapper.findBrandInfo();
		for(GoodBrand i:list) {
			String path = "http://192.168.8.2:8080/highliving/img/"+i.getBrandlogopath();
			i.setBrandlogopath(path);
		}
		PageInfo<GoodBrand> pageInfo = new PageInfo<GoodBrand>(list);
		
		return pageInfo;
	}
	
	public int insert(GoodBrand goodBrand) {
		return goodBrandMapper.insert(goodBrand);
	}
	
	public int update(GoodBrand goodBrand) {
		return goodBrandMapper.updateByPrimaryKey(goodBrand);
	}
	
	public int delete(Integer brandId) {
		return goodBrandMapper.deleteByPrimaryKey(brandId);
	}
	
	public GoodBrand findById(Integer brandId) {
		GoodBrand i =  goodBrandMapper.selectByPrimaryKey(brandId);
		String logopath = "http://192.168.8.2:8080/highliving/img/"+i.getBrandlogopath();
		i.setBrandlogopath(logopath);
		return i;
	}
	
	public PageInfo<Goods> findWithGoodsById(Integer brandid,int page,int rows) {
		PageHelper.startPage(page, rows);
			List<Goods> goods = goodsMapper.selectByBrandId(brandid);
			for (Goods j : goods) {
				String goodpath = "http://192.168.8.2:8080/highliving/img/"+j.getDefaultpic();
				j.setDefaultpic(goodpath);
			}
		
		PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods);
		
		return pageInfo;
	}
}
