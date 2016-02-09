<%@ page language="java"  pageEncoding="gbk" import="com.yihuan.util.*,java.util.*,java.lang.*" contentType="text/html; charset=gbk" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 	<style>
		/* table切换样式  */

		/* 标题格样式 */
		#table_change td{
			font-size: 12px;
			color: #000;
			line-height: 25px;
			background-image:url('images-table/index_37.png');
			text-align:center;
			width:129px;
		}
		#table_change a{
			font-size:20px;
			font-weight: bold;
			color: rgb(86, 89, 146);
		}
		/* 内容样式 */
		#div_val{
			border:1px solid #D8D6D7;
			text-align:center;
			OVERFLOW-Y: auto;  OVERFLOW-X: auto ;
  			height: 91%;
  			width:99.8%;
  			border-radius: 5px;
		}
		/* 切换内容div样式 */
		#div_val div,.pro_text_val{
			display:none;
		}
		#change_body{
			overflow: hidden;width: 815px;
		}
	</style>
	
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<div id="change_body">
      <table id="table_change"  border="0" cellpadding="0" cellspacing="3" width="100%" height="50px">
        <tr>
          <td id='menu_0'  style='cursor:hand; ' ><a>工程测量</a></td>
          <td id='menu_1'  style='cursor:hand; ' ><a>房产测量</a></td>
          <td id='menu_2'  style='cursor:hand; ' ><a>地理信息系统</a></td>
         </tr>
      </table>
      <div id="div_val" >
      
      	<div id="val_1">
      	<c:choose>
    		<c:when test="${requestScope.result_Mes_IT.status==0 && !empty requestScope.result_Mes_IT.result_Val[1]}">
    			<c:forEach var="img_texts" items="${requestScope.result_Mes_IT.result_Val[1]}" varStatus="self" step="1">
    				<c:if test="${self.index<=16}">
    					<table  id="gps${img_texts.identity_id}" width="96%" border="0" align="center" cellpadding="0" cellspacing="0" style="border-bottom:1px #ccc dotted; margin-top:8px;">
            			  	<tr>
               				 	<td width="15%" height="88" align="center"><a class="project_link" href="javascript:;"><img src="<%=path %>${img_texts.img.img_path}"  border="0" width="93" height="69"></a></td>
           				     	<td width="85%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="2">
            		     	<tr>
            		        	<td height="20"><strong class="pro_title">${img_texts.custom_title}</strong></td>
              			 	</tr>
                  			<tr>
                    			<td class="pro_text" height="49" valign="top" style="line-height:24px;">
                    			${img_texts.text_val}</td>
                  			</tr>
                				</table></td>
              				</tr>
            			</table>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${empty requestScope.result_Mes_IT.result_Val[1][0].classify}">
    			<li style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</li>
    		</c:when>
    	</c:choose>

      </div>
      <div id="val_2">
      	<c:choose>
    		<c:when test="${requestScope.result_Mes_IT.status==0 && !empty requestScope.result_Mes_IT.result_Val[2]}">
    			<c:forEach var="img_texts" items="${requestScope.result_Mes_IT.result_Val[2]}" varStatus="self" step="1">
    				<c:if test="${self.index<=16}">
    					<table id="gps${img_texts.identity_id}"  width="96%" border="0" align="center" cellpadding="0" cellspacing="0" style="border-bottom:1px #ccc dotted; margin-top:8px;">
            			  	<tr>
               				 	<td width="15%" height="88" align="center"><a class="project_link" href="javascript:;"><img src="<%=path %>${img_texts.img.img_path}"  border="0" width="93" height="69"></a></td>
           				     	<td width="85%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="2">
            		     	<tr>
            		        	<td height="20"><strong class="pro_title">${img_texts.custom_title}</strong></td>
              			 	</tr>
                  			<tr>
                    			<td class="pro_text"  height="49" valign="top" style="line-height:24px;">
                    			${img_texts.text_val}</td>
                  			</tr>
                				</table></td>
              				</tr>
            			</table>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${empty requestScope.result_Mes_IT.result_Val[2][0].classify}">
    			<li style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</li>
    		</c:when>
    	</c:choose>
		</div>
		
      	<div id="val_3">
      	<c:choose>
    		<c:when test="${requestScope.result_Mes_IT.status==0 && !empty requestScope.result_Mes_IT.result_Val[3]}">
    			<c:forEach var="img_texts" items="${requestScope.result_Mes_IT.result_Val[3]}" varStatus="self" step="1">
    				<c:if test="${self.index<=16}">
    					<table  id="gps${img_texts.identity_id}" width="96%" border="0" align="center" cellpadding="0" cellspacing="0" style="border-bottom:1px #ccc dotted; margin-top:8px;">
            			  	<tr>
               				 	<td width="15%" height="88" align="center"><a class="project_link" href="javascript:;"><img src="<%=path %>${img_texts.img.img_path}"  border="0" width="93" height="69"></a></td>
           				     	<td width="85%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="2">
            		     	<tr>
            		        	<td height="20"><strong class="pro_title">${img_texts.custom_title}</strong></td>
              			 	</tr>
                  			<tr>
                    			<td class="pro_text"  height="49" valign="top" style="line-height:24px;">
                    			${img_texts.text_val}</td>
                  			</tr>
                				</table></td>
              				</tr>
            			</table>
    				</c:if>
    			</c:forEach>
    		</c:when>
    		<c:when test="${empty requestScope.result_Mes_IT.result_Val[3][0].classify}">
    			<li style="line-height: 50px;font-size: 20px;color: rgb(163, 163, 140);font-weight: bold;">暂无内容！</li>
    		</c:when>
    	</c:choose>
      	</div>
      	
      </div>
      <script type="text/javascript">
		$('#table_change td').mouseover(function(){
			$(this).css("background-image","url('images-table/index_39.png')").css("background-size","269px 45px").siblings()
				.css("background-image","url('images-table/index_37.png')").css("background-size","270px 43px");
			$($('#div_val div').get($(this).index())).show().siblings().hide();
		});
		$('#table_change td:eq(0)').mouseover();
	  </script>
	  
	</div>
	  