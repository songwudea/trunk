<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <script type="text/javascript" >
    	$(document).ready(function() {
	    	var prices = eval($('#price').val());
	    	$.each(prices,function(n,price) {
	    		var dom = "<div>";
				dom += "<label>价格区间</label><input type='text' size='8' class='input' name='rangeMins' value='" + price.rangeMin  +"'>到<input type='text' size='8' class='input' name='rangeMaxs' value='" + price.rangeMax  +"'><a onclick='delSpec(this)' href='javascript:;'>[-]</a>";
				dom += "</div>";
	    		
	    		$("fieldset").append(dom);
       		});
    	});
    
    
    	var addSpec= function(value) {
			var dom = "<div>";
			dom += "<label>价格区间</label><input type='text' size='8' class='input' name='rangeMins'>到<input type='text' size='8' class='input' name='rangeMaxs'><a onclick='delSpec(this)' href='javascript:;'>[-]</a>";
			dom += "</div>";
			$("fieldset").append(dom);
		}
		
		var delSpec = function(value) {
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
	<form method="post" name="form" action="${ctx}/admin/price/edit.html">
		<input type="hidden" id="price" name="price" value=${price} />
		<input type="hidden" id="siteId" name="siteId" value=${siteId} />
		<fieldset>
			<legend>价格区间</legend> 
			<div>
				<label>价格区间</label>
				<input type="button" name="add" id="add" value="添加" onclick="addSpec(this);" />
			</div>
		</fieldset>
		<div class="enter">
			<input name="add" type="submit" class="buttom" value="完成" />
			<input name="submit" type="reset" class="buttom" value="重置" />
		</div>
	</form>
</div>
