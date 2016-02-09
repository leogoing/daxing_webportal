$('.update_button').each(function(i){
	if($(this).attr('href')==null || $(this).attr('href').length<=6){
		$(this).attr('href',$(this).next('.link_hide').val());
	}
});
	//浮动定位
	//window.setInterval("roll('float',1600,1100)",5);
	var width=window.screen.width-18;
	$('.foot,.logo,.nav').css('width',width+'px');
	
//走马灯滚动方案
var demo=document.getElementById('roll_imgs');
var demo1=document.getElementById('demo_self');
var demo2=document.getElementById('demo_copy');
var speed=50
demo2.innerHTML=demo1.innerHTML//创建两个一样的内容条
function Marquee(){
if(demo2.offsetLeft-demo.scrollLeft<=0)//如果前面的内容条的可见宽度小于被滚动的消失的高度
demo.scrollLeft-=demo1.offsetWidth//则设置滚动量为后面的内容的可见高度
else{
demo.scrollLeft++//否则设置滚动量增一
}
}
var MyMar=setInterval(Marquee,speed)//设置定时器
demo.onmouseover=function() {clearInterval(MyMar)}//鼠标移入停止定时器
demo.onmouseout=function() {MyMar=setInterval(Marquee,speed)}//鼠标移出启动定时器
