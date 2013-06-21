<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/jspHead.jsp" %>
<!doctype html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="眼睛护理,眼部护理" /> 
<meta name="description" content="眼睛，眼部护理专家瞳话，拥有四百年历史。旗下有似水明眸，雪莹星眸，时光回眸，弹力金翠四个系列。解决眼睛干涩，黑眼圈，有眼袋等问题且有显著效果。拥有一双美丽的眼睛，就来瞳话官方商城。" /> 
<meta property="wb:webmaster" content="288285f76d29771d" />
<meta property="qc:admins" content="3423267047602541456375" />
<title>眼睛,眼部护理专家 - 瞳话官方商城</title>
<link rel="stylesheet" href="${path}/css/layout.css"  type="text/css"/>
<script type="text/javascript" src="${ctx}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="${ctx}/js/iepngfix/iepngfix_tilebg.js"></script>
<script type="text/javascript" src="${ctx}/js/slides.min.jquery.js"></script>
<script>

		$(function(){
			$('DIV.slide-info').slides({
				preload: true,
				preloadImage: '${ctx}images/loading.gif',
				play: 5000,
				pause: 2000,
				effect: 'fade',
				hoverPause: true,
				animationStart: function(current){

				},
				animationComplete: function(current){
					current_slide_no = current-2;
					var x = current_slide_no + 1 == 4?0:current_slide_no+1;
					var color = $("#nivoSlider IMG")[x].getAttribute("color");
					$("DIV#slider-holder").animate({ backgroundColor: color }, 300);
				},
				slidesLoaded: function() {
	
				}
			});
		});
</script>
<style type="text/css">
div#logo img, div#channel img, div#channel div,a.next img,a.prev img{ behavior: url(${ctx}/js/iepngfix/iepngfix.htc) }

#slides {
	width: 980px;
	margin: 0px auto;
	position:absolute;
	z-index:100;
}
.slides_container {
	width:980px;
	margin: 0px auto;
	overflow:hidden;
	position:relative;
}
.slides_container a {
	width:980px;
	height:700px;
	display:block;
}
.slides_container a img {
	display:block;
}
#slides .next,#slides .prev {
	position:relative;
	top:-410px;
	width:24px;
	height:43px;
	display:block;
	z-index:101;
}
#slides .next {
	left:955px;
	top:-445px;
}
.pagination {
	display:none;
}


</style>
<link rel="prefetch" href="${path}/images/banner1.jpg">
<link rel="prerender" href="${path}/images/banner1.jpg">
<link rel="prefetch" href="${path}/images/banner2.jpg">
<link rel="prerender" href="${path}/images/banner2.jpg"> 
<link rel="prefetch" href="${path}/images/banner3.jpg">
<link rel="prerender" href="${path}/images/banner3.jpg"> 
<link rel="prefetch" href="${path}/images/banner4.jpg">
<link rel="prerender" href="${path}/images/banner4.jpg"> 
</head>
<body>

