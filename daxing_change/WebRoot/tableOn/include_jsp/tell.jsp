<%@ page language="java" pageEncoding="gbk" contentType="text/html; charset=gbk" %>
<style>
	.down_text{color: rgb(29, 29, 26);}.cut_line{height: 10px;}.tell_tubiao{width: 60px;height: 50px;}.td_2{background-color:rgb(235, 235, 247);font-size: 20px;font-weight: bold;}
</style>
<div id="tell" >
		<div class="title_line">
    		<p  style="line-height: 42px;width: 120px;background-image:url(<%=path %>/tableOn//images-table/d_r_bg.gif);background-size: 100% 100%;">联系我们</p>
    	</div>
    	<table cellspacing="0px" style="padding:10px;width: 280px;">
    		<tr>
    			<td><img class="tell_tubiao" src="link-img/tell1.png"/></td>
    			<td class="td_2"><p class="down_text">010-3845672</p></td>
    		</tr>
    		<tr class="cut_line"></tr>
    		<tr>
    			<td><img class="tell_tubiao"  src="link-img/tell2.png"/></td>
    			<td class="td_2"><p class="down_text">bjzhcch@163.com</p></td>
    		</tr>
    		<tr class="cut_line"></tr>
    		<tr>
    			<td><img  class="tell_tubiao" src="link-img/tell3.png"/></td>
    			<td class="td_2"><p class="down_text">010-69260033</p></td>
    		</tr>
    		<tr class="cut_line"></tr>
    		<tr>
    			<td><img  class="tell_tubiao" src="link-img/tell4.png"/></td>
    			<td class="td_2"><p style="font-size:14px;line-height: 25px;" class="down_text">北京市大兴区黄村镇三合<br>北巷5号院2号楼</p></td>
    		</tr>
    		<tr class="cut_line"></tr>
    		
    		<c:if  test="${requestScope.result_Mes_Img.status==0 && !empty requestScope.result_Mes_Img.result_Val[4]}">
    			<tr>
    				<td colspan="2" style="font-size: 14px;text-align: center;color: rgb(155, 155, 131);"><img style="margin: 20 50 5 50;" width="150px" height="140px" src="<%=path %>${requestScope.result_Mes_Img.result_Val[4][0][2]}"/><br/>扫描二维码<br/>关注公众微信号</td>
    			</tr>
    		</c:if>
    	</table>
	</div>