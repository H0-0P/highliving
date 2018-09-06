package com.highliving.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.highliving.common.EUDataGridResult;
import com.highliving.common.IDUtils;
import com.highliving.common.TaotaoResult;
import com.highliving.dao.GoodsMapper;
import com.highliving.dao.ParamMapper;
import com.highliving.pojo.Goods;
import com.highliving.pojo.Param;
import com.highliving.pojo.Pictures;

@Service
public class GoodsService{
	
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private ParamMapper paramMapper;
	
	public int deleteGood(String goodid) {
		return goodsMapper.deleteByPrimaryKey(goodid);
	}
	public int insertGood(Goods record) {
		return goodsMapper.insert(record);
	}

	public int insertGoodSelective(Goods record) {
		return goodsMapper.insertSelective(record);
	}

	public Goods findGoodByGoodId(String goodid) {
		return goodsMapper.selectByPrimaryKey(goodid);
	}
	public int updateGoodSelective(Goods record) {
		return goodsMapper.updateByPrimaryKeySelective(record);
	}

	public int updateGood(Goods record) {
		return goodsMapper.updateByPrimaryKey(record);
	}
	//根据userId查good
	public List<Goods> findGoodByUserId(Integer userid) {
		return goodsMapper.selectByUserId(userid);
	}
	//根据商品名模糊查询商品
	public List<Goods> findGoodByGoodName(String goodname) {
		return goodsMapper.selectByGoodName(goodname);
	}
	//根据品牌名查所有商品
	public List<Goods> findGoodByBrandId(Integer brandid) {
		return goodsMapper.selectByBrandId(brandid);
	}
	//根据商品id查图片
	public List<Goods> findPicByGoodId(String goodid) {
			List<Goods> list =goodsMapper.selectPicByGoodId(goodid);
			for (Goods i : list) {
				String path = "http://192.168.8.2:8080/highliving/img/"+i.getDefaultpic();
				i.setDefaultpic(path);
				List<Pictures> picList = i.getPictures();
				for (Pictures pictures : picList) {
					String picPath = "http://192.168.8.2:8080/highliving/img/"+pictures.getPicpath();
					pictures.setPicpath(picPath);
				}
			}
			return list;
	}

	//根据商品类型查商品
	public List<Goods> findByGoodTypeId(Integer goodtypeid) {
		return goodsMapper.selectByGoodTypeId(goodtypeid);
	}
	
	//模糊查询商品2
	public PageInfo<Goods> findGoodsByName(String goodname, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> goodList = goodsMapper.selectByGoodName2(goodname);
		for(Goods g : goodList) {
			String goodpath = "http://192.168.8.2:8080/highliving/img/" + g.getDefaultpic();
			g.setDefaultpic(goodpath);
		}
		PageInfo<Goods> pageInfo = new PageInfo<Goods>(goodList);
		return pageInfo;
	}
	
	public PageInfo<Goods> findByGoodTypeId(Integer typeid, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> list = goodsMapper.selectByGoodTypeId(typeid);
		for(Goods i:list) {
			String path = "http://192.168.8.2:8080/highliving/img/" + i.getDefaultpic();
			i.setDefaultpic(path);
		}
		PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
		return pageInfo;
	}
	
	//添加规格参数
	private TaotaoResult insertItemParamItem(String goodid, String itemParam) {
		Param param = new Param();
		param.setGoodid(goodid);
		param.setParam(itemParam);
		paramMapper.insert(param);
		return TaotaoResult.ok();
	}
	//后台添加商品
	public TaotaoResult save(Goods goods,String itemParam)throws Exception{
		goods.setGoodid(IDUtils.genItemId());
		goods.setGoodcreatetime(new Date());
		goods.setGoodstatus(true);
		goods.setIsvalid(true);
		goods.setBrandid(1);
//			goods.setDefaultpic(defaultpic);
		goodsMapper.insert(goods);
		TaotaoResult result = insertItemParamItem(goods.getGoodid(), itemParam);
		if(result.getStatus()!=200) {
			throw new Exception();
		}
		return TaotaoResult.ok();		
	}
	
	public TaotaoResult updateGoodInfo(Goods goods, String itemParams) {
		goodsMapper.updateByPrimaryKeySelective(goods);
		Param param = new Param();
		param.setGoodid(goods.getGoodid());
		param.setParam(itemParams);
		paramMapper.updateByGoodId(param);
		return TaotaoResult.ok();
	}
	
	//后台管理商品列表展示
	public EUDataGridResult getGoodsList(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> list = goodsMapper.findAll();
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		PageInfo<Goods> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
