package com.highliving.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.highliving.pojo.News;
import com.highliving.service.NewsService;

@RequestMapping("/news")
@RestController
public class NewsController {
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value="/detail",method = RequestMethod.GET)
	public News findNews(@RequestParam Integer id) {
		News news = newsService.selectNews(id);
		if(news == null) {
			throw new NullPointerException();
		}
		return 	news;
	}
	
	@RequestMapping(value="/indexlist")
	public List<News> findLastestNews(){
		return newsService.findLastestNews();
	}
}
