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
		fieldset label {float:left;width:120px;
		text-align:right;padding:4px;margin:1px;}
		fieldset div {clear:left;margin-bottom:2px;}
		.input { width:120px;}
		.enter{ text-align:center;}
		.clear {clear:both;}
	-->
	</style>
</head>
<body>	
	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
		<form method="post" name="form" action="${ctx}/staff/edit.html">
			<input type="hidden" name="id" id="id" size="24" value="${model.id}"/>
			<fieldset>
				<legend>用户信息</legend>
				<div>
					<label for="sta_username">用户名</label>
					<input type="text" name="sta_username" class="input" id="sta_username" size="20" maxlength="30" value="${model.sta_username}"/>
					*(最多30个字符)<br/>
				</div>
				<div>
					<label for="sta_password">密码</label>
					<input type="text" name="sta_password" class="input" id="sta_password" size="20" maxlength="30" value="${model.sta_password}"/>
					*(最多30个字符)<br/>
				</div>
				<div>
					<label for="sta_email">邮箱</label>
					<input type="text" name="sta_email" class="input" id="sta_email" size="20" maxlength="30" value="${model.sta_email}" />
					*(最多30个字符)<br/>
				</div>
				<div>
					<label for="sta_name">真实姓名</label>
					<input type="text" name="sta_name" class="input" id="sta_name" size="20" maxlength="30" value="${model.sta_name}" />
					*(最多30个字符)<br/>
				</div>
				<div>
					<label for="sta_sex">性别</label>
					<select name="sta_sex" id="sta_sex" class="select">
						<option value="">---请选择---</option>
						<option value="m" <c:if test="${model.sta_sex == 'm'}">selected</c:if>>男</option>
						<option value="f" <c:if test="${model.sta_sex == 'f'}">selected</c:if>>女</option>
					</select>
					*<br/>
				</div>
				<div>
					<label for="sta_province">省份</label>
					<select name="sta_province" id="sta_province" class="select">
						<option value="">---请选择---</option>
						<option value="北京市" <c:if test="${model.sta_province == '北京市'}">selected</c:if>>北京市</option>
						<option value="上海市" <c:if test="${model.sta_province == '上海市'}">selected</c:if>>上海市</option>
						<option value="天津市" <c:if test="${model.sta_province == '天津市'}">selected</c:if>>天津市</option>
						<option value="河北省" <c:if test="${model.sta_province == '河北省'}">selected</c:if>>河北省</option>
						<option value="山西省" <c:if test="${model.sta_province == '山西省'}">selected</c:if>>山西省</option>
						<option value="内蒙古" <c:if test="${model.sta_province == '内蒙古'}">selected</c:if>>内蒙古</option>
						<option value="辽宁省" <c:if test="${model.sta_province == '辽宁省'}">selected</c:if>>辽宁省</option>
						<option value="吉林省" <c:if test="${model.sta_province == '吉林省'}">selected</c:if>>吉林省</option>
						<option value="黑龙江" <c:if test="${model.sta_province == '黑龙江'}">selected</c:if>>黑龙江</option>
						<option value="江苏省" <c:if test="${model.sta_province == '江苏省'}">selected</c:if>>江苏省</option>
						<option value="浙江省" <c:if test="${model.sta_province == '浙江省'}">selected</c:if>>浙江省</option>
						<option value="安徽省" <c:if test="${model.sta_province == '安徽省'}">selected</c:if>>安徽省</option>
						<option value="福建省" <c:if test="${model.sta_province == '福建省'}">selected</c:if>>福建省</option>
						<option value="江西省" <c:if test="${model.sta_province == '江西省'}">selected</c:if>>江西省</option>
						<option value="山东省" <c:if test="${model.sta_province == '山东省'}">selected</c:if>>山东省</option>
						<option value="河南省" <c:if test="${model.sta_province == '河南省'}">selected</c:if>>河南省</option>
						<option value="湖北省" <c:if test="${model.sta_province == '湖北省'}">selected</c:if>>湖北省</option>
						<option value="湖南省" <c:if test="${model.sta_province == '湖南省'}">selected</c:if>>湖南省</option>
						<option value="广东省" <c:if test="${model.sta_province == '广东省'}">selected</c:if>>广东省</option>
						<option value="广西区" <c:if test="${model.sta_province == '广西区'}">selected</c:if>>广西区</option>
						<option value="海南省" <c:if test="${model.sta_province == '海南省'}">selected</c:if>>海南省</option>
						<option value="重庆市" <c:if test="${model.sta_province == '重庆市'}">selected</c:if>>重庆市</option>
						<option value="四川省" <c:if test="${model.sta_province == '四川省'}">selected</c:if>>四川省</option>
						<option value="贵州省" <c:if test="${model.sta_province == '贵州省'}">selected</c:if>>贵州省</option>
						<option value="云南省" <c:if test="${model.sta_province == '云南省'}">selected</c:if>>云南省</option>
						<option value="西藏区" <c:if test="${model.sta_province == '西藏区'}">selected</c:if>>西藏区</option>
						<option value="陕西省" <c:if test="${model.sta_province == '陕西省'}">selected</c:if>>陕西省</option>
						<option value="甘肃省" <c:if test="${model.sta_province == '甘肃省'}">selected</c:if>>甘肃省</option>
						<option value="青海省" <c:if test="${model.sta_province == '青海省'}">selected</c:if>>青海省</option>
						<option value="宁夏区" <c:if test="${model.sta_province == '宁夏区'}">selected</c:if>>宁夏区</option>
						<option value="新疆区" <c:if test="${model.sta_province == '新疆区'}">selected</c:if>>新疆区</option>
					</select>
					*<br/>
				</div>
				<div>
					<label for="sta_tel">电话</label>
					<input type="text" name="sta_tel" class="input" id="sta_tel" size="20" maxlength="150" value="${model.sta_tel}"/>
					*<br/>
				</div>
				<div>
					<label for="sta_mobile">手机</label>
					<input type="text" name="sta_mobile" class="input" id="sta_mobile" size="20" maxlength="150" value="${model.sta_mobile}" />
					*<br/>
				</div>
				<div>
					<label for="sta_loginstatus">状态</label>
					<select name="sta_loginstatus" id="sta_loginstatus" class="select">
						<option value="">---请选择---</option>
						<option value="y" <c:if test="${model.sta_loginstatus == 'y'}">selected</c:if>>有效</option>
						<option value="n" <c:if test="${model.sta_loginstatus == 'n'}">selected</c:if>>无效</option>
					</select>
					*<br/>
				</div>
				<div>
					<label for="sta_station">职责</label>
					<select name="sta_station" id="sta_station">
						<option value="">---请选择---</option>
						<option value="zc" <c:if test="${model.sta_station == 'zc'}">selected</c:if>>总裁</option>
						<option value="jl" <c:if test="${model.sta_station == 'jl'}">selected</c:if>>经理</option>
						<option value="kf" <c:if test="${model.sta_station == 'kf'}">selected</c:if>>客服</option>
						<option value="xs" <c:if test="${model.sta_station == 'xs'}">selected</c:if>>销售</option>
						<option value="sc" <c:if test="${model.sta_station == 'sc'}">selected</c:if>>市场</option>
						<option value="js" <c:if test="${model.sta_station == 'js'}">selected</c:if>>技术</option>
						<option value="cw" <c:if test="${model.sta_station == 'cw'}">selected</c:if>>财务</option>
						<option value="xz" <c:if test="${model.sta_station == 'xz'}">selected</c:if>>行政</option>
						<option value="hb" <c:if test="${model.sta_station == 'hb'}">selected</c:if>>伙伴</option>
					</select>
					*(最多15个字符)<br/>
				</div>
				<div class="enter">
					<input name="create791" type="submit" class="buttom" value="提交" />
					<input name="submit" type="reset" class="buttom" value="重置" />
				</div>
			</fieldset>
		</form>
</div>
</body>
</html>