package com.highliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.highliving.pojo.GoodsType;
@Repository
public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer goodtypeid);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer goodtypeid);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
    
    //根据parent查类型
    List<GoodsType> selectByParent(Integer parent);
    
    //根据hasChildren查明是否子节点
    GoodsType selectByHasChildren(Integer hasChildren);
    
    //List<GoodsType> findGoodsById(Integer goodTypeId);
}