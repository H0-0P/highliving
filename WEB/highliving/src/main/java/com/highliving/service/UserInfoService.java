package com.highliving.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highliving.dao.UserInfoMapper;
import com.highliving.pojo.UserInfo;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	/*
	 * 根据loginName查
	 */
	public UserInfo findUserByName(String loginName) {
		return userInfoMapper.findUserByLoginName(loginName);
	}
	
	/*
	 * 登录
	 */
	public UserInfo loginCheck(String loginName, String password) {
		UserInfo user = userInfoMapper.findUserByLoginName(loginName);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}
	
	/*
	 * 根据电话查找
	 */
	public UserInfo findByPhone(String phone) {
		return userInfoMapper.findByPhone(phone);
	}

	/*
	 * 插入用户信息
	 */
	public Object save(UserInfo userInfo) {
//		System.out.println(userInfo);
		return userInfoMapper.insert(userInfo);
	}
	
	public int updateUser(UserInfo record) {
		return userInfoMapper.updateByPrimaryKeySelective(record);
	}
	
}
