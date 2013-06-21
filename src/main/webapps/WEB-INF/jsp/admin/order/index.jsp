<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery.EasyUI</title>
    <script type="text/javascript" src="${ctx}/js/datagrid-detailview.js"></script> 
    <script type="text/javascript" >    
    $(document).ready(function() {
    	$('#tt').datagrid({  
    		view: detailview,  
    		detailFormatter:function(index,row){ 
    			 return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>'; 
    		},
    		onExpandRow: function(index,row){  
		        $('#ddv-'+index).datagrid({  
		            url:'${ctx}/admin/order/orderdetail.html?orderId='+row.id,  
		            fitColumns:true,  
		            singleSelect:true,  
		            loadMsg:"正在加载订单明细......",
		            striped:true,
		            rownumbers:false,  
		            showFooter:true,
		            columns:[[  
		                {field:'itemName',title:'商品名称',width:70},  
		                {field:'quantity',title:'数量',width:10, formatter:function(value) {return value + "件";}},  
		                {field:'price',title:'单价',width:30,formatter:function(value) {return value / 100 + "元";}},
		                {field:'amount',title:'合计',width:30,formatter:function(value) {return value / 100 + "元";}}  
		            ]],  
		            onResize:function(){  
		                $('#tt').datagrid('fixDetailRowHeight',index);  
		            },  
		            onLoadSuccess:function(){  
		                setTimeout(function(){  
		                    $('#tt').datagrid('fixDetailRowHeight',index);  
		                },0);  
		            }
		        });  
		        $('#tt').datagrid('fixDetailRowHeight',index);  
	    	},  
    		title:"订单列表",
    		loadMsg:"正在加载......",
    		toolbar:[{
	        	text:'下载订单',  
	         	iconCls:'icon-edit',
	         	plain:true,
	         	handler:function() {	         		
	         		var loadingTip = $('#loadingTip');
	         		loadingTip.show();
		            loadingTip.ajaxStart(function(){
		                loadingTip.text('loading...');
		            });
	         		$.post('${ctx}/admin/order/downorder.html',{},
	         		function(data){
            			if(data != '') {
            				loadingTip.ajaxStop(function(){
				                loadingTip.empty();
				                loadingTip.hide();
				            });
                    		$('#tt').datagrid('reload');//刷新当前页数据
                    		window.location.href = "${ctx}"+data;
                    		$.messager.alert('操作成功','导出订单成功','info');
            			} else {
            				$.messager.alert('操作失败','导出订单失败','info');
            			}
		             });
	         	}
     		}],
			rows:15,
			striped:true,
			pageSize:15,
			pageList:[15],
			height:"500",
			width:"920",
			method:"post",
			url:'${ctx}/admin/order/list.html',  
			pagination:true,
			rownumbers:false,
			singleSelect:true,
			sortName:'id',
    		sortOrder:'desc',
	     	columns:[[  
	        	{field:'orderNumber',title:'订单编号',width:180,sortable:true,
	        	formatter:function(value) {
	        		var url = "${ctx}/admin/order/view.html?orderNumber=" + value;
	        		return "<a href='" + url + "'>" + value + "</a>";
	        	}},
	        	{field:'userName',title:'用户姓名',width:80},
	        	{field:'price',title:'订单金额',width:80,formatter:function(value){return "￥" + parseFloat(value) / 100;}},
	        	// {field:'amountPrice',title:'总价格(商品价格＋配送价格)',width:160,formatter:function(value,rowData,rowIndex){return "￥" + (parseFloat(rowData['price'])/100 + parseFloat(rowData['shipfee'])/100)}},
	        	{field:'status',title:'订单状态',width:60,sortable:true,
	        	 formatter:function(value) {
	        	 	if(value == 'ORDER_STATUS_PAY') {
	        	 		return "支付中";
	        	 	} else if(value == 'ORDER_STATUS_DISPATCH') {
	        	 		return "发货中";
	        	 	} else if(value == 'ORDER_STATUS_REFUND') {
	        	 		return "退款中";
	        	 	} else if(value == 'ORDER_STATUS_FINISH') {
	        	 		return "交易完成";
	        	 	}
	        	}},
	        	{field:'shiptel',title:'手机',width:100},
	        	{field:'payStatus',title:'是否可退款',width:240,formatter:function(value,rowData,rowIndex) {
	        		if(value == 'ORDER_PAY_STATUS_SELLER_CONFIRM') {
	        			var href = "<a href='${ctx}/admin/order/createRenderBill.html?orderNumber=" +  rowData['orderNumber']   + "'>确认并生成退款单</a>";
	        			return href;
	        		} else if(value == 'ORDER_PAY_STATUS_BUYER_WAIT') {
	        			return "否";
	        		} else if(value == 'ORDER_PAY_FINISH') {
	        			return "否";
	        		} else if(value == 'ORDER_PAY_STATUS_BUYER_WAIT') {
	        			return "否";
	        		}else if(value == 'ORDER_PAY_STATUS_RENDER') {
	        			return "已生成退款单";
	        		} else if(value == null || value == '') {
	        			return "否";
	        		} 
	        		
	        	}},
	        	{field:'createdAt',title:'创建时间',width:140,sortable:true,
	        		formatter:function(value) {
	        		if(value == null) {
	        			return "";
	        		} else {
	        			var date = new Date(value)  
	        	 		return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
	        		}	
	        	}
	        	}
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
	    
	    var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.startcreatedAt= $('#startcreatedAt').datetimebox('getValue');
	    
	    var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.endcreatedAt= $('#endcreatedAt').datetimebox('getValue')
	    
		$('#tt').datagrid('options').queryParams=queryParams; 
		$("#tt").datagrid('reload');
    }
	    
	</script>
	
	 <script type="text/javascript" >
    $(document).ready(function() {
    	$('#startcreatedAt').datetimebox({
    		width:120,
			showSeconds:false
    	});  
    	$('#endcreatedAt').datetimebox({
    		width:120,
			showSeconds:false
    	});  
    });
	</script>
</head>
	<body>
		<div id="loadingTip" style="height:80px;width:300px; display:none; color:red; align:middle; font-size:24px;"></div>
		<form method="post" name="form" action="${ctx}/admin/order/list.html">
		<div id="tb" style="padding:5px;height:auto;float:left;">  
			订单编号编号:<input style="width:150px" id="orderNumber" />  
			订单状态:<select name="status" id="status">
				<option value="all">全部</option>
				<c:forEach var="status" items="${status}">
					<option value="${status}">${status.value}</option>
				</c:forEach>
			    </select>
			用户姓名:<input style="width:70px" id="userName" />   
			手机:<input style="width:150px" id="shiptel" /><br/>
			开始时间:<input type="text" name="startcreatedAt" class="input" id="startcreatedAt" size="20" maxlength="30" />
			结束时间:<input type="text" name="endcreatedAt" class="input" id="endcreatedAt" size="20" maxlength="30" />   
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchlist();">查询</a>  
		</div>	
		</form>
		<div style="clear:both"></div>
		<table id="tt">
		</table>
	</body>
</html>