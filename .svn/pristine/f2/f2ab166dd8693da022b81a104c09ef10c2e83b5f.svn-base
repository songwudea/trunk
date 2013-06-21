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
    		title:"模版管理列表",
    		loadMsg:"正在加载......",
			rows:15,
			pageSize:15,
			pageList:[15],
			width:"820",
			method:"post",
			url:'${ctx}/admin/template/list.html',  
			pagination:true,
			striped:true,
			rownumbers:true,
			sortName:'id',
    		sortOrder:'asc',
    		toolbar:[{
	        	text:'首页模版配置',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		if(row == null) {
	         			alert('请选择模版');
	         		} else {
		         		document.location.href="${ctx}/admin/template/confighomepage.html?templateId=" + row.id + "&pageType=Page";
	         		}
	         		
	         	}
     		},{
	        	text:'分类模版配置',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		if(row == null) {
	         			alert('请选择模版');
	         		} else {
		         		document.location.href="${ctx}/admin/template/confighomepage.html?templateId=" + row.id + "&pageType=Category";
	         		}
	         	}
     		}],
	     	columns:[[  
	        	{field:'id',title:'',width:60, checkbox:true},
	        	{field:'name',title:'名称',width:60},
	        	{field:'path',title:'路径',width:60}
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