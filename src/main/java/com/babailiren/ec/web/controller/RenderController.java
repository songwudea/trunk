package com.babailiren.ec.web.controller;

import static net.coobird.thumbnailator.geometry.Positions.BOTTOM_RIGHT;
import static net.coobird.thumbnailator.geometry.Positions.CENTER;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.web.common.Configuration;
import com.google.common.base.Joiner;
@Controller
@RequestMapping("/img")
public class RenderController {

	@RequestMapping(value = "{md5}/{watermark}/{resolution}.{suffix}", method = RequestMethod.GET)
	//@ResponseBody
	public ResponseEntity<byte[]> render(HttpServletResponse response,@PathVariable Integer watermark,@PathVariable String md5,@PathVariable String resolution,@PathVariable String suffix) throws Exception {
		final String path = Configuration.getImageSavepath();
		String substring = md5.substring(0, Configuration.getImagePrefix());
		final HttpHeaders headers = new HttpHeaders();
		
		MediaType type = MediaType.IMAGE_JPEG;
		if("gif".equalsIgnoreCase(suffix)) {
			type = MediaType.IMAGE_GIF;
		}
		headers.setContentType(type);
		//读取已生成的文件
		File cacheFile = new File(Joiner.on("/").join(new String[]{path,substring,md5,String.valueOf(watermark),resolution+"."+suffix}));
		if(cacheFile.exists()) {
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(cacheFile), headers, HttpStatus.CREATED);
		}
		
	    
	    String file = Joiner.on("/").join(new String[]{path,substring,md5,"source."+suffix});
		if(resolution == null) {
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(file)), headers, HttpStatus.CREATED);
		} else {
			int[] wh = getWH(resolution);
			int toWidth = wh[0];
			int toHeight = wh[1];
			if(toWidth > Configuration.getImageMaxWidth()) {
				//输出图片大小超出系统设定
				response.setStatus(404);
				return null;
			}
			
			ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
			BufferedImage read = ImageIO.read(new FileInputStream(file));
			int width = read.getWidth();
			int height = read.getHeight();

			//原图宽高比
			double o_r = new Double(width) / new Double(height);
			//期望宽高比
			double to_r = new Double(toWidth) / new Double(toHeight);
			//纵向缩减的图按高度算比值
			double r = o_r > to_r?new Double(height) / new Double(toHeight):new Double(width) / new Double(toWidth);
			
			int clipHeight = Double.valueOf(toHeight * r).intValue(); 
			int clipWidth = Double.valueOf(toWidth * r).intValue();
			
			Builder<File> builder = Thumbnails.of(file).sourceRegion(CENTER,clipWidth,clipHeight).size(toWidth, toHeight).outputFormat(suffix);
	        if(watermark == 1) {
				builder.watermark(BOTTOM_RIGHT, ImageIO.read(new File("watermark.gif")), 0.5f);
	        }

			builder.toOutputStream(out);
			out.close();
			if(Configuration.isImageSaveThumb()) {
				File f = new File(Joiner.on("/").skipNulls().join(new String[]{path,substring,md5,String.valueOf(watermark),resolution+"."+suffix}));
				com.babailiren.ec.common.FileUtils.mkdir(f);
				System.out.println(f);
				builder.toFile(new File(Joiner.on("/").skipNulls().join(new String[]{path,substring,md5,String.valueOf(watermark),resolution+"."+suffix})));
			}
			return new ResponseEntity<byte[]>(out.toByteArray(), headers, HttpStatus.CREATED);
		}

	}
	
	@RequestMapping(value = "{md5}/{resolution}.{suffix}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> render(HttpServletResponse response,@PathVariable String md5,@PathVariable String resolution,@PathVariable String suffix) throws Exception {
		return render(response,0,md5,resolution,suffix);
	}
	
	@RequestMapping(value = "{md5}.{suffix}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> render(HttpServletResponse response,@PathVariable String md5,@PathVariable String suffix) throws Exception {
		return render(response,0,md5,null,suffix);
	}
			
	@RequestMapping(value = "default/{resolution}.jpg", method = RequestMethod.GET)
	@ResponseBody
	public byte[] render(@PathVariable String resolution) throws Exception {
		File file = new File("default.jpg");
		int[] wh = getWH(resolution);
		ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
		Builder<File> outputFormat = Thumbnails.of(file).size(wh[0], wh[1]).outputFormat("jpg");
		outputFormat.toOutputStream(out);
		out.close();
		return out.toByteArray();
	}
	
	
	private int[] getWH(String resolution) {
		//String[] split = resolution.split("/D");
		//生成的图片格式可能需要存储，因此限定必须用小写x分割
		String[] split = resolution.split("x");
		if(split.length == 1) {
			return new int[] {Integer.valueOf(split[0]),Integer.valueOf(split[0])};
		} else {
			return new int[] {Integer.valueOf(split[0]),Integer.valueOf(split[1])};
		}
	}
	

}
