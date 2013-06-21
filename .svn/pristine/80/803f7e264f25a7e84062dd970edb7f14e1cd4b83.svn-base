<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
	
	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
		<form method="post" name="form" action="${ctx}/admin/privilege/edit.html">
			<input type="hidden" name="id" id="id" size="24" value="${model.id}"/>
			<fieldset>
				<legend>权限信息</legend>
				<div>
					<label for="name">权限名</label>
					<input type="text" name="name" class="input" id="name" size="20" maxlength="30" value="${model.name}"/><br/>
				</div>
				<div>
					<label for="menuId">权限模块</label>
					<select id="menuId" name="menuId">
						<c:forEach var="menu" items="${menus}" varStatus="state">
							<option value="${menu.id}" <c:if test="${menu.id==model.menuId}">selected</c:if>>${menu.name}</option>
						</c:forEach>
					</select>
				</div>
				
				<div>
					<label for="description">权限描述</label>
					<input type="text" name="description" class="input" id="description" size="20" maxlength="30" value="${model.description}"/><br/>
				</div>
				<div>
					<label for="code">权限代码</label>
					<input type="text" name="code" class="input" id="code" size="20" maxlength="30" value="${model.code}"/><br/>
				</div>
				<div class="enter">
					<input name="create791" type="submit" class="buttom" value="提交" />
					<input name="submit" type="reset" class="buttom" value="重置" />
				</div>
			</fieldset>
		</form>
</div>
