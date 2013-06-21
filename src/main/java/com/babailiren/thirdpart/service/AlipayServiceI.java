package com.babailiren.thirdpart.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.babailiren.thirdpart.service.impl.ServiceImpl;


/**
 * 第三方登录的接口类
 * @author Administrator
 *
 */
public interface AlipayServiceI extends ServiceI{
	/**
	 * 拿到授权成功后的回调参数
	 */
	public Map getParameterMaps(HttpServletRequest request);
}
