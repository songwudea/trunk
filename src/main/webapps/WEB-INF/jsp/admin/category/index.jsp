<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery.EasyUI</title>
    <script type="text/javascript">
    $(document).ready(function() {
   		$('#tt').treegrid({
   			url:'${ctx}/admin/category/list.html',
   			frozenColumns:[[
                {title:'分类名称',field:'name',width:180}
			]],
			columns:[[
				{field:'attr',title:'属性数量',width:80},
				{field:'headerTpl',title:'头模版',width:80,formatter:function(value){ return value==null || value =='' ?'':'<font color="green">有</font>';}},
				{field:'footerTpl',title:'脚模版',width:80,formatter:function(value){return value==null || value =='' ?'':'<font color="green">有</font>';}}
			]],
   			  
   			toolbar:[{
	        	text:'新增',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		var node = $('#tt').treegrid('getSelected');
					if (node) {
						if(node.level == 2) {
							alert("只支持3级分类");
						} else {
							document.location.href="${ctx}/admin/category/edit.html?method=add&categoryId=" + node.id + "&level=" + node.level;
						}
					} else {
						document.location.href="${ctx}/admin/category/edit.html?method=add";
					}
	         	}
     		},{
     			text:'修改',  
	         	iconCls:'icon-edit',
	         	plain:true,
	         	handler:function() {
	         		var node = $('#tt').treegrid('getSelected');
					if (node) {
						if(node.level <= 2) {
							document.location.href="${ctx}/admin/category/edit.html?method=edit&categoryId=" + node.id + "&level=" + node.level;
						}
					} else {
						alert('请选中一个分类');
					}
	         	}
     		},{
     			text:'分配品牌',
     			iconCls:'icon-edit',
	         	plain:true,
	         	handler:function() {
	         		var node = $('#tt').treegrid('getSelected');
	         		
	         		if(node) {
	         			if(node.level == 0) {
		         			document.location.href="${ctx}/admin/category/categorybrand.html?categoryId=" + node.id;
		         		} else {
		         			alert("分配品牌只支持大类");
		         		}
	         		} else {
	         			alert('请选中一个大类');
	         		}
	         	}
     		},{
     			text:'创建分类属性',
     			iconCls:'icon-edit',
	         	plain:true,
	         	handler:function() {
	         		var node = $('#tt').treegrid('getSelected');
	         		if(node == null) {
						alert('请选中一个分类');	         		
	         		} else {
		        	 	document.location.href="${ctx}/admin/category/doCategoryAttribute.html?id=" + node.id;
	         		}
	         		
	         	}
	        },{
	        	text:'查看',
     			iconCls:'icon-edit',
	         	plain:true,
	         	handler:function() {
	         		var node = $('#tt').treegrid('getSelected');
	        	 	document.location.href="${ctx}/admin/category/categoryView.html?id=" + node.id;
	         	}
	        },{
	        	text:'1级分类页面配置',
	        	iconCls:'icon-edit',
	         	plain:true,
	         	handler:function() {
	         		var node = $('#tt').treegrid('getSelected');
	         		if(node.level == 0) {
	         			// /admin/indexpublish/
	        	 		document.location.href="${ctx}/admin/indexpublish/?categoryId=" + node.id + "&pageType=Category";	
	         		} else {
	         			alert('目前只支持1级分类');
	         		}
	         	}
	        },{
	        	text:'1级分类页面静态配置',
	        	iconCls:'icon-edit',
	         	plain:true,
	         	handler:function() {
	         		var node = $('#tt').treegrid('getSelected');
	         		if(node.level == 0) {
	         			// /admin/indexpublish/
	        	 		document.location.href="${ctx}/admin/category/editcategorypage.html?categoryId=" + node.id;	
	         		} else {
	         			alert('目前只支持1级分类');
	         		}
	         	}
	        }],
   			title:'分类管理',
   			loadMsg:"正在加载......",
			width:800,
			height:550,
			animate:false,
			idField:'id',
			striped:true,
			singleSelect:false,
			collapsible:false,
			treeField:'name',
			onLoadSuccess:function(row, data) {
				$('#tt').treegrid("collapseAll");
			}
   		});
    });
	</script>
</head>
	<body>
		<table id="tt">
		</table>
	</body>
</html>