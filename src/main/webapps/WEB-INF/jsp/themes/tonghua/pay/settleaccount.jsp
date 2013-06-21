<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
<title>核对订单</title>
<base href="${path}/"/>
<meta name="decorator" content="${current_site.template.path}" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery_extend.js"></script>
<script type="text/javascript" src="${ctx}/js/messages_cn.js"></script>
<script type="text/javascript" src="${path}/js/jquery.tools.min.js"></script>
	<style>
.hint {display: none;padding-left:5px}

</style>
<script type="text/javascript">
	//是否索要发票 checkbox
		function doShowInvoiceDiv(invobox){
			var ord_invoiceDiv = document.getElementById("invoiceDiv");
			if(ord_invoiceDiv.style.display == "none"){
				ord_invoiceDiv.style.display = "block";
				document.getElementById("invoice").value = "y";
			}else{
				ord_invoiceDiv.style.display = "none";
				document.getElementById("invoice").value = "n";
			}
		}
		//发票抬头类型 ： 个人 or 单位
		function doInvoicetitletype(v){
			if(v == "1"){
				document.getElementById("invoiceTitle").value = "";
				document.getElementById("invoiceTitle").focus();
			}else if(v == "0"){
				document.getElementById("invoiceTitle").value = "个人";
			}
		}
		
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
	
	var addRes = function() {
		var city = $('#city').find("option:selected").text();
		var name = $('#name').val();
		var mobile = $('#mobile').val();
		var province = $('#province').find("option:selected").text();
		var address = $('#address').val();
		var zip = $('#zip').val();
		
		if(null == name || "" == name){
			$("#errorSpan").html("请输入收货人姓名!");
 			return;
		}
		/** 省 **/
		if(null == province || "" == province || "---请选择---" == province){
			$("#errorSpan").html("请选择省份!");
			return;
		}
		/** 详细地址 **/
		if(null == address || "" == address){
			$("#errorSpan").html("请填写详细地址!");
  			return;
		}
		if((null == mobile || "" == mobile) && ((null == telone || "" == telone) || (null == teltwo || "" == teltwo))){
			$("#errorSpan").html("请填写手机号码或者固定电话!");
      		return;
		} else{
			if(null != mobile && "" != mobile){
			if(mobile.length != 11){
				$("#errorSpan").html("请填写11位手机号码!");
		      	return;
			}
					//var a = /^((\(\d{3}\))|(\d{3}\-))?13\d{9}|15[89]\d{8}$/ ; if(!mobile.match(a)){
		  	if( (mobile.substring(0,2) != "13") 
		  		&& (mobile.substring(0,2) != "15") 
		  		&& (mobile.substring(0,2) != "18") ){
					$("#errorSpan").html("请填写正确的手机号码!");
	     		return;
			}
		}
	}
		
		
	$.ajax({
		  url: "${ctx}/user/address/addAddress.html",
		  type:"post",
		  dataType: 'json',
		  data:{city:city,name:name,mobile:mobile,province:province,address:address,zip:zip},
		  success: function(data){
		  	 if(data.result == 'suss') {
		  	 	$("#errorSpan").html("");
				$('#addresst tr:gt(0)').each(function () {  
					var dom = $(this).children('td').eq(0).html();
					dom += "<input type='radio' name='addressId' id='addressId' value='" + data.addid + "' checked/>";
					dom += " 收货人: " + name;
					dom += " 电话: " + mobile;
					dom += " 地址: " + province + city;
					dom += " 详细地址: " +address;
					dom += " 邮编: " + zip + "</br>";
					$("#exAdd").html(dom);
					$("#smt").attr("disabled",false);
		        });	 			  	 
		  	 }
		  }
	});


			
	}
	

</script>

</head>
<body>
	
<div id="warpper">
<div id="login-warpper">
  <div id="login">
<div class="logo"><a href="${ctx==""?"/":ctx}"><img src="${path}/images/logo.png" width="292" height="108" /></a></div>
<div class="errorbox">
    	<p><%@ include file="/common/formMessage.jsp" %></p>
    </div>
	<div class="flow_step_no2 flow_cart">
		<div class="flow_step">
			<ol class="cols3">
				<li class="step_1">我的购物袋</li>
				<li class="step_2">核对订单</li>
				<li class="step_3">订单提交成功</li>
			</ol>
		</div>
	</div>
    
  <div class=mt>
<h2>核对订单</h2></div>

	<form id="orderForm" method="post" action="${ctx}/order/createorder.html">
	<input type="hidden" value="${ifdemand}" id="ifdemand" name="ifdemand" />
