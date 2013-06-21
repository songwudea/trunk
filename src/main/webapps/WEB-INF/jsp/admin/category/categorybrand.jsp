<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<div id="formwrapper">
	<c:if test="${message!=null}">
		<div id=xbox>
			${message}
		</div>
	</c:if>

	<fieldset>
		<legend>分类品牌信息</legend>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
			<form name="form" method="post" action="${ctx}/admin/category/categorybrand.html">
				<input id="id" type="hidden" name="id" value="${id}">
				<tr>
					<td>
						<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0">
							<tr class="nowtable">
								<tr class="nowtable">
										<td width="20%" colspan="2">
										<c:forEach var="brand" items="${brands}" varStatus="state">
											<input type="checkbox" value="${brand.id}" name="brandid" id="brandid" <c:if test="${fn:contains(checkbrands,brand.id)}">checked</c:if>/>${brand.name}
											<c:if test="${state.index / 5 == 1}"><br></c:if>
										</c:forEach>
										</td>
								</tr>
							</tr>
						</table>
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
