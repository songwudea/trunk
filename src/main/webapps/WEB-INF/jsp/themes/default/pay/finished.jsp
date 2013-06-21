<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
<title>完成付款</title>
<base href="${path}/"/>
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
	<tr class="th">
		<td>完成付款</td>
		
	</tr>
	<tr>
		<td>${message}</td>
		
	</tr>


</table>
</div>
    </div>    

 
</div>
<script>
var _BBLRSID = "${orderId}"; 
var _BBLRType = "支付完成"; 
var _BBLRAmount = "${amount}"; 
var _BBLRCurrency = "CNY"; 
</script>


</body>
</html>
