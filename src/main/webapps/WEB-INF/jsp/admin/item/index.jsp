<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery.EasyUI</title>
    <script type="text/javascript" >
    $(document).ready(function() {
    	$('#tt').datagrid({  
    		title:"商品管理列表",
    		loadMsg:"正在加载......",
    		toolbar:[{
	        	text:'新增',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		document.location.href="${ctx}/admin/item/edit.html";
	         	}
     		 },{  
	        	text:'修改',  
	         	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		document.location.href="${ctx}/admin/item/edit.html?id=" + row.id;
	         	}
     		 },{
     		 	text:'上架',
     		 	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		var id = row.id;
	         		$.ajax({
						  url: "${ctx}/admin/item/shelves.html",
						  type:"post",
						  dataType: 'json',
						  data:{id:id},
						  success: function(data){
						  	 if(data.result == 'suss') {
						  	 	$.messager.alert('商品操作',data.message,'info');
						  	 } else {
						  	 	$.messager.alert('商品操作',data.message,'info');
						  	 }
						  }
					});
	         		
	         	}
     		 },{
     		 	text:'商品属性',  
	         	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		document.location.href="${ctx}/admin/item/doItemAttr.html?id=" + row.id;
	         	}
     		 },{
     		 	text:'附加属性',  
	         	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		document.location.href="${ctx}/admin/item/itemCustomerAttr.html?itemId=" + row.id;
	         	}	
     		}],
			rows:15,
			pageSize:15,
			pageList:[15],
			width:"820",
			method:"post",
			url:'${ctx}/admin/item/list.html',  
			pagination:true,
			rownumbers:true,
			striped:true,
			singleSelect:true,
			sortName:'id',
    		sortOrder:'asc',
	     	columns:[[  
	        	{field:'name',title:'商品名称',width:120},
	        	{field:'categoryId',title:'分类名称',width:130,sortable:true,
	        	formatter:function(value,rowData,rowIndex){
	        		return rowData['categoryName'];
	        	}},
	        	{field:'sellable',title:'是否出售',width:80,sortable:true,formatter:function(value){return value==true ?'是':'否';}},
	        	{field:'published',title:'是否发布',width:80,sortable:true,formatter:function(value){return value==true ?'是':'否';}},
	        	{field:'price',title:'价格',width:60,sortable:true,formatter:function(value){return "￥" +value / 100;}},
	        	{field:'marketPrice',title:'市场价',width:60,sortable:true,formatter:function(value){return "￥" + value / 100;}},
	        	{field:'publishOn',title:'发布时间',sortable:true,width:130,
	        	 formatter:function(value) {
	        	 	var date = new Date(value)  
	        	 	return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
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
	    queryParams.name= $('#name').val();
	    
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.categoryId= $('#categoryId').val();
	    
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
		<form method="post" name="form" action="${ctx}/admin/item/list.html">
		<div id="tb" style="padding:5px;height:auto;float:left;">  
			商品名称:<input style="width:150px" id="name" /> 
			分类名称:<select name="categoryId" id="categoryId">
				<option value="all">全部</option>
				<c:forEach var="cate" items="${categories}">
					<option value="${cate.id}">${cate.name}</option>
				</c:forEach>
			    </select> 
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