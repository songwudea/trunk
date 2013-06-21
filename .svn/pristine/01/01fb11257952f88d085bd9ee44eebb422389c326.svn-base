<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>瞳话官方商城</title>
    <link href="${ctx}/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/themes/icon.css" />
    <script type="text/javascript" src="${ctx}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.easyui.min.1.3.0.js"></script>
	<script type="text/javascript" src='${ctx}/js/outlook2.js'> </script>
    <style type="text/css">
	/*避免出现2层滚动条 BY TAO*/
		.panel DIV {overflow-y: hidden;}
	</style>
</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<input type="hidden" name="menus" id="menus" value=${menus}>
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div></noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(${ctx}/common/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 30px;color: #fff; font-family: Verdana, 微软雅黑,黑体;font-size:14px;margin-left:15px;">
		瞳话官方商城 <span style="float:right;margin-right:20px"><a href="${ctx}/admin/logout.html">退出系统</a><span>
    </div>
    <div region="west" hide="true" split="true" title="导航菜单" style="width:180px;overflow-y:hidden" id="west">
		<div id="nav" class="easyui-accordion" fit="true" border="false">
		<!--  导航内容 -->
				
		</div>

    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false">

		</div>
    </div>
    
    

	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>


</body>
 <script type="text/javascript">
 	rooturl = "${ctx}";
	var _menus = eval('(' + $('#menus').val() + ')');
    </script>
</html>