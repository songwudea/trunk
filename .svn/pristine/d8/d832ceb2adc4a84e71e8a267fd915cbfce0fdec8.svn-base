<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/jspHead.jsp" %>
<!doctype html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>${category.name}</title>
<meta name="keywords" content="" /> 
<meta name="description" content="" /> 
<base href="${path}/"/>
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<script type="text/javascript">
$(function(){
	$(".box_content").mousemove(function() {
		this.className="box_content2";
	}).mouseout(function (){
		this.className="box_content";
	})
});
</script>

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
           	产品系列 > 
           <a href="${ctx}/eyes/${category.path}.html">${category.name}</a></p>
</div>
<div  id="menu"><h2>产品系列</h2>
   
        <ul>
        <c:forEach var="item" items="${categoryList}" varStatus="state">
          <li><a href="${ctx}/eyes/${item.path}.html" class="current"><b>${item.name}</b></a></li>
        </c:forEach>

        </ul></div>
        <div class="sideContent">
        
        <c:forEach var="item" items="${itemList}" varStatus="state">
          <div class="box">
            <div class="box_tit"> <span class="chn"><a href="${ctx}/product/p${item.id}.html">${item.name}</a></span><br />
              <span class="eng">- -  ${item.itemTitle}</span> </div>
            <div class="box_content"> 
	            <a href="${ctx}/product/p${item.id}.html">
	            <img src="${ctx}/img/${item.itemImage[0].url}" alt="${item.name}"/>
	            </a>
              <div class="describe">
                <div class="description">
                  ${item.shortDesc}
                </div>
                <div class="restriction-button "> <span class="value"><fmt:formatNumber value="${item.price/100}" pattern="￥#,#00.##" /></span>
                <c:if test="${item.inventory != 0}">
                <form action="${ctx}/cart/add" method="post">
                <input type="hidden" name="qty" value="1"/>
                <input type="hidden" name="itemId" value="${item.id}"/>
                 <a href="${ctx}/product/p${item.id}.html" class="but" onclick="$(this).closest('form').submit();return false;"></a>
                </form>
                </c:if>
                <c:if test="${item.inventory == 0}">
				<a href="${ctx}/product/p${item.id}.html" class="oos"></a>
                </c:if>
                
                </div>
              </div>
            </div>
          </div>
		</c:forEach>



        </div>
        
        
     <div class="clear"></div>
       </div>
       </div>
<c:if test="${category.path eq 'heiyanquan'}">
<script>
var _BBLRJID = "PATH_2"; //保持这行不要改，直接原封不动得输出
</script>
</c:if>
</body>
</html>
