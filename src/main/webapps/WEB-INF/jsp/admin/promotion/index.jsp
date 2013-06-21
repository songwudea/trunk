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
	        	text:'查看用户地址',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		var row = $('#tt').datagrid('getSelected');
	         		if(row == null) {
	         			alert('请选择一个用户');
	         		}else{
		         		document.location.href="${ctx}/admin/address/?userId="+row.id;
	         		} 
	         	}
     		},{
	        	text:'下载所有用户',  
	         	iconCls:'icon-edit',
	         	plain:true,
	         	handler:function() {
	         		var loadingTip = $('#loadingTip');
	         		loadingTip.show();
		            loadingTip.ajaxStart(function(){
		                loadingTip.text('loading...');
		            });
	         		$.post('${ctx}/admin/user/downuser.html',{},
	         		function(data){
            			if(data != '') {
            				loadingTip.ajaxStop(function(){
				                loadingTip.empty();
				                loadingTip.hide();
				            });
                    		$('#tt').datagrid('reload');//刷新当前页数据
                    		window.location.href = "${ctx}"+data;
                    		$.messager.alert('操作成功','导出用户成功','info');
            			} else {
            				$.messager.alert('操作失败','导出用户失败','info');
            			}
		             });
	         	}
     		}],
			rows:15,
			striped:true,
			pageSize:15,
			pageList:[15],
			width:"820",
			method:"post",
			url:'${ctx}/admin/user/list.html',  
			pagination:true,
			singleSelect:true,
			rownumbers:true,
			sortName:'id',
    		sortOrder:'desc',
	     	columns:[[  
	        	{field:'username',title:'用户名',width:140},
	        	{field:'email',title:'电子邮件',width:140},
	        	{field:'name',title:'姓名',width:140},
	        	{field:'gender',title:'性别',width:140,
	        		formatter:function(value) {
	        			if(value == 'MALE') {
	        				return '男';
	        			} else if(value == 'FEMALE') {
	        				return '女';
	        			} 
	        			return "";
	        		}
	        	},
	        	{field:'mobile',title:'手机',width:140},
	        	{field:'userSource',title:'用户来源',width:140,sortable:true,
	        		formatter:function(value,rowData) {
	        			if(value == 'SINA_WEIBO') {
	        				return '新浪微博';
	        			} else if(value == 'QQ') {
	        				return 'QQ';
	        			} else if(value == 'MSN') {
	        				return 'MSN';
	        			} else if(value == 'ALIPAY') {
	        				return 'ALIPAY';
	        			} else if(value == 'TENCENT_WEIBO') {
	        				return '腾讯微博';
	        			} else {
	        				return "";
	        			}
	        			return "";
	        		}
	        	},
	        	{field:'createdAt',title:'注册时间',width:140,sortable:true,
	        		formatter:function(value) {
	        		if(value == null) {
	        			return "";
	        		} else {
	        			var date = new Date(value)  
	        	 		return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
	        		}	
	        	}
	        	}
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
	    queryParams.username= $('#username').val();
	    
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.email= $('#email').val();
	
		var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.mobile= $('#mobile').val();
	    
	    var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.gender= $('#gender').val();
	    
	    var queryParams = $('#tt').datagrid('options').queryParams;
	    queryParams.userSource= $('#userSource').val();
	    
		$('#tt').datagrid('options').queryParams=queryParams; 
		$("#tt").datagrid('reload');
    }
    
	</script>
	
</head>
	<body>
	<div id="loadingTip" style="height:80px;width:300px; display:none; color:red; align:middle; font-size:24px;"></div>
		<div id="tb" style="padding:5px;height:auto;float:left;">  
			用户名:<input style="width:150px" id="username" /> 
			性别:<select name="gender" id="gender">
				<option value="all">全部</option>
				<option value="MALE" <c:if test="${user.gender == 'MALE'}">selected="selected"</c:if> >男</option>
				<option value="FEMALE" <c:if test="${user.gender == 'FEMALE'}">selected="selected"</c:if>>女</option>
			    </select> 
			 来源:<select name="userSource" id="userSource">
				<option value="all">全部</option>
				<option value="qq" <c:if test="${user.userSource == 'qq'}">selected="selected"</c:if> >QQ</option>
				<option value="sina" <c:if test="${user.userSource == 'sina'}">selected="selected"</c:if>>SINA</option>
				<option value="alipay" <c:if test="${user.userSource == 'alipay'}">selected="selected"</c:if>>ALIPAY</option>
			    </select> 
			电子邮件:<input style="width:150px" id="email" />
			手机:<input style="width:150px" id="mobile" /> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchlist();">查询</a>  
		</div>	
		<div style="clear:both"></div>
		<table id="tt">
		</table>
	</body>
</html>