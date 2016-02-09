<%@ page language="java" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<body>
		<img width="130px" height="140px" src="<%=path %>/tableOn/img/error.png"/><strong style="color:red;font-size: 30px;">错误页面：${requestScope.result_Mes.message },3秒后自动返回...</strong>
		<p>&lt;&lt;<a href="javascript:;" onclick="history.back(-1);">返回上一页</a></p>
	</body>
	<script type="text/javascript">
		window.setTimeout("history.back(-1);",3500);
	</script>
</html>