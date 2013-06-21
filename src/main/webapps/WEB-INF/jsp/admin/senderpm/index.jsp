<%@ page contentType="text/html; charset=utf-8"%><%@ include file="/common/jspHead.jsp" %>
<!doctype html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/ueditor/editor_config.js"></script>
	<script type="text/javascript" src="${ctx}/js/ueditor/editor_all_min.js"></script>
	 	<link rel="stylesheet" type="text/css" href="${ctx}/js/ueditor/themes/default/ueditor.css"/>
<style>
</style>
</head><div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
		<form method="post" name="form" action="${ctx}/admin/senderpm/sendsms.html">
			<fieldset>
				<legend>发送短信</legend>
				<div>
					<label for="phone">手机号码</label>
					<input type="text" name="phone" class="input" id="phone" size="20" maxlength="30" value="${model.title}"/><br/>
				</div>
				<div>
					<label for="content">消息内容</label>
					<textarea id="content" name="content" rows="7" cols="30"></textarea><br/>
				</div>
				<div class="enter">
					<input name="add" type="submit" class="buttom" value="确认发送" />
					<input name="submit" type="reset" class="buttom" value="重置" />
				</div>
			</fieldset>
		</form>
</div>
