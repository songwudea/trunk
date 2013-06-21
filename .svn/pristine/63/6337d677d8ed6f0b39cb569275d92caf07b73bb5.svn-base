<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<head>
<style type="text/css">
	<!--
		.nowtable {
			background-color: #E0ECFF;
			border-top-width: 1px;
			border-right-width: 1px;
			border-bottom-width: 1px;
			border-left-width: 1px;
			border-top-style: solid;
			border-top-color: #bfc4ca;
			border-right-color: #bfc4ca;
			border-bottom-color: #bfc4ca;
			border-left-color: #bfc4ca;
		}
		
		.left_bt {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 14px;
			font-weight: bold;
			color: #395a7b;
		}
		
		.left_bt2 {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 25px;
			color: #333333;
		}
		
		.table-table {
			width: 100%;
			houbo-border: expression(this .   border =   0);
			houbo-cellspacing: expression(this .   cellSpacing =   0);
			houbo-cellpadding: expression(this .   cellPadding =   0);
			border-top-width: 1px;
			border-left-width: 1px;
			border-top-style: solid;
			border-left-style: solid;
			border-top-color: #CAD8EA;
			border-left-color: #CAD8EA;
		}
		
		.table-table td {
			font-size: 12px;
			padding-top: 3px;
			padding-bottom: 3px;
			/*text-align: left;*/
			height: 23px;
			padding-left: 5px;
			padding-right: 5px;
			border-right: #CAD8EA 1px solid;
			border-bottom: #CAD8EA 1px solid;
		}
	-->
</style>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="71" valign="middle">&nbsp;</td>
			<td valign="top">
				<table  width="100%" height="138" border="0" cellpadding="0" cellspacing="0">
					<tr>
				<td height="30" align="left"><a href="${ctx}/admin/orderdispatch">返回发货单管理列表</a></td>
			</tr>
					<tr><td height="6" valign="top"></td></tr>
						<tr>
							<td>
								<table class="table-table" width="95%" height="31" border="0" cellpadding="0" cellspacing="0">
									<tr align="center"><td class="left_bt2" colspan="11" align="center"><font color="#FF0000">发货单明细</font></td></tr>
									<tr align="center" class="nowtable">
										<td width="7%" align="center">商品名字</td>
										<td width="8%" align="center">数量</td>
										<td width="7%" align="center">单价</td>
										<td width="7%" align="center">总金额</td>
									</tr>
									<c:forEach var="orderDispatchDetail" items="${orderDispatchDetails}" varStatus="state1">
									<tr align="center">
										<td class="left_bt2" align="center">${orderDispatchDetail.itemName}</td>
										<td class="left_bt2" align="center">${orderDispatchDetail.quantity}</td>
										<td class="left_bt2" align="center"><fmt:formatNumber value="${orderDispatchDetail.price/100}" pattern="#,#00.00" /></td>
										<td class="left_bt2" align="center"><fmt:formatNumber value="${orderDispatchDetail.amount/100}" pattern="#,#00.00" /></td>
									</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
						<tr><td height="30" align="center"></td></tr>
						<tr>
							<td>
								<table class="table-table" width="95%" height="31" border="0" cellpadding="0" cellspacing="0">
									<tr align="center"><td class="left_bt2" colspan="11" align="center"><font color="#FF0000">发货信息</font></td></tr>
									<tr><td class="left_bt2" align="left">发货地址信息：${orderDispatch.shipcity}${orderDispatch.shipregion}${orderDispatch.shipaddress}， ${orderDispatch.shipzip}，${orderDispatch.shipname}， ${orderDispatch.shiptel} </td></tr>
								</table>
							</td>
						</tr>
						
						
						<tr><td height="30" align="center"></td></tr>
						<tr>
							<td>
								<table class="table-table" width="95%" height="31" border="0" cellpadding="0" cellspacing="0">
									<tr align="center"><td class="left_bt2" colspan="11" align="center"><font color="#FF0000">物流信息</font></td></tr>
									<tr>
							<td class="left_bt2" align="left">物流名称：
							<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_BUYER_CONFIRM'}">
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
							</c:if>
							
							<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_FINISH'}">
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
								</c:if>
								<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_SELLER_WAIT'}">
									等待卖家发货
								</c:if>
							</td>
						</tr>
						<tr>
							<td class="left_bt2" align="left">物流单号：
								<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_BUYER_CONFIRM'}">
									${orderDispatch.orderDispatchNumber}
								</c:if>
								
								<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_FINISH'}">
									${orderDispatch.orderDispatchNumber}
								</c:if>
								<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_SELLER_WAIT'}">
									等待卖家发货	
								</c:if>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
				</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td valign="bottom"></td>
			<td></td>
			<td valign="bottom"></td>
		</tr>
	</table>
	<script>
		var href = "${ctx}/admin/order/confirmDispath.html&orderNumber=" + orderNumber + "&shipInfo=" + shipInfo + "&orderDispatchNumber=" + orderDispatchNumber;
		$("#confirmDispath").attr("href",href);
	</script>
</body>