<%@ page language="java"  pageEncoding="gbk" import="com.yihuan.util.*,java.util.*,java.lang.*" contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=path %>/tableOn/" />
<meta />
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
  
   <div class="top"  >
    <div >
    <img  src="img/titlecopy4.png" style="width: 100%;height: 100%;">
    </div>
  </div>
  
  <script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
    	$(function(){
    		$('.nav ul li a:eq(3)').css("color","#736E12").css("background-color","#F7F9F4");
    		if("${requestScope.result_Mes_IT.status==1}"=='true'){
    			$('.cut_bg').append('<div style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</div>');
    		}
    		if("${requestScope.result_Mes_IT.status==2}"=='true'){
    			$('.cut_bg').append('<div class="error"  style="line-height: 50px;font-size: 20px;">加载错误！</div>');
    		}
    	});
	</script>
	<%@include file="include_jsp/tell.jsp"%>
  <div class="left">
  	<style> 
  		.img{
  			 width: 300px;
  			 height:215px;
	 		 padding-left:;
  		}
		.left{float:right;width:900px;}
		.left h2{
			text-align: center;
			line-height: 70px;
			font-size: 28px;
		}
		.img_div{
			width: 300px;
			float: left;
			padding-left: 8%;
		}
  	</style>
  	
    <p class="title_val"></p>
    <div class="inner">
     <style>
     	.inner h2{
  			line-height: 60px;
  			font-size: 25px;
  			padding-top: 10px;
  			font-family: 黑体;
     	}
     	.inner{
     		padding: 40px 40px 40px 20px;
     	}
     </style>
     
     <div style="font-size: 32px;font-weight: bold;">职业证书</div>
    <div class="cut_bg"></div>
    	<div style="padding-left: 10%;">
    	<c:choose>
    		<c:when test="${requestScope.result_Mes_IT.status==0 && !empty requestScope.result_Mes_IT.result_Val[1]}">
    			<c:forEach var="img_texts" items="${requestScope.result_Mes_IT.result_Val[1]}" varStatus="self" step="1">
    				<c:if test="${self.index<=6}">
    					<div class="img_div" id="gps${img_texts.identity_id}" >
    						<h2>${img_texts.custom_title}</h2>
    						<div>
    							<img class="img" src="<%=path %>${img_texts.img.img_path}">
   							</div>
  						</div>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${empty requestScope.result_Mes_IT.result_Val[1][0].classify}">
    			<li style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</li>
    		</c:when>
    	</c:choose>
    
    <div style="clear: both;"></div>
    </div>
    
    <div style="clear: both;"></div>
    <div style="font-size: 32px;font-weight: bold;">获得资奖</div>
     <div class="cut_bg"></div>
     <div style="clear: both;"></div>
    
    <div style="padding-left: 10%">
    	<c:choose>
    		<c:when test="${requestScope.result_Mes_IT.status==0 && !empty requestScope.result_Mes_IT.result_Val[2]}">
    			<c:forEach var="img_texts" items="${requestScope.result_Mes_IT.result_Val[2]}" varStatus="self" step="1">
    				<c:if test="${self.index<=6}">
    					<div class="img_div" id="gps${img_texts.identity_id}" >
    						<h2>${img_texts.custom_title}</h2>
    						<div>
    							<img class="img" src="<%=path %>${img_texts.img.img_path}">
   							</div>
  						</div>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${empty requestScope.result_Mes_IT.result_Val[2][0].classify}">
    			<li style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</li>
    		</c:when>
    	</c:choose>
   	
    </div>
    <div style="clear: both;"></div>
    
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