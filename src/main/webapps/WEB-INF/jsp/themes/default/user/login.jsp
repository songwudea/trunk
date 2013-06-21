<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
<title>用户登录</title>
<base href="${path}/"/>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery_extend.js"></script>
<script type="text/javascript" src="${ctx}/js/messages_cn.js"></script>
<script type="text/javascript">

$(function(){
	$(":input").focus(function() {
		if($(this).parent().find("label.error").css("display")!=="inline") {
			$(this).parent().find("span.hint").show();
		}
	}).blur(function() {
		$(this).parent().find("span.hint").hide();
	});
});



$(function(){
$("#captchaimage").click(function(){
	$("#captchaimage").attr('src','${ctx}/captcha.jpg?'+Math.random());
});

$("#refresh").click(function(){
	$("#captchaimage").attr('src','${ctx}/captcha.jpg?'+Math.random());
	return false;
});

$("#loginForm").validate({
    onkeyup: false,
    focusInvalid: false,
    rules: {
        password: {
            required: true,
            rangelength: [6, 20]
        },
        email: {
            required: true,
            email: true
        },
		captcha: {
			required: true,
			remote: "${ctx}/user/ajax/captcha"
		}
    },
    messages: {
        password: {
            required: "密码必须填写",
            rangelength: "密码长度应为6到20"
        },
        email: {
            required: "请输入邮件地址",
            email: "请输入正确的邮件地址"
        },
        captcha: "请正确填写验证码，可点击验证码刷新"
    },

    errorPlacement: function(error, element) {
    	$(".errorbox P").html("");
        error.appendTo($(".errorbox P") );
    }
    
});
});


</script>

</head>
<body>
<form id="loginForm" method="post" action="${ctx}/user/login.html">
<input type="hidden" value="${url}" name="url" id="url" />
<div id="warpper">
<div id="login-warpper">
<div id="login">
<div class="logo"><a href="${ctx==""?"/":ctx}"><img src="images/logo.png" width="292" height="108" /></a></div>
<div class="sign_in">
<div class="zuo"><img src="images/login_img1.jpg" width="430" height="290" /></div>
<div class="you">
<div class="errorbox">
    	<p><%@ include file="/common/simpleMessage.jsp" %></p>
    </div>
<p class="first">
  	    <label for="email">用户账号 | Username</label>
        <input class="input" name="email" type="text" id="email" size="25" value="${email}"/>
</p>
      <p class="second">
	    <label for="password">用户密码 | Password</label>
	    <input class="input" name="password" type="password" id="password" size="25" />
	    </span></p>
        <div class="remember">
    <p><label for="captcha">验证码:</label></p>
    <input name="captcha" type="text" id="captcha" size="4" maxlength="4"/>
    <img id="captchaimage" src="${ctx}/captcha.jpg" title="点击刷新验证码"/> <span style="font-size:12px; margin-left:10px" ><a id="refresh" href="#">看不清楚?换一个</a></span>
   </div>
   <div class="submit">
   <input name="Login2" type="image" class="submitBtn" src="images/submit.png" align="middle"/>
   <span style="font-size:12px; margin:5px 0px 0px 10px; float:left; color:#009"><a href="${ctx}/user/forget.html">忘记密码？</a></span>
    <input name="Login" type="image" class="submitBtn2" src="images/submit2.png" align="middle" onclick="location = '${ctx}/user/register.html';return false"/>
    
   </div>
    <div class="accountbox">
   <p>
   <a href="${ctx}/tp/qqLogin.html"><img src="${path}/images/logon_qq.png"/></a>
   <a href="${ctx}/tp/alipayLogin.html"><img src="${path}/images/logon_zfb.png"/></a>
   </p>
   </div>
   
        </div>
        
</div>
 
</div>

</form>


</body>
</html>


	