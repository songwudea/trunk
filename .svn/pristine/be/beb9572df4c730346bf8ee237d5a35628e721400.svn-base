package com.babailiren.ec.web.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.babailiren.ec.sendsms.SendSmsI;
import com.babailiren.ec.sendsms.impl.SendSmsImpl;
import com.babailiren.ec.web.common.WebCache;

@Controller
@RequestMapping("/admin/senderpm")
public class SenderPmController {
	
	@Autowired
	private WebCache webCache;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		return "admin/senderpm/index";
	}
	@RequestMapping(value="sendsms.html", method = RequestMethod.POST)
	public String sendsms(HttpServletRequest request,String site,String phone,String content) {
		Map<String , String> sendParams = new HashMap<String, String>();
		sendParams.put("phone", phone);
		sendParams.put("content", content);
		SendSmsI sendSmsI = new SendSmsImpl();
		String result = sendSmsI.sendSMSEXI(sendParams);
		if (result != null && !"".equals(result)) {
			String results = StringUtils.substringBetween(result, "<result>","</result>");
			if ("0".equals(results)) {
				request.setAttribute("message", "短信发送成功！");
				return "admin/senderpm/index";
			}else{
				request.setAttribute("message", "短信发送失败！");
				return "admin/senderpm/index";
			}
		}
		return "admin/senderpm/index";
	}
	
	
	@RequestMapping(value="recvsms.html", method = RequestMethod.POST)
	public String recvsms(HttpServletRequest request,String site,String phone,String content) {
		/*String result = sinaService.sendSMSEXI(sendParams);
		if (result != null && !"".equals(result)) {
			String results = StringUtils.substringBetween(result, "<result>","</result>");
			if ("0".equals(results)) {
				request.setAttribute("message", "短信发送成功！");
				return "admin/senderpm/index";
			}else{
				request.setAttribute("message", "短信发送失败！");
				return "admin/senderpm/index";
			}
		}*/
		return "admin/senderpm/index";
	}
	/*public static void main(String[] args) {
		String s1=PasswordManager.md5("16576447");
		String s2=DigestUtils.md5Hex(getContentBytes("16576447", AlipayConfig.input_charset));
		System.out.println(s1.equals(s2));
		System.out.println(s1);
	}
	private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }

        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }*/

}
