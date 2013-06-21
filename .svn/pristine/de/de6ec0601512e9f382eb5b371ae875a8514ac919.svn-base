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
    		title:"内容类型",
    		loadMsg:"正在加载......",
    		toolbar:[{
	        	text:'新增',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		document.location.href="${ctx}/admin/contentType/edit.html";
	         	}
     		 },{  
	        	text:'修改',  
	         	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		document.location.href="${ctx}/admin/contentType/edit.html?id=" + row.id;
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
	                		$.post('${ctx}/admin/contentType/delete.html',{id:row.id},function(data){
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
			striped:true,
			method:"post",
			url:'${ctx}/admin/contentType/list.html',  
			pagination:true,
			rownumbers:true,
			sortName:'id',
    		sortOrder:'asc',
	     	columns:[[  
	        	{field:'id',title:'',width:60, checkbox:true},
	        	{field:'name',title:'类型名称',width:60,formatter:function(value,rowData){return "<a href='${ctx}/admin/content/?typeId="+rowData.id+"'>"+value+"</a>";}}
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