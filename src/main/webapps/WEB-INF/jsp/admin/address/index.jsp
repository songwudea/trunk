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
    		title:"用户地址管理列表",
    		loadMsg:"正在加载......",
			rows:15,
			pageSize:15,
			pageList:[15],
			width:"820",
			method:"post",
			url:'${ctx}/admin/address/${callBackMethod}',  
			pagination:true,
			singleSelect:true,
			rownumbers:true,
			striped:true,
			sortName:'id',
    		sortOrder:'desc',
	     	columns:[[  
	     		{field:'username',title:'用户名',width:140},
	        	{field:'name',title:'姓名',width:60},
	        	{field:'province',title:'城市',width:80},
	        	{field:'city',title:'地区',width:80},
	        	{field:'address',title:'地址',width:140},
	        	{field:'zip',title:'邮编',width:60},
	        	{field:'mobile',title:'手机',width:90},
	        	{field:'email',title:'邮箱',width:90}	        	
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
		<table id="tt">
		</table>
	</body>
</html>