<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/jspHead.jsp" %>
<!doctype html>
<head>
<title>${content.htmlTitle}</title>
<meta name="decorator" content="${current_site.template.path}" />
<meta name="keywords" content="${content.metaKeywords}" /> 
<meta name="description" content="${content.metaDesc}" /> 
<link rel="stylesheet" type="text/css" href="css/layout.css" />
</head>
<body >
<div id="warpper">
    <div id="banner2">
    <div class="${parent.code}">
		<div id="header2">
			<c:import url="/part/header.html?site=${current_site.template.path}"></c:import>
	    </div>
    </div></div>
       <div id="content">
       <div class="content_resize">
       <div id="breadcrumb">
         <p><span class="you-are-in"><a href="${ctx==""?"/":ctx}"> 首页</a> </span> > 
           <a href="${content.urlRewrite}.html">${parent.title}</a>> 
           	${content.title}
</div>
<div  id="menu"><h2>${parent.title}</h2>
   
        <ul>
        <c:forEach var="item" items="${contentList}" varStatus="state">
          <li><a href="${item.urlRewrite}.html" class="current"><b>${item.title}</b></a></li>

        </c:forEach>
        </ul></div>
        <div class="sideContent_n ">
        <div class="det_h1"><h1>${content.subTitle}</h1></div>
        <div id="description">
         <div class="nr">
         ${content.content}
         	<c:forEach var="sec" items="${seconds}" varStatus="state">
         		<li style="padding-left: 20px;line-height:30px"><a href="${sec.urlRewrite}.html" class="current">${sec.title}</a></li>
         	</c:forEach>
           </div></div>
        </div>
     <div class="clear"></div>
       </div>
       </div>
       

</body>
</html>
