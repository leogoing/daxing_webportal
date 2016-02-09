<%@ page language="java" import="java.util.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="ajax/addMail.action" id="form" > 
    	name<input name="mail.name" type="text" />
    	qq<input name="mail.qq_num" type="text" />
    	email<input name="mail.email" type="text" />
    	phone<input name="mail.phone" type="text" />
    	 <textarea name="mail.message_val" wrap="physical">输入文本。。。</textarea>
    	 job<input name="mail.job" type="text" />
    	<input value="提交" type="submit" />
    </form>
   
  </body>
</html>