<%@ page language="java" pageEncoding="gbk" contentType="text/html; charset=gbk" %>
<div class="nav">
    	<ul>
            <li><a href="<%=path %>/main/main.action?status=0">首页</a></li>
            <li><a href="<%=path %>/main/main.action?status=1">企业概况</a></li>
            <li><a href="<%=path %>/main/main.action?status=2">业务范围</a></li>
            <li><a href="<%=path %>/main/main.action?status=3">荣誉资信</a></li>
            <li><a href="<%=path %>/main/main.action?status=4">成果展示</a></li>
            <li><a href="<%=path %>/main/main.action?status=5">招贤纳士</a></li>
            <li><a href="<%=path %>/main/main.action?status=6">联系我们</a></li>
            <li style="width:200px;text-align: right;line-height: 15px;font-size: 13px;padding-top: 8px;" id="date"></li>
        </ul>
    </div>
    <script type="text/javascript">
    	//日期
		window.setInterval("$('#date').html(new Date().toLocaleString().replace(' ','<br/>')+' &nbsp;');",1000);
    </script>