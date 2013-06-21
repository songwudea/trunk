<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${ctx}/js/datagrid-detailview.js"></script> 
    <title>支付单列表</title>
    <script type="text/javascript">
    $(document).ready(function() {
    	$('#tt').datagrid({
    		view: detailview,  
    		detailFormatter:function(index,row){ 
    			 return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>'; 
    		},
    		onExpandRow: function(index,row){  
		        $('#ddv-'+index).datagrid({  
		            url:'${ctx}/admin/orderdispatch/orderdispatchdetail.html?orderDispathId='+row.id,  
		            fitColumns:true,  
		            singleSelect:true,  
		            loadMsg:"正在加载发货明细......",
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
    		title:"发货单列表",
    		loadMsg:"正在加载......",
			rows:15,
			pageSize:15,
			pageList:[15],
			width:"1100",
			nowrap:false,
			height:600,
			method:"post",
			url:'${ctx}/admin/orderdispatch/list.html',  
			pagination:true,
			rownumbers:true,
			singleSelect:true,
			striped:true,
			sortName:'created_at',
    		sortOrder:'asc',
	     	columns:[[  
	        	{field:'shipname',title:'收货人姓名',width:70},
	        	{field:'shipcity',title:'城市',width:50},
	        	{field:'shipregion',title:'地区',width:50},
	        	{field:'shipaddress',title:'地址',width:180},
	        	{field:'shiptel',title:'手机',width:85},
	        	{field:'status',title:'状态',width:140,
	        	 formatter:function(value){
	        	 	if(value == 'ORDER_DISPATCH_STATUS_SELLER_WAIT') {
	        	 		return "等待卖家发货";
	        	 	} else if(value == 'ORDER_DISPATCH_STATUS_CANEL') {
	        	 		return "取消发货";
	        	 	} else if(value == 'ORDER_DISPATCH_STATUS_BUYER_CONFIRM') {
	        	 		return "已发货等待买家确认";
	        	 	} else if(value == 'ORDER_DISPATCH_STATUS_FINISH') {
	        	 		return "发货完成";
	        	 	} 
	        	 }
	        	},
	        	{field:'orderDispatchNumber',title:'发货单号',width:130},
	        	{field:'expressDeliveryName',title:'快递名称',width:60,formatter:function(value) {
	        		if(value == 'EMS') {
	        			return "EMS";
	        		}
	        		if(value == 'STO') {
	        			return "申通";
	        		}
	        		if(value == 'YTO') {
	        			return "圆通";
	        		}
	        		if(value == 'SF') {
	        			return "顺丰";
	        		}
	        		if(value == 'ZJS') {
	        			return "宅急送";
	        		}
	        	
	        	
	        	}},
	        	{field:'price',title:'总价',width:85,formatter:function(value) {
	        		return value/100;
	        	}},
	        	{field:'opertion',title:'操作',width:150, formatter:function(value,rowData,rowIndex) {
	        		if(rowData['status'] == 'ORDER_DISPATCH_STATUS_SELLER_WAIT') {
	        			var href = "<a href='${ctx}/admin/orderdispatch/edit.html?orderDispathId=" + rowData['id'] +  "'>确认发货</a>";
	        			return href;
	        		} else {
	        			return "<a href='" + "${ctx}/admin/orderdispatch/view.html?orderDispathId=" + rowData['id'] +  "'>详情</a>";   ;
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
	    queryParams.orderDispatchNumber= $('#orderDispatchNumber').val();
	    
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.status= $('#status').val();
	
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.shipname= $('#shipname').val();
	    
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.shipaddress= $('#shipaddress').val();
	    
		$('#tt').datagrid('options').queryParams=queryParams; 
		$("#tt").datagrid('reload');
    }
    
    
    
	</script>
</head>
	<body>
		<div id="tb" style="padding:5px;height:auto;float:left;">  
			发货单号编号:<input style="width:150px" id="orderDispatchNumber" />  
			状态:<select name="status" id="status">
				<option value="all">全部</option>
				<c:forEach var="status" items="${status}">
					<option value="${status}">${status.value}</option>
				</c:forEach>
			    </select>
			收货人姓名:<input style="width:70px" id="shipname" />   
			地址:<input style="width:150px" id="shipaddress" />  
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchlist();">查询</a>  
		</div>	
		<div style="clear:both"></div>
		<div style="padding: 5px 10px;text-align: left">			
		<a href="javascript:;" onclick="$('#status').attr('selectedIndex','1');searchlist()">待发货单据</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:;" onclick="$('#status').attr('selectedIndex','3');searchlist()">已发货单据</a></div>
		
		<table id="tt">
		</table>
	</body>
	
</html>