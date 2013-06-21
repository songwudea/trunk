<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery.EasyUI</title>
    <link href="${ctx}/common/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/common/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/common/js/themes/icon.css" />
    <script type="text/javascript" src="${ctx}/common/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/jquery.easyui.min.1.2.2.js"></script>
    <script>
		$(function(){
			$('#pp').pagination({
				total:114,
				buttons:[{
					iconCls:'icon-add',
					handler:function(){
						alert('add');
					}
				},{
					iconCls:'icon-cut',
					handler:function(){
						alert('cut');
					}
				},{
					iconCls:'icon-save',
					handler:function(){
						alert('save');
					}
				}],
				onSelectPage:function(pageNumber, pageSize){
					$(this).pagination('loading');
					alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
					$(this).pagination('loaded');
				}
			});
		});
	</script>
    
</head>
<body>
	<h1>Pagination</h1>
	<div style="margin:10px 0;">
		<a href="#" onclick="javascript:$('#pp').pagination({loading:false})">loaded</a>
		<a href="#" onclick="javascript:$('#pp').pagination({loading:true})">loading</a>
	</div>
	
	<div id="pp" style="background:#efefef;border:1px solid #ccc;"></div>
</body>
</html>