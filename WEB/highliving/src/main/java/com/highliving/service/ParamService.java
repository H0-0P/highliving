package com.highliving.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highliving.dao.ParamMapper;
import com.highliving.pojo.Param;

@Service
public class ParamService {
	
	@Autowired
	private ParamMapper paramMapper;	
	
	/*
	 * 根据goodId查
	 */
	public Param findParamByGoodId(String goodId) {
		return paramMapper.findParamByGoodId(goodId);
	}
	
	/*
	 * 根据goodId改
	 */
	public void updateParamByGoodId(Param param) {
		paramMapper.updateByGoodId(param);
	}
	
}
