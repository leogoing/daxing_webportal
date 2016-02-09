<%@ page language="java"  pageEncoding="gbk" contentType="text/html; charset=gbk" %>
<a id="go_top" href="javascript:;" title="·µ»Ø¶¥²¿" ></a>
<script type="text/javascript">
lastScrollY=0;
function go_top(){
var diffY;
if (document.documentElement && document.documentElement.scrollTop)
diffY = document.documentElement.scrollTop;
else if (document.body)
diffY = document.body.scrollTop;
else
{/*Netscape stuff*/}
percent=.1*(diffY-lastScrollY);
if(percent>0)percent=Math.ceil(percent);
else percent=Math.floor(percent);
lastScrollY=lastScrollY+percent;
if(lastScrollY<100){ $("#go_top").fadeOut('fast');} else {$("#go_top").fadeIn('fast');}
}
$("#go_top").click(function(){
$("html,body").animate({scrollTop: 0}, 200);
return false;
});
window.setInterval("go_top()",1);
</script>
<style>
#go_top{
	position:fixed;
    display: block;
    width: 58px;
    height: 58px;
    left: 90%;
	bottom: 14%;
    font-size: 14px;
    text-align: center;
    line-height: 1000px;
    color: #333;
    overflow: hidden;
    z-index: 10;
    background: #CBEBF5 url("<%=path %>/tableOn/images-table/gotop.png") no-repeat scroll 0px 0px;
}
</style>