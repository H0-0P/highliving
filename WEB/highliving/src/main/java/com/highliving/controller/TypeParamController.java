package com.highliving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.highliving.pojo.TypeParamModel;
import com.highliving.service.TypeParamModelService;

@RestController
public class TypeParamController {

	@Autowired
	private TypeParamModelService typeParamModelService;
	
	@RequestMapping(value="/paramModel",method=RequestMethod.GET)
	public TypeParamModel getTypeParamModel(@RequestParam Integer goodTypeId) {
		TypeParamModel model = typeParamModelService.findParamByTypeId(goodTypeId);
		System.out.println(model.toString());
		
		return model;
	}
	
//	@RequestMapping("/param")
//	public TypeParamModel getParamModel(@RequestParam Integer modelid) {
//		TypeParamModel model = typeParamModelService.findById(modelid);
//		//JSONArray json = JSONArray.fromObject(model.getParamdata() ); // 首先把字符串转成 JSONArray  对象
//		System.out.println(model.toString());
//		
//		return model;
//	}
}
