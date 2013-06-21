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
    		title:"员工管理列表",
    		loadMsg:"正在加载......",
    		toolbar:[{
	        	text:'新增',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		document.location.href="${ctx}/admin/employee/doEdit.html";
	         	}
     		 },{  
	        	text:'修改',  
	         	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		document.location.href="${ctx}/admin/employee/doEdit.html?id=" + row.id;
	         	}
     		 },{
	        	text:'分配角色',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		document.location.href="${ctx}/admin/employee/doEmployeerole.html?employeeId=" + row.id;
	         	}
     		},{
     			text:'分配站点',
     			iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		document.location.href="${ctx}/admin/employee/assortSite.html?employeeId=" + row.id;
	         	}
     		}],
			rows:15,
			pageSize:15,
			pageList:[15],
			striped:true,
			rownumbers:true,
			width:"820",
			method:"post",
			url:'${ctx}/admin/employee/list.html',  
			pagination:true,
			singleSelect:true,
			sortName:'id',
    		sortOrder:'asc',
	     	columns:[[  
	        	{field:'account',title:'用户名',width:80},
	        	{field:'position',title:'职位',width:80, sortable:true},
	        	{field:'department',title:'部门',width:80, sortable:true},
	        	{field:'email',title:'邮箱',width:140, sortable:true},
	        	{field:'name',title:'真实姓名',width:80, sortable:true},
	        	{field:'gender',title:'性别',width:60,formatter:function(value){return value=="m" ?'男':'女';}, sortable:true},
	        	{field:'telphone',title:'电话',width:90},
	        	{field:'mobile',title:'手机',width:90}
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
	    queryParams.sta_username= $('#sta_username').val();
	    
    	var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.sta_email= $('#sta_email').val();

    	var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.sta_loginstatus= $('#sta_loginstatus').val();
	    
    	var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.sta_station= $('#sta_station').val();
	    
 		$('#tt').datagrid('options').queryParams=queryParams; 
		$("#tt").datagrid('reload');
    }
	    
	</script>
</head>
	<body>
		<table id="tt">
		</table>
	</body>
</html>