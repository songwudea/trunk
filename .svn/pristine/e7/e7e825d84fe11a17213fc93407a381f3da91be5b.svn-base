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
<script type="text/javascript">
	var confirmPay = function (orderNumber) {
		window.location.href = '${ctx}/admin/order/confirmPay.html?orderNumber=' + orderNumber;
	}

	var confirmPay = function () {
	    if(confirm('确定要生成发货单吗?'))
	    {
	        return true;
	    }
	    return false;
	}

	var checkForm = function () {
		var shipInfo = $('#shipInfo').val();
		var orderDispatchNumber = $('#dispatchNumber').val();
		if(shipInfo == null || shipInfo == "") {
			alert("请选择相应的快递");
			return false;
		}
		if(orderDispatchNumber == null || orderDispatchNumber == "") {
			alert("请填写快递单编号");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="71" valign="middle">&nbsp;</td>
			<td valign="top">
				<table  width="100%" height="138" border="0" cellpadding="0" cellspacing="0">
					<tr><td height="6" valign="top"></td></tr>
					<tr>
												<td align="left"><a href="${ctx}/admin/order">返回订单列表页</a></td>
											</tr>
					<tr>
						<td valign="top">
							<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<table class="table-table" width="95%" height="31" border="0" cellpadding="0" cellspacing="0">
											<tr align="center">
												<td class="left_bt2" colspan="5" align="center">
													<font color="#FF0000">订单信息</font>
												</td>
											</tr>
											<tr align="center" class="nowtable">
												<td width="10%" align="center">订单编号</td>
												<td width="40%" align="center">付款人信息</td>
												<td width="15%" align="center">订单信息</td>
												<td width="15%" align="center">付款方式</td>
												<td width="20%" align="center">发票信息</td>
											</tr>
											<tr align="center">
												<td class="left_bt2" align="center">
													${order.orderNumber}
												</td>
												<td class="left_bt2" align="center">
													<div align="left">会员：${user.name}&nbsp;&nbsp;&nbsp;&nbsp;用户名：${user.username}</div>
													<div align="left">姓名：${order.shipname}</div>
													<div align="left">联系方式：${order.shiptel}</div>
													<div align="left">地址：${order.shipcity}&nbsp;&nbsp;${order.shipregion}&nbsp;&nbsp;${order.shipaddress}&nbsp;&nbsp;&nbsp;&nbsp;</div>
													<div align="left">邮件：${user.username}</div>
													<div align="left">附加要求：</div>
													<div align="left"></div>
												</td>
												<td class="left_bt2" align="center">
													<div align="left">总金额：￥<fmt:formatNumber value="${order.price/100}" pattern="#,##0.00" /></div>
												</td>
												<td class="left_bt2" align="center">
													<div align="left">订单状态：
													<c:if test="${order.status == 'ORDER_STATUS_PAY'}">
														支付中
													</c:if>
													<c:if test="${order.status == 'ORDER_STATUS_DISPATCH'}">
														发货中
													</c:if>
													<c:if test="${order.status == 'ORDER_STATUS_FINISH'}">
														订单完成
													</c:if>
													<c:if test="${order.status == 'ORDER_STATUS_CANEL'}">
														订单取消
													</c:if>
													</div>
													<div align="left">支付金额：￥<fmt:formatNumber value="${order.price/100}" pattern="#,##0.00" /></div>
													<div align="left">支付方式：
													<c:if test="${order.paytype == 'ALIPAY_PAY'}">
														支付宝
													</c:if>
													
													</div>
												</td>
												<td class="left_bt2" align="center">
													<div align="left">是否需要发票：<c:if test="${order.invoice == 'n'}">否</c:if><c:if test="${order.invoice == 'y'}">是</c:if></div>
													<c:if test="${order.invoice == 'y'}">
													<div align="left">发票类型：${order.invoiceType}</div>
													<div align="left">发票抬头：${order.invoiceTitle}</div>
													</c:if>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr><td height="30" align="center"></td></tr>
					
					<tr>
						<td>
							<table class="table-table" width="95%" height="31" border="0" cellpadding="0" cellspacing="0">
								<tr align="center"><td class="left_bt2" colspan="7" align="center"><font color="#FF0000">订单详细</font></td></tr>
								<tr align="center" class="nowtable">
									<td width="5%" align="center">订单项编号</td>
									<td width="5%" align="center">商品id</td>
									<td width="5%" align="center">商品名称</td>
									<td width="5%" align="center">购买数量</td>
									<td width="7%" align="right">商品价格</td>
									<td width="7%" align="right">商品市场价格</td>
									<td width="7%" align="right">总价</td>
								</tr>
								<c:forEach var="orderDetail" items="${orderDetail}" varStatus="state1">
								<tr align="center">
									<td class="left_bt2" align="center">${orderDetail.id}</td>
									<td class="left_bt2" align="center">${orderDetail.itemId}</td>
									<td class="left_bt2" align="center">${orderDetail.itemName}</td>
									<td class="left_bt2" align="center">${orderDetail.quantity}</td>
									<td class="left_bt2" align="right">￥<fmt:formatNumber value="${orderDetail.price/100}" pattern="#,##0.00" /></td>
									<td class="left_bt2" align="right">￥<fmt:formatNumber value="${orderDetail.marketprice/100}" pattern="#,##0.00" /></td>
									<td class="left_bt2" align="right">￥<fmt:formatNumber value="${orderDetail.amount/100}" pattern="#,##0.00" /></td>
								</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
					<tr><td height="30" align="center"></td></tr>
					
					<c:if test="${fn:length(orderPay) > 0}">
						<tr>
							<td>
								<table class="table-table" width="95%" height="31" border="0" cellpadding="0" cellspacing="0">
									<tr align="center"><td class="left_bt2" colspan="7" align="center"><font color="#FF0000">支付记录</font></td></tr>
									<tr align="center" class="nowtable">
										<td width="5%" align="center">支付类型</td>
										<td width="5%" align="center">支付金额</td>
										<td width="5%" align="center">支付状态</td>
										<td width="10%" align="center">支付编号</td>
										<td width="10%" align="center">确认人</td>
										<td width="10%" align="center">确认时间</td>
										<td width="10%" align="center">操作</td>
									</tr>
									<c:forEach var="orderPay" items="${orderPay}" varStatus="state1">
									<tr align="center">
										<td class="left_bt2" align="center">
										<c:if test="${orderPay.type == 'ALIPAY_PAY'}">
											支付宝
										</c:if>
										</td>
										<td class="left_bt2" align="center">￥<fmt:formatNumber value="${orderPay.payAmount/100}" pattern="#,##0.00" /></td>
										<td class="left_bt2" align="center">
										<c:if test="${orderPay.status == 'ORDER_PAY_STATUS_BUYER_WAIT'}">
											等待买家付款
										</c:if>
										<c:if test="${orderPay.status == 'ORDER_PAY_STATUS_SELLER_CONFIRM'}">
											买家已付款等待商家确认
										</c:if>
										<c:if test="${orderPay.status == 'ORDER_PAY_FINISH'}">
											支付完成
										</c:if>
										</td>
										<td class="left_bt2" align="center">${orderPay.payNumber}</td>
										<td class="left_bt2" align="center">${orderPay.confirmEmployeeName}</td>
										<td class="left_bt2" align="center">${orderPay.confirmAt}</td>
										
										<td width="10%" align="center">
										<c:if test="${orderPay.status == 'ORDER_PAY_STATUS_SELLER_CONFIRM'}">
											<form method="post" name="form" action="${ctx}/admin/order/confirmPay.html" onsubmit="return confirmPay(this)">
												<input type="hidden" value="${orderPay.orderNumber}" id= "orderNumber" name="orderNumber"/>
												<button type="submit">确认并生成发货单</button>
											</form>
										</c:if>
										</td>
									</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
					</c:if>
					<tr><td height="30" align="center"></td></tr>
					
					<c:if test="${fn:length(orderDispatch) > 0}">
						<tr>
						<td>
							<form method="post" name="form" action="${ctx}/admin/order/confirmDispath.html" onsubmit="return checkForm(this)">
							<input type="hidden" value="${order.orderNumber}" id= "orderNumber" name="orderNumber"/>
							<table class="table-table" width="95%" height="31" border="0" cellpadding="0" cellspacing="0">
								<tr align="center"><td class="left_bt2" colspan="11" align="center"><font color="#FF0000">送货单信息</font></td></tr>
								<tr align="center" class="nowtable">
									<td width="7%" align="center">收货姓名</td>
									<td width="8%" align="center">收货人电话</td>
									<td width="7%" align="center">收货人城市</td>
									<td width="7%" align="center">收货人区域</td>
									<td width="15%" align="center">收货人地址</td>
									<td width="7%" align="center">收货人邮编</td>
									<td width="12%" align="center">发送快递单号</td>
									<td width="8%" align="center">发送快递名称</td>
									<td width="14%" align="center">发货状态</td>
									<td width="8%" align="center">操作</td>
								</tr>
								<c:forEach var="orderDispatch" items="${orderDispatch}" varStatus="state1">
								<tr align="center">
									<td class="left_bt2" align="center">${orderDispatch.shipname}</td>
									<td class="left_bt2" align="center">${orderDispatch.shiptel}</td>
									<td class="left_bt2" align="center">${orderDispatch.shipcity}</td>
									<td class="left_bt2" align="center">${orderDispatch.shipregion}</td>
									<td class="left_bt2" align="center">${orderDispatch.shipaddress}</td>
									<td class="left_bt2" align="center">${orderDispatch.shipzip}</td>
									<td class="left_bt2" align="center">
									<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_SELLER_WAIT'}">
										<input type="text" name="dispatchNumber" id="dispatchNumber"/>
									</c:if>
									
									<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_BUYER_CONFIRM'}">
										${orderDispatch.orderDispatchNumber}
									</c:if>
									
									<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_FINISH'}">
										${orderDispatch.orderDispatchNumber}
									</c:if>
									</td>
									
									<td class="left_bt2" align="center">
									<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_SELLER_WAIT'}">
										<select id="shipInfo" name="shipInfo">
											<option value = "">请选择</option>
											<c:forEach var="shipInfo" items="${shipInfos}" varStatus="index">
											<option value = "${shipInfo}">${shipInfo.name}</option>
											</c:forEach>
										</select>
									</c:if>
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
									</td>
									
									
									<td class="left_bt2" align="center">
									<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_SELLER_WAIT'}">
										等待商家发货
									</c:if>
									<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_BUYER_CONFIRM'}">
										已发货等待买家确认
									</c:if>
									<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_FINISH'}">
										买家已确认发货完成
									</c:if>
									</td>
									
									<td class="left_bt2" align="center">
									<c:if test="${orderDispatch.status == 'ORDER_DISPATCH_STATUS_SELLER_WAIT'}">
										<button type="submit">发货</button>
									</c:if>
									</td>
								</tr>
								</c:forEach>
							</table>
							</form>
							${sHtmlText}
						</td>
					</tr>
					</c:if>
				</table>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td valign="bottom"></td>
		</tr>
	</table>
	<script>
		var href = "${ctx}/admin/order/confirmDispath.html&orderNumber=" + orderNumber + "&shipInfo=" + shipInfo + "&orderDispatchNumber=" + orderDispatchNumber;
		$("#confirmDispath").attr("href",href);
	</script>
</body>