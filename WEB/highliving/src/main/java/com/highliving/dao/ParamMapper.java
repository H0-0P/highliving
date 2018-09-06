package com.highliving.dao;

import com.highliving.pojo.Param;

public interface ParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Param record);

    int insertSelective(Param record);

    Param selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Param record);

    int updateByPrimaryKeyWithBLOBs(Param record);

    int updateByPrimaryKey(Param record);
    
    //根据goodid查找
    Param findParamByGoodId(String goodId);
    
    //根据goodId改
    void updateByGoodId(Param param);
    
}