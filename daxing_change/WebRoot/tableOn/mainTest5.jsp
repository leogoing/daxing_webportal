<%@ page language="java"  pageEncoding="gbk" import="com.yihuan.util.*,java.util.*,java.lang.*" contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=path %>/tableOn/" />
<meta  />
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
    <img  src="img/titlecopy6.jpg" style="width: 100%;height: 100%;">
    </div>
  </div>
  
  
  	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
    	$(function(){
    		$('.nav ul li a:eq(5)').css("color","#736E12").css("background-color","#F7F9F4");
    		if("${requestScope.result_Mes_Text.status==1}"=='true'){
    			$('.cut_bg').next().html('<div style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</div>');
    		}
    		if("${requestScope.result_Mes_Text.status==2}"=='true'){
    			$('.cut_bg').next().html('<div class="error"  style="line-height: 50px;font-size: 20px;">加载错误！</div>');
    		}
    	});
	</script>
  <%@include file="include_jsp/tell.jsp"%>
  <div class="left" >
    <style>
     .zhaoping_val{
     	margin: 50px 40px 0px 10px;
  		border-bottom: 1px dashed #BABABA;
  		padding-bottom: 40px;
  		font-size: 15px;
     }
      .zhaoping_val strong{
      	font-size: 20px;
      }
      .inner{
      	padding: 30px 40px 40px 20px;
      }
      .title_val{
      	font-size:32px;
      	font-weight:bold;
      }
      .left{float:right;width:900px;}
    </style>
    
    <div class="inner">
     <p class="title_val" style="line-height:40px;">欢迎加入</p>
     <div class="cut_bg"></div>
      <div style="padding-left: 115px;">
      	<div style="float:right;"><img src="img/rencai.jpg"/></div>
      	<c:choose>
    		<c:when test="${requestScope.result_Mes_Text.status==0 && !empty requestScope.result_Mes_Text.result_Val[1]}">
    			<c:forEach var="texts" items="${requestScope.result_Mes_Text.result_Val[1]}" varStatus="self" step="1">
    				<c:if test="${self.index<=6}">
    					<div id="gps${texts.identity_id}" class="zhaoping_val">
    						<strong>${texts.custom_title}</strong><br/><br>
   	 						${texts.content_text}
      					</div>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${empty requestScope.result_Mes_Text.result_Val[1][0].classify}">
    			<li style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</li>
    		</c:when>
    	</c:choose>
      </div>
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
