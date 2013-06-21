<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
	
		<form method="post" name="form" action="${ctx}/admin/chooseSite.html">
			<fieldset>
				<legend>站点选择</legend>
				<div>
					<label for="siteId">管理站点</label>
					<select id="siteId" name="siteId">
						<c:forEach var="site" items="${sites}" varStatus="state">
							<option value="${site.id}">${site.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="enter">
					<input name="submit" type="submit" class="buttom" value="选择" />
				</div>
			</fieldset>
		</form>
</div>
