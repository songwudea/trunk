<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery.EasyUI</title>
    <link href="${ctx}/common/css/default.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/common/css/om-all.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
	   a,input,button{
		   outline:none;
		   hide-focus:expression(this.hideFocus=true) \9; 
	   }
	  button::-moz-focus-inner,input::-moz-focus-inner{border:none;}
    </style>
    
    <script type="text/javascript" src="${ctx}/common/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/operamasks-ui.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
		$('#edit').omButton({
	         onClick : function(event){
	         }
	    });    	
    });
    </script>
    
</head>
<body>	
	<div id="dialog-form">
        <form id="ipForm" method="post" action="${ctx}/staff/edit.html">
	        <input name="id" style="display: none"/>
	        <table border="0" cellspacing="0" cellpadding="0">
	        	<tr>
				    <td colspan="2">
					   <div id="errorMessages"></div>
					</td>
				</tr>
	            <tr>
	                <td width="75" align="right"><label>用户名：</label></td>
	                <td width="245"><input type="text" name="sta_username"/></td>
	            </tr>
	            <tr>
	                <td align="right"><label>密码：</label></td>
	                <td><input type="password" name="sta_password"/></td>
	            </tr>
	            <tr>
	                <td align="right"><label>邮箱：</label></td>
	                <td><input name="sta_email"/></td>
	            </tr>
	            <tr>
	                <td align="right"><label>性别：</label></td>
	                <td><input name="sta_sex" /></td>
	            </tr>
	            <tr>
	                <td align="right"><label>省份：</label></td>
	                <td><input name="sta_province"/></td>
	            </tr>
	            <tr>
	                <td align="right"><label>电话：</label></td>
	                <td><input name="sta_tel"/></td>
	            </tr>
	            <tr>
	                <td align="right"><label>手机：</label></td>
	                <td><input name="sta_mobile"/></td>
	            </tr>
	            <tr>
	                <td align="right"><label>状态：</label></td>
	                <td><input name="sta_loginstatus"/></td>
	            </tr>
	            <tr>
	                <td align="right"><label>职责：</label></td>
	                <td><input name="sta_station"/></td>
	            </tr>
	            <tr>
					<td align="right">
	                	<input id="edit" type="submit" value="新增"/>
	                </td>
				</tr>
	        </table>
        </form>
    </div>
</body>
</html>