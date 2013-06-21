<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>

<head>
<title>用户收货地址</title>
<base href="${path}/"/>
<meta name="decorator" content="${current_site.template.path}" />
	<script type="text/javascript">
	var selectCity = function() {
		var pid = $('#province').val();
		$("#city").empty();
		$.post('${ctx}/user/address/getCity.html',{pid: pid},function(data){
			var json = eval(data);
			$.each(json,function(index, city){
				var option = "<option value='" + city.cityId + "'>" + city.cityName + "</option>";
				$("#city").append(option);
			});
        });
	}
	

$(function(){
	$(":input").focus(function() {
		if($(this).parent().find("label.error").css("display")!=="inline") {
			$(this).parent().find("span.hint").show();
		}
	}).blur(function() {
		$(this).parent().find("span.hint").hide();
	});
});
	</script>
	
	<style>
.hint {display: none;padding-left:5px}

</style>
</head>


<body>
	
<div id="warpper">
<div id="login-warpper">
  <div id="login">
  <div class="logo"><a href="${ctx==""?"/":ctx}"><img src="images/logo.png" width="292" height="108" /></a></div>
  
<div id="menu" style="width: 125px"><h2>我的瞳话</h2>
   
        <ul>
        
          <li><a class="current" href="${ctx}/user/modifyUser.html"><b>个人信息</b></a></li>
          <li><a class="current" href="${ctx}/user/order.html"><b>我的订单</b></a></li>
          <li><a class="current" href="${ctx}/user/address"><b>送货地址</b></a></li>
          <c:if test="${IF_DEMAND == 0}">
	         <li><a class="current" href="${ctx}/user/demandnote.html"><b>索取小样</b></a></li>
          </c:if>
</ul></div>
  
<div class="sideContent_n ">

<div class="errorbox">
	    	<p><%@ include file="/common/formMessage.jsp" %></p>
	    </div>

<table width="100%" class="simpleTable">
	<tr class="th">
		<td>收货人</td>
		<td>地址</td>
		<td>邮编</td>
		<td>手机</td>
		<td>操作</td>
	</tr>
	<c:forEach var="address" items="${addresses}" varStatus="state">
	<tr>
		<td>${address.name}</td>
		<td>${address.province}${address.city}${address.address}</td>
		<td>${address.zip}</td>
		<td>${address.mobile}</td>
		<td align="center">
			<a href="${ctx}/user/address/delete.html?addressId=${address.id}">删除</a>  
			<c:if test="${address.mainflag != 'y'}">
				|  <a href="${ctx}/user/address/setDefAddress.html?addressId=${address.id}">设置默认</a>
			</c:if>
			<c:if test="${address.mainflag == 'y'}">
				|  <font style='color:#FF0000'>默认</font>
			</c:if>
		</td>
	</tr>
	</c:forEach>

</table>
	
	
	
		
	  <div class=mt>
	<h2>添加送货地址</h2></div>
	
	     <form action="${ctx}/user/address/edit.html" method="post" class="simpleForm">
	        <ol>
	          <li>
	            <label for="name">收货人: </label>
	            <input type="text" name="name" id="name"  class="text" />
	          <span class="red hint">请填写收货人真实姓名</span></li>
	          <li>
	             <label>地区： </label>
	            <span>
	            <select name="province" id="province" onchange="selectCity();">
					<c:forEach var="province" items="${provinces}" varStatus="state">
						<option value="${province.provId}">${province.provName}</option>
					</c:forEach>
				</select>
				<select name="city" id="city" ></select><span class="red hint">请选择送货省市</span>
				</span>
	          </li>
	          <li><div class="clr"></div></li>
	          <li>
	            <label for="address ">街道地址：</label>
	            <input type="text" id="address " name="address" class="text" />
	          <span class="red hint"> 请正确填写完整的地址信息</span></li>
	          <li>
	            <label for="zip">邮政编码</label>
	            <input type="text" id="zip" name="zip" class="text" />
	            <span class="red hint">填写邮编有助我们更快的给您安排送货</span>
	          </li>
	            <li>
	            <label for="mobile">手机:</label>
	            <input type="text" id="mobile" name="mobile" class="text" />
	            <span class="red hint">填写手机确保物流随时与您联系</span>
	          </li>
	
	          <li class="buttons">
	            <input type="image" name="imageField" id="imageField" src="${path}/images/butform.png" />
	          </li>
	      </ol>
	      <div class="clr"></div>
	    </form>


</div>
  
  
  


      
</div>
    </div>    

 
</div>
	<script type="text/javascript">
		selectCity();
	</script>	
</body>
</html>