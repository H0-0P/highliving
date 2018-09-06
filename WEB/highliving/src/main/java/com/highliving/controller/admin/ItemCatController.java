package com.highliving.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.highliving.common.TreeNode;
import com.highliving.service.GoodsTypeService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private GoodsTypeService goodsTypeService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0")Integer parentId){
		return goodsTypeService.getItemCatList(parentId);
	}

}
