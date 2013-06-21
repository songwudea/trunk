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
    		title:"用户管理列表",
    		loadMsg:"正在加载......",
    		toolbar:[{  
	        	text:'新增',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		document.location.href="${ctx}/admin/staff/doEdit.html";
	         	}
     		},{  
	        	text:'修改',  
	         	plain:true,
	         	iconCls:'icon-edit',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		document.location.href="${ctx}/admin/staff/doEdit.html?id=" + row.id;
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
	                		$.post('${ctx}/admin/staff/delete.html',{id:row.id},function(data){
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
    		},{  
	        	text:'查看',  
	         	iconCls:'icon-ok',
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		document.location.href="${ctx}/admin/staff/view.html?id=" + row.id;
	         	}
     		},{  
	        	text:'导出',  
	         	iconCls:'icon-excel'
     		}],
			rows:15,
			pageSize:15,
			pageList:[15],
			width:"820",
			method:"post",
			url:'${ctx}/admin/staff/list.html',  
			pagination:true,
			rownumbers:true,
			sortName:'id',
    		sortOrder:'asc',
	     	columns:[[  
	        	{field:'id',title:'',width:60, checkbox:true},
	        	{field:'sta_username',title:'用户名',width:100, sortable:true},
	        	{field:'sta_email',title:'邮件',width:120, sortable:true},
	        	{field:'sta_sex',title:'性别',width:45, formatter:function(value){return value=="m" ?'男':'女';},sortable:true},
	        	{field:'sta_tel',title:'电话',width:100,sortable:true},
	        	{field:'sta_mobile',title:'手机',width:100},
	        	{field:'sta_loginstatus',title:'状态',width:100,sortable:true, formatter:function(value){return value=="y" ?'<font color="green">有效</font>':'<font color="red">无效</font>';}},
	        	{field:'sta_province',title:'省份',width:100},
	        	{field:'sta_station',title:'岗位',width:100,formatter:function(value){
	         			 		if(value == 'zc') {
	         			 			return '总裁';
	         			 		} else if(value == 'jl') {
	         			 			return '经理';
	         			 		} else if(value == 'kf') {
	         			 			return '客服';
	         			 		} else if(value == 'xs') {
	         			 			return '销售';
	         			 		} else if(value == 'sc') {
	         			 			return '市场';
	         			 		} else if(value == 'js') {
	         			 			return '技术';
	         			 		} else if(value == 'cw') {
	         			 			return '财务';
	         			 		} else if(value == 'xz') {
	         			 			return '行政';
	         			 		} else if(value == 'hb') {
	         			 			return '伙伴';
	         			 		} else {
	         			 			return "";
	         			 		}
	         			 	}}
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
    
    var del = function() {
    	var row = $('#tt').datagrid('getSelected');
    	$.messager.confirm('确认删除', '删除用户后，它所有的发帖和回帖将同时删除（不可恢复），你确定要这样做吗？', function(r){
    		if(r) {
    				$.post('${ctx}/admin/staff/delete.html',{id:row.id},function(data){
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
<div id="tb" style="padding:5px;height:auto;">  
	<div>  
		用户名 : <input style="width:70px" id="sta_username" />  
		邮件 : <input style="width:70px" id="sta_email" />
		状态 : <select id="sta_loginstatus" name="sta_loginstatus">
			<option value="">---请选择---</option>
			<option value="n">无效</option>
			<option value="y">有效</option>
		</select>  
		
		岗位 :<select id="sta_station" name="sta_station">
		<option value="">---请选择---</option>
		<option value="zc">总裁</option>
		<option value="jl">经理</option>
		<option value="kf">客服</option>
		<option value="xs">销售</option>
		<option value="sc">市场</option>
		<option value="js">技术</option>
		<option value="cw">财务</option>
		<option value="xz">行政</option>
		<option value="hb">伙伴</option>
	</select>
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchlist();">查询</a>  
	</div>  
</div>	


<table id="tt">
</table>



</body>
</html>