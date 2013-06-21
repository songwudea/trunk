<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery.EasyUI</title>
    <style type="text/css">
	<!--
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
	    width:450px;
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
	</head>
	
	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
		<form method="post" name="form" id="form" action="${ctx}/admin/login.html">
			<fieldset>
				<legend>管理员登录</legend>
				<div>
					<label for="name">用户名</label>
					<input type="text" name="name" class="input" id="name" size="20" maxlength="30"/><br/>
				</div>
				<div>
					<label for="password">密码</label>
					<input type="password" name="password" class="input" id="password" size="20" maxlength="30"/><br/>
				</div>
				<div class="enter">
					<input name="submit" type="submit" class="buttom" value="登录" />
				</div>
			</fieldset>
		</form>
</div>
