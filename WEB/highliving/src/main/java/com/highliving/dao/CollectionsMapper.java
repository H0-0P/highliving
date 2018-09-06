package com.highliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.highliving.pojo.Collections;

public interface CollectionsMapper {
    int deleteByPrimaryKey(Integer collectid);

    int insert(Collections record);

    int insertSelective(Collections record);

    Collections selectByPrimaryKey(Integer collectid);

    int updateByPrimaryKeySelective(Collections record);

    int updateByPrimaryKey(Collections record);
    
    List<Collections> findByUserId(Integer userId);
    
    int findCountByUserId(Integer userId);
    
    int deletecollection(Integer userId, String goodId);
}