package com.highliving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highliving.dao.PicturesMapper;
import com.highliving.pojo.Pictures;

@Service
public class PictureService {
	
	@Autowired
	private PicturesMapper picturesMapper;
	
	/*
	 * 根据goodId查图片
	 */
	public List<Pictures> findPicsByGoodId(String goodId) {
		return picturesMapper.findByPicsGoodId(goodId);
	}
	
	/*
	 * 根据good删除
	 */
	public void deletePicByGoodId(String goodId) {
		picturesMapper.deletePicByGoodId(goodId);
	}
}
