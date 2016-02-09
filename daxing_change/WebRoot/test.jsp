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
    <form action="ajax/addText_Val.action" id="form" > 
    	classify<input name="text_Val.classify" type="text" />
    	ide<input name="text_Val.identity_id" type="text" />
    	custom_title<input name="text_Val.custom_title" type="text" />
    	queue<input name="text_Val.queue" type="text" />
    	status<input name="text_Val.status" type="text" />
    	 <textarea name="text_Val.content_text" wrap="physical">输入文本。。。</textarea>
    	 img<input name="img_Text_Val.img.classify" type="text" />
    	 ide<input name="img_Text_Val.img.identity_id" type="text" />
    	 queue<input name="img_Text_Val.img.queue" type="text" />
    	 status<input name="img_Text_Val.img.status" type="text" />
    	 tu<input name="img_Text_Val.img.img_path" type="text" />
    	<input value="提交" type="submit" />
    </form>
    
   
  </body>
</html>