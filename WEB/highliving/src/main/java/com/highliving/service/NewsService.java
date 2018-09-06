package com.highliving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highliving.dao.NewsMapper;
import com.highliving.pojo.News;

@Service
public class NewsService{
	@Autowired
	private NewsMapper newsMapper;
	public int deleteNews(Integer newsid) {
		return newsMapper.deleteByPrimaryKey(newsid);
	}

	public int insertNews(News record) {
		return newsMapper.insert(record);
	}

	public int insertNewsSelective(News record) {
		return newsMapper.insertSelective(record);
	}

	public News selectNews(Integer newsid) {
		News news = newsMapper.selectByPrimaryKey(newsid);
		String path = "http://192.168.8.2:8080/highliving/img/"+news.getNewspicpath();
		news.setNewspicpath(path);
		return news;
	}

	public int updateNewsSelective(News record) {
		return newsMapper.updateByPrimaryKeySelective(record);
	}
	public int updateNews(News record) {
		return newsMapper.updateByPrimaryKey(record);
	}
	
	public List<News> findLastestNews() {
		List<News> list = newsMapper.findLastestNews();
		for (News news : list) {
			String path = "http://192.168.8.2:8080/highliving/img/"+news.getNewspicpath();
			news.setNewspicpath(path);
		}
		return list;
	}

}
