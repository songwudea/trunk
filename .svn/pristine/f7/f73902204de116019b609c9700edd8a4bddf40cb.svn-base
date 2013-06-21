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
	var comfire = function(orderNumber) {
		$.post('${ctx}/admin/order/createRenderBill.html',{orderNumber:orderNumber},function(data){
        	$('#tt').datagrid('reload');//刷新当前页数据
        	$.messager.alert('退款单操作',data,'info');
    	});
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
					<tr align="left">
						<td><button type="button" onclick="comfire('${order.orderNumber}')">确认并生成退款单</button></td>
					</tr>
					<tr><td height="30" align="center"></td></tr>
				</table>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td valign="bottom"></td>
		</tr>
	</table>
</body>