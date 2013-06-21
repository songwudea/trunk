<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
<title>完成注册</title>
<meta http-equiv="Refresh" content="3;url=${ctx==""?"/":ctx}">
<base href="${path}/"/>
<meta name="decorator" content="${current_site.template.path}" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery_extend.js"></script>
<script type="text/javascript" src="${ctx}/js/messages_cn.js"></script>


</head>
<body>
	
<div id="warpper">
<div id="login-warpper">
  <div id="login">
  <div class="logo"><a href="${ctx==""?"/":ctx}"><img src="images/logo.png" width="292" height="108" /></a></div>



<table width="100%" class="simpleTable">

	<tr>
		<td style="padding: 20px;line-height:150%">
<img src="images/ico1.gif"  style="float:left"><div style="margin-left:20px;font: 16px 微软雅黑;line-height:50px;float:left">您好！${USER_NAME} 感谢您注册成为瞳话会员</div><br/>

<div style="clear:both;margin-left: 66px">
您的账号：${USER_EMAIL}<br/>
您已完成注册，并登录瞳话官方商城，稍后为您转到首页<p/>
您也可以直接访问以下链接<p/>
<a href="${ctx}/eyes/heiyanquan.html" style="float:left;display:block;width: 100px;height:22px ;line-height:22px;background-color:#3164AF;margin:5px 0px;text-align:center;color:white" onmouseover="this.style.backgroundColor = '#5E82C9'" onmouseout="this.style.backgroundColor = '#3164AF'">瞳话产品</a>
<a href="${ctx==""?"/":ctx}" style="float:left;display:block;width: 100px;height:22px ;line-height:22px;background-color:#3164AF;margin:5px 20px;text-align:center;color:white" onmouseover="this.style.backgroundColor = '#5E82C9'" onmouseout="this.style.backgroundColor = '#3164AF'">瞳话首页</a><p/>


</div>
		</td>
		
	</tr>


</table>
</div>
    </div>    

 
</div>

<script>
var _BBLRSID = "${USER_EMAIL}";
var _BBLRType = "用户注册";
</script>
</body>
</html>
