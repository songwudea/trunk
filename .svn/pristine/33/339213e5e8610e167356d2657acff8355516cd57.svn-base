<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
	
	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
		<form method="post" name="form" action="${ctx}/admin/brand/edit.html">
			<input type="hidden" name="id" id="id" size="24" value="${model.id}"/>
			<fieldset>
				<legend>品牌信息</legend>
				<div>
					<label for="name">品牌名称</label>
					<input type="text" name="name" class="input" id="name" size="20" maxlength="30" value="${model.name}"/><br/>
				</div>
				<div>
					<label for="sorts">顺序</label>
					<input type="text" name="sorts" class="input" id="sorts" size="20" maxlength="30" value="${model.sorts}"/><br/>
				</div>
				<div>
					<label for="hide">是否显示</label>
					<input type="radio" id="hide" name="hide" value="0" checked />显示
					<input type="radio" id="hide" name="hide" value="1" />隐藏
					<br/>
				</div>
				<div class="enter">
					<input name="add" type="submit" class="buttom" value="提交" />
					<input name="submit" type="reset" class="buttom" value="重置" />
				</div>
			</fieldset>
		</form>
</div>
