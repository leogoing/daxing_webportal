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
	.p_val{
		letter-spacing: 1px;font-size: 20px;line-height: 25px;padding:20px 0px 0px 122px;
	}
	.p_bold{
		letter-spacing: 3px;font-weight: bold;font-size: 22px;line-height: 30px;
	}
	.left{float:right;width:900px;}
</style>
</head>
<body>


<div >
<%@include file="include_jsp/logo.jsp"%>
    <%@include file="include_jsp/nav.jsp"%>
    <div class="main">
    <div class="big">
    
	<div class="top" >
    <div >
    <img  src="images-table/titlecopy2.jpg" style="width: 100%;height: 100%;">
    </div>
  </div>
  
  <script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
    	$(function(){
    		$('.nav ul li a:eq(1)').css("color","#736E12").css("background-color","#F7F9F4");
    		$('.p_val:eq(1)').addClass('p_bold');
    	});
	</script>
	 <%@include file="include_jsp/tell.jsp"%>
  <div class="left">
    <div style=" padding: 0px 50px 0px 30px;">
    	<c:choose>
    		<c:when test="${requestScope.result_Mes_Text.status==0 && !empty requestScope.result_Mes_Text.result_Val[11]}">
    			<c:forEach var="text_Vals" items="${requestScope.result_Mes_Text.result_Val[11]}" varStatus="self" step="1">
    				<c:if test="${self.index<=1}">
    						<div id="gps${text_Vals[2]}" style="letter-spacing: 3px;padding-top: 30px;">
   								<p  class="title_val" style="font-size: 28px;margin-bottom:10px;font-weight: bold;">${text_Vals[4]}</p>
   								<div class="cut_bg"></div>
    							<p  class="p_val">
    								${text_Vals[3]}
   								</p>
   							</div>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Text.status==1 || empty requestScope.result_Mes_Text.result_Val[11][0]}">
    			<p style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</p>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Text.status==2}">
    			<p  class="error" style="line-height: 50px;font-size: 20px;">加载错误！</p>
    		</c:when>
    	</c:choose>
    </div>
    <img src="img/exaimg4.gif" style="position: relative;left: 550px;top: -250px;">
  </div>
 <div style="clear:both;"></div>
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
