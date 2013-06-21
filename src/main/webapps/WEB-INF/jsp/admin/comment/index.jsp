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
    		title:"商品评论列表",
    		loadMsg:"正在加载......",
    		toolbar:[{
	        	text:'审核',  
	         	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		if(row == null) {
	         			alert('请选择评论');
	         		} else {
	         			var row = $('#tt').datagrid('getSelected');
	         			$.post('${ctx}/admin/comment/verify.html',{id:row.id},function(data){
                			if(data == 'suss') {
	                    		$('#tt').datagrid('reload');//刷新当前页数据
	                    		$.messager.alert('操作成功','审核成功,数据前台可以显示','info');
                			} else {
                				$.messager.alert('操作失败','审核失败','info');
                			}
	                	});
	         		}
	         	}
     		 },{
     		 	text:'隐藏',
     		 	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		if(row == null) {
	         			alert('请选择评论');
	         		} else {
	         			var row = $('#tt').datagrid('getSelected');
	         			$.post('${ctx}/admin/comment/hidden.html',{id:row.id},function(data){
                			if(data == 'suss') {
	                    		$('#tt').datagrid('reload');//刷新当前页数据
	                    		$.messager.alert('操作成功','隐藏成功,数据前台隐藏显示','info');
                			} else {
                				$.messager.alert('操作失败','隐藏失败','info');
                			}
	                	});
	         		}
	         	}
     		 },{
     		 	text:'明细',
     		 	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         	}
     		 }],
			rows:15,
			pageSize:15,
			pageList:[15],
			width:"820",
			method:"post",
			url:'${ctx}/admin/comment/list.html',  
			pagination:true,
			rownumbers:false,
			singleSelect:true,
			sortName:'id',
			striped:true,
    		sortOrder:'desc',
	     	columns:[[  
	        	{field:'id',title:'编号',width:60},
	        	{field:'title',title:'评论',width:320},
	        	{field:'itemName',title:'商品名字',width:320},
	        	{field:'commentDisplayFlag',title:'审核状态',width:100,formatter:function(value){return value=='1' ?'审核通过':'待审核';}}
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
	    queryParams.userName= $('#userName').val();
	    
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
		<form method="post" name="form" action="${ctx}/admin/comment/list.html">
		<div id="tb" style="padding:5px;height:auto;float:left;">  
			评论用户名:<input style="width:150px" id="userName" />  
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