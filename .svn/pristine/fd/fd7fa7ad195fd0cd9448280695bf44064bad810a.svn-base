package com.babailiren.ec.web.controller.admin;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babailiren.ec.model.Site;
import com.babailiren.ec.model.User;
import com.babailiren.ec.repository.Page;
import com.babailiren.ec.service.UserService;
import com.babailiren.ec.web.common.Pager;
import com.babailiren.ec.web.common.WebCache;
import com.babailiren.ec.web.vo.UserVo;

@Controller
@RequestMapping("/admin/user")
public class BackUserController {
	
	@Autowired
	private WebCache webCache;
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/user/index";
	}
	
	@RequestMapping(value = "list.html", method = RequestMethod.POST)
	public @ResponseBody
	String list(User user, Page<User> page, HttpServletRequest request,
			HttpServletResponse response) {
		page = userService.list(page, user);
		request.setAttribute("user", user);
		return new Pager<User>().getJsonPagerData(page);
	}
	
	
	@RequestMapping(value = "downuser.html", method = RequestMethod.POST)
	public @ResponseBody String downuser(User user, String site ,HttpServletRequest request,
			HttpServletResponse response) throws ParsePropertyException, InvalidFormatException, IOException {
		Site currentSite = webCache.getSiteByDomain(request.getSession().getServletContext(), site);
		String templateFileName = request.getSession().getServletContext().getRealPath("/downtemplate/User.xls");
		List<UserVo> userVo = userVo = userService.listVo(user);
		Map beans = new HashMap();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String datePath = dateFormat.format(new Date());
		String destFileName ="/downfile/"+ datePath +"user.xls";
		String downFileName = request.getSession().getServletContext().getRealPath(destFileName);
        beans.put("userdown", userVo);
        XLSTransformer transformer = new XLSTransformer();
        transformer.transformXLS( templateFileName, beans,downFileName);
        
       /* FileInputStream is = new FileInputStream(downFileName);
		byte[] buffer = new byte[is.available()];
		response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(downFileName, "UTF-8"));
		OutputStream os = new BufferedOutputStream(response.getOutputStream());
		// 下载窗体
		response.setContentType("application/octet-stream");
		int byteread = 0;
		while ((byteread = is.read(buffer)) != -1) {
			os.write(buffer, 0, byteread);
		}
		is.close();
		os.flush();
		os.close();*/
        return destFileName;
	}
	
	
	
}
