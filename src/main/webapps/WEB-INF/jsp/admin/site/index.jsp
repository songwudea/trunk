<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>站点管理</title>
    <script type="text/javascript" >
    $(document).ready(function() {
    	$('#tt').datagrid({  
    		title:"站点管理列表",
    		loadMsg:"正在加载......",
			width:"820",
			method:"post",
			striped:true,
			url:'${ctx}/admin/site/list.html',  
			pagination:false,
			rownumbers:true,
			sortName:'id',
			singleSelect:true,
    		sortOrder:'asc',
    		toolbar:[{
	        	text:'添加价格区间',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
					if(row == null) {
						alert('请选择一个站点');
					} else {
		         		document.location.href="${ctx}/admin/price/view.html?siteId=" + row.id;
					}	         		
	         		
	         	}
    		},{
	        	text:'配置静态首页',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
					if(row == null) {
						alert('请选择一个站点');
					} else {
		         		document.location.href="${ctx}/admin/site/editindexpage.html?siteId=" + row.id;
					}	         		
	         		
	         	}
    		}],
	     	columns:[[  
	        	{field:'domain',title:'域名',width:120},
	        	{field:'template',title:'模版',width:100,formatter:function(value){return value.name;}},
	        	{field:'defaultSite',title:'默认站点',width:100,formatter:function(value){return value==true ?'是':'否';}},
	        	{field:'language',title:'语言',width:140,formatter:function(value){return value.name;}}
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
		<table id="tt" />
	</body>
</html>