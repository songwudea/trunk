package com.babailiren.thirdpart.sina.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.babailiren.thirdpart.config.Config;
import com.babailiren.thirdpart.service.ServiceI;
import com.babailiren.thirdpart.service.impl.ServiceImpl;
import com.babailiren.thirdpart.sina.config.SinaConfig;


public class SinaServiceTest implements ServiceI {
	private ServiceImpl impl=new ServiceImpl();
	/**
     * 返回sina授权请求的表单元素
     */
	@Override
	public String  sbHtml() {
		 //生成请求的路径
		String code="";
    	Map<String, String> sParaTemp =new HashMap<String, String>();
    	 sParaTemp.put("client_id", Config.SINA_AppKey);
         sParaTemp.put("redirect_uri",Config.SINA_redirect_uri);
         sParaTemp.put("response_type",code);
         sParaTemp.put("state", "zq0209");
         sParaTemp.put("display", "default");
         sParaTemp.put("language", "");
         String actionUrl=actionUrl(sParaTemp);
         String sbHtml=impl.buildForm(sParaTemp, actionUrl,"post");
        return sbHtml;
	}
	/**
     *返回sina授权的表单请求的action
     */
	@Override
	public String actionUrl(Map<String, String> sParam) {
		StringBuffer action_url=new StringBuffer();
        List<String> keys = new ArrayList<String>(sParam.keySet());
        action_url.append(Config.SINA_GATEWAY_LOGIN);
   	 	for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sParam.get(name);
            action_url.append(name);
            action_url.append("=");
            action_url.append(value);
            if (i==keys.size()-1) {				
			}else{
				action_url.append("&");
			}
        }
       return action_url.toString();
	}
	
	 @Override
	public String actionReturnUrl(Map<String, String> sParam) {
		// TODO Auto-generated method stub
		return null;
	}
}
