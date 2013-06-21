<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<head>
	<script type="text/javascript" charset="utf-8" src="${ctx}/common/js/ueditor/editor_config.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/ueditor/editor_all_min.js"></script>
   	<link rel="stylesheet" type="text/css" href="${ctx}/common/js/ueditor/themes/default/ueditor.css"/>
   	<script type="text/javascript" >
    $(document).ready(function() {
		var editor_a = new baidu.editor.ui.Editor({
			autoFloatEnabled: false,
			minFrameHeight: 800,
			autoHeightEnabled:false,
			elementPathEnabled:false,
			maximumWords:10000000,
			wordCount:false,
			textarea:'indexHtmlContent'
		});
		editor_a.render('indexHtmlContent');
	});
</script>
</head>
	<div id="formwrapper">
	<c:if test="${message!=null}">
		<div id=xbox>
			${message}
		</div>
	</c:if>
	<form method="post" name="form" action="${ctx}/admin/site/editindexpage.html">
		<input type="hidden" name="siteId" id="siteId" value="${siteId}"/>
		<fieldset>
			<legend>首页静态页面编辑</legend>
			<div><script type="text/plain" id="indexHtmlContent" name="indexHtmlContent">${model.indexHtmlContent}</script></div>
		</fieldset>
		<div class="enter">
			<input name="add" type="submit" class="buttom" value="新增" />
			<input name="submit" type="reset" class="buttom" value="重置" />
		</div>
	</form>
</div>
