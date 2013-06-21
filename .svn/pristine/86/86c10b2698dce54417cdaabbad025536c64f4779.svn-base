<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
<title>用户注册</title>
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
$("#registerForm").validate({
    onkeyup: false,
    focusInvalid: false,
    rules: {
        name: {
            required: true,
            byteRangeLength: [4, 20],
            userNameCheck: true
        },
        password: {
            required: true,
            rangelength: [6, 20]
        },
        confirmPassword: {
            required: true,
            equalTo: "#password"
        },
        email: {
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
        name: {
            required: "请填写姓名，4到20个字符",
            byteRangeLength: "姓名长度应为4到20个字符"
        },
        password: {
            required: "密码必须填写",
            rangelength: "密码长度应为6到20"
        },
        confirmPassword: {
            required: "确认密码必须填写",
            equalTo: "必须和密码一致"
        },
        email: {
            required: "请输入邮件地址",
            email: "请输入正确的邮件地址",
            remote: "该E-Mail地址已注册"
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
.hint {display: none;padding-left:5px}

</style>
</head>
<body>

<div id="warpper">
<div id="login-warpper">
  <div id="login">
  <div class="logo"><a href="${ctx==""?"/":ctx}"><img src="images/logo.png" width="292" height="108" /></a></div>
<div class="errorbox">
    	<p><%@ include file="/common/formMessage.jsp" %></p>
    </div>
  <div class=mt>
<h2>注册新用户</h2></div>

     <form id="registerForm" method="post" action=""  class="simpleForm">
        <ol>
          <li>
            <label for="email">电子邮箱 </label>
            <input id="email" name="email" class="text" />
          <span class="red hint"> 邮箱用于登录</span></li>
          <li>
            <label for="name">姓名</label>
            <input id="name" name="name" class="text" />
          <span class="red hint"> 可填写姓名或昵称</span></li>
          <li>
            <label for="password ">密码</label>
            <input type="password" id="password" name="password" class="text" />
          <span class="red hint"> 密码需由6-20个字符组成</span></li>
          <li>
            <label for="confirmPassword">确认密码</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="text" />
            <span class="red hint">请再次输入密码</span>
          </li>
          <li>
            <label for="captcha">验证码</label>
            
            <input id="captcha" name="captcha" class="text" style="width:60px"/>
            <img id="captchaimage" src="${ctx}/captcha.jpg" title="点击刷新验证码" /><span class="red hint">输入验证码，如看不清可点击验证码换一张</span></li>
          <li class="buttons">
            <input type="image" name="imageField" id="imageField" src="${path}/images/butform.png" />
          </li>
      </ol>
      <div class="clr"></div>
    </form>

      
</div>
    </div>    

 
</div>
</body>
</html>
