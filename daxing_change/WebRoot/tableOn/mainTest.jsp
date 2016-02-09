<%@ page language="java"  pageEncoding="gbk" import="java.util.*,com.yihuan.util.*" contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>北京智环成测绘有限公司</title>
<link rel="stylesheet" href="<%=path %>/tableOn/css/son.css" type="text/css"></link>
<link rel="stylesheet" href="<%=path %>/tableOn/css/main.css" type="text/css"></link>
</head>
<body>
	<div id="body">
	<%@include file="include_jsp/logo.jsp"%>
	<%@include file="include_jsp/nav.jsp"%>
    <div class="main">
  <div class="big">
	<div class="top">
    	<%@include file="roll/index.jsp"%>
    </div>
  <div class="left">
    <div class="title_line">
    	<p  class="title_val">行业动态</p>
    	<div style="left:92%" ><font class="left_more">News</font></div>
    </div>
    <div style="height:142px" >
    	<c:choose >
    		<c:when test="${requestScope.result_Mes_Title.status==0 && !empty requestScope.result_Mes_Title.result_Val[4]}">
    			<table cellspacing="5px" class="left_table">
    			<c:forEach var="titles" items="${requestScope.result_Mes_Title.result_Val[4]}" varStatus="self" step="1">
    				<c:if test="${self.index<=3}">
    					<tr>
    						<td class="img_td"> <img src="<%=path %>/tableOn/images-table/icon3.gif"/></td>
    						<td><a class="update_button" href="${titles[4]}"  target="_blank"> ${titles[3]}
    						</a>
    						<input class="link_hide" value="<%=path %>/main/main.action?status=${titles[7]}&identity_id=${titles[2]}"/>
    						<font class="time_val">[${titles[5]}]</font></td>
    					</tr>
    				</c:if>
    			</c:forEach>
    			</table>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Title.status==1 || empty requestScope.result_Mes_Title.result_Val[4][0]}">
    			<p style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</p>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Title.status==2}">
    			<p  class="error" style="line-height: 50px;font-size: 20px;">加载错误！</p>
    		</c:when>
    	</c:choose>
    </div>
   	<div class="left_bg" style="background-image:url(<%=path %>/tableOn/img/leftbg1.jpg);width: 100%;height: 30%;
   							width: 100%;height: 25%;background-size: 100% 100%;border-radius: 6px;">
   	</div>
  </div>
  <div class="right">
    <!--h1><img  src="#">企业公告</h1-->
    <div class="model_title"><font class="right_title">企业公告</font>
    </div>
    <img style="width:95%;" src="<%=path %>/tableOn/images-table/menu_top_bg.jpg"/>
    <div style="width: 90%;height: 82%;margin-left: 14px;background-color:rgb(223,247,248);" >
    	<c:choose >
    		<c:when test="${requestScope.result_Mes_Title.status==0 && !empty requestScope.result_Mes_Title.result_Val[7]}">
    			<table class="right_table" cellspacing="6px" style="padding-left:6px;height:100%;">
    			<c:forEach var="titles" items="${requestScope.result_Mes_Title.result_Val[7]}" varStatus="self" step="1">
    				<c:if test="${self.index<=3}">
    					<tr>
    						<td class="right_img_td"> <img src="<%=path %>/tableOn/images-table/icon4.png"/></td>
    						<td><a class="update_button" href="${titles[4]}" target="_blank"><font class="right_title_val"> ${titles[3]} </font><font color="red">New</font></a>
    						<input class="link_hide" value="<%=path %>/main/main.action?status=${titles[7]}&identity_id=${titles[2]}"/>
    						</td>
   					 	</tr>
    				</c:if>
    			</c:forEach>
    			</table>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Title.status==1 || empty requestScope.result_Mes_Title.result_Val[7][0]}">
    			<p style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</p>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Title.status==2}">
    			<p class="error"  style="line-height: 50px;font-size: 20px;">加载错误！</p>
    		</c:when>
    	</c:choose>
    </div>
    <img style="width:90%;" src="<%=path %>/tableOn/images-table/menu_bottom.jpg">
  </div>
  <div class="left1">
  <div class="left2" height="236px" class="left_table">
    <div class="title_line">
    	<p  class="title_val">业务范围</p>
    	<div ><font class="left_more"><a href="<%=path %>/main/main.action?status=2" target="_blank">更多</a></font></div>
    </div>
    	<c:choose >
    		<c:when test="${requestScope.result_Mes_Title.status==0 && !empty requestScope.result_Mes_Title.result_Val[5]}">
    			<table cellspacing="5px">
    			<c:forEach var="titles" items="${requestScope.result_Mes_Title.result_Val[5]}" varStatus="self" step="1">
    				<c:if test="${self.index<=6}">
    					<tr>
    						<td class="img_td"> <img src="<%=path %>/tableOn/images-table/icon3.gif"/></td>
    						<td><a class="update_button" href="${titles[4] }" target="_blank">${titles[3] }
    						</a>
    						<input class="link_hide" value="<%=path %>/main/main.action?status=${titles[7]}&identity_id=${titles[2]}"/>
    						<font class="time_val">&gt; &gt; </font></td>
    					</tr>
    				</c:if>
    			</c:forEach>
    			</table>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Title.status==1 || empty requestScope.result_Mes_Title.result_Val[5][0]}">
    			<p  style="line-height: 50px;font-size: 20px;">暂无资源！</p>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Title.status==2}">
    			<p  class="error" style="line-height: 50px;font-size: 20px;">加载错误！</p>
    		</c:when>
    	</c:choose>
  </div>
   <div class="left3" height="236px" class="left_table">
    <div class="title_line">
    	<p  class="title_val">荣誉资信</p>
    	<div style="left: 86%;"><font class="left_more"><a href="<%=path %>/main/main.action?status=3" target="_blank">更多</a></font></div>
    </div>
    <c:choose >
    		<c:when test="${requestScope.result_Mes_Title.status==0 && !empty requestScope.result_Mes_Title.result_Val[6]}">
    			<table cellspacing="5px">
    			<c:forEach var="titles" items="${requestScope.result_Mes_Title.result_Val[6]}" varStatus="self" step="1">
    				<c:if test="${self.index<=6}">
    					<tr>
    						<td class="img_td"> <img src="<%=path %>/tableOn/images-table/icon3.gif"/></td>
    						<td><a class="update_button" href="${titles[4] }" target="_blank">${titles[3] }
    						</a>
    						<input class="link_hide" value="<%=path %>/main/main.action?status=${titles[7]}&identity_id=${titles[2]}"/>
    						<font class="time_val">&gt; &gt; </font></td>
    					</tr>
    				</c:if>
    			</c:forEach>
    			</table>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Title.status==1 || empty requestScope.result_Mes_Title.result_Val[6][0]}">
    			<p style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</p>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Title.status==2}">
    			<p  class="error" style="line-height: 50px;font-size: 20px;">加载错误！</p>
    		</c:when>
    </c:choose>
  </div>
  </div>
   <div class="right1">
    <div style="text-align: center;padding-top: 18px;"><font class="right_title">友情链接</font></div>
    	<div class="link_table">
    	<c:choose>
    		<c:when test="${requestScope.result_Mes_Title.status==0 && !empty requestScope.result_Mes_Title.result_Val[8]}">
    			<c:forEach var="titles" items="${requestScope.result_Mes_Title.result_Val[8]}" varStatus="self" step="1">
    				<c:if test="${self.index<=6}">
    						<a href="${titles[4] }" target="_blank" style="text-decoration: none;">${titles[3]}
    						</a><br/>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Title.status==1 || empty requestScope.result_Mes_Title.result_Val[8][0]}">
    			<p style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</p>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Title.status==2}">
    			<p  class="error" style="line-height: 50px;font-size: 20px;">加载错误！</p>
    		</c:when>
    	</c:choose>
  </div>
  </div>
  <div style="clear: both;"></div>
    <div id="demo">
    	<div id="roll_imgs" style="overflow:hidden;margin:0 5px 0 5px;height:166px;">
    	<c:choose>
    		<c:when test="${requestScope.result_Mes_Img.status==0 && !empty requestScope.result_Mes_Img.result_Val[2]}">
    			<table id="demo_roll">
    			<tr>
    			<td id="demo_self">
    			<table>
    			<tr>
    			<c:forEach var="imgs" items="${requestScope.result_Mes_Img.result_Val[2]}" varStatus="self" step="1">
    				<c:if test="${self.index>=0}">
    					<td class="roll_td" >
    						<div class="demo_img_val">
    							<a href="${imgs[4]}" target="_blank"><img style="width: 98%;height: 93%;padding: 3% 1% 3% 1%;" src="<%=path %>${imgs[3] }"></a>
    						</div>
    					</td>
    				</c:if>
    			</c:forEach>
    			</tr>
    			</table>
    			</td>
    			<td id="demo_copy"></td>
    			</tr>
    			</table>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Img.status==1 || empty requestScope.result_Mes_Img.result_Val[2][0]}">
    			<p style="line-height: 50px;font-size: 20px;">暂无资源！</p>
    		</c:when>
    		<c:when test="${requestScope.result_Mes_Img.status==2}">
    			<p class="error"  style="line-height: 50px;font-size: 20px;">加载错误！</p>
    		</c:when>
    	</c:choose>
    	</div>
    </div>
</div>
    </div>
</div>
<%@include file="include_jsp/foot.jsp" %>
</body>
<script type="text/javascript" src="<%=path %>/tableOn/js/main.js"></script>
<!-- JiaThis Button BEGIN -->
<script type="text/javascript" src="http://v3.jiathis.com/code/jiathis_r.js?type=left" charset="utf-8"></script>
<!-- JiaThis Button END -->
<%@include file="include_jsp/go_top.jsp" %>
</html>
