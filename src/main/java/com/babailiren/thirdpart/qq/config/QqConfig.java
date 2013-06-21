package com.babailiren.thirdpart.qq.config;

import com.babailiren.thirdpart.qq.util.QqMd5Encrypt;


/**
 * 腾讯qq联合登录参数
 * @author Administrator
 *
 */
public class QqConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static final String APPID = "100290201";
	
	// 交易安全检验码，由数字和字母组成的32位字符串
	public static final String APPKEY = "80a425198ce2a8b746ae578fc34157aa";
	
	//qq登录授权的类型
	public static final String response_type="code";
	
	//qq登录授权登录的安全验证
	public static String state=QqMd5Encrypt.md5("test0209");
	// 返回的地址
	
	
	public static final String redirect_uri = "www.pretale.com/tp/qqReturn.html";
	// 返回的地址
	public static final String redirect_uri_token = "www.pretale.com/tp/qqReturn.html";

	
	
	//svn test
}
