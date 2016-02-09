<%@ page language="java"  pageEncoding="gbk" contentType="text/html; charset=gbk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta >
<title>yihuan可悬停控制图片</title>
<style>
.flex-control-paging li a{display:block;overflow:hidden;width:1pc;height:1pc;background:url(<%=path%>/tableOn/roll/images/dot.png) no-repeat 0 -1pc;text-indent:-99em;cursor:pointer}.flex-direction-nav a{position:absolute;top:50%;z-index:10;display:block;overflow:hidden;margin:-35px 0 0;width:70px;height:70px;border-radius:35px;background:url(<%=path%>/tableOn/roll/images/ad_ctr.png) no-repeat;line-height:99em;opacity:0;cursor:pointer;-webkit-transition:all .3s ease;filter:alpha(opacity=0)}
</style>
</head>
<body>
<!-- 轮播广告 -->
<div id="banner_tabs" class="flexslider">
	<ul class="slides">
		<c:choose>
    		<c:when test="${requestScope.result_Mes_Img.status==0 && !empty requestScope.result_Mes_Img.result_Val[1]}">
    			<c:forEach var="imgs" items="${requestScope.result_Mes_Img.result_Val[1]}" varStatus="self" step="1">
    				<c:if test="${self.index>=0}">
    					<li >
							<a class="update_button" target="_blank" href="${imgs[4]}">
    						<input class="link_hide" value="<%=path %>/main/main.action?status=${imgs[6]}&identity_id=${imgs[2]}"/>
								<img style="background-image: url(<%=path %>${imgs[3]});" src="<%=path%>/tableOn/roll/images/alpha.png">
							</a>
						</li>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Img.status==1 || empty requestScope.result_Mes_Img.result_Val[5][0]}">
    			<li><p style="line-height: 50px;font-size: 20px;">暂无资源！</p></li>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Img.status==2}">
    			<li><p class="error"  style="line-height: 50px;font-size: 20px;">加载错误！</p></li>
    		</c:when>
    	</c:choose>
    	</ul>
	
	<ul class="flex-direction-nav">
		<li><a class="flex-prev" href="javascript:;">Previous</a></li>
		<li><a class="flex-next" href="javascript:;">Next</a></li>
	</ul>
	<ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
		<li><a>1</a></li>
		<li><a>2</a></li>
		<li><a>2</a></li>
		<li><a>2</a></li>
	</ol>
</div>
<script src="<%=path%>/tableOn/js/jquery-1.4.3.js"></script>
<script src="<%=path%>/tableOn/roll/js/slider.js"></script>
<script type="text/javascript">
$(function() {
	var bannerSlider = new Slider($('#banner_tabs'), {
		time: 90000,
		delay: 400,
		event: 'hover',
		auto: true,
		mode: 'fade',
		controller: $('#bannerCtrl'),
		activeControllerCls: 'active'
	});
	$('#banner_tabs .flex-prev').click(function() {
		bannerSlider.prev()
	});
	$('#banner_tabs .flex-next').click(function() {
		bannerSlider.next()
	});
})
	function f(){
		var text = document.getElementById("text").innerHTML;

	}
</script>
</body>
</html>

