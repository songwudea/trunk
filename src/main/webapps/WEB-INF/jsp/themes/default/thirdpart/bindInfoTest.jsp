<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/jspHead.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>绑定帐号</title>
<script type="text/javascript">

</script>
</head>
<body>

<div id="warpper">
<div id="login-warpper">
  <div id="login">
  <div class="logo"><a href="${ctx==""?"/":ctx}"><img src="${path}/images/logo.png" width="292" height="108" /></a></div>
<div class="errorbox">
    	<p><%@ include file="/common/formMessage.jsp" %></p>
    </div>
  <div class=mt>
<h2>与${source}账号绑定</h2></div>

     <form id = "form_name" name="form_name" method="post" class="simpleForm" onsubmit="return false;" >
        <ol>
          <li style="font-size:14px;">${userName}，您好！<br/>绑定后你可以通过${source}帐号登录瞳话，也可以使用这里设置的用户名密码进行登录<br/></li>
          <li>
            <label for="email">电子邮箱 </label>
            <input type="text"  id="email" name="email" value="" class="text"/>
          <span id="apiNicknameTip" class="red hint"> 邮箱用于登录</span></li>
          <li>
            <label for="password">密码</label>
            <input type="password"  id="password" name="password" value=""  class="text"/>
          <span  id="passwordTip" class="red hint"></span></li>
          <li class="buttons">
            <input type="image" name="toLoginBtn" id="toLoginBtn" src="${path}/images/butform.png" />
          </li>
      </ol>
      <div class="clr"></div>
    </form>

      
</div>
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
		   $("#apiNicknameTip").text('登录名不能为空');
           $("#apiNicknameTip").css("display", "");
       }else if(!emailValida.test(nickname)){
	   		 $("#apiNicknameTip").text('邮箱格式不正确');
            $("#apiNicknameTip").css("display", "");
	   }else if(password == ''){
       	   $("#passwordTip").text('登录密码不能为空');
           $("#passwordTip").css("display", "");
       }else if(password.length<6 || password.length>20){
	   		$("#passwordTip").text('密码6~20个字符');
           	$("#passwordTip").css("display", "");
	   }else{
       		if (nickname != '') {
            	var url  = "${ctx}/user/ajax/email.html";
            	$.get(
				url,
				{
					email:nickname
				},
				function(data){
					if(null!=data){
						if(data=="true"){
							document.forms[0].action="${ctx}/tp/${bianPage}Bind.html";
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