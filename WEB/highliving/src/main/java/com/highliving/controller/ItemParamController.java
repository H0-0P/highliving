package com.highliving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.highliving.pojo.ItemParams;
import com.highliving.service.ItemParamsService;

@RequestMapping("/itemParams")
@RestController
public class ItemParamController {
	@Autowired
	private ItemParamsService itemParamsService;
	
	@RequestMapping(value="/insert")
	public int inserParam(@RequestParam Integer itemId, @RequestParam String params) {
		ItemParams itemParams = new ItemParams();
		itemParams.setItemid(itemId);
		itemParams.setItemparams(params);
		return itemParamsService.inser(itemParams);
	}
	
	@RequestMapping(value="/delete")
	public int deletParam(@RequestParam Integer itemid) {
		return itemParamsService.deleteParam(itemid);
	}
	
	@RequestMapping(value="/findParam")
	public ItemParams find(@RequestParam Integer itemid) {
		System.out.println(itemid);
		return itemParamsService.findParam(itemid);
	}

}