<div id="warpper">
<c:import url="/part/top.html?site=${current_site.template.path}"></c:import>
<div id="slider">
  <div id="slider2">
		<div id="slider-holder" style="background-color:#A7ADC5">

		            <div id="slides" class="slide-info">
		                <div id="nivoSlider" class="slides_container">

                <a onclick='_BBLRTracker.event("tmall","访问天猫店",false);' target="_blank" href="http://www.pretale.com/eyes/heiyanquan.html"><img src="${path}/images/banner2.jpg" color="#A7ADC5"/></a>
                <a onclick='_BBLRTracker.event("tmall","访问天猫店",false);' target="_blank" href="http://www.pretale.com/eyes/yanwen.html"><img src="${path}/images/banner3.jpg" color="#CEAC7B"/></a>
                <a onclick='_BBLRTracker.event("tmall","访问天猫店",false);' target="_blank" href="http://www.pretale.com/eyes/yandai.html"><img src="${path}/images/banner4.jpg" color="#F8C4CA"/></a>
                <a onclick='_BBLRTracker.event("tmall","访问天猫店",false);' target="_blank" href="http://www.pretale.com/eyes/bushui.html"><img src="${path}/images/banner1.jpg" color="#D0E9FE"/></a>
		                </div>
				<div style="width:980px;margin:0px auto ">
				<a href="#" class="prev"><img src="${ctx}/images/arrow-prev.png" width="24" height="43" alt="Prev"></a>
				<a href="#" class="next"><img src="${ctx}/images/arrow-next.png" width="24" height="43" alt="Next"></a>
				</div>
		            </div>

		</div>
		<div id="channel">
		    <div class="channel">
		        <div class="chanpinshiyong">
		            <p style="font-size:18px">
		                产品使用报告
		            </p>
		            <div class="left">
		                <img src="${path}/images/cpbg.jpg" width="58" height="79" class="img" />
		            </div>
		            <div class="right">
		                <div class="jrzx">
		                    今日推荐
		                </div>
		                <div class="t">
		                    <a href="${ctx}/product/p17.html">雪莹星眸黑眼圈眼霜...</a>
		                </div>
		                <div class="message">
		                    <a href="${ctx}/product/p17.html">这款眼霜很适合长期对着电脑族的MM们...</a>
		                </div>
		            </div>
		        </div>
		        <div class="free-trial">
		            <p style="font-size:18px">
		                免费试用
		            </p>
		            <div class="left">
		                <span style="font-size:12px">瞳话眼部产品</span><br />
		                <span style="font-size:14px">免费领用</span><a href="${ctx}/content/event.html"><img src="${path}/images/sy_but.png" width="86" height="58" /></a>
		            </div>
		            <div class="right">
		                <a href="${ctx}/content/event.html"><img src="${path}/images/sy_img.png" width="115" height="90" /></a>
		            </div>
		        </div>
		        <div class="chanpinshiyong">
		            <p style="font-size:18px">
		                专家专栏
		            </p>
		            <div class="left">
		                <img src="${path}/images/js.jpg" width="58" height="79" class="img2" />
		            </div>
		            <div class="right2">
		                <div class="call">
		                    Dr Tonghua
		                </div>
		                <div class="problem">
		                    <a href="${ctx}/content/faq.html">
		                        <img src="${path}/images/cjwenti.png" width="101" height="25" />
		                    </a>
		                </div>
		            </div>
		        </div>
		        <div class="Products-through-train">
		            <p style="font-size:18px">
		                产品直通车
		            </p>
		            <div class="condition">
		                <select id="product_select" class="select">
		                    <option>
		                        按产品系列分查询
		                    </option>
		                    <option>
		                        雪莹星眸系列
		                    </option>
		                    <option>
		                        时光回眸系列
		                    </option>
		                    <option>
		                        弹力金萃系列
		                    </option>
		                    <option>
		                        似水明眸系列
		                    </option></select>
		            </div><img src="${path}/images/subiao.png" width="55" height="67" />
		        </div>
		    </div>
		</div>
		<div id="zy-butt">

		</div>
	<div id="header">
		<c:import url="/part/header.html?site=${current_site.template.path}"></c:import>
    </div>
  </div>
</div>

</div>

<div id="sy-footer-warpper">
  <div id="sy-footer">
<script>
var _BBLRJID = "PATH_1"; 
</script>
<c:import url="/part/copy.html?site=${current_site.template.path}"></c:import>
</div></div>

<a id="banner_href" href=""></a>
    <script type="text/javascript">

    

	var href = ["heiyanquan","yanwen","yandai","bushui"];
	$(document).ready(function() {
		$("SELECT#product_select").change(function() {
			if(this.selectedIndex>0) {
				location.href = "${ctx}/eyes/"+href[this.selectedIndex-1]+".html"
			}
		})
	});
    </script>

</body>
</html>