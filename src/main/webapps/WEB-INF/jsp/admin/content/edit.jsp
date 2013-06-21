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
    	
    	var editor_a = new baidu.editor.ui.Editor({
    		autoFloatEnabled: false,
    		autoHeightEnabled:false,
    		elementPathEnabled:false,
    		textarea:'content'
    	});
        //渲染编辑器
        editor_a.render('content');

    });
	    
	</script>
</head>
<body>

	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
		<form method="post" name="form" action="${ctx}/admin/content/edit.html">
			<input type="hidden" name="typeId" id="typeId" value="${model.typeId}"/>
			<input type="hidden" name="id" id="id" value="${model.id}"/>
			<fieldset>
				<legend>内容</legend>
				<div>
					<label for="title">标题</label>
					<input type="text" name="title" class="input" id="title" size="80" value="${model.title}"/><br/>
				</div>
				<div>
					<label for="title">副标题</label>
					<input type="text" name="subTitle" class="input" id="subTitle" size="80" value="${model.subTitle}"/><br/>
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
				<div>
					<label for="parent">父文章目录</label>
					<select name="parentId" id="parentId" class="select">
						<option value="0">---请选择---</option>
						<c:forEach var="content" items="${contents}" varStatus="state">
							<option value="${content.id}" <c:if test="${content.id==model.parentId}">selected</c:if>>${content.title}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<label for="hitCounter">点击数</label>
					${model.hitCounter}<input type="hidden" id="hitCounter" name="hitCounter" value="${model.hitCounter}" />
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
				<legend>页面内容</legend>
				<div>
					<script type="text/plain" id="content">${model.content}</script>
				</div>
			</fieldset>
			<div class="enter">
				<input name="add" type="submit" class="buttom" value="提交" />
				<input name="submit" type="reset" class="buttom" value="重置" />
			</div>
			
		</form>
</div>
</body>