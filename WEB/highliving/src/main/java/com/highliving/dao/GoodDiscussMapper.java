package com.highliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.highliving.pojo.GoodDiscuss;

public interface GoodDiscussMapper {
    int deleteByPrimaryKey(Integer discussid);

    int insert(GoodDiscuss record);

    int insertSelective(GoodDiscuss record);

    GoodDiscuss selectByPrimaryKey(Integer discussid);

    int updateByPrimaryKeySelective(GoodDiscuss record);

    int updateByPrimaryKey(GoodDiscuss record);
    
    List<GoodDiscuss> findByGoodId(String goodId);
    
    List<GoodDiscuss> findByUserId(Integer userId);
    
    //根据商品id查询总分
    int findSumScoreByGoodId(String goodId);
    //根据商品id查询评价人数
    int findCountUserByGoodId(String goodId);
//    List<GoodDiscuss> findAllInfoByGoodId(String goodId);
}