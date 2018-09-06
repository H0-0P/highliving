package com.highliving.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highliving.dao.ItemParamsMapper;
import com.highliving.pojo.ItemParams;

@Service
public class ItemParamsService {
	@Autowired
	private ItemParamsMapper itemParamsMapper;
	
	public int inser(ItemParams itemParams) {
		return itemParamsMapper.insert(itemParams);
	}
	
	public ItemParams findParam(Integer itemid) {
		return itemParamsMapper.selectByPrimaryKey(itemid);
	}
	
	public int deleteParam(Integer itemid) {
		return itemParamsMapper.deleteByPrimaryKey(itemid);
	}
	
	public int  updataParam(ItemParams itemParams) {
		return itemParamsMapper.updateByPrimaryKeySelective(itemParams);
	}
	
	public ItemParams findByIdAndParams(Integer itemid, String params) {
		return itemParamsMapper.selectByIdAndParam(itemid, params);
	}
}
