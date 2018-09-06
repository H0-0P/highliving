package com.highliving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.highliving.dao.CollectionsMapper;
import com.highliving.pojo.Collections;
import com.highliving.pojo.Goods;

@Service
public class CollectionsService {

	@Autowired
	private CollectionsMapper collectionsMapper;
	
	public int insert(Collections collections) {
		return collectionsMapper.insert(collections);
	}
	
	public int deleteById(Integer collectionId) {
		return collectionsMapper.deleteByPrimaryKey(collectionId);
	}
	
	public List<Collections> findByUserId(Integer userId) {
		return collectionsMapper.findByUserId(userId);
	}
	
	public int delectById(Integer collectid) {
		return collectionsMapper.deleteByPrimaryKey(collectid);
	}
	/*
	 * 根据用户id查总数
	 */
	public int findCountByUserId(Integer userId){
		return collectionsMapper.findCountByUserId(userId);
	}
	
	public Collections findById(Integer collectId) {
		return collectionsMapper.selectByPrimaryKey(collectId);
	}
	
	public int deleteCollection(Integer userId, String goodId) {
		return collectionsMapper.deletecollection(userId, goodId);
		
	}
}
