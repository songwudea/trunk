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
<img src="images/ico1.gif"  style="float:left"><div style="margin-left:20px;font: 16px 微软雅黑;line-height:50px;float:left">您的订单已成功提交，请及时支付</div><br/>

<div style="clear:both;margin-left: 66px">
订单号：${order.orderNumber}<br/>
支付方式：网上支付（支付宝）<p/>
<a href="${ctx}/pay/alipay_${order.orderNumber}.html" style="display:block;width: 100px;height:22px ;line-height:22px;background-color:#3164AF;margin:5px 0px;text-align:center;color:white" onmouseover="this.style.backgroundColor = '#5E82C9'" onmouseout="this.style.backgroundColor = '#3164AF'">现在付款</a><p/>
请您在<font color="red">24小时</font>内付款，以免订单超时被取消。 如果您需要稍后支付，您可打开"我的瞳话"点击"我的订单"进行支付<br/>
付款完成后请勿直接关闭支付宝窗口，请等待页面返回到本网站后再关闭<br/>
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
