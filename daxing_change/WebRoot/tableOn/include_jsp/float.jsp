<%@ page language="java"  pageEncoding="gbk" contentType="text/html; charset=gbk" %>
<style>
	/*方案二*/
	#float{
		/*position: absolute;*/
		bottom: 90px;
		background-image:url(<%=path %>/tableOn/img/lianxibg.jpg);
		width: 250px;
		height: 250px;
		background-size: 100% 100%;
		position:fixed;
		left:0px;
	}
	#close{
		z-index: 99;
		text-align:right;
	}
	
</style>
<div id="float" style="display:;">
	<div class="" id="close">
		<img alt="" src="<%=path %>/tableOn/img/closeCha.jpg">
	</div>
	<c:choose>
    	<c:when test="${requestScope.result_Mes_Text.status==0 && !empty requestScope.result_Mes_Text.result_Val[10]}">
    		<c:forEach var="text_Vals" items="${requestScope.result_Mes_Text.result_Val[10]}" varStatus="self" step="1">
    			<c:if test="${self.index<=0}">
    					<div style="font-size: 15px;padding: 5px 0px 10px 10%;text-align: center;">${text_Vals[4] }</div>
    					<div style="padding-left: 65px;">
    					${text_Vals[3] }
    					</div>
    			</c:if>
    		</c:forEach>
    	</c:when>
    	<c:when test="${requestScope.result_Mes_Text.status==1 || empty requestScope.result_Mes_Text.result_Val[10][0]}">
    		<div style="padding-left: 65px;"><p class="error"  style="line-height: 50px;font-size: 20px;">查找的内容为空！</p></div>
    	</c:when>
    	<c:when test="${requestScope.result_Mes_Text.status==2}">
    		<div style="padding-left: 65px;"><p  class="error" style="line-height: 50px;font-size: 20px;">加载错误！</p></div>
    	</c:when>
    </c:choose>
</div>
<script type="text/javascript" src="<%=path %>/tableOn/js/float.js"></script>