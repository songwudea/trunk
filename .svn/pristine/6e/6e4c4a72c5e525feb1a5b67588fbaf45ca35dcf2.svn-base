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
    		title:"站点管理列表",
    		loadMsg:"正在加载......",
			width:"820",
			height:"500",
			method:"post",
			url:"${ctx}/admin/site/list.html?employeeId=" + $('#employeeId').val(),  
			pagination:false,
			rownumbers:false,
			sortName:'id',
    		sortOrder:'asc',
    		toolbar:[{
	        	text:'分配权限',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	method:"post",
	         	handler:function() {
	         		var rows = $('#tt').datagrid('getSelections');
	         		var ids = '';
	         		if(rows != null && rows.length > 0) {
	         			for(var i = 0;i < rows.length;i++) {
	         				ids += rows[i].id + ",";
	         			}
	         			$.ajax({
							url: "${ctx}/admin/employee/assortSite.html",
						  	type:"post",
						  	data:{employeeId:$('#employeeId').val(), siteIds:ids},
						  	success: function(data) {
						  		if(data == 'success') {
						  			$("#tt").datagrid('reload');
						  			alert('分配成功');
						  		}
					  		}
						});
	         		}
	         	}
     		},{
     			text:'撤销权限',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	method:"post",
	         	handler:function() {
	         		var rows = $('#tt').datagrid('getSelections');
	         		var ids = '';
	         		if(rows != null && rows.length > 0) {
	         			for(var i = 0;i < rows.length;i++) {
	         				ids += rows[i].id + ",";
	         			}
	         			$.ajax({
							url: "${ctx}/admin/employee/cancelSite.html",
						  	type:"post",
						  	data:{employeeId:$('#employeeId').val(), siteIds:ids},
						  	success: function(data) {
						  		if(data == 'success') {
						  			$("#tt").datagrid('reload');
						  			alert('权限撤销成功');
						  		}
					  		}
						});
	         		}
	         	}
     		}],
	     	columns:[[  
	        	{field:'id',title:'编号',width:40,checkbox:true},
	        	{field:'name',title:'站点名称',width:120},
	        	{field:'authorize',title:'站点权限',width:100,formatter:function(authorize){return authorize==true ?"<img src='${ctx}/images/success.png'>":'';}}
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
	</script>
</head>
	<body>
		<input type="hidden" name="employeeId" id="employeeId" size="24" value="${employeeId}"/>
		<div id="tt" />
	</body>
</html>