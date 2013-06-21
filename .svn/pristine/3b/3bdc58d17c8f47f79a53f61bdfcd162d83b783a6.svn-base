<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<head>
	<meta http-equiv="link-Type" link="text/html; charset=utf-8" />
	<script type="text/javascript" charset="utf-8" src="${ctx}/common/js/ueditor/editor_config.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/ueditor/editor_all_min.js"></script>
   	<link rel="stylesheet" type="text/css" href="${ctx}/common/js/ueditor/themes/default/ueditor.css"/>
    <script type="text/javascript" >
	</script>
</head>
<body>

	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
	<form method="post" name="form" action="${ctx}/admin/link/edit.html">
		<input type="hidden" name="id" id="id" value="${model.id}"/>
		<fieldset>
			<legend>链接管理</legend>
			<div>
				<label for="title">链接URL</label>
				<input type="text" name="linkUrl" class="input" id="linkUrl" size="80" value="${model.linkUrl}"/><br/>
			</div>
			
			<div>
				<label for="title">链接类型</label>
				<select id="linkType" name="linkType">
					<option <c:if test="${model.linkType == 'MAIN_NAV'}">selected</c:if> value="MAIN_NAV">主导航</option>
					<option <c:if test="${model.linkType == 'FRIENDLY_LINK'}">selected</c:if> value="FRIENDLY_LINK">友情链接</option>
				</select>
			</div>
			
			<div>
				<label for="title">链接文本</label>
				<input type="text" name="linkText" class="input" id="linkText" size="80" value="${model.linkText}"/><br/>
			</div>
			<div>
				<label for="title">打开方式</label>
				<select id="linkTarget" name="linkTarget">
					<option value="" <c:if test="${model.linkTarget == ''}">selected</c:if>>当前页面</option>
					<option value="_blank" <c:if test="${model.linkTarget == '_blank'}">selected</c:if>>新窗口</option>
				</select>
			</div>
			
			<div class="enter">
				<input name="add" type="submit" class="buttom" value="提交" />
				<input name="submit" type="reset" class="buttom" value="重置" />
			</div>
		</fieldset>
	</form>
</div>
</body>