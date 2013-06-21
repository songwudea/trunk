<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <script type="text/javascript" >
	    $(document).ready(function() {
	    	var keys = eval($('#keys').val()); 
	    	var values = eval($('#values').val());
	    	var dom = "";
    		$.each(keys,function(n,key) {
    			dom += "<fieldset><legend>" + key + "</legend>";
    			var arrays = eval(values[n]);
    			$.each(arrays,function(n,value) {
    				
					dom += "<div>";
		    		dom += "<input type='hidden' name='attrKeyList' value='" +  key + "'>";
		    		if(n == 0) {
			    		dom += "<a onclick='addSpec(this)' href='javascript:;'>[+]</a>";
		    		} else {
			    		dom += "<a onclick='delSpec(this)' href='javascript:;'>[-]</a>";
		    		}
		    		
		    		dom += "<input type='text' class='input' name='attrValueList' value='" + value +"'>";
		    		dom += "</div>";     					
    			});
    			dom += "</fieldset>";
       		});
       		$('fieldset:last').after(dom);
    	});
    
   	 	var addAttr = function() {
   	 		var attrs = "";
   	 		$("legend").each(function(){
   	 			attrs+= $(this).text() + "||";
   	 		});
   	 		if(attrs.indexOf($('#name').val()) == -1) {
	   	 		var dom = '<fieldset><legend>' + $('#name').val() + '</legend>';
	   	 		dom += "<div>";
	   	 		dom += "<input type='hidden' name='attrKeyList' value='" +  $('#name').val() + "'>";
	   	 		dom += "<a onclick='addSpec(this)' href='javascript:;'>[+]</a>";
	   	 		dom += "<input type='text' class='input' name='attrValueList'>";
	   	 		dom += "</div>";
				dom +=  '</fieldset>';  	 		
	    		$('fieldset:last').after(dom);
   	 		} else {
   	 			alert('不能添加重复属性');
   	 		}
   	 		
   	 	}
   	 	
   	 	var delSpec = function(value) {
   	 		$(value).parent().empty();
   	 	}
   	 	
		var addSpec= function(value) {
			var dom = "<div>";
			dom += "<input type='hidden' name='attrKeyList' value='" + $('#name').val() + "'>";
			dom += "<a onclick='delSpec(this)' href='javascript:;'>[-]</a><input type='text' class='input' name='attrValueList'></div>";
		
			$(value).parent().after(dom);
		}
    </script>
</head>

<div id="formwrapper">
	<c:if test="${message!=null}">
		<div id=xbox>
			${message}
		</div>
	</c:if>
	<form method="post" name="form" action="${ctx}/admin/item/itemCustomerAttr.html">
		<input type="hidden" id="itemId" name="itemId" value=${itemId} />
		<input type="hidden" id="keys" name="keys" value=${keys} />
		<input type="hidden" id="values" name="values" value=${values} />
		<fieldset>
			<div>
				<label>属性</label>
				<input type="text" name="name" class="input" id="name" size="20" maxlength="30" />
				<input type="button" name="add" id="add" value="添加" onclick="addAttr();" />
			</div>
			
		</fieldset>
		<div class="enter">
			<input name="add" type="submit" class="buttom" value="完成" />
			<input name="submit" type="reset" class="buttom" value="重置" />
		</div>
	</form>
</div>
