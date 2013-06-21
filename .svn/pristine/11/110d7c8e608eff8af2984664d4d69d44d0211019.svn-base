<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<div id="formwrapper">
		<fieldset>
			<legend>权限分配</legend>
			<c:if test="${message!=null}">
				<div id=xbox>
					${message}
				</div>
			</c:if>
			
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<form name="form" method="post" action="${ctx}/admin/role/permissions.html">
					<input id="roleId" type="hidden" name="roleId" value="${roleId}">
					<tr>
						<td>
							<c:forEach var="privileges" items="${privileges}" varStatus="state">
								<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0">
									<tr class="nowtable">
										<c:set var="array" value="${fn:split(privileges.key, '>')}"/>
										<c:if test="${array[0]!=name}">
											<c:set var="name" value="${array[0]}"/> 
											<tr class="nowtable">
												<td width="20%" bgcolor="#8DB2E3" colspan="2">${name}</td>
											</tr>
										</c:if>
									</tr>
									
									<c:if test="${state.index % 2== 0}">
										<tr bgcolor="#FF6699">
										<td width="20%">${array[1]}</td>
										<td width="80%">
											<c:forEach var="privilege" items="${privileges.value}" varStatus="stat">
												<input type="checkbox" value="${privilege.id}" name="privilegeid" <c:if test="${fn:contains(rolePrivilegeList,privilege.id)}">checked</c:if>/>${privilege.name}
												<c:if test="${stat.index / 4 == 1}"><br></c:if>
											</c:forEach>
										</td>				
										</tr>
									</c:if>
									
									<c:if test="${state.index % 2!= 0}">
										<tr bgcolor="#66FFFF">
										<td width="20%">${array[1]}</td>
										<td width="80%">
											<c:forEach var="privilege" items="${privileges.value}" varStatus="stat">
												<input type="checkbox" value="${privilege.id}" name="privilegeid" <c:if test="${fn:contains(rolePrivilegeList,privilege.id)}">checked</c:if>/>${privilege.name}
												<c:if test="${stat.index / 4 == 1}"><br></c:if>
											</c:forEach>
										</td>				
										</tr>
									</c:if>
								</table>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td align="center">
							<input name="create791" type="submit" class="buttom" value="提交" />
						</td>
					</tr>
				</form>
			</table>
		</fieldset>
	</div>
