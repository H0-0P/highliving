package com.highliving.dao;

import com.highliving.pojo.ItemParams;

public interface ItemParamsMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(ItemParams record);

    int insertSelective(ItemParams record);

    ItemParams selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(ItemParams record);

    int updateByPrimaryKey(ItemParams record);
    
    ItemParams selectByIdAndParam(Integer itemid, String params);
}