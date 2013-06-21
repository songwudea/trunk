<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<head>
   	<script type="text/javascript" charset="utf-8" src="${ctx}/js/ueditor/editor_config.js"></script>
	<script type="text/javascript" src="${ctx}/js/ueditor/editor_all_min.js"></script>
   	<link rel="stylesheet" type="text/css" href="${ctx}/js/ueditor/themes/default/ueditor.css"/>
   	<script type="text/javascript" >
    $(document).ready(function() {
		var editor_header = new baidu.editor.ui.Editor({
			autoFloatEnabled: false,
			autoHeightEnabled:false,
			elementPathEnabled:false,
			textarea:'headerTpl'		
		});
		
		var editor_footer = new baidu.editor.ui.Editor({
			autoFloatEnabled: false,
			autoHeightEnabled:false,
			elementPathEnabled:false,
			textarea:'footerTpl'		
		});
		
		editor_header.render('headerTpl');
		editor_footer.render('footerTpl');
	});
</script>
</head>
	<div id="formwrapper">
	<c:if test="${message!=null}">
		<div id=xbox>
			${message}
		</div>
	</c:if>
	<form method="post" name="form" action="${ctx}/admin/category/edit.html">
		<input type="hidden" name="parentId" id="id" size="24" value="${model.parentId}"/>
		<input type="hidden" name="id" id="id" size="24" value="${model.id}"/>
		<input type="hidden" name="level" id="level" size="24" value="${model.level}"/>
		<input type="hidden" name="pid" id="pid" size="24" value="${pid}"/>
		<input type="hidden" name="method" id="method" size="24" value="${method}"/>
		<input type="hidden" name="pname" id="pname" size="24" value="${pname}"/>
		<input type="hidden" name="plevel" id="plevel" size="24" value="${plevel}"/>
		<input type="hidden" name="siteId" id="siteId" size="24" value="${model.siteId}"/>
		<input type="hidden" name="createdAt" id="createdAt" size="24" value="${model.createdAt}"/>
		<fieldset>
			<legend>分类信息</legend>
			<div>
				<label for="name">分类名称</label>
				<input type="text" name="name" class="input" id="name" size="20" maxlength="30" value="${model.name}"/>
			</div>
			<div>
				<label for="name">分类路径</label>
				<input type="text" name="path" id="name" size="20" maxlength="30" value="${model.path}"/>
			</div>
			<div>
				<label for="name">分类图片</label>
				<input type="text" name="code" id="code" size="20" maxlength="30" value="${model.code}"/>
			</div>
			<div>
				<label for="name">排序</label>
				<input type="text" name="sort" id="sort" size="20" maxlength="30" value="${model.sort}"/>
			</div>
			
		</fieldset>
		<fieldset>
				<legend>内容页面SEO定制</legend>
				<div>
					<label for="name">html标题</label>
					<input type="text" name="htmlTitle" class="input" id="htmlTitle" size="60"  value="${model.htmlTitle}"/><br/>
				</div>
				<div>
					<label for="metaKeywords">meta-关键字</label>
					<input type="text" name="metaKeywords" class="input" id="metaKeywords" size="80"  value="${model.metaKeywords}"/><br/>
				</div>
				<div>
					<label for="metaDesc">meta-描述</label>
					<input type="text" name="metaDesc" class="input" id="metaDesc" size="80" value="${model.metaDesc}"/><br/>
				</div>
				<div>
					<label for="urlRewrite">url重写</label>
					<input type="text" name="urlRewrite" class="input" id="urlRewrite" size="60" value="${model.urlRewrite}"/><br/>
				</div>
			</fieldset>
		<fieldset>
			<legend>分类(头模版)</legend>
			<div>
				<script type="text/plain" id="headerTpl" name="headerTpl">${model.headerTpl}</script>
			</div>
		</fieldset>
		<fieldset>
			<legend>分类(脚模版)</legend>
			<div>
				<script type="text/plain" id="footerTpl" name="footerTpl">${model.footerTpl}</script>
			</div>
		</fieldset>
		<div class="enter">
			<input name="add" type="submit" class="buttom" value="新增" />
			<input name="submit" type="reset" class="buttom" value="重置" />
		</div>
	</form>
</div>
