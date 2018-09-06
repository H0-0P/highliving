package com.highliving.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.highliving.common.EUDataGridResult;
import com.highliving.common.TaotaoResult;
import com.highliving.pojo.TypeParamModel;
import com.highliving.service.TypeParamModelService;

@Controller
@RequestMapping("/item/param")
public class ItemParamAdminController {
	@Autowired
	private TypeParamModelService typeParamModelService;
	
	@RequestMapping("/list")
	@ResponseBody
	private EUDataGridResult findAllTypeParam(Integer page, Integer rows) {
		EUDataGridResult result= typeParamModelService.findAllTypeParam(page, rows);
		return result;
	}
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable Integer itemCatId) {
		
		TaotaoResult result = typeParamModelService.getItemParamByCid(itemCatId);
		return result ;
	}	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable Integer cid, String paramData) {
		//创建pojo对象
		 
		TypeParamModel typeParamModel = new TypeParamModel();
		typeParamModel.setGoodtypeid(cid);
		typeParamModel.setParamdata(paramData);
		TaotaoResult result = typeParamModelService.InsertTypeParam(typeParamModel);
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteItemParam(@RequestParam String params) {
        JSONArray jsonArray = JSONArray.parseArray(params);
        String  paramId = null;  
        String[] list = {};
        for (int i = 0; i < jsonArray.size(); i++) {  
          paramId = jsonArray.getJSONObject(i).getString("ids");    
       }  
        list = paramId.split(",");
        for(int i = 0; i < list.length; i++) {
        	 int modelid = Integer.valueOf(list[i]).intValue();
        	 typeParamModelService.deleteParams(modelid);
        }
          return TaotaoResult.build(200, "OK");
	}
	
	
}
