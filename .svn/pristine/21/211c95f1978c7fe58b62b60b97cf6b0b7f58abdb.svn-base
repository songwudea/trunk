<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
<title>修改密码</title>
<base href="${path}/"/>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery_extend.js"></script>
<script type="text/javascript" src="${ctx}/js/messages_cn.js"></script>
<script type="text/javascript">
		function memberPass(){
			var oldPassword = $("#oldPassword").val();
			var newPassword = $("#newPassword").val();
			var newConPassword = $("#newConPassword").val();

			if(null == oldPassword || "" == oldPassword){
				$("#errorSpan").html("请输入旧密码!");
				return;
			}
			if(null == newPassword || "" == newPassword){
				$("#errorSpan").html("请输入新密码!");
				return;
			}
			if(null == newConPassword || "" == newConPassword){
				$("#errorSpan").html("请输入确认密码!");
				return;
			}
			if(newConPassword != newPassword){
		    	$("#errorSpan").html("两次输入的密码不一致!");
		    	return false;
			} 
			
			document.forms[0].submit();
			
		}
	</script>
<style>
</style>
</head>
<body>

<div id="warpper">
<div id="login-warpper">
  <div id="login">
  <div class="logo"><a href="${ctx==""?"/":ctx}"><img src="images/logo.png" width="292" height="108" /></a></div>
  
<div id="menu" style="width: 125px"><h2>我的瞳话</h2>
   
        <ul>
        
          <li><a class="current" href="${ctx}/user/modifyUser.html"><b>修改密码</b></a></li>
          <li><a class="current" href="${ctx}/user/order.html"><b>我的订单</b></a></li>
          <li><a class="current" href="${ctx}/user/address"><b>送货地址</b></a></li>
</ul></div>
  
<div class="sideContent_n ">

<div class="errorbox">
	    	<p><%@ include file="/common/formMessage.jsp" %></p>
	    </div>


	
		
	  <div class=mt>
	<h2>修改密码</h2></div>
	
	<form name="passform" action="${ctx}/user/modifyUser.html" method="post" class="simpleForm">
	
				<li><span id="errorSpan" style="color:#FF0000"></span></li>
	        <ol>
	          <li>
	            <label for="name">旧密码: </label>
	            <input type="password" id="oldPassword" name="oldPassword" class="text">
	          <span class="red hint"></span></li>
	          <li>
	            <label for="address ">新密码：</label>
	            <input type="password" id="newPassword" name="newPassword" class="text">
	          <span class="red hint"> </span></li>
	          <li>
	            <label for="zip">确认密码：</label>
	            <input type="password" id="newConPassword" name="newConPassword" class="text">
	            <span class="red hint"></span>
	          </li>

	
	          <li class="buttons">
	            <input type="image" name="imageField" id="imageField" src="${path}/images/butform.png" onclick="memberPass();return false"/>
	          </li>
	      </ol>
	      <div class="clr"></div>
	
	

	</form>


</div>
  
  
  


      
</div>
    </div>    

 
</div>

</body>
</html>
