package com.highliving.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.highliving.dao.GoodDiscussMapper;
import com.highliving.dao.UserInfoMapper;
import com.highliving.pojo.GoodBrand;
import com.highliving.pojo.GoodDiscuss;
import com.highliving.pojo.UserInfo;

@Service
public class GoodDiscussService {
	@Autowired
	private GoodDiscussMapper goodDiscussMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public PageInfo<GoodDiscuss> findByGoodId(String goodId,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<GoodDiscuss>list = goodDiscussMapper.findByGoodId(goodId);
		for (GoodDiscuss i : list) {
			UserInfo userInfo = userInfoMapper.selectByPrimaryKey(i.getUserid());
			i.setUserInfo(userInfo);
		}
		PageInfo<GoodDiscuss> pageInfo = new PageInfo<GoodDiscuss>(list);
		
		return pageInfo;
	}
	
	public int insert(GoodDiscuss goodDiscuss) {
		return goodDiscussMapper.insert(goodDiscuss);
	}
	
	public int update(GoodDiscuss goodDiscuss) {
		return goodDiscussMapper.updateByPrimaryKey(goodDiscuss);
	}
	
	public int delete(Integer DiscussId) {
		return goodDiscussMapper.deleteByPrimaryKey(DiscussId);
	}
	
	public GoodDiscuss findById(Integer DiscussId) {
		return goodDiscussMapper.selectByPrimaryKey(DiscussId);
	}
	
	public PageInfo<GoodDiscuss> findByUserId(Integer userId,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<GoodDiscuss>list = goodDiscussMapper.findByUserId(userId);
		PageInfo<GoodDiscuss> pageInfo = new PageInfo<GoodDiscuss>(list);		
		return pageInfo;
	}

//	public List<GoodDiscuss> findAllInfoByGoodId(String goodId) {
//		return goodDiscussMapper.findAllInfoByGoodId(goodId);
//	}
	
	public float findAvgScoreByGoodId(String goodId) {
		//DecimalFormat df=new DecimalFormat("0.0");
		int count = goodDiscussMapper.findCountUserByGoodId(goodId);
		int sum = goodDiscussMapper.findSumScoreByGoodId(goodId);
		return (float)(Math.round(sum/count*10))/10;
	}
}
