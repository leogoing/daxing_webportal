<%@ page language="java" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<body >
		<img  width="130px" height="140px" src="<%=path %>/tableOn/img/success.png"><strong style="font-size: 26px;">�ɹ�ҳ�棺${requestScope.result_Mes.message},3����Զ�����...</strong>
		<p>&lt;&lt;<a href="javascript:;" onclick="history.back(-1);">������һҳ</a></p>
	</body>
	<script type="text/javascript">
		window.setTimeout("history.back(-1);",3500);
	</script>
</html>