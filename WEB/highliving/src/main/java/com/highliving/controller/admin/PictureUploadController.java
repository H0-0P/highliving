package com.highliving.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.highliving.common.JsonUtils;
import com.highliving.service.admin.PictureUploadService;

/**
 * 上传图片处理
 */
@Controller
public class PictureUploadController {

	@Autowired
	private PictureUploadService pictureUploadService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile, HttpServletRequest request) {
		String savePath = request.getServletContext().getRealPath("img");
		Map result = pictureUploadService.uploadPicture(uploadFile, savePath);
		//为了保证功能的兼容性，需要把Result转换成json格式的字符串。
		String json = JsonUtils.objectToJson(result);
		return json;
	}
	
}
