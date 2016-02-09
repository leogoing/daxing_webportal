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
	.inner{
      	padding: 30px 40px 40px 20px;
      }
      .title_val{
      	font-size:32px;
      	font-weight:bold;
      }
       .left{float:right;width:900px;}
		#inputBox .input{
			width: 370px;background-color: #FBFBFB;
			border: 1px solid #DDD;
			height: 25px;
		}
		.submit-input{
       		color: rgb(141, 120, 104);
			background-color: rgb(165, 209, 223);
			border-color: rgb(243, 252, 249);
			height: 30px;
			width: 110px;
			margin-top: 20px;
			border-radius: 8px;
		}
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
    <img  src="img/titlecopy7.jpg" style="width: 100%;height: 100%;">
    </div>
  	</div>
  
  	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
    	$(function(){
    		$('.nav ul li a:eq(6)').css("color","#736E12").css("background-color","#F7F9F4");
    		var width=window.screen.width-18;
			$('.foot,.logo,.nav').css('width',width+'px');
    	});
    	function to_submit(){
    		if(!$('#content').val() || !$('.input:eq(0)')){
    		console.log('error');
    		alert('请输入留言信息！');
				return false;
			}
			$('#myform').submit();
    	}
	</script>
	
  <%@include file="include_jsp/tell.jsp"%>
  <div class="left" >
 	<div class="inner">
    <p class="title_val" style="line-height:40px;">查看地图</p>
    <div class="cut_bg"></div>
    <div style="padding: 30px 0px 0px 135px;font-family:arial;">
    <div id="cs">
        </div>
        <div id="map">
        	<iframe width="604" height="720" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://j.map.baidu.com/mKrd7"></iframe>
        </div>
        <form action="<%=path %>/main/sendMail.action" method="post" name="myform" id="myform" class="bor">
        <p style="font-size: 22px;font-weight: bold;">留言与建议</p>
        <table id="inputBox">
            <tr style="height: 30px;"><td style="text-align: left;color: rgb(19, 19, 16);">姓名：</td><td><input class="input" name="mail.name" id="username" size="20" maxlength="20" type="text">*</td></tr>
            <tr style="height: 30px;"><td style="text-align: left;color: rgb(19, 19, 16);">QQ号：</td><td><input class="input" name="mail.qq_num" id="qq" size="20" maxlength="20" type="text"></td></tr>
            <tr style="height: 30px;"><td style="text-align: left;color: rgb(19, 19, 16);">E-mail：</td><td><input class="input" name="mail.email" id="E-mail" size="20" maxlength="20" type="text"></td></tr>
            <tr style="height: 30px;"><td style="text-align: left;color: rgb(19, 19, 16);">联系电话：</td><td><input class="input" name="mail.phone" id="telephone" size="20" maxlength="20" type="text">*</td></tr>
            <tr ><td style="text-align: left;color:rgb(19, 19, 16);">留言建议：</td><td><textarea name="mail.message_val" id="content" rows="5" cols="50" style="background-color: #FBFBFB;border: 1px solid #DDD"></textarea>*</td></tr>
            <tr style="height: 30px;"><td style="text-align: left;"><input name="mail.id" value="" type="hidden"></td><td><input class="submit-input" onclick="to_submit();" value=" 提交留言 " type="button"/></td></tr>
        </table>
    </form>
    </div>
    </div>
  </div>
  <div style="clear:both"></div>
</div>
</div>
</div>
<%@include file="include_jsp/foot.jsp" %>
</body>
<!-- JiaThis Button BEGIN -->
<script type="text/javascript" src="http://v3.jiathis.com/code/jiathis_r.js?type=left" charset="utf-8"></script>
<!-- JiaThis Button END -->
<%@include file="include_jsp/go_top.jsp" %>
</html>
