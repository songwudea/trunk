<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<head>
<title>订单明细</title>
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

	
	<table width="100%" class="simpleTable">
	<tr>
		<td class="th">订单号</td>
		<td>${orderInfo.order.orderNumber}</td>
		<td class="th">收货人</td>
		<td>${orderInfo.order.shipname}</td>
		<td class="th">订单状态</td>
		<td>
			<c:if test="${orderInfo.order.status == 'ORDER_STATUS_PAY'}">
				<c:if test="${orderInfo.order.payStatus == 'ORDER_PAY_FINISH'}">
					支付完成
				</c:if>
				<c:if test="${orderInfo.order.payStatus == 'ORDER_PAY_STATUS_BUYER_WAIT'}">
					等待买家付款
				</c:if>
				<c:if test="${orderInfo.order.payStatus == null}">
					等待买家付款
				</c:if>
				<c:if test="${orderInfo.order.payStatus == 'ORDER_PAY_STATUS_SELLER_CONFIRM'}">
					等待卖家确认付款
				</c:if>
			</c:if>
			<c:if test="${orderInfo.order.status == 'ORDER_STATUS_DISPATCH'}">
				<c:if test="${orderInfo.order.dispatchStatus == 'ORDER_DISPATCH_STATUS_SELLER_WAIT'}">
					等待卖家发货
				</c:if>
				<c:if test="${orderInfo.order.dispatchStatus == 'ORDER_DISPATCH_STATUS_CANEL'}">
					取消发货
				</c:if>
				<c:if test="${orderInfo.order.dispatchStatus == 'ORDER_DISPATCH_STATUS_BUYER_CONFIRM'}">
					已发货等待买家确认
				</c:if>
			</c:if>
			<c:if test="${orderInfo.order.status == 'ORDER_STATUS_FINISH'}">
				订单完成
			</c:if>
		
		</td>
	</tr>
	<tr>
		<td class="th">收货人信息</td>
		<td>${orderInfo.order.shipcity}${orderInfo.order.shipregion}${orderInfo.order.shipaddress}</td>
		<td class="th">手机</td>
		<td> ${orderInfo.order.shiptel}</td>
		<td class="th">支付方式</td>
		<td>网上支付 </td>
	</tr>
	<c:if test="${orderInfo.order.dispatchStatus == 'ORDER_DISPATCH_STATUS_BUYER_CONFIRM'}">
		<tr>
			<td class="th">快递名称</td>
			<td>
				<c:if test="${orderDispatch.expressDeliveryName == 'EMS'}">
					EMS
				</c:if>
				<c:if test="${orderDispatch.expressDeliveryName == 'STO'}">
					申通
				</c:if>	
				<c:if test="${orderDispatch.expressDeliveryName == 'SF'}">
					顺丰
				</c:if>
				<c:if test="${orderDispatch.expressDeliveryName == 'ZJS'}">
					宅急送
				</c:if>
				<c:if test="${orderDispatch.expressDeliveryName == 'YTO'}">
					圆通
				</c:if>
			</td>
			<td class="th">快递单编号</td>
			<td>${orderDispatch.orderDispatchNumber}</td>
		</tr>
	</c:if>
</table>
	
	</br>
	<table width="100%" class="simpleTable">
	<tr class="th">
		<td>商品名称</td>
		<td align="right">单价</td>
		<td>数量</td>
		<td align="right">小计（元）</td>
		<td> </td>
	</tr>
	<c:forEach var="detail" items="${orderInfo.orderDetail}" varStatus="state">
	<tr>
		<td>${detail.itemName}</td>
		<td align="right"><fmt:formatNumber value="${detail.price/100}" pattern="#,##0.00" /></td>
		<td>${detail.quantity}</td>
		<td align="right">
		<fmt:formatNumber value="${detail.price/100*detail.quantity}" pattern="#,##0.00" />
		<c:set var="total" scope="page">${detail.price*detail.quantity+total}</c:set> 
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td align="right">合计：</td>
		<td align="right"><fmt:formatNumber value="${total/100}" pattern="#,##0.00" /></td>
		<td></td>
	</tr>

</table>
	
</div>

</body>
</html>