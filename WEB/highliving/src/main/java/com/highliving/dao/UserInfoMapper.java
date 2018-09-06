package com.highliving.dao;

import com.highliving.pojo.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    // 根据用户名查找
	UserInfo findUserByLoginName(String loginName);
	
	// 根据phone查
	UserInfo findByPhone(String phone);
}