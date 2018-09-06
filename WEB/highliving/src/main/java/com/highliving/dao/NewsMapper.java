package com.highliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.highliving.pojo.News;
@Repository
public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsid);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsid);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
    
    List<News> findAll();
    
    List<News> findLastestNews();
}