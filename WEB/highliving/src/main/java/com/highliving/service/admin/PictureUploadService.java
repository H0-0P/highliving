package com.highliving.service.admin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.highliving.common.IDUtils;


/**
 * 图片上传服务
 */
@Service
public class PictureUploadService{
	
	public Map uploadPicture(MultipartFile uploadFile, String savePath) {
		Map resultMap = new HashMap<>();
		try {
			//生成一个新的文件名
			//取原始文件名
			//String oldName = uploadFile.getOriginalFilename();
			//生成新文件名
			//UUID.randomUUID();
			//String newName = IDUtils.genImageName();
			//newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//图片上传
			/*String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, 
					FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());*/
			// 文件名
			String fileName= uploadFile.getOriginalFilename();
			File file=new File(savePath, fileName);
			uploadFile.transferTo(file);
			resultMap.put("error", 0);
			resultMap.put("url", "http://192.168.8.2:8080/highliving/img/" + fileName);
			return resultMap;
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
	}

}
