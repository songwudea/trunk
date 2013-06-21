<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
	
	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
		<form method="post" name="form" action="${ctx}/admin/contentType/edit.html">
			<input type="hidden" name="id" id="id" size="24" value="${model.id}"/>
			<fieldset>
				<legend>内容类型</legend>
				<div>
					<label for="name">类型名称</label>
					<input type="text" name="name" class="input" id="name" size="20" maxlength="30" value="${model.name}"/><br/>
				</div>
				<div>
					<label for="code">类型编码</label>
					<input type="text" name="code" class="input" id="code" size="20" maxlength="50" value="${model.code}"/><br/>
				</div>
				<div class="enter">
					<input name="add" type="submit" class="buttom" value="提交" />
					<input name="submit" type="reset" class="buttom" value="重置" />
				</div>
			</fieldset>
		</form>
</div>
