<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
	<div id="formwrapper">
		<fieldset>
			<c:if test="${topCategory != null}">
				<legend>大类- ${topCategory.name}</legend>
				<div>
					<label for="sta_username">大类品牌:</label>
					<span>
						<c:forEach var="brand" items="${topCategory.brands}" varStatus="state">
							${brand.name},
							<c:if test="${state.index / 8 == 1}"><br></c:if>
						</c:forEach>
					</span>
				</div>
				
				<div>
					<label for="sta_username">大类属性:</label>
					<span>
					<c:forEach var="categoryAttribute" items="${topCategory.categoryAttributes}" varStatus="state">
						${categoryAttribute.name},
						<c:if test="${state.index / 8 == 1}"><br></c:if>
					</c:forEach>
					</span>
				</div>
			</c:if>
		</fieldset>
		<c:if test="${parentCategory != null}">
		<fieldset>
				<legend>二级分类- ${parentCategory.name}</legend>
				<div>
					<label for="sta_username">分类属性:</label>
					<span>
					<c:forEach var="categoryAttribute" items="${parentCategory.categoryAttributes}" varStatus="state">
						${categoryAttribute.name},
						<c:if test="${state.index / 8 == 1}"><br></c:if>
					</c:forEach>
					</span>
				</div>
		</fieldset>
		</c:if>
		<c:if test="${currCategory != null}">
		<fieldset>
				<legend>三级分类- ${currCategory.name}</legend>
				<div>
					<label for="sta_username">分类属性:</label>
					<span>
					<c:forEach var="categoryAttribute" items="${currCategory.categoryAttributes}" varStatus="state">
						${categoryAttribute.name},
						<c:if test="${state.index / 8 == 1}"><br></c:if>
					</c:forEach>
					</span>
				</div>
		</fieldset>
		</c:if>
</div>
