package com.highliving.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.highliving.pojo.Result;
import com.highliving.utils.VerifyCode;

@Controller
public class VerifyCodeController {
	
	@RequestMapping(value = "/getVerifycode", method = RequestMethod.GET)
	public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException{
		response.setContentType("image/jpeg");
		Map<String, BufferedImage> map = VerifyCode.getMap();
		String code = VerifyCode.getCode(map);
		BufferedImage image = VerifyCode.getImage(map);
		//将code绑定到session
		request.getSession().setAttribute("code", code);
		
		//image可以压缩当做一个输出流
		OutputStream os = response.getOutputStream();
		
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
//		encoder.encode(image);
		ImageIO.write(image, "jpeg", os);
	}
	
	@RequestMapping(value = "/checkCode", method = RequestMethod.GET)
	@ResponseBody
	public Result CheckCode(HttpServletRequest request) throws IOException{
		String code1 = request.getParameter("code");
		//获得服务器生成的code值
		String code2 = (String) request.getSession().getAttribute("code");
		if(code1.equals(code2)){
			return new Result(1, "success");
		} else{
			return new Result(0, "error");
		}
	}
	
}

