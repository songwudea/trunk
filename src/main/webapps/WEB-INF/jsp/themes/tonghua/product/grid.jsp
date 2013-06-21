<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<div clstag="thirdtype|keycount|thirdtype|select" class="m" id="select">
	<div class="mt">
		<h1>家电配件</h1>
		<strong>&nbsp;-&nbsp;商品筛选</strong>
		<div class="extra">
			<a href="http://www.360buy.com/products/737-794-877.html"></a>
		</div>
	</div>
	
	<dl id="select-brand" class="fore">
		<dt>品牌：</dt>
		<dd>
			<div class="content">
				<c:forEach items="${brandList.filterValue}" varStatus="state">
					<div>
						<a <c:if test="${brandList.ids[state.index] == brandList.checkVal}">class="curr"</c:if> href="${brandList.urls[state.index]}" id="${brandList.ids[state.index]}">${brandList.filterValue[state.index]}</a>
					</div>
				</c:forEach>
			</div>
		</dd>
	</dl>
	<dl>
		<dt>价格：</dt>
		<dd>
			<c:forEach items="${priceList.filterValue}" varStatus="state">
				<div><a <c:if test="${priceList.ids[state.index] == priceList.checkVal}">class="curr"</c:if> href="${priceList.urls[state.index]}" id="${priceList.ids[state.index]}">${priceList.filterValue[state.index]}</a></div>
			</c:forEach>
		</dd>
	</dl>
	 
	<c:forEach items="${attrFilterList}" varStatus="state1" var="attr">
	<dl>
		<dt>${attr.filterName}：</dt>
		<dd>
			<c:forEach items="${attr.urls}" varStatus="state">
				<div><a <c:if test="${attr.ids[state.index] == attr.checkVal}">class="curr"</c:if> href="${attr.urls[state.index]}" id="${attr.ids[state.index]}">${attr.filterValue[state.index]}</a></div>
			</c:forEach>
		</dd>
	</dl>
	</c:forEach>
	

	</div>
	<div id="filter" >

        <div class='fore1'>
        	<dl class='order'>
        		<dt>排序：</dt>
        		<c:forEach items="${otherFilterList.filterValue}" varStatus="state">
		        	<dd <c:if test="${otherFilterList.ids[state.index] == otherFilterList.checkVal}">class="curr"</c:if>><a href='${otherFilterList.urls[state.index]}'>${otherFilterList.filterValue[state.index]}</a><b></b></dd>
				</c:forEach>
        	</dl>
        	
        	<div class='pagin pagin-m'>
        		<span class='text'>1/2</span>
        		<span class="prev-disabled">上一页<b></b></span>
        		<a href="670-677-678-0-0-0-0-0-0-0-1-1-2.html" class="next" >下一页<b></b></a>
        	</div>
        	
        	<div class='total'>
        		<span>共<strong>38</strong>个商品</span></div><span class='clr'></span>
        	</div>

	</div>
	
	
	<div id="plist" class="m">
		<ul class="listh">
			<c:forEach items="${productList}" var="item">
			<li>
				<div class="img"><img width="130" height="130" src="${ctx}/img/${item.itemImage[0].url}"></div>
				<div class="name">${item.name}u</div>
				<div class="price"><fmt:formatNumber value="${item.price / 100}" type="currency" /></div>
				<div class="extra"></div>
				<div class="btns"></div>
			</li>
			</c:forEach>
		</ul>
	</div>