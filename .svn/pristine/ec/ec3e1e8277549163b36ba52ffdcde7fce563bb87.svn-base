<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<div id="formwrapper">
		<fieldset>
			<legend>角色分配</legend>
			<c:if test="${message!=null}">
				<div id=xbox>
					${message}
				</div>
			</c:if>
			
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<th bgcolor="#8DB2E3">选择</th>
				<th bgcolor="#8DB2E3">角色名称</th>
				<th bgcolor="#8DB2E3">角色描述</th>
				<form name="form" method="post" action="${ctx}/admin/employee/employeeRole.html">
					<input id="employeeId" type="hidden" name="employeeId" value="${employeeId}">
					<c:forEach var="role" items="${roles}" varStatus="state">
						<c:if test="${state.index % 2 == 0}">
						<tr bgcolor="#FF6699">
							<td>
								<input type="checkbox" value="${role.id}" name="roleId" id ="roleId" <c:if test="${fn:contains(employeeRoles,role.id)}">checked</c:if> />
							</td>
							<td>
								${role.name}
							</td>
							<td>
								${role.description}
							</td>
						</tr>
						</c:if>
						<c:if test="${state.index % 2 == 1}">
						<tr bgcolor="#66FFFF">
							<td>
								<input type="checkbox" value="${role.id}" name="roleId" id ="roleId" <c:if test="${fn:contains(employeeRoles,role.id)}">checked</c:if> />
							</td>
							<td>
								${role.name}
							</td>
							<td>
								${role.description}
							</td>
						</tr>
						</c:if>
					</c:forEach>
					<tr>
						<td align="center">
							<input name="create791" type="submit" class="buttom" value="提交" />
						</td>
					</tr>
				</form>
			</table>
		</fieldset>
	</div>
