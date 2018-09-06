package com.highliving.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.highliving.pojo.Collections;
import com.highliving.pojo.Result;
import com.highliving.pojo.UserInfo;
import com.highliving.service.CollectionsService;
import com.highliving.service.GoodsService;

@RestController
@RequestMapping("/collections")
public class CollectionController {
	@Autowired
	private CollectionsService collectionsService;
	@Autowired
	private GoodsService goodservice;
	
	/*@RequestMapping(value="/collect/{userId}",method=RequestMethod.GET)
	public List<Collections> findByUserId(@PathVariable Integer userId){
		System.out.println(userId);
		List<Collections> list = collectionsService.findByUserId(userId);
		return list;
	}
	
	@RequestMapping(value="/collectCount/{userId}",method=RequestMethod.GET)
	public int findCountByUserId(@PathVariable Integer userId) {
		return collectionsService.findCountByUserId(userId);
	}
	
	@RequestMapping(value="/collectById/{collectId}",method=RequestMethod.GET)
	public Collections findById(@PathVariable Integer collectId) {
		System.out.println(collectionsService.findById(collectId));
		return collectionsService.findById(collectId);
	}*/
	
	/*
	 * 加入收藏夹
	 */
	@RequestMapping(value="/addToCollection")
	public Result addToCollection(@RequestParam String goodid, HttpServletRequest request) {
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
		Integer userid = user.getUserid();
		
		// 先查看收藏的商品是否已经存在
		List<Collections> collections = collectionsService.findByUserId(userid);
		for(int i = 0; i < collections.size(); i++) {
			if(collections.get(i).getGoodid().equals(goodid)) {
				return new Result(1, "已加入收藏");
			}
		}
		// 如果收藏的商品不存在，则插入一条记录
		Collections collection = new Collections();
		collection.setGoodid(goodid);
		collection.setUserid(userid);
		int line = collectionsService.insert(collection);
		if (line > 0) {
			return new Result(1, "已加入收藏");
		} else {
			return new Result(0, "加入收藏失败");
		}
	}
	
	
	@RequestMapping(value="/getCollection/{userId}", method=RequestMethod.GET)
	public PageInfo<Collections> findCollectionByUserId(@PathVariable Integer userId,int pageNum,int pageSize){
		
		PageHelper.startPage(pageNum, pageSize);
		String defaultPic;	
		
		List<Collections> collections = collectionsService.findByUserId(userId);
		//设置默认图片
		for(int i = 0; i < collections.size(); i++) {
			defaultPic = collections.get(i).getGoods().getDefaultpic();
			String picPath="http://192.168.8.2:8080/highliving/img/"+ defaultPic;
			collections.get(i).getGoods().setDefaultpic(picPath);
		}
		PageInfo<Collections> pageInfo = new PageInfo<>(collections);
		return pageInfo;
	}

	/**
	 * 删除收藏
	 */
	@RequestMapping(value="/deleteCollection/{userid}/{goodid}")
	public int delete(@PathVariable("userid") Integer userid, @PathVariable("goodid") String goodid) {
		int result = collectionsService.deleteCollection(userid, goodid);
		if(result == 1) {
			return 1;
		}else {
			return 0;
		}
	}

}
