package com.babailiren.thirdpart.service;

import java.util.Map;

import com.babailiren.thirdpart.service.impl.ServiceImpl;


/**
 * 第三方登录的接口类
 * @author Administrator
 *
 */
public interface ServiceI {
	/**
	 * 构造第三方登录的请求页面
	 * @return
	 */
	public  String sbHtml(); 
	
	/**
	 * 构造地方三登录返回信息的URL
	 * @return
	 */
	public  String actionUrl(Map<String, String> sParam);
	
	/**
	 * 登录授权成功后回调url
	 */
	public String actionReturnUrl(Map<String, String> sParam);
}
