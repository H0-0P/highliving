package com.highliving.dao;

import java.util.List;

import com.highliving.pojo.Pictures;

public interface PicturesMapper {
    int deleteByPrimaryKey(Integer picid);

    int insert(Pictures record);

    int insertSelective(Pictures record);

    Pictures selectByPrimaryKey(Integer picid);

    int updateByPrimaryKeySelective(Pictures record);

    int updateByPrimaryKey(Pictures record);
    
    //根据goodId查
    List<Pictures> findByPicsGoodId(String goodId);
    
    //根据goodId删
    void deletePicByGoodId(String goodId);
}