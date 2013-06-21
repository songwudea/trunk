<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
<title>找回密码</title>
<base href="${path}/"/>
<meta name="decorator" content="${current_site.template.path}" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery_extend.js"></script>
<script type="text/javascript" src="${ctx}/js/messages_cn.js"></script>
<script type="text/javascript">


$(function(){
	
	$("#forgetForm").submit(function(){
		var mail = $('#username').val();
		$.post('${ctx}/user/forget.html',{username: mail},function(data){
	    	$(".errorbox P").html("").html(data);
        });
		return false;
	});

	$("#captchaimage").click(function(){
		$("#captchaimage").attr('src','${ctx}/captcha.jpg?'+Math.random());
	});
	$("#forgetForm").validate({
	    onkeyup: false,
	    focusInvalid: false,
	    rules: {
	        username: {
	            required: true,
	            email: true,
	            remote: "${ctx}/user/ajax/email"
	        },
			captcha: {
				required: true,
				remote: "${ctx}/user/ajax/captcha"
			}
	    },
	    messages: {
	        username: {
	            required: "请填写您注册时使用的Email地址",
	            email: "请输入一个正确的Email地址"
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
<style>
</style>
</head>
<body>

	
<div id="warpper">
<div id="login-warpper">
<div id="login">
<div class="logo"><a href="${ctx==""?"/":ctx}"><img src="images/logo.png" width="292" height="108" /></a></div>

<div class="errorbox">
<p><%@ include file="/common/simpleMessage.jsp" %></p>
</div>

  <div class=mt>
<h2>找回密码</h2></div>

<form id="forgetForm" method="post" action=""  class="simpleForm">



	
        <ol>
        <li style="font-size: 16px;">
			请填写您注册是使用的电子邮箱地址，我们会通过邮件发送密码到您的邮箱中。
          </li>
          <li>
            <label for="email">电子邮箱</label>
            <input type="input" name="username" id="username" class="text">
          </li>
          <li>
            <label for="captcha">验证码</label>
            
            <input id="captcha" name="captcha" class="text" style="width:60px"/>
            <img id="captchaimage" src="${ctx}/captcha.jpg" title="点击刷新验证码" /></li>
          <li >
          <input type="submit" style="padding: 3px 10px;background-color:buttonface;border: 1px outset buttonface" value="找回密码"/>
          </li>
      </ol>
</form>

</div>
</div>
</div>

</body>
</html>
