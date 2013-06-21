package com.babailiren.thirdpart.qq.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.babailiren.ec.model.Site;
import com.babailiren.ec.web.common.WebUtils;
import com.babailiren.thirdpart.config.Config;
import com.babailiren.thirdpart.qq.config.QqConfig;
import com.babailiren.thirdpart.qq.vo.QqInfoOpenIdVo;
import com.babailiren.thirdpart.qq.vo.QqUserInfoVo;
import com.babailiren.thirdpart.service.ServiceI;
import com.babailiren.thirdpart.service.impl.ServiceImpl;
import com.google.gson.Gson;

public class QqServiceTest implements ServiceI {
	private ServiceImpl impl=new ServiceImpl();
	@Override
	public String sbHtml() {
		// 把请求参数打包成数组
		String scope = "get_user_info";
		String state = "test";
		String display = "";
		String g_ut = "2";
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("scope", scope);
		sParaTemp.put("state", state);
		sParaTemp.put("display", display);
		sParaTemp.put("g_ut", g_ut);
		sParaTemp.put("client_id", Config.QQ_APPID);
		sParaTemp.put("redirect_uri", Config.QQ_redirect_uri);
		sParaTemp.put("response_type", Config.QQ_response_type);
		sParaTemp.put("state", Config.QQ_state);
		String actionUrl=actionUrl(sParaTemp);
		 String sbHtml=impl.buildForm(sParaTemp, actionUrl,"post");
		return sbHtml;
	}

	@Override
	public String actionUrl(Map<String, String> sParaTemp) {
		StringBuffer action_url = new StringBuffer();
		List<String> keys = new ArrayList<String>(sParaTemp.keySet());
		action_url.append(Config.QQ_GATEWAY_NEW);
		for (int i = 0; i < keys.size(); i++) {
			String name = (String) keys.get(i);
			String value = (String) sParaTemp.get(name);
			action_url.append(name);
			action_url.append("=");
			action_url.append(value);
			if (i == keys.size() - 1) {
			} else {
				action_url.append("&");
			}
		}
		return action_url.toString();
	}
	
	
	

	 @Override
	public String actionReturnUrl(Map<String, String> sParaTemp) {
		 StringBuffer action_url = new StringBuffer();
			List<String> keys = new ArrayList<String>(sParaTemp.keySet());
			action_url.append(Config.QQ_GATEWAY_NEW);
			for (int i = 0; i < keys.size(); i++) {
				String name = (String) keys.get(i);
				String value = (String) sParaTemp.get(name);
				action_url.append(name);
				action_url.append("=");
				action_url.append(value);
				if (i == keys.size() - 1) {
				} else {
					action_url.append("&");
				}
			}
			return action_url.toString();
	}

}
