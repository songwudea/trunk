<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/ueditor/editor_config.js"></script>
	<script type="text/javascript" src="${ctx}/js/ueditor/editor_all_min.js"></script>
	 	<link rel="stylesheet" type="text/css" href="${ctx}/js/ueditor/themes/default/ueditor.css"/>
	  <script type="text/javascript" >
    $(document).ready(function() {
    	$('#publishOn').datetimebox({
    		width:160,
			showSeconds:false
			
    	});  
    	
    	$('#expireOn').datetimebox({
    		width:160,
			showSeconds:false
    	});  
    });
	    
	</script>
</head>
	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
		<form method="post" name="form" action="${ctx}/admin/content/edit.html">
			<input type="hidden" name="id" id="id" size="24" value="${model.id}"/>
			<input type="hidden" id="hitCounter" name="hitCounter" value="${model.hitCounter}" />
			<input type="hidden" name="htmlTitle"  id="htmlTitle" size="60"  value="${model.htmlTitle}"/>
			<input type="hidden" name="metaKeywords" id="metaKeywords" size="80"  value="${model.metaKeywords}"/>
			<input type="hidden" name="metaDesc"  id="metaDesc" size="80" value="${model.metaDesc}"/>
			<input type="hidden" name="typeId" id="typeId" value="${model.typeId}"/>
			<input type="hidden" name="parentId"  id="parentId" size="80" value="${model.parentId}"/>
			<script type="text/plain" id="content">${model.content}</script>
			<input type="hidden" name="urlRewrite" class="input" id="urlRewrite" size="60" value="${model.urlRewrite}"/><br/>
			<fieldset>
				<legend>内容类型</legend>
				<div>
					<label for="name">类型名称</label>
					<input type="text" name="title" class="input" id="title" size="20" maxlength="30" value="${model.title}"/><br/>
				</div>
				<div>
					<label for="publishOn">发布时间</label>
					<input type="text" name="publishOn" class="input" id="publishOn" size="20" maxlength="30" value="${model.publishOn}"/><br/>
				</div>
				<div>
					<label for="expireOn">有效期</label>
					<input type="text" name="expireOn" class="input" id="expireOn" size="20" maxlength="30" value="${model.expireOn}"/><br/>
				</div>
				<div>
					<label for="published">是否已发布</label>
					<input type="checkbox" id="published" name="published" <c:if test="${model.published == true}">checked</c:if>/>
				</div>
				<div class="enter">
					<input name="add" type="submit" class="buttom" value="提交" />
					<input name="submit" type="reset" class="buttom" value="重置" />
				</div>
			</fieldset>
		</form>
</div>
