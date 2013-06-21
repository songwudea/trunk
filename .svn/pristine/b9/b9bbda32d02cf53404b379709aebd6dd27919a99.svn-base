<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>

<!doctype html>
	
	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
		<form method="post" name="form" action="${ctx}/admin/employee/edit.html">
			<input type="hidden" name="id" id="id" size="24" value="${model.id}"/>
			<fieldset>
				<legend>员工信息</legend>
				<div>
					<label for="account">用户名</label>
					<input type="text" name="account" class="input" id="account" size="30" maxlength="30" value="${model.account}"/><br/>
				</div>
				<div>
					<label for="password">密码</label>
					<input type="password" name="password" class="input" id="password" size="30" maxlength="30" value="${model.password}"/><br/>
				</div>
				<div>
					<label for="position">部门</label>
					<input type="text" name="department" class="input" id="department" size="30" maxlength="30" value="${model.department}"/><br/>
				</div>
				<div>
					<label for="position">职位</label>
					<input type="text" name="position" class="input" id="position" size="30" maxlength="30" value="${model.position}"/><br/>
				</div>
				<div>
					<label for="name">真实姓名</label>
					<input type="text" name="name" class="input" id="name" size="30" maxlength="30" value="${model.name}"/><br/>
				</div>
				<div>
					<label for="gender">性别</label>
					<select name="gender" id="gender" class="select">
						<option value="">---请选择---</option>
						<option value="m" <c:if test="${model.gender=='m'}">selected</c:if>>男</option>
						<option value="f" <c:if test="${model.gender=='f'}">selected</c:if>>女</option>
					</select>
					<br/>
				</div>
				<div>
					<label for="email">email</label>
					<input type="text" name="email" class="input" id="email" size="30" maxlength="30" value="${model.email}"/><br/>
				</div>
				<div>
					<label for="telphone">电话</label>
					<input type="text" name="telphone" class="input" id="telphone" size="30" maxlength="30" value="${model.telphone}"/><br/>
				</div>
				<div>
					<label for="mobile">手机</label>
					<input type="text" name="mobile" class="input" id="mobile" size="30" maxlength="30" value="${model.mobile}"/><br/>
					<br/>
				</div>
				<div class="enter">
					<input name="create791" type="submit" class="buttom" value="提交" />
					<input name="submit" type="reset" class="buttom" value="重置" />
				</div>
			</fieldset>
		</form>
</div>
