<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
	
	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
		<form method="post" name="form" action="${ctx}/admin/role/edit.html">
			<input type="hidden" name="id" id="id" size="24" value="${model.id}"/>
			<fieldset>
				<legend>角色信息</legend>
				<div>
					<label for="name">角色名</label>
					<input type="text" name="name" class="input" id="name" size="20" maxlength="30" value="${model.name}"/><br/>
				</div>
				<div>
					<label for="description">角色描述</label>
					<input type="text" name="description" class="input" id="description" size="20" maxlength="30" value="${model.description}"/><br/>
				</div>
				<div class="enter">
					<input name="create791" type="submit" class="buttom" value="提交" />
					<input name="submit" type="reset" class="buttom" value="重置" />
				</div>
			</fieldset>
		</form>
</div>
