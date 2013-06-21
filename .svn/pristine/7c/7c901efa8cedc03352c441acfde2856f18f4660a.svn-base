<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="link-Type" link="text/html; charset=utf-8" />
    <title>jQuery.EasyUI</title>
     <script type="text/javascript" >
    $(document).ready(function() {
    	$('#tt').datagrid({  
    		title:"链接列表",
    		loadMsg:"正在加载......",
    		toolbar:[{
	        	text:'新增',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		document.location.href="${ctx}/admin/link/edit.html";
	         	}
     		 },{  
	        	text:'修改',  
	         	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		document.location.href="${ctx}/admin/link/edit.html?id=" + row.id;
	         	}
     		 }],
			rows:15,
			pageSize:15,
			pageList:[15],
			width:"820",
			method:"post",
			url:'${ctx}/admin/link/list.html',  
			pagination:true,
			singleSelect:true,
			striped:true,
			rownumbers:true,
			sortName:'id',
    		sortOrder:'desc',
	     	columns:[[  
	        	{field:'linkType',title:'链接类型',width:100, formatter:function(value){return value=='MAIN_NAV' ? '主导航':'友情链接'}},
	        	{field:'linkUrl',title:'链接URL',width:250},
	        	{field:'linkTarget',title:'打开方式',width:80,formatter:function(value){return value=='_blank' ? '新窗口':'当前页'}}
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