<table width="100%" class="simpleTable" id="addresst" >
	<tr class="th">
		<td>确认收货信息</td>
	</tr>
	<tr>
		<td>	
		<c:forEach var="address" items="${addresses}" varStatus="state">
			<input type="radio" value=${address.id} name="addressId" id="addressId" <c:if test="${state.index == 0}">checked</c:if>/>
			收货人: ${address.name}   电话: ${address.mobile}  地址: ${address.province} ${address.city}  街道地址: ${address.address} 邮编: ${address.zip} </br>
		</c:forEach>
		</td>
	</tr>
	<tr>
		<td id="exAdd"></td>
	</tr>
	<tr>
		<td>
		<table>
			<tr><td colspan="2"><span id="errorSpan" style="color:#FF0000">
		<c:if test="${fn:length(addresses) == 0}">
		<font color=red>您需要填写收货信息后才能确认订单</font>
		</c:if>	
			</span></td></tr>
			<tr>
			<td><label for="name">收货人: </label></td><td>		            
		            <input type="text" name="name" id="name"  class="text" />
		         	<span class="red hint">请填写收货人真实姓名</span></br></td>
			</tr>
			<tr>
			<td><label>地区： </label>
			</td><td>		            
		            <span>
		            <select name="province" id="province" onchange="selectCity();">
						<c:forEach var="province" items="${provinces}" varStatus="state">
							<option value="${province.provId}">${province.provName}</option>
						</c:forEach>
					</select>
					<select name="city" id="city" ></select><span class="red hint">请选择送货省市</span>
					</span>
		         </td>
			</tr>
			<tr>
			<td><label for="address ">街道地址：</label>
			</td><td>
		            <input type="text" id="address" name="address" class="text" style="width: 300px;" />
		            <span class="red hint"> 请正确填写完整的地址信息</span></br></td>
			</tr>
			<tr>
			<td><label for="zip">邮政编码</label>
			</td><td>
		            <input type="text" id="zip" name="zip" class="text" />
		            <span class="red hint">填写邮编有助我们更快的给您安排送货</span></br></td>
			</tr>
			<tr>
			<td>		            <label for="mobile">手机:</label>
			</td><td>
		            <input type="text" id="mobile" name="mobile" class="text" />
		            <span class="red hint">填写手机确保物流随时与您联系</span></br></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="button" name="mybutton" value="添加地址"  onclick="addRes();" style="padding: 3px 10px"/></td>
			</tr>
		</table>

		</td>
	</tr>	
	
</table>


<table width="100%" class="simpleTable">
	<tr class="th">
		<td>确认配送方式</td>
	</tr>
	<tr>
		<td style="height:50px;">
		<input type="radio" name="shipmethod" id="shipmethod" checked/> <font color="red">免费</font> E邮宝全国配送 
		</td>
	</tr>

</table>


<table width="100%" class="simpleTable">
	<tr class="th">
		<td>确认支付方式</td>
	</tr>
	<tr>
		<td>
		目前我们仅支持通过支付宝支付，您可以在登录支付宝后再选择您方便的银行进行付款。<br/><br/>
		<input type="radio" name="paymethod" id="paymethod" checked style="display:none"/> 
		<img src="images/bank21.jpg" align="middle">
		</td>
	</tr>

</table>

<table width="100%" class="simpleTable">
	<tr class="th">
		<td>发票信息</td>
	</tr>
	<tr>
		<td>
			<input type="checkbox" id="invoice" name="invoice" value="n" onclick="doShowInvoiceDiv()">
	       				需要发票？<br/><br/>
	       		<div id="invoiceDiv" name="invoiceDiv" style="display:none;margin-left:25px;">
   				<ul class=ie_list>
     				<li>
     					<span class="dt_tit">发票类型：</span>
     					<span class="ny_l">
     						<em>普通发票</em>
     					</span>
       				</li>
           			<li>
           			  	<span>发票抬头：</span>
         				<span>
           					<input name="invoiceType" type="radio" id="invoiceType" value="0" checked="checked" onclick="doInvoicetitletype('0')">
           					<em>个人</em>
           				 </span>
           				 <span class="ny_l mn_left">
          		 			<input name="invoiceType" type="radio" id="invoiceType" value="1" onclick="doInvoicetitletype('1')">
           					<em>单位</em>
           				</span>
           			</li>
     				<li>
     					<span class="dt_tit">发票抬头：</span>
     					<span class="ny_l">
         					<input type="text" id="invoiceTitle" name="invoiceTitle" value="">
         					<span style="color:red;margin-left:5px;">*</span>
         				</span>
       				</li>
  	 			</ul>
 			</div>
		</td>
	</tr>

</table>


<table width="100%" class="simpleTable">
	<tr class="th">
		<td>商品</td>
		<td align="right">单价</td>
		<td>数量</td>
		<td>优惠</td>
		<td align="right">小计（元）</td>
	</tr>
	<c:set var="total" scope="page">0</c:set> 
	<c:forEach var="item" items="${orders}" varStatus="state">
	<tr>
		<td><input name="itemId" type="hidden" value="${item.itemId}">${item.name}</td>
		<td align="right"><fmt:formatNumber value="${item.price/100}" pattern="￥#,##0.00" /></td>
		<td>${item.qty}</td>
		<td><c:if test="${item.purchasingType eq 'NORMAL'}">无</c:if>  </td>
		<td align="right">
		<fmt:formatNumber value="${item.price/100*item.qty}" pattern="￥#,##0.00" />
		<c:set var="total" scope="page">${item.price*item.qty+total}</c:set> 
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td align="right">合计：</td>
		<td align="right"><fmt:formatNumber value="${total/100}" pattern="￥#,##0.00" /></td>
	</tr>

</table>
			
		<div style="float:right;margin-bottom:30px;margin-top:10px;"><a href="${ctx}/cart" style="margin-right: 20px">返回购物车修改 &#187;</a>  
		
			<input id="smt" type="submit" value="确认订单" style="padding: 5px 10px;" <c:if test="${fn:length(addresses) ==0}">disabled="disabled" </c:if>/>
		</div>
	</form>

      
</div>
    </div>    

 
</div>

<script type="text/javascript">
		selectCity();
	</script>
</body>
</html>
