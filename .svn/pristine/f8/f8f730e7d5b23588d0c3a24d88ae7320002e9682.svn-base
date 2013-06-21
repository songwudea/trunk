<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery.EasyUI</title>
    <script type="text/javascript">
    
    $(document).ready(function() {
    	$('#tt').datagrid({  
    		title:"退款单列表",
    		loadMsg:"正在加载......",
			rows:15,
			pageSize:15,
			pageList:[15],
			width:"820",
			height:"500",
			striped:true,
			method:"post",
			url:'${ctx}/admin/refund/list.html',  
			pagination:true,
			rownumbers:true,
			singleSelect:true,
			sortName:'id',
    		sortOrder:'desc',
    		toolbar:[{
	        	text:'确认退款',  
	         	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		var status = row.status;
	         		var id = row.id;
	         		if(status == 'ORDER_REFUND_STATUS_WAIT') {
	         			$.post('${ctx}/admin/refund/comfireRefund.html',{id:id},function(data){
	         				if(data == "suss") {
					        	$('#tt').datagrid('reload');//刷新当前页数据
					       		$.messager.alert('退款操作','确认退款操作成功','info');
	         				} else {
					       		$.messager.alert('退款操作','确认退款操作失败','info');
	         				}
				    	});
	         		} else if(status == 'ORDER_REFUND_STATUS_COMFIRE') {
	         			alert('已经退款了不能重复操作');
	         		}
	         	}
     		}],
	     	columns:[[  
	        	{field:'orderNumber',title:'订单编号',width:150,sortable:true},
	        	{field:'account',title:'退款账户',width:150},
	        	{field:'price',title:'退款金额',width:100,formatter:function(value){return "￥" + parseFloat(value) / 100;}},
	        	{field:'status',title:'退款状态',width:100,formatter:function(value){
	        		if(value=='ORDER_REFUND_STATUS_WAIT') {
	        			return "等待确认退款";
	        		}
	        		if(value=='ORDER_REFUND_STATUS_COMFIRE') {
	        			return "已确认并退款";
	        		}
	        	}},
	        	{field:'createdAt',title:'退款单创建时间',width:130,formatter:function(value) {
	        		if(value == null) {
	        			return "";
	        		} else {
	        			var date = new Date(value)  
	        	 		return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
	        		}	
	        	}},
	        	{field:'refundDate',title:'退款时间',width:130,formatter:function(value) {
	        		if(value == null) {
	        			return "";
	        		} else {
	        			var date = new Date(value)  
	        	 		return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
	        		}	
	        	}},
	        	{field:'createByEmployeeName',title:'提交退款人',width:150},
	        	{field:'confirmByEmployeeName',title:'退款审核人',width:150}
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
	    queryParams.orderNumber= $('#orderNumber').val();
	    
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.status= $('#status').val();
	
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.userName= $('#userName').val();
	    
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.shiptel= $('#shiptel').val();
	    
		$('#tt').datagrid('options').queryParams=queryParams; 
		$("#tt").datagrid('reload');
    }
	    
	</script>
</head>
	<body>
		<div id="tb" style="padding:5px;height:auto;float:left;">  
			订单编号编号:<input style="width:150px" id="orderNumber" />  
			订单状态:<select name="status" id="status">
				<option value="all">全部</option>
				<c:forEach var="status" items="${status}">
					<option value="${status}">${status.value}</option>
				</c:forEach>
			    </select>
			用户姓名:<input style="width:70px" id="userName" />   
			手机:<input style="width:150px" id="shiptel" />  
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchlist();">查询</a>  
		</div>	
		<div style="clear:both"></div>
		<table id="tt">
		</table>
	</body>
</html>