<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.alipay.services.*"%>
<%@ page import="com.alipay.util.*"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://service.zol.com.cn/user/version2011/css/all.css" rel="stylesheet" type="text/css" />

<title>绑定页</title>
<script type="text/javascript">

</script>
</head>
<body>
<div class="div_body">
  <div class="head"> <span>与sina账号绑定</span> <a href="http://www.pretale.com/" title="瞳话官方商城">
  </a> </div>
  <!--end head-->
  <div class="user">
    <p class="p_1">${QqUserInfoVo.nickname}，您好！</p>
    <p class="p_2">欢迎通过"与sina账号连接"来到瞳话官方商城！</p>
  </div>
  <div class="login_name bor_bot">
    <form id = "form_name" name="form_name" method="post" theme="simple" onsubmit="return false;" >
      <p class="p_3">没有瞳话帐号？设置一个邮箱登录名直接登录：</p>
      <p class="p_4"><span>登录名：</span>
        <input type="text"  class="text_1" id="email" name="email" value=""  alt="请设置您常用的邮箱地址.." autocomplete="off" />
        <em class="ts" id="apiNicknameTip" style="display:none;">
        	<em class="l"></em>
        	<em class="m">该帐号已经注册过，请尝试更换一个帐号</em> 
        	<em class="r"></em>
        </em>
      </p>
      
      <p class="p_5">（只能是邮箱地址..）</p>
      <p class="p_4">  <span>登录密码：</span>
        <input type="password"  class="text_1" id="password" name="password" value=""   autocomplete="off" />
        <em class="ts" id="passwordTip" style="display:none;">
        	<em class="l"></em>
        	<em class="m">密码不能为空</em> 
        	<em class="r"></em>
        </em>
      </p>
      <p class="p_6">
        <input name="toLoginBtn" id="toLoginBtn" type="submit" value="直接登录" class="login_btn">
        <input id="ctxContent" name="ctxContent" type="text" value="${ctx}" style="display:none;" />
       </p>
    </form>
  </div>
  
  
</div>
<script type="text/javascript">
$(function() {
   $("#toLoginBtn").click(function() {
	   $("#email").focusout();
	   var ctx=$("#ctxContent").val();
	   var nickname = $("#email").val();
	   var password = $("#password").val();
	   var emailValida=/^(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\-+)|([A-Za-z0-9]+\.+)|([A-Za-z0-9]+\++))*[A-Za-z0-9]+@((\w+\\-+)|(\w+\.))*\w{1,63}\.[a-zA-Z]{2,6}$/;

	   if (nickname == '') {
		   $("#apiNicknameTip .m").text('登录名不能为空');
           $("#apiNicknameTip").css("display", "");
       }else if(!emailValida.test(nickname)){
	   		 $("#apiNicknameTip .m").text('邮箱格式不正确');
            $("#apiNicknameTip").css("display", "");
	   }else if(password == ''){
       	   $("#passwordTip .m").text('登录密码不能为空');
           $("#passwordTip").css("display", "");
       }else if(password.length<6 || password.length>20){
	   		$("#passwordTip .m").text('密码6~20个字符');
           	$("#passwordTip").css("display", "");
	   }else{
       		if (nickname != '') {
            	var url  = "http://www.pretale.com/user/ajax/email.html";
            	$.get(
				'http://www.pretale.com/user/ajax/email.html',
				{
					email:nickname
				},
				function(data){
					if(null!=data){
						if(data=="true"){
							document.forms[0].action="http://www.pretale.com/user/sinaLoginRegist.html";
							document.forms[0].submit();
						}else if(data=="false"){
							alert("此邮箱名已经被注册了");
							return;
						}
					}
				}
			);
        }
       }
       if ($("#apiNicknameTip").css("display") != 'none') {
            return false;
       }
       var nickname = $("#apiNickname").val();
   });
})


</script>

</body>
</html>