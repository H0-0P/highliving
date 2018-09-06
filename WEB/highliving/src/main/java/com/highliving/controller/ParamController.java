package com.highliving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.highliving.pojo.Param;
import com.highliving.service.ParamService;

@RestController
public class ParamController {

	@Autowired
	private ParamService paramService;
	
	@RequestMapping("/param")
	public Param getGoodParam(@RequestParam String goodid) {
		//System.out.println(paramService.findParamByGoodId(goodid));
		return paramService.findParamByGoodId(goodid);
	}
}
