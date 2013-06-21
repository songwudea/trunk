<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<div id="formwrapper">
	<c:if test="${message!=null}">
		<div id=xbox>
			${message}
		</div>
	</c:if>
	<form method="post" name="form" action="${ctx}/admin/category/categoryAttribute.html">
		<input type="hidden" name="categoryId" id="categoryId" size="24" value="${categoryModel.id}"/>
		<fieldset>
			<legend>分类属性信息</legend>
			<div>
				<label for="name">分类名称</label>
				<span>${categoryModel.name}</span>
			</div>
			
			<div>
				<label for="name">属性名称</label>
				<input type="text" name="name" class="input" id="name" size="20" maxlength="30" value="${model.name}"/>
			</div>
			<div>
				<label for="sorts">属性类型</label>
				<select id="attrType" name="attrType">
					<option value="SELECT">选择型</option>
					<option value="TEXT">输入型</option>
				</select>
			</div>
			<div>
				<label for="options">属性选项</label>
				<textarea id="options" name="options" class="input" rows="10">${model.options}</textarea>
			</div>
			<div>
				<label for="filter">商品筛选属性</label>
				<input type="radio" id="filter" name="filter" value="1" checked />是
				<input type="radio" id="filter" name="filter" value="0" />否
			</div>
			<div>
				<label for="filter">商品比较属性</label>
				<input type="radio" id="comparable" name="comparable" value="1" checked />是
				<input type="radio" id="comparable" name="comparable" value="0" />否
			</div>
			<div>
				<label for="memo">备注</label>		
				<input type="text" name="memo" class="input" id="memo" size="20" maxlength="30" value="${model.memo}"/><br/>	
			</div>
			<div class="enter">
				<input name="add" type="submit" class="buttom" value="提交" />
				<input name="submit" type="reset" class="buttom" value="重置" />
			</div>
		</fieldset>
	</form>
</div>
