<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<head>
<title>我的订单</title>
<base href="${path}/"/>
	<script type="text/javascript">
	</script>

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

<table width="100%" class="simpleTable">
	<tr class="th">
		<td>编号</td>
		<td>金额</td>
		<td>支付方式</td>
		<td>订单状态</td>
		<td>下单时间</td>
		<td>操作</td>
	</tr>
	<c:forEach var="orderInfo" items="${orderInfos}" varStatus="state">
		<tr>
			<td><a href="${ctx}/user/orderDetail.html?orderId=${orderInfo.order.id}"><font color="blue">${orderInfo.order.orderNumber}</a></td>
			<td><fmt:formatNumber value="${orderInfo.order.price/100}" pattern="#,##0.00" /></td>
			<td>网上支付</td>
			<td>
			<c:if test="${orderInfo.order.status == 'ORDER_STATUS_PAY'}">
				<c:if test="${orderInfo.order.payStatus == 'ORDER_PAY_FINISH'}">
					支付完成
				</c:if>
				<c:if test="${orderInfo.order.payStatus == 'ORDER_PAY_STATUS_BUYER_WAIT'}">
					未付款
				</c:if>
				<c:if test="${orderInfo.order.payStatus == null}">
					未付款
				</c:if>
				<c:if test="${orderInfo.order.payStatus == 'ORDER_PAY_STATUS_SELLER_CONFIRM'}">
					待发货
				</c:if>
			</c:if>
			<c:if test="${orderInfo.order.status == 'ORDER_STATUS_DISPATCH'}">
				<c:if test="${orderInfo.order.dispatchStatus == 'ORDER_DISPATCH_STATUS_SELLER_WAIT'}">
					待发货
				</c:if>
				<c:if test="${orderInfo.order.dispatchStatus == 'ORDER_DISPATCH_STATUS_CANEL'}">
					取消订单
				</c:if>
				<c:if test="${orderInfo.order.dispatchStatus == 'ORDER_DISPATCH_STATUS_BUYER_CONFIRM'}">
					已发货
				</c:if>
			</c:if>
			<c:if test="${orderInfo.order.status == 'ORDER_STATUS_FINISH'}">
				订单完成
			</c:if>
			</td>
			<td><fmt:formatDate value="${orderInfo.order.createdAt}" type="both"/></td>
			<td>
				<c:if test="${orderInfo.order.payStatus == 'ORDER_PAY_STATUS_BUYER_WAIT'}">
					<a href="${ctx}/pay/alipay_${orderInfo.order.orderNumber}.html" >支付</a>
				</c:if>
				<c:if test="${orderInfo.order.payStatus == null}">
					<a href="${ctx}/pay/alipay_${orderInfo.order.orderNumber}.html" >支付</a>
				</c:if>
			</td>
		</tr>
	</c:forEach>
	
</table>
</div>
  
  
  


      
</div>
    </div>    

 
</div>

</body>
</html>