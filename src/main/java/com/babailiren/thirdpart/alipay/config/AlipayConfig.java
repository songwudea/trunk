package com.babailiren.thirdpart.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.2
 *日期：2011-03-17
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”
	
 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088801161035375";
	
	// 交易安全检验码，由数字和字母组成的32位字符串
	public static String key = "fufn02kxvrbgt1z4doyz5ezagi34w7ub";
	
	// 签约支付宝账号或卖家收款支付宝帐户
	public static String seller_email = "mylbbsw@126.com";
	
	// 支付宝服务器通知的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
	// 必须保证其地址能够在互联网中访问的到
	public static String notify_url = "http://www.pretale.com/pay/alipay_return.html";
	
	// 当前页面跳转后的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
	// 域名不能写成http://localhost/trade_create_by_buyer_jsp_utf8/return_url.jsp ，否则会导致return_url执行无效
	public static String return_url = "http://www.pretale.com/pay/pay_success.html";
	
	public static String login_suss = "http://www.pretale.com/tp/alipayReturn.html";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	//http://www.pretale.com/pay/pay_success.html?buyer_email=13917102908&buyer_id=2088502801222774&exterface=trade_create_by_buyer&is_success=T&logistics_fee=1.00&logistics_payment=BUYER_PAY&logistics_type=EXPRESS&notify_id=RqPnCoPT3K9%252Fvwbh3I71kZl%252BMRbAtjIxWyFp5R7yQiJGsKbP8HZ7eCGEjseCZtmV2Y%252Bm&notify_time=2012-07-12+18%3A21%3A18&notify_type=trade_status_sync&out_trade_no=20120712182040&payment_type=1&receive_address=%E4%B8%8A%E6%B5%B7%E9%BB%84%E6%B5%A6%E5%8C%BA+%E6%88%91%E4%B9%9F%E4%B8%8D%E7%9F%A5%E9%81%93&receive_mobile=13917102908&receive_name=%E9%99%B6%E6%9D%B0&receive_phone=13917102908&receive_zip=200442&seller_email=mylbbsw%40126.com&seller_id=2088801161035375&subject=%E7%9E%B3%E8%AF%9D%E5%AE%98%E6%96%B9%E5%95%86%E5%9F%8E_001_00000001_2012_06&total_fee=2.00&trade_no=2012071276856877&trade_status=TRADE_FINISHED&sign=ec254fad2c18e5c84766fa1c71027927&sign_type=MD5

	// 调试用，创建TXT日志路径
	public static String log_path = "/home/babailiren/pay_log/alipay_log_" + System.currentTimeMillis()+".txt";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "UTF-8";
	
	// 签名方式 不需修改
	public static String sign_type = "MD5";

}
