<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
<title>修改个人信息</title>
<base href="${path}/"/>
<meta name="decorator" content="${current_site.template.path}" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery_extend.js"></script>
<script type="text/javascript" src="${ctx}/js/messages_cn.js"></script>
<link type="text/css" rel="stylesheet" href="${ctx}/themes/tonghua/js/jscalendar/css/calendar.css" />
<script type="text/javascript" src="${ctx}/themes/tonghua/js/jscalendar/script/calendar.js"></script>
<script type="text/javascript">
$(function(){
	$('#birthday').click(function(){
		var imagepath = "${path}/js/jscalendar/dataImages/";
		displayCalendar(this,'yyyy-mm-dd', this, false, '',imagepath);
	});
});
</script>

<script type="text/javascript">
		function memberPass(){
			var name = $("#name").val();
			var mobilen = $("#mobile").val();
			var birth = $("#birthday").val();
			var oldPassword = $("#password").val();
			var newPassword = $("#newPassword").val();
			var newConPassword = $("#newConPassword").val();
			if(null == name || "" ==  name){
				$("#errorSpan").html("请输入真实姓名!");
				return ;
			}
			if(null == birth || "" == birth){
				$("#errorSpan").html("请输入您的生日!");
				return ;
			}
			if(null == mobilen || "" == mobilen){
				$("#errorSpan").html("请输入联系电话!");
				return ;
			}
			if("" != oldPassword){
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
        
          <li><a class="current" href="${ctx}/user/modifyUser.html"><b>个人信息</b></a></li>
          <li><a class="current" href="${ctx}/user/order.html"><b>我的订单</b></a></li>
          <li><a class="current" href="${ctx}/user/address"><b>送货地址</b></a></li>
          <c:if test="${IF_DEMAND == 0}">
	          <li><a class="current" href="${ctx}/user/demandnote.html"><b>索取小样</b></a></li>
          </c:if>
</ul></div>
  
<div class="sideContent_n ">

<div class="errorbox">
	    	<p><%@ include file="/common/formMessage.jsp" %></p>
	    </div>


	
		
	  <div class=mt>
	<h2>个人信息</h2></div>
	
	<form name="passform" action="${ctx}/user/modifyUser.html" method="post" class="simpleForm">
		
				<li><span id="errorSpan" style="color:#FF0000"></span></li>
	        <ol>
	        	<li>
	            <label for="name">用户名 :</label>
	            <input type="text"  value="${user.username}" class="text" disabled="disabled"> 
	          <span class="red hint"></span></li>
	          <li>
	            <label for="name">真实姓名: </label>
	            <input type="text" id="name" name="name" value="${user.name}" class="text">
	          <span class="red hint"></span></li>
	          <li>
	            <label for="name">性别:</label>
	       		<input type="radio" class="radio" id="gender" <c:if test="${user.gender == 'MALE'}">checked="true"</c:if>  name="gender" value="MALE">
					男
		 		</input>			      
				<input type="radio" class="radio" id="gender" <c:if test="${user.gender == 'FEMALE'}">checked="true"</c:if> name="gender" value="FEMALE">
					女
				</input>
	            <span class="red hint"></span>
	          </li>
	          <li>
	            <label for="name">生日: </label>
	            <input type="text" id="birthday" name="birthday" value="<fmt:formatDate value="${user.birthday}" type="both" pattern="yyyy-MM-dd" />" class="text" >
	          <span class="red hint"></span></li>
	           <li>
	            <label for="name">联系电话: </label>
	            <input type="text" id="mobile" name="mobile" value="${user.mobile}" class="text">
	          <span class="red hint"></span></li>
	          <li>
	            <label for="name">旧密码: </label>
	            <input type="password" id="password" name="password" class="text">
	          <span class="red hint">*不修改密码请保持为空！</span></li>
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
