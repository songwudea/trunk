<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery.EasyUI</title>
    <link href="${ctx}/common/css/default.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/common/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/jquery.easyui.min.1.2.2.js"></script>
    <link href="${ctx}/common/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/common/js/themes/icon.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
	<!--
		#xbox {
			clear: both; border-right: #19cc01 2px solid; border-top: #19cc01 2px solid; padding-left: 30px; background: url(/uploadfile/2007-10/200710212547404.gif) #f2fcf1 no-repeat left center; margin-bottom: 8px; border-left: #19cc01 2px solid; color: #159600; line-height: 24px; border-bottom: #19cc01 2px solid; height: 24px; text-align: right
			height:auto !important;
			height:200px; /*假定最低高度是200px*/
			height:auto !important;
			min-height:50px; 
		}
		body {font-family: Arial, Helvetica, sans-serif;
		font-size:12px;color:#666666;background:#fff;
		text-align:center;}
		* {margin:0;padding:0;}
		a {color:#1E7ACE;text-decoration:none; }
		a:hover {color:#000;text-decoration:underline;}
		h3 {font-size:14px;font-weight:bold;}
		pre,p {color:#1E7ACE;margin:4px;}
		input, select,textarea {padding:1px;
		margin:2px;font-size:11px;}
		.buttom{padding:1px 10px;font-size:12px;
		border:1px #1E7ACE solid;background:#D0F0FF;}
		#formwrapper {width:600px;margin:15px auto;
		padding:20px;text-align:left;border:1px solid #A4CDF2;}
		fieldset {padding:10px;margin-top:5px;
		border:1px solid #A4CDF2;background:#fff;}
		fieldset legend {color:#1E7ACE;font-weight:bold;
		padding:3px 20px 3px 20px;border:1px solid #A4CDF2; 
		background:#fff;}
		fieldset label {float:left;width:120px; text-align:right;padding:4px;margin:1px;}
		fieldset span {float:left;width:80px; text-align:left;padding:4px;margin:1px;}
		fieldset div {clear:left;margin-bottom:2px;}
		.input { width:120px;}
		.enter{ text-align:center;}
		.clear {clear:both;}
	-->
	</style>
</head>
<body>	
	<div id="formwrapper">
		<fieldset>
			<legend>用户信息</legend>
			<div>
				<label for="sta_username">用户名</label>
				<span>${model.sta_username}</span>
			</div>
			<div>
				<label for="sta_password">密码</label>
				<span>${model.sta_password}</span>
			</div>
			<div>
				<label for="sta_email">邮箱</label>
				<span>${model.sta_email}</span>
			</div>
			<div>
				<label for="sta_name">真实姓名</label>
				<span>${model.sta_name}</span>
			</div>
			<div>
				<label for="sta_sex">性别</label>
				<span>
				<c:if test="${model.sta_sex == 'm'}">男</c:if>
				<c:if test="${model.sta_sex == 'f'}">女</c:if>
				</span>
			</div>
			<div>
				<label for="sta_province">省份</label>
				<span>
				<c:if test="${model.sta_province == '北京市'}">北京市</c:if>
				<c:if test="${model.sta_province == '上海市'}">上海市</c:if>
				<c:if test="${model.sta_province == '天津市'}">天津市</c:if>
				<c:if test="${model.sta_province == '河北省'}">河北省</c:if>
				<c:if test="${model.sta_province == '山西省'}">山西省</c:if>
				<c:if test="${model.sta_province == '内蒙古'}">内蒙古</c:if>
				<c:if test="${model.sta_province == '辽宁省'}">辽宁省</c:if>
				<c:if test="${model.sta_province == '吉林省'}">吉林省</c:if>
				<c:if test="${model.sta_province == '黑龙江'}">黑龙江</c:if>
				<c:if test="${model.sta_province == '江苏省'}">江苏省</c:if>
				<c:if test="${model.sta_province == '浙江省'}">浙江省</c:if>
				<c:if test="${model.sta_province == '安徽省'}">安徽省</c:if>
				<c:if test="${model.sta_province == '福建省'}">福建省</c:if>
				<c:if test="${model.sta_province == '江西省'}">江西省</c:if>
				<c:if test="${model.sta_province == '山东省'}">山东省</c:if>
				<c:if test="${model.sta_province == '河南省'}">河南省</c:if>
				<c:if test="${model.sta_province == '湖北省'}">湖北省</c:if>
				<c:if test="${model.sta_province == '湖南省'}">湖南省</c:if>
				<c:if test="${model.sta_province == '广东省'}">广东省</c:if>
				<c:if test="${model.sta_province == '广西区'}">广西区</c:if>
				<c:if test="${model.sta_province == '海南省'}">海南省</c:if>
				<c:if test="${model.sta_province == '重庆市'}">重庆市</c:if>
				<c:if test="${model.sta_province == '四川省'}">四川省</c:if>
				<c:if test="${model.sta_province == '贵州省'}">贵州省</c:if>
				<c:if test="${model.sta_province == '云南省'}">云南省</c:if>
				<c:if test="${model.sta_province == '西藏区'}">西藏区</c:if>
				<c:if test="${model.sta_province == '陕西省'}">陕西省</c:if>
				<c:if test="${model.sta_province == '甘肃省'}">甘肃省</c:if>
				<c:if test="${model.sta_province == '青海省'}">青海省</c:if>
				<c:if test="${model.sta_province == '宁夏区'}">宁夏区</c:if>
				<c:if test="${model.sta_province == '新疆区'}">新疆区</c:if>
				</span>
			</div>
			<div>
				<label for="sta_tel">电话</label>
				<span>${model.sta_tel}</span>
			</div>
			<div>
				<label for="sta_mobile">手机</label>
				<span>${model.sta_mobile}</span>
			</div>
			<div>
				<label for="sta_loginstatus">状态</label>
				<span>
				<c:if test="${model.sta_loginstatus == 'y'}">有效</c:if>
				<c:if test="${model.sta_loginstatus == 'n'}">无效</c:if>
				</span>
			</div>
			<div>
				<label for="sta_station">职责</label>
				<span>
				<c:if test="${model.sta_station == 'zc'}">总裁</c:if>
				<c:if test="${model.sta_station == 'jl'}">经理</c:if>
				<c:if test="${model.sta_station == 'kf'}">客服</c:if>
				<c:if test="${model.sta_station == 'xs'}">销售</c:if>
				<c:if test="${model.sta_station == 'sc'}">市场</c:if>
				<c:if test="${model.sta_station == 'js'}">技术</c:if>
				<c:if test="${model.sta_station == 'cw'}">财务</c:if>
				<c:if test="${model.sta_station == 'xz'}">行政</c:if>
				<c:if test="${model.sta_station == 'hb'}">伙伴</c:if>
				</span>
			</div>
		</fieldset>
</div>
</body>
</html>