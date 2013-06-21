<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
<title>完成付款</title>
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
<div class="logo"><a href="${ctx==""?"/":ctx}"><img src="${path}/images/logo.png" width="292" height="108" /></a></div>

	<div class="flow_step_no3 flow_cart">
		<div class="flow_step">
			<ol class="cols3">
				<li class="step_1">我的购物袋</li>
				<li class="step_2">核对订单</li>
				<li class="step_3">订单提交成功</li>
			</ol>
		</div>
	</div>

<table width="100%" class="simpleTable">

	<tr>
		<td style="padding: 20px;line-height:150%">
<img src="images/ico1.gif"  style="float:left"><div style="margin-left:20px;font: 16px 微软雅黑;line-height:50px;float:left">
您已经成功索取试用装，我们会尽快为您安排发货。</div><br/>

<div style="clear:both;margin-left: 66px">
订单号：${order.orderNumber}<br/>
<p/>
<p/>
<font color="red"></font><br/>
您可以在我的订单里面<br/>
<a href="${ctx}/user/orderDetail.html?orderId=${order.id}"><u>查看订单</u></a>   <br/>

</div>
		</td>
		
	</tr>


</table>
</div>
    </div>    

 
</div>
<script>

var _BBLRItems = [];
<c:forEach var="item" items="${orderDetail}" varStatus="state">
_BBLRItems.push(["${item.itemName}","${item.quantity}","${item.price/100}","1","0"]);
</c:forEach>

</script>
</body>
</html>
