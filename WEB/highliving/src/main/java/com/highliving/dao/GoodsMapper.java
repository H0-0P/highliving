package com.highliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.highliving.pojo.Goods;
@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(String goodid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String goodid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    List<Goods> selectByUserId(Integer userid);
    
    List<Goods> selectByGoodName(String goodname);
    
    List<Goods> selectByBrandId(Integer brandid);
    
    List<Goods> selectPicByGoodId(String goodid);
    
    List<Goods> selectByGoodTypeId(Integer goodtypeid);
    
    List<Goods> selectByGoodName2(String goodname);
    
    List<Goods> findAll();
}