<%@ page language="java" pageEncoding="gbk" contentType="text/html; charset=gbk" %>
<div class="nav">
    	<ul>
            <li><a href="<%=path %>/main/main.action?status=0">��ҳ</a></li>
            <li><a href="<%=path %>/main/main.action?status=1">��ҵ�ſ�</a></li>
            <li><a href="<%=path %>/main/main.action?status=2">ҵ��Χ</a></li>
            <li><a href="<%=path %>/main/main.action?status=3">��������</a></li>
            <li><a href="<%=path %>/main/main.action?status=4">�ɹ�չʾ</a></li>
            <li><a href="<%=path %>/main/main.action?status=5">������ʿ</a></li>
            <li><a href="<%=path %>/main/main.action?status=6">��ϵ����</a></li>
            <li style="width:200px;text-align: right;line-height: 15px;font-size: 13px;padding-top: 8px;" id="date"></li>
        </ul>
    </div>
    <script type="text/javascript">
    	//����
		window.setInterval("$('#date').html(new Date().toLocaleString().replace(' ','<br/>')+' &nbsp;');",1000);
    </script>