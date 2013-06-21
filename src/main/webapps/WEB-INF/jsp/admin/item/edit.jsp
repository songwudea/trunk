<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/ueditor/editor_config.js"></script>
	<script type="text/javascript" src="${ctx}/js/ueditor/editor_all_min.js"></script>
   	<link rel="stylesheet" type="text/css" href="${ctx}/js/ueditor/themes/default/ueditor.css"/>
    <script type="text/javascript" >
    var child,intvl;
    var showDialog = function() {
		child = window.open('${ctx}/js/ueditor/dialogs/image/image1.html' + "?ver=" + new Date(),'child', 'height=500, width=700, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
		intvl = setInterval(closedProperty,100);
	}
	
	var delPic = function(value, name) {
		var itemid = $('#id').val();
		$.ajax({
		  url: "${ctx}/admin/item/deleteItemPic.html",
		  type:"post",
		  data:{itemId:itemid,picName:name},
		  success: function(data){
    	  	$(value).parent().parent().empty();
    	  	$('#images').val(data);
		  	alert("商品图片删除成功.");
		  }
		});
	
	}
	
    var createTable = function() {
    	var dom = "<table id='imagetable'><th width='240'>图片名</th><th width='50'>操作</th>";
    	var images = $('#images').val();
    	var json = eval('[' + images + ']');
    	$.each(json,function(index, image){
    		if(image.originalFilename != '') {
    			dom += "<tr>";
				dom += "<td width='80'>" + image.originalFilename + "</td>";
				dom += "<td width='70'><a href='javascript:;' onclick='delPic(this,\"" + image.url + "\");'>删除</a>|<a href='javascript:;'>默认</a></td>";
				dom += "</tr>";
    		}
    	});
		dom += "</table>";
		$('#showimage').after(dom);
  	}		
	
	var closedProperty = function() {
		if (child.closed) {
			clearInterval(intvl);
			
			if($('#imagetable').length > 0) {
				$("#imagetable").empty();  	
			}
			createTable();
  		}		
	}
	
	
    
    $(document).ready(function() {
		createTable();    
    
    	$('#publishOn').datetimebox({
    		width:160
    	});  
    	
    	$('#expireOn').datetimebox({
    		width:160
    	});  

    	var dd = $('#secondCategoryId').combobox({  
	     	url:'${ctx}/admin/category/childCategory.html?id=' +  $('#fid').val() + '&sid=' + $('#sid').val(),
	     	width:130,
	     	valueField:'id',
	     	textField:'text',
	     	editable:false
    	});
    	
    	var ee = $('#thirdCategoryId').combobox({  
	     	url:'${ctx}/admin/category/childCategory.html?id=' +  $('#sid').val() + '&tid=' + $('#tid').val(),
	     	width:130,
	     	valueField:'id',
	     	textField:'text',
	     	editable:false
    	});
    	
    	var brand = $('#brandId').combobox({
    		url:'${ctx}/admin/brand/getBrands.html?id=' + $('#fid').val() + '&bid=' + $('#bid').val(),
    		width:130,
    		valueField:'id',
	     	textField:'text',
    		editable:false
    	});
    	
    	var editor_a = new baidu.editor.ui.Editor({
    		autoFloatEnabled: false,
    		autoHeightEnabled:false,
    		elementPathEnabled:false,
    		textarea:'description'
    	});
    	
    	var editor_item_short_desc = new baidu.editor.ui.Editor({
    		autoFloatEnabled: false,
    		autoHeightEnabled:false,
    		elementPathEnabled:false,
    		textarea:'shortDesc',
    		toolbars:[
            ['Source', '|', 'Undo', 'Redo', '|',
                'Bold', 'Italic', 'Underline', 'StrikeThrough', 'Superscript', 'Subscript', 'RemoveFormat', 'FormatMatch', '|',
                'BlockQuote', '|', 'PastePlain', '|', 'ForeColor', 'BackColor', 'InsertOrderedList', 'InsertUnorderedList', '|', 'CustomStyle',
                'Paragraph', 'RowSpacing', 'LineHeight', 'FontFamily', 'FontSize', '|',
                'DirectionalityLtr', 'DirectionalityRtl', '|', '', 'Indent', '|',
                'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyJustify', '|',
                'Link', 'Unlink', 'Anchor', '|',
                'Horizontal', 'Date', 'Time', 'Spechars']
        	],
        	minFrameHeight:120
    	});
    	
        //渲染编辑器
        editor_a.render('description');
        editor_item_short_desc.render('shortDesc');
    	   
    
    	var cc = $('#topCategoryId').combobox({
	     	url:'${ctx}/admin/category/rootCategory.html?fid=' + $('#fid').val(),  
	     	valueField:'id',
	     	textField:'text',
	     	editable:false,
	     	width:130,
	     	onSelect:function(record){  
	     		dd.combobox('clear');
	     		ee.combobox('clear');
	     		brand.combobox('clear');
	     		brand.combobox({
	     			url:'${ctx}/admin/brand/getBrands.html?id=' + record.id + '&bid=' + $('#bid').val()
	     		})
	     		
	     		
				dd.combobox({
					url:'${ctx}/admin/category/childCategory.html?id=' + record.id + '&sid=' + $('#sid').val(),
					valueField:'id',
					textField:'text',
					onSelect:function(record) {
						ee.combobox({
							url:'${ctx}/admin/category/childCategory.html?id=' + record.id + '&tid=' + $('#tid').val(),
							valueField:'id',
							textField:'text'
						}).combobox('clear');
					}
				}).combobox('clear');	     		
	     	}
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
	
	<form:form modelAttribute="model" method="post" action="${ctx}/admin/item/edit.html">
		<input type="hidden" name="id" id="id" value="${model.id}"/>
		<input type="hidden" name="fid" id="fid" value="${model.topCategoryId}"/>
		<input type="hidden" name="sid" id="sid" value="${model.secondCategoryId}"/>
		<input type="hidden" name="images" id="images" value='${model.images}'/>
		<input type="hidden" name="bid" id="bid" value="${model.brandId}"/>
		<input type="hidden" name="tid" id="tid" value="${model.thirdCategoryId}"/>
		<fieldset>
			<legend>商品基本信息</legend>
			<div>
				<label for="name">商品名称</label>
				<input type="text" name="name" class="input" id="name" size="20" maxlength="30" value="${model.name}"/><br/>
			</div>
			<div>
				<label for="sort">排序权重</label>
				<input type="text" name="sort" class="input" id="sort" size="20" maxlength="10" value="${model.sort}"/><br/>
			</div>
			<div>
				<label for="itemTitle">商品副标题</label>
				<input type="text" name="itemTitle" class="input" id="itemTitle" size="20" maxlength="30" value="${model.itemTitle}"/><br/>
			</div>
			<div>
				<label for="name">商品图片</label>
				<button type="button" onclick="showDialog();">上传图片</button>
				<span id="showimage"></span>
				<br/>
			</div>
			
			<div>
				<label for="upcCode">upcCode</label>
				<input type="text" name="upcCode" class="input" id="upcCode" size="20" maxlength="30" value="${model.upcCode}"/><br/>
			</div>
			<div>
				<label for="skuCode">sku编码</label>
				<input type="text" name="skuCode" class="input" id="skuCode" size="20" maxlength="30" value="${model.skuCode}"/><br/>
			</div>
			<div>
				<label for="sellable">是否能购买</label>
				<input type="checkbox" id="sellable" name="sellable" <c:if test="${model.sellable == true}">checked</c:if>/>
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
				<label for="shippingType">物流类型</label>
				<input type="text" name="shippingType" class="input" id="shippingType" size="20" maxlength="30" value="${model.shippingType}"/><br/>
			</div>
		</fieldset>
		
		<fieldset>
			<legend>商品页面元素信息</legend>
			<div>
				<label for="name">html标题</label>
				<input type="text" name="htmlTitle" class="input" id="htmlTitle" size="70" maxlength="70" value="${model.htmlTitle}"/><br/>
			</div>
			<div>
				<label for="metaKeywords">meta-关键字</label>
				<input type="text" name="metaKeywords" class="input" id="metaKeywords" size="70" maxlength="70" value="${model.metaKeywords}"/><br/>
			</div>
			<div>
				<label for="metaDesc">meta-描述</label>
				<input type="text" name="metaDesc" class="input" id="metaDesc" size="70" maxlength="70" value="${model.metaDesc}"/><br/>
			</div>
		</fieldset>
		
		<fieldset>
			<legend>商品分类,品牌,属性信息</legend>
			<div>
				<label for="topCategoryId">1级分类</label>
				<input id="topCategoryId" name="topCategoryId" type="text" value="${model.topCategoryId}"/>
			</div>
			<div>
				<label for="secondCategoryId">2级分类</label>
				<input id="secondCategoryId" name="secondCategoryId" type="text" value="${model.secondCategoryId}"/>
			</div>
			<div>
				<label for="thirdCategoryId">3级分类</label>
				<input id="thirdCategoryId" name="thirdCategoryId" type="text" value="${model.thirdCategoryId}"/>
			</div>
			<div>
				<label for="brandId">品牌</label>
				<input id="brandId" name="brandId" type="text" />
			</div>
		</fieldset>
		<fieldset>
			<legend>商品价格信息</legend>
			<div>
				<label for="inventory">库存</label>
				<input type="text" name="inventory" class="input" id="inventory" size="20" maxlength="30" value="${model.inventory}"/><br/>
			</div>
			<div>
				<label for="bookedQuantity">预定数量</label>
				<input type="text" name="bookedQuantity" class="input" id="bookedQuantity" size="20" maxlength="30" value="${model.bookedQuantity}"/><br/>
			</div>
			<div>
				<label for="cmarketPrice">市场价</label>
				<input type="text" name="cmarketPrice" class="input" id="cmarketPrice" size="20" maxlength="30" value="${model.cmarketPrice}"/><br/>
			</div>
			<div>
				<label for="ccost">成本价</label>
				<input type="text" name="ccost" class="input" id="ccost" size="20" maxlength="30" value="${model.ccost}"/><br/>
			</div>
			<div>
				<label for="cprice">销售价格</label>
				<input type="text" name="cprice" class="input" id="cprice" size="20" maxlength="30" value="${model.cprice}"/><br/>
			</div>
		</fieldset>
		
		<fieldset>
			<legend>其他销售渠道</legend>
			<div>
				<label for="tmallUrl">天猫地址</label>
				<input id="tmallUrl" name="tmallUrl" type="text" value="${model.tmallUrl}"  size="80"/>
			</div>
		</fieldset>
		<fieldset>
			<legend>商品描述编辑</legend>
			<div>
				<script type="text/plain" id="description">${model.description}</script>
			</div>
		</fieldset>
		<fieldset>
			<legend>商品短描述</legend>
				<div>
					<script type="text/plain" id="shortDesc">${model.shortDesc}</script>
				</div>
			</legend>
		</fieldset>
		<div class="enter">
			<input name="add" type="submit" class="buttom" value="提交" />
			<input name="reset" type="reset" class="buttom" value="重置" />
		</div>
	</form:form>
</div>
