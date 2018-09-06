package com.highliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.highliving.pojo.GoodBrand;

public interface GoodBrandMapper {
    int deleteByPrimaryKey(Integer brandid);

    int insert(GoodBrand record);

    int insertSelective(GoodBrand record);

    GoodBrand selectByPrimaryKey(Integer brandid);

    int updateByPrimaryKeySelective(GoodBrand record);

    int updateByPrimaryKey(GoodBrand record);
    
    List<GoodBrand> findBrandInfo();
    //连查商品 
    List<GoodBrand> findWithGoodsById(Integer brandid);
}