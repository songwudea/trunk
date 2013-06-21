<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/jspHead.jsp" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!doctype html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title /></title>   
    <script type="text/javascript" src="${ctx}/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.easyui.min.1.3.0.js"></script>
    <script type="text/javascript" src="${ctx}/js/locale/easyui-lang-zh_CN.js"></script>
    
    <link href="${ctx}/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/js/themes/icon.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
	<!--
		#xbox {
			clear: both; border-right: #19cc01 2px solid; border-top: #19cc01 2px solid; padding-left: 30px; background: url(/uploadfile/2007-10/200710212547404.gif) #f2fcf1 no-repeat left center; margin-bottom: 8px; border-left: #19cc01 2px solid; color: #159600; line-height: 24px; border-bottom: #19cc01 2px solid; height: 24px; text-align: right
			height:auto !important;
			height:200px; /*假定最低高度是200px*/
			height:auto !important;
			min-height:50px; 
		}
		body {
    font-family: Arial, Helvetica, sans-serif;
    font-size:12px;
    color:#666666;
    background:#fff;
    text-align:center;

}

* {
    margin:0;
    padding:0;
}

a {
    color:#1E7ACE;
    text-decoration:none;   
}

a:hover {
    color:#000;
    text-decoration:underline;
}
h3 {
    font-size:14px;
    font-weight:bold;
}

pre,p {
    color:#1E7ACE;
    margin:4px;
}
input, select,textarea {
    padding:1px;
    margin:2px;
    font-size:11px;
}
.buttom{
    padding:1px 10px;
    font-size:12px;
    border:1px #1E7ACE solid;
    background:#D0F0FF;
}
#formwrapper {
    width:650px;
    margin:15px auto;
    padding:20px;
    text-align:left;
    border:1px #1E7ACE solid;
}

fieldset {
    padding:10px;
    margin-top:5px;
    border:1px solid #1E7ACE;
    background:#fff;
}

fieldset legend {
    color:#1E7ACE;
    font-weight:bold;
    padding:3px 20px 3px 20px;
    border:1px solid #1E7ACE;   
    background:#fff;
}

fieldset span {
    text-align:right;
    width:140px;
    margin:1px;
}

fieldset label {
    float:left;
    width:120px;
    text-align:right;
    padding:4px;
    margin:1px;
}

fieldset div {
    clear:left;
    margin-bottom:2px;
}

.enter{ text-align:center;}
.clear {
    clear:both;
}
	-->
	</style>
<style>
@import “${ctx}/common/style.css.jsp”;
</style>
<decorator:head />
</head>
<body>
<decorator:body />
</body> 