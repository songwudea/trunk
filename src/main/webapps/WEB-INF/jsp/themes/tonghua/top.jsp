<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/jspHead.jsp" %>
<div id="top-warpper"><div id="header-top">
			<div class="loginbar"><div class="welcome">您好！${USER_NAME} 欢迎来到瞳话官方商城！</div>
			
			<div class="registered">
			<c:if test="${USER_NAME == null}">
			<a href="${ctx}/user/login.html">请登录</a></div><div class="enrolment"><a href="${ctx}/user/register.html">注册</a></div>
			</c:if>
			<c:if test="${USER_NAME != null}">
			<a href="${ctx}/user/address">我的瞳话</a></div><div class="enrolment"><a href="${ctx}/user/logout.html">退出</a></div>
			</c:if>
			
			
			</div>
			
			<div class="links">
            <div class="guild"><%--a href="http://pretale.tmall.com/" target="_blank" onclick='_BBLRTracker.event("tmall","访问天猫店",false);'>Tmall 瞳话旗舰店</a--%>  </div> 
				<div class="shop"><a href="${ctx}/cart">购物袋<span  class="count"> <c:if test="${CART_COUNT==null}">0</c:if>${CART_COUNT} </span> 件 </a></div>
				<div class="partake">
					<iframe id="sinaweiboiframe" style="vertical-align: middle" width="136" height="24"
            frameborder="0" allowtransparency="true" marginwidth="0" marginheight="0" scrolling="no"
            src="http://widget.weibo.com/relationship/followbutton.php?width=136&height=24&uid=2688758603&style=2&btn=red&dpc=1"
            frameborder="No" border="0"></iframe>
				</div>
			</div>
		</div></div>
