<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>支付单列表</title>
    <script type="text/javascript">
    $(document).ready(function() {
    	$('#tt').datagrid({
    		title:"支付单列表",
    		loadMsg:"正在加载......",
			rows:15,
			pageSize:15,
			pageList:[15],
			width:"950",
			nowrap:false,
			height:600,
			method:"post",
			url:'${ctx}/admin/orderpay/list.html',  
			pagination:true,
			rownumbers:true,
			singleSelect:true,
			striped:true,
			sortName:'created_at',
    		sortOrder:'asc',
	     	columns:[[  
	        	{field:'payNumber',title:'支付单编号',width:160},
	        	{field:'type',title:'支付类型',width:80,formatter:function(value){
	        		return "支付宝";
	        	}},
	        	{field:'userName',title:'用户名',width:70},
	        	{field:'payAmount',title:'金额',width:60,formatter:function(value){
	        		return "￥" + value / 100;
	        	}},
	        	{field:'status',title:'状态',width:120,formatter:function(value){
	        		if(value == 'ORDER_PAY_STATUS_BUYER_WAIT') {
	        			return "等待买家支付";
	        		}
	        		if(value == 'ORDER_PAY_STATUS_SELLER_CONFIRM') {
	        			return "等待卖家确认支付";
	        		}
	        		if(value == 'ORDER_PAY_FINISH') {
	        			return "支付完成";
	        		}
	        		if(value == 'ORDER_PAY_VERIFY_FAIL') {
	        			return "支付验证失败";
	        		}
	        	}},
	        	{field:'tradeNumber',title:'交易号',width:120},
	        	{field:'confirmEmployeeName',title:'确认人',width:60},
	        	{field:'confirmAt',title:'确认时间',width:120,formatter:function(value) {
	        		if(value == null) {
	        			return "";
	        		} else {
	        			var date = new Date(value)  
	        	 		return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
	        		}	
	        	}},
	        	{field:'opertion',title:'操作',width:120, formatter:function(value,rowData,rowIndex) {
	        		if(rowData['status'] == 'ORDER_PAY_STATUS_SELLER_CONFIRM') {
	        			var href = "<a href='${ctx}/admin/orderpay/confirmPay.html?orderNumber=" + rowData['orderNumber'] + "' onclick='return confirm(\"用户确实已支付该订单？\")'>确认付款</a>";
	        			return href;
	        		}
	        	}}
	    	]]  
		}); 
		
		var pager = $('#tt').datagrid('getPager');   
		pager.pagination({
			showPageList:false,
			showRefresh:false,
			displayMsg:"显示 {from} 到 {to} 总数 {total} 项",
			beforePageText : "页"
		});
    });
    
    var searchlist = function() {
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.payNumber= $('#payNumber').val();
	    
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.status= $('#status').val();
	
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.userName= $('#userName').val();
	    
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.tradeNumber= $('#tradeNumber').val();
	    
		$('#tt').datagrid('options').queryParams=queryParams; 
		$("#tt").datagrid('reload');
    }
	</script>
</head>
	<body>
		<div id="tb" style="padding:5px;height:auto;float:left;">  
			支付单编号:<input style="width:150px" id="payNumber" />  
			状态:<select name="status" id="status">
				<option value="all">全部</option>
				<c:forEach var="status" items="${status}">
					<option value="${status}">${status.value}</option>
				</c:forEach>
			    </select>
			用户名:<input style="width:70px" id="userName" />   
			交易号:<input style="width:150px" id="tradeNumber" />  
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchlist();">查询</a>  
		</div>	
		<div style="clear:both"></div>
		<table id="tt">
		</table>
	</body>
	
</html>