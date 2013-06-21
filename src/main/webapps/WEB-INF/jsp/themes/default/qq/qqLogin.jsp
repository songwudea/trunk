<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qq.service.*"%>
<%@ page import="com.alipay.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>腾讯QQ快捷登录接口</title>
		
	</head>
	<body>
	<%    
		
		//生成请求URL
		String sHtmlText = QqService.get_user_info();
		out.println(sHtmlText);
		
	%>
	</body>
	
</html>