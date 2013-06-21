<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery.EasyUI</title>
    <script type="text/javascript" >
    $(document).ready(function() {
    	var json = eval($("#attrs").val());
    	$.each(json,function(index, attr){
    		var dom = "<div><label for='name'>" + attr.attr + "</label>";
    		
    		// 判断属性 如果是唯一属性 文本框, 如果是单选或者多选下拉框
    		
    		if(attr.attrType == "SELECT") {
    			dom += "<input type='hidden' value='" + attr.attr + "'" + "name='attr_name_list' />";
    			dom += "<select name = 'attr_value_list' class='input'>";
    			var options = attr.attrOption.split("||");
    			for(var i = 0;i < options.length; i++) {
    				if(options[i] != "") {
	    				dom+="<option value='" + options[i] + "'";
    					if(attr.oldValue == options[i]) {
    						dom+=" selected";
    					}
    					dom+=">" + options[i] + "</option>";
    				}
    			}
    			dom += "</select>";
    		} else if(attr.attrType=="TEXT") {
    			dom += "<input type='hidden' value='" + attr.attr + "'" + "name='attr_name_list' />";
	    		dom += "<input type='text' size='34' name='attr_value_list'";
	    		if(attr.oldValue != null && attr.oldValue != "") {
	    			dom += " value = '" + attr.oldValue + "'";
	    		}
	    		dom += ">";
	    		if(attr.lostAttr == true) {
	    			dom += "<a href='javascript:;' onclick='delSpec(this)'>";
	    			dom += "[-]";
	    			dom += "</a>";
	    		}
	    		
    		}
    		dom += "</div>";
    		
    		$("fieldset").append(dom);
    	});
    	
    	dom = "<div class='enter'>";
    	dom += "<input name='add' type='submit' class='buttom' value='提交' />";
    	dom += "<input name='reset' type='reset' class='buttom' value='重置' />";
    	dom += "</div>";
    	$("fieldset").append(dom);
    });
    
    // var addSpec= function(value) {
    //	$(value).parent().after("<div>" + $(value).parent().html().replace("[+]","[-]").replace("addSpec", "delSpec") + "</div>");
    // }
    
    var delSpec= function(value) {
    	var itemid = $('#itemId').val();
    	var key = $(value).parent().find("label").text();
    	
    	$.ajax({
		  url: "${ctx}/admin/item/deleteItemAttr.html",
		  type:"post",
		  data:{itemId:itemid,key:key},
		  success: function(){
    	  	$(value).parent().empty();
		  	alert("属性删除成功.");
		  }
		});
    }
	</script>
</head>

<div id="formwrapper">
	<c:if test="${message!=null}">
		<div id=xbox>
			${message}
		</div>
	</c:if>
	<form method="post" name="form" action="${ctx}/admin/item/itemattr.html">
		<input type="hidden" id="attrs" name="attrs" value=${attrs} />
		<input type="hidden" id="itemId" name="itemId" value=${itemId} />
		<fieldset>
			<legend>商品属性</legend>
		</fieldset>
	</form>
</div>
