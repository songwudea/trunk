<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页配置</title>
    <script type="text/javascript" >
    
     $(document).ready(function(){
		var value = eval($('#sitePageConfigs').val());
		for(var i = 0;i < value.length;i++) {
			if(value[i].entityType == 'item') {
				var val = $('#items>div>input:first').attr("value");
				if(val == null || val == '') {
					$('#items>div>input:first').val(value[i].nameKey);
					$('#items>div>input:nth-child(4)').val(value[i].quantity);
				} else {
					var element = "<div>";
					element += "<a href='javascript:;' onclick='delSpec(this)'>[ - ]</a>";
					element += "<input type='text' name='nameKey' class='input' id='nameKey' value='" + value[i].nameKey + "' />";
					element += "<input type='hidden' name='entityType' id='entityType' value='item' />";
					element += " 数量<input type='text' name='quantity' class='input' id='quantity' value='" + value[i].quantity + "' />";
					element += '</div>';
					$('#items>div>a').parent().parent().append(element);
				}
			} else if(value[i].entityType == 'brand') {
				var val = $('#brands>div>input:first').attr("value");
				if(val == null || val == '') {
					$('#brands>div>input:first').val(value[i].nameKey);
					$('#brands>div>input:nth-child(4)').val(value[i].quantity);
				} else {
					var element = "<div>";
					element += "<a href='javascript:;' onclick='delSpec(this)'>[ - ]</a>";
					element += "<input type='text' name='nameKey' class='input' id='nameKey' value='" + value[i].nameKey + "' />";
					element += "<input type='hidden' name='entityType' id='entityType' value='brand' />";
					element += " 数量<input type='text' name='quantity' class='input' id='quantity' value='" + value[i].quantity + "' />";
					element += '</div>';
					$('#brands>div>a').parent().parent().append(element);
				}
			} else if(value[i].entityType == 'content') {
				var val = $('#contents>div>input:first').attr("value");
				if(val == null || val == '') {
					$('#contents>div>input:first').val(value[i].nameKey);
					$('#contents>div>input:nth-child(4)').val(value[i].quantity);
				} else {
					var element = "<div>";
					element += "<a href='javascript:;' onclick='delSpec(this)'>[ - ]</a>";
					element += "<input type='text' name='nameKey' class='input' id='nameKey' value='" + value[i].nameKey + "' />";
					element += "<input type='hidden' name='entityType' id='entityType' value='content' />";
					element += " 数量<input type='text' name='quantity' class='input' id='quantity' value='" + value[i].quantity + "' />";
					element += '</div>';
					$('#contents>div>a').parent().parent().append(element);
				}
			}
		}		
     });
    
   	var addSpec= function(value) {
   		$(value).parent().parent().append("<div>" + $(value).parent().html().replace("[+]","[ - ]").replace("addSpec", "delSpec") + "</div>");
   	}
   	
   	var delSpec= function(value) {
		$(value).parent().empty();
    }
	</script>
</head>


<div id="formwrapper">
	<c:if test="${message!=null}">
		<div id=xbox>
			${message}
		</div>
	</c:if>
	<form method="post" name="form" action="${ctx}/admin/site/confighomepage.html">
		<input type="hidden" name="siteId" id="siteId" value=${siteId} />
		<input type="hidden" name="pageType" id="pageType" value=${pageType} />
		<input type="hidden" name="sitePageConfigs" id="sitePageConfigs" value=${sitePageConfigs} />
		<fieldset id="items">
			<legend>商品</legend>
			<div>
				<a href='javascript:;' onclick='addSpec(this)'>[+]</a>
				<input type="text" name="nameKey" class="input" id="nameKey"/>
				<input type="hidden" name="entityType" id="entityType" value="item"/>
				数量<input type="text" name="quantity" class="input" id="quantity"/>
			</div>
		</fieldset>
		
		<fieldset id="brands">
			<legend>品牌</legend>
			<div>
				<a href='javascript:;' onclick='addSpec(this)'>[+]</a>
				<input type="text" name="nameKey" class="input" id="nameKey"/>
				<input type="hidden" name="entityType" id="entityType" value="brand"/>
				数量<input type="text" name="quantity" class="input" id="quantity"/>
			</div>
		</fieldset>
		
		<fieldset id="contents">
			<legend>内容</legend>
			<div>
				<a href='javascript:;' onclick='addSpec(this)'>[+]</a>
				<input type="text" name="nameKey" class="input" id="nameKey"/>
				<input type="hidden" name="entityType" id="entityType" value="content"/>
				数量<input type="text" name="quantity" class="input" id="quantity"/>
			</div>
		</fieldset>
		<div class="enter">
			<input name="add" type="submit" class="buttom" value="设置" />
		</div>
	</form>
</div>