package com.highliving.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.highliving.common.EUDataGridResult;
import com.highliving.common.TaotaoResult;
import com.highliving.pojo.Goods;
import com.highliving.pojo.Param;
import com.highliving.service.GoodsService;

@Controller
public class ItemController {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public Goods getGoodsById(@PathVariable String id) {
		return goodsService.findGoodByGoodId(id);
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getGoodsList(Integer page, Integer rows) {
		
		EUDataGridResult result = goodsService.getGoodsList(page, rows);
		return result;
	}
	@RequestMapping(value="/item/save", method= RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createItem(@ModelAttribute("goods") Goods goods, String itemParams)throws Exception {
		String image = goods.getDefaultpic();
		image = image.substring(image.lastIndexOf("/") + 1);
		goods.setDefaultpic(image);
		TaotaoResult result = goodsService.save(goods,itemParams);
		return result;
	}
	
	@RequestMapping(value="/item/update", method= RequestMethod.POST)
	@ResponseBody
	public TaotaoResult updateItem(@ModelAttribute("goods") Goods goods, String itemParams)throws Exception {
		String image = goods.getDefaultpic();
		image = image.substring(image.lastIndexOf("/") + 1);
		goods.setDefaultpic(image);
		TaotaoResult result = goodsService.updateGoodInfo(goods,itemParams);
		return result;
	}
	
	@RequestMapping(value="/item/delete", method= RequestMethod.POST)
	@ResponseBody
	public TaotaoResult deleteItem(String ids)throws Exception {
		String[] id_arr = ids.split(",");
		for(int i = 0; i < id_arr.length; i++) {
			goodsService.deleteGood(id_arr[i]);
		}
		return TaotaoResult.ok();
	}
}
