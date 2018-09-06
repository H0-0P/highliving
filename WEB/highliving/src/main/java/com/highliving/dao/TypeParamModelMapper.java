package com.highliving.dao;

import java.util.List;

import com.highliving.pojo.TypeParamModel;

public interface TypeParamModelMapper {
    int deleteByPrimaryKey(Integer modelid);

    int insert(TypeParamModel record);

    int insertSelective(TypeParamModel record);

    TypeParamModel selectByPrimaryKey(Integer modelid);

    int updateByPrimaryKeySelective(TypeParamModel record);

    int updateByPrimaryKeyWithBLOBs(TypeParamModel record);

    int updateByPrimaryKey(TypeParamModel record);
    
    //根据goodTypeId查找
    TypeParamModel findParamByTypeId(Integer goodTypeId);
    
    //根据goodTypeId改text，传入对象
    void updateByTypeId(TypeParamModel param);
    
    List<TypeParamModel> selectAll();
}