<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<head>
<meta name="decorator" content="${current_site.template.path}" />
<title>${item.htmlTitle}</title>
<link rel="stylesheet" type="text/css" href="css/layout.css" />

</head>
<body >
<div id="warpper">
    <div id="banner">
    <div class="${category.code}">
	<div id="header2">
		<c:import url="/part/header.html?site=${current_site.template.path}"></c:import>

      </div>
       </div></div>
       <div id="content">
       <div class="content_resize">
       <div id="breadcrumb">
         <p><span class="you-are-in"><a href="${ctx==""?"/":ctx}"> 首页</a> </span> > 
           <a href="${ctx}/eyes/${category.path}.html">${category.name}</a>> 
           <a href="${ctx}/product/p${item.id}.html">${item.name}</a></p>
</div>
<div  id="menu"><h2>产品系列11</h2>
   
        <ul>
         <c:forEach var="item" items="${itemList}" varStatus="state">
          <li><a href="${ctx}/product/p${item.id}.html"><b>${item.name}</b></a></li>
		 </c:forEach>
          
        </ul></div>
        <div class="sideContent_n ">
        <div class="det_h1"><h1>${item.name}</h1> - -  ${item.itemTitle}</div>
         <div class="productImg"><img src="${ctx}/img/${item.itemImage[0].url}" alt="${item.name}"/></div>
         <div class="info">
         <div class="kind">价 格</div>
         <div class="qiang"><span class="red"><fmt:formatNumber value="${item.price/100}" pattern="￥#,#00.##" /></span><span class="hei">元</span>
         </div>


       <div class="guige">
       <div class="jifen">送&nbsp;积&nbsp;分：${item.point}分</div>
       </div>
       
       
       
<c:if test="${item.inventory != 0}">
    <form action="${ctx}/cart/add" method="post">
       
         <div class="guige">
        <div class="qty">
    <dt>我要买： </dt>

    <a href="javascript:;"  class="minus"><img src="${path}/images/jian.jpg" width="13" height="13" / align="left"></a>
<dd class=it>
  <input class="border" onchange=keychk_num() id="qty" value="1"
  name="qty" />
</dd>
    <dd>件 </dd>
    <a href="javascript:;" class="plus"><img src="${path}/images/jia.jpg" width="13" height="13" /></a>
  </div>
         </div>  
          <div class="btn">

            <input class="list_pr buy_btn" type="submit" value=""/>
            <%--c:if test="${item.tmallUrl != null && item.tmallUrl != ''}">
            <a onclick='_BBLRTracker.event("tmall","访问天猫店",false);' href="${item.tmallUrl}" target="_blank" style="position:relative;top:-22px;left: 15px;"><img src="${path}/images/buy_tmall.jpg"></a>
            </c:if--%>
          </div>
          <input type="hidden" name="itemId" id="itemId" value="${item.id}"/>
          </form>
</c:if>

<c:if test="${item.inventory == 0}">
 <div class="btn">
	<input class="list_pr oos_btn" type="submit" value=""/>
	</div>
</c:if>
          
          
          
            <div class="fenxiang"><!-- JiaThis Button BEGIN -->
		<div id="ckepop"><span class="jiathis_txt">分 享 到：</span> <a class="jiathis_button_tsina"></a> <a class="jiathis_button_qzone"></a> <a class="jiathis_button_tqq"></a> <a class="jiathis_button_renren"></a> <a class="jiathis_button_kaixin001"></a><a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a></div>
		<script type="text/javascript" src="http://v2.jiathis.com/code/jia.js" charset="utf-8"></script>
		<!-- JiaThis Button END --></div>
         </div>
         <div class="ds_tab">
         <ul>
  <li class="cur" ><span>商品详情</span> </li>
	<%--li><span>售后服务</span></li--%>
				</ul></div>
       <div id="description">
             ${category.headerTpl}
             ${item.description}
             ${category.footerTpl}
             
             <div class="comment"><img src="${path}/images/kb.jpg" width="298" height="31" /></div>


		
		<c:forEach var="comment" items="${comments}" varStatus="state">
             <div class="pingfenliuyan">
               <div class="avatar"> <%--img src="images/head.jpg" alt="" /><br /--%>
                 ${comment.userName} </div>
               <div class="comment-details">
                 <div class="biaoti2">
                   <div class="bt"><span class="author">${comment.itemName}</span> <span class="date"> ${comment.createdAt}</span></div>
                 </div>
                 <div class="btxt">
                   <p>${comment.title} </p>
                 </div>
                 <div class="btxtdi"></div>
               </div>
             </div>
        </c:forEach>
        <textarea name="comment" id="comment" cols="80" rows="5"></textarea><br/>
        <button onclick="ajaxComment();" style="padding: 3px 10px">评论</button>
<%--div class="page_number">
			<ul>
			<li><a href="#" >上一页</a></li>
			<li><a href="#" class="hover">1</a></a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li>...</li>
			<li><a href="#">10</a></li>
			<li><a href="#">下一页</a></li>
			</ul>
			</div>
         </div>   
                
                
        </div--%>
        
        
     <div class="clear"></div>
       </div>
       </div>
       
	<script type="text/javascript">
		var ajaxComment = function() {
			var itemId = ${item.id};
			var content = $('#comment').val();
		
			$.post('${ctx}/comments/edit.html',{itemId: itemId,content:content},function(data){
				alert(data);
        	});
		}
		
		var keychk_num = function() {
			if(isNaN(parseInt($("#qty").val()))){
				$("#qty").val("1");
			}
		}
		
		$(".plus").click(function(){ 
			var v = parseInt($("#qty").val());

			$("#qty").val(v+1);

        	return false;

        	return false;
		})
		$(".minus").click(function(){ 
			var v = parseInt($("#qty").val());
			if(v-1 >=1) {
				$("#qty").val(v-1);
			}
        	return false;
		})
		
	</script>
</body>
</html>
