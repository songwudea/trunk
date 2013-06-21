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
    		title:"品牌管理列表",
    		loadMsg:"正在加载......",
    		toolbar:[{
	        	text:'新增',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		document.location.href="${ctx}/admin/brand/edit.html";
	         	}
     		 },{  
	        	text:'修改',  
	         	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		if(row == null) {
	         			alert('请选中一个品牌');
	         		} else {
		         		document.location.href="${ctx}/admin/brand/edit.html?brandId=" + row.id;
	         		}
	         		
	         	}
     		 },{
     			id:'btndel',
				text:'删除',
	         	plain:true,
				iconCls:'icon-remove',
				handler:function(){
					var row = $('#tt').datagrid('getSelected');
					if (row) {
						$.messager.confirm('确认删除', '删除用户后，它所有的发帖和回帖将同时删除（不可恢复），你确定要这样做吗？', function(r){
						if(r) {
	                		$.post('${ctx}/admin/brand/delete.html',{id:row.id},function(data){
	                			if(data == 'suss') {
		                    		$('#tt').datagrid('reload');//刷新当前页数据
		                    		$.messager.alert('操作成功','删除数据成功','info');
	                			} else {
	                				$.messager.alert('操作失败','删除数据失败','info');
	                			}
		                	});
	                	}
					});
					}
				}
    		}],
			rows:15,
			pageSize:15,
			pageList:[15],
			width:"820",
			method:"post",
			url:'${ctx}/admin/brand/list.html',  
			pagination:true,
			rownumbers:true,
			singleSelect:true,
			sortName:'id',
    		sortOrder:'asc',
    		striped:true,
	     	columns:[[  
	        	{field:'name',title:'品牌名称',width:90},
	        	{field:'sorts',title:'顺序',width:60},
	        	{field:'hide',title:'状态',width:60,formatter:function(value){return value=="" ?'显示':'隐藏';}}
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