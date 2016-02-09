<%@ page language="java"  pageEncoding="gbk" import="com.yihuan.util.*,java.util.*,java.lang.*" contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=path %>/tableOn/" />
<meta/>
<title>北京智环成测绘有限公司</title>
<link rel="stylesheet" href="css/son.css" type="text/css"></link>
<style>
	
</style>
</head>
<body>

<div id="body">
<%@include file="include_jsp/logo.jsp"%>
    <%@include file="include_jsp/nav.jsp"%>
    <div class="main">
    <div class="big">
  <div class="top" >
    <div >
    <img  src="img/titlecopy3.jpg" style="width: 100%;height: 100%;">
    </div>
  </div>
  
  <script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
    	$(function(){
    		$('.nav ul li a:eq(2)').css("color","#736E12").css("background-color","#F7F9F4");
    		if("${requestScope.result_Mes_Title.status==1}"=='true'){
    			$('.val').html('<li style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</li>');
    		}
    		if("${requestScope.result_Mes_Title.status==2}"=='true'){
    			$('.val').html('<li class="error"  style="line-height: 50px;font-size: 20px;">加载错误！</li>');
    		}
    		$('.title_link_a').click(function(){
    			$('.click_hide').hide();
    			$(this).parent().parent().prev().prev('.cut_bg').show().prev('.title').show();
    			$('#show_text').text($(this).next().text()).show();
    			$('#goback').show();
    			return false;
    		});
    		$('#goback').click(function(){
    			$('.cut_bg,.exa_img,.val,.title').show();
    			$(this).hide();
    			$('#show_text').hide();
    		});
    	});
	</script>
	 <%@include file="include_jsp/tell.jsp"%>
  <div class="left" >
    <p class="title_val"></p>
  	<style>
  		.text_val{
  			 text-align: left;
  			 padding: 15px 20px 0px 30px;font-weight: 900;
  			 font-family: 黑体;
  		}
  		.text_val .title{
  			list-style: none;
  			font-size: 28px;
  			line-height: 35px;
  		}
  		.text_val .val{
  			color:rgb(137, 137, 101);
  			font-size: 18px;
  			line-height: 55px;
  			padding:30px 0px 30px 490px;
  		}
  		.exa_img{
  			display: inline-block;
  			width: 280px;
			background-size: 100% 100%;
			height: 245px;
  			background-image:url(img/exa_img_bg.gif);
  			float: left;
  			margin: 40px 0px 20px 130px;
  		}
  		.exa_img img{
  			width: 96%;
			padding: 5px;
			height: 175px;
  		}
  		.title{
  			clear:both;
  		}
  		.exa_img_title{
  			font-size: 22px;
			color: rgb(165, 165, 65);
			padding-left: 30%;
			line-height: 48px;
  		}
  		.hide_val,#show_text{
  			display:none;
  		}
  		.click_hide{
  		}
  		#show_text{
  			font-size: 20px;
			letter-spacing: 2px;
			font-weight: 300;
  		}
  		.left{float:right;width:900px;}
  	</style>
  	<div class="text_val" >
  	<a id="goback" href="javascript:;" style="display:none;position: relative;left: 92%;top: 25px;"><img src="link-img/back_button.png" style="width: 30px;height: 20px;"></img></a>
    <p class="title click_hide">不动产测量：</p>
    <div class="cut_bg click_hide"></div>
    <div class="exa_img click_hide"><img src="img/exaimg3.jpg"/><p class="exa_img_title">房产测绘</p></div>
    <ul class="val click_hide">
    	<c:choose>
    		<c:when test="${requestScope.result_Mes_Title.status==0 && !empty requestScope.result_Mes_Title.result_Val[1]}">
    			<c:forEach var="titles" items="${requestScope.result_Mes_Title.result_Val[1]}" varStatus="self" step="1">
    				<c:if test="${self.index<=6}">
    						<li id="gps${titles.identity_id}"><a class="title_link_a" href="javascript:;">${titles.title_val}</a><div class="hide_val"><p>${titles.text_Val.content_text}</p></div></li>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${empty requestScope.result_Mes_Title.result_Val[1][0].classify}">
    			<li style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</li>
    		</c:when>
    	</c:choose>
    </ul>
    <p class="title click_hide">地理信息系统工程：</p>
    <div class="cut_bg click_hide"></div>
    <div class="exa_img click_hide"><img src="img/exaimg2.jpg"/><p class="exa_img_title">地理测绘</p></div>
    <ul class="val click_hide">
    	<c:choose>
    		<c:when test="${requestScope.result_Mes_Title.status==0 && !empty requestScope.result_Mes_Title.result_Val[2]}">
    			<c:forEach var="titles" items="${requestScope.result_Mes_Title.result_Val[2]}" varStatus="self" step="1">
    				<c:if test="${self.index<=6}">
    						<li id="gps${titles.identity_id}" ><a class="title_link_a" href="javascript:;">${titles.title_val}</a><div class="hide_val"><p>${titles.text_Val.content_text}</p></div></li>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${empty requestScope.result_Mes_Title.result_Val[2][0].classify}">
    			<li style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</li>
    		</c:when>
    	</c:choose>
    </ul>
    <p class="title click_hide">工程测量：</p>
    <div class="cut_bg click_hide"></div>
    <div class="exa_img click_hide"><img src="img/exaimg1.jpg"/><p class="exa_img_title">工程测绘</p></div>
    <ul class="val click_hide">
    	<c:choose>
    		<c:when test="${requestScope.result_Mes_Title.status==0 && !empty requestScope.result_Mes_Title.result_Val[3]}">
    			<c:forEach var="titles" items="${requestScope.result_Mes_Title.result_Val[3]}" varStatus="self" step="1">
    				<c:if test="${self.index<=6}">
    						<li id="gps${titles.identity_id}" ><a class="title_link_a" href="javascript:;">${titles.title_val}</a><div class="hide_val"><p>${titles.text_Val.content_text}</p></div></li>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${empty requestScope.result_Mes_Title.result_Val[3][0].classify}">
    			<li style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</li>
    		</c:when>
    	</c:choose>
    </ul>
    <div style="margin: 30px;"><p id="show_text"></p></div>
    <div style="clear:both;"></div>
    </div>
  </div>
  <div style="clear:both"></div>
</div>
</div>
</div>
<%@include file="include_jsp/foot.jsp" %>
</body>
<script type="text/javascript">
	var documt=document.getElementById("gps"+("${param.identity_id}"==""?null:"${param.identity_id}"));
</script>
<script type="text/javascript" src="js/gps.js"></script>
<!-- JiaThis Button BEGIN -->
<script type="text/javascript" src="http://v3.jiathis.com/code/jiathis_r.js?type=left" charset="utf-8"></script>
<!-- JiaThis Button END -->
<%@include file="include_jsp/go_top.jsp" %>
</html>
