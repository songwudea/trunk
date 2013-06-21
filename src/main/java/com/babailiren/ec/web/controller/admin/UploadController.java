package com.babailiren.ec.web.controller.admin;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.babailiren.ec.common.FileUtils;
import com.babailiren.ec.web.common.Configuration;
import com.google.common.base.Joiner;
import com.google.gson.Gson;

@Controller
@RequestMapping("/admin/upload")
public class UploadController {

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String upload2(MultipartHttpServletRequest request,
			@RequestParam("pictitle") String pictitle // 页面上的控件值
	) throws Exception {
	
		UploadPic up = new UploadPic();
		
		if(pictitle.indexOf(".") != -1) {
			pictitle = pictitle.substring(0,pictitle.indexOf("."));
		}
		up.title = pictitle;
		MultipartFile files = request.getFile("picdata");
		up.originalFilename = files.getOriginalFilename();
		
		if (!files.isEmpty()) {
			String md5Hex = DigestUtils.md5DigestAsHex(files.getBytes());
			String substring = md5Hex.substring(0, Configuration.getImagePrefix());
			String ext = files.getOriginalFilename().substring(files.getOriginalFilename().lastIndexOf(".")+1);
			//flash会自动压缩PNG等格式成jpeg
			ext = "gif".equalsIgnoreCase(ext)?ext:"jpg";
			String filename = "source."+ext;

			FileUtils.save(files.getInputStream(), new File(Joiner.on("/").skipNulls().join(new String[]{Configuration.getImageSavepath(),substring,md5Hex,filename})));
			up.url = md5Hex+"."+ext;
			up.state = "SUCCESS";
		}
		return new Gson().toJson(up);
	}

	
	
	private class UploadPic {
		private String url;
		private String title;
		private String originalFilename;
		private String state;
	}
	
	
}
