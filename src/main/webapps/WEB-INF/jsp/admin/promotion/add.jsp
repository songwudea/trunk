<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>

<!doctype html>

		<script type="text/javascript"  >
			$(".datebox :text").attr("readonly","readonly");
		</script>

	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		

		
		<form method="post" name="form" action="${ctx}/admin/employee/edit.html">
			<input type="hidden" name="id" id="id" size="24" value="${model.id}"/>
			<fieldset>
				<legend>组合促销设置</legend>
				
				<div>
					<label for="password">商品名称</label>
					<input type="text" name="name" class="input" id="password" size="30" maxlength="30" value="${model.password}" /><br/>
				</div>
				
				<div>
					<label for="account">商品数量</label>
					<input type="text" name="account" class="input" id="account" size="30" maxlength="30" value="${model.account}"/><br/>
				</div>
				
				<div>
					<label for="password">促销开始时间</label>
					<input type="text" name="spec.pubTime" class="easyui-datebox" id="pubTime" value="${model.password}" readonly="readonly"/><br/>
				</div>
				
				<div>
					<label for="password">促销结束时间</label>
					<input type="text" name="spec.pubTime" class="easyui-datebox" id="pubTime"  value="${model.password} " readonly="readonly"/><br/>
				</div>
				
				
				<div>
					<label for="password">减免价格</label>
					<input type="text" name="price" class="input" id="password" size="30" maxlength="30" value="${model.password}"/><br/>
				</div>
		
				<div class="enter">
					<input name="create791" type="submit" class="buttom" value="确定" />
					<input name="submit" type="reset" class="buttom" value="重置" />
				</div>
			</fieldset>
		</form>
</div>
