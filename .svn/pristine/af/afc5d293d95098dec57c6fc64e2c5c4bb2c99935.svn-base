package com.babailiren.thirdpart.config;

import com.babailiren.thirdpart.qq.util.QqMd5Encrypt;

public final class Config {
		////////////////////////////////////////
		//////////////QQ的基本信息//////////////////////////
		////////////////////////////////////////
		// 合作身份者ID，以2088开头由16位纯数字组成的字符串
		public static final String QQ_APPID = "100290201";
		// 交易安全检验码，由数字和字母组成的32位字符串
		public static final String QQ_APPKEY = "80a425198ce2a8b746ae578fc34157aa";
		//qq登录授权的类型
		public static final String QQ_response_type="code";
		//qq登录授权登录的安全验证
		public static String QQ_state=QqMd5Encrypt.md5("test0209");
		// 返回的地址
		public static final String QQ_redirect_uri = "www.pretale.com/tpTest/qqLoginRegist.html";
		// 返回的地址
		public static final String QQ_redirect_uri_token = "www.pretale.com/tpTest/qqLoginRegist.html";
		public static final String QQ_GATEWAY_NEW = "https://graph.qq.com/oauth2.0/authorize?";
		public static final String QQ_GATEWAY_ACCESS_TOKEN_URL = "https://graph.qq.com/oauth2.0/token?";
		public static final String QQ_GATEWAY_ACCESS_OpenID = "https://graph.qq.com/oauth2.0/me?";
		public static final String QQ_GATEWAY_INFO = "https://graph.qq.com/user/get_user_info?";

		
		////////////////////////////////////////
		//////////////////SINA的基本信息/////////////////////
		////////////////////////////////////////
		// 合作身份者ID
		public static final String SINA_AppKey = "3275610904";
		// 交易安全检验码，由数字和字母组成的32位字符串
		public static final String SINA_AppSecret = "de9dd4fbf2fdaf96e6c04e8f230c405e";
		//qq登录授权登录的安全验证
		public static String SINA_state=QqMd5Encrypt.md5("test0209");
		// 返回的地址
		public static final String SINA_redirect_uri = "http://www.pretale.com/tpTest/sinaLoginRegist.html";
		public static final String SINA_GATEWAY_TOKEN = "https://api.weibo.com/oauth2/access_token?";
		public static final String SINA_GATEWAY_USER_INFO="https://api.weibo.com/2/users/show.json?";
		public static final String SINA_GATEWAY_LOGIN="https://api.weibo.com/oauth2/authorize?";
		
		
		////////////////////////////////////////
		///////////////ALIPAY的基本信息/////////////////////////
		////////////////////////////////////////
		// 合作身份者ID，以2088开头由16位纯数字组成的字符串
		public static String ALIPAY_partner = "2088801161035375";
		// 交易安全检验码，由数字和字母组成的32位字符串
		public static String ALIPAY_key = "fufn02kxvrbgt1z4doyz5ezagi34w7ub";
		// 签约支付宝账号或卖家收款支付宝帐户
		public static String ALIPAY_seller_email = "mylbbsw@126.com";
		// 支付宝服务器通知的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
		// 必须保证其地址能够在互联网中访问的到
		public static String ALIPAY_notify_url = "http://www.pretale.com/pay/alipay_return.html";
		// 当前页面跳转后的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
		// 域名不能写成http://localhost/trade_create_by_buyer_jsp_utf8/return_url.jsp ，否则会导致return_url执行无效
		public static String ALIPAY_return_url = "http://www.pretale.com/pay/pay_success.html";
		public static String ALIPAY_login_suss = "http://www.pretale.com/tpTest/AlipayLoginRegist.html";
		//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
		//http://www.pretale.com/pay/pay_success.html?buyer_email=13917102908&buyer_id=2088502801222774&exterface=trade_create_by_buyer&is_success=T&logistics_fee=1.00&logistics_payment=BUYER_PAY&logistics_type=EXPRESS&notify_id=RqPnCoPT3K9%252Fvwbh3I71kZl%252BMRbAtjIxWyFp5R7yQiJGsKbP8HZ7eCGEjseCZtmV2Y%252Bm&notify_time=2012-07-12+18%3A21%3A18&notify_type=trade_status_sync&out_trade_no=20120712182040&payment_type=1&receive_address=%E4%B8%8A%E6%B5%B7%E9%BB%84%E6%B5%A6%E5%8C%BA+%E6%88%91%E4%B9%9F%E4%B8%8D%E7%9F%A5%E9%81%93&receive_mobile=13917102908&receive_name=%E9%99%B6%E6%9D%B0&receive_phone=13917102908&receive_zip=200442&seller_email=mylbbsw%40126.com&seller_id=2088801161035375&subject=%E7%9E%B3%E8%AF%9D%E5%AE%98%E6%96%B9%E5%95%86%E5%9F%8E_001_00000001_2012_06&total_fee=2.00&trade_no=2012071276856877&trade_status=TRADE_FINISHED&sign=ec254fad2c18e5c84766fa1c71027927&sign_type=MD5
		// 调试用，创建TXT日志路径
		public static String ALIPAY_log_path = "/home/babailiren/pay_log/alipay_log_" + System.currentTimeMillis()+".txt";
		// 字符编码格式 目前支持 gbk 或 utf-8
		public static String ALIPAY_input_charset = "UTF-8";
		// 签名方式 不需修改
		public static String ALIPAY_sign_type = "MD5";
}
