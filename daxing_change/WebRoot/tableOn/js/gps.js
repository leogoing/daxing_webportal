var width=window.screen.width-18;
$('.foot,.logo,.nav').css('width',width+'px');
//定位滚动条滚动
//获取纵坐标
function getTop(e){
 	    var offset=e.offsetTop;
 	    if(e.offsetParent!=null){
 	        offset+=getTop(e.offsetParent);
 	    }
 	    return offset;
	} 

var yPos=document.body.clientHeight;//获得浏览器窗口高度
var lastHeight=getTop(documt)-yPos/5;
var one_step=0;
var time_start_index;
function start(){
	one_step+=10;
	//根据不同浏览器算滚动条位置
	var return_step=(document.documentElement.scrollTop=one_step);
	if(document.documentElement.scrollTop==0){
		return_step=(document.body.scrollTop=one_step);
	}
	if(return_step>=lastHeight || return_step>=(document.body.scrollHeight-document.body.clientHeight)){
		clearInterval(time_start_index);
		return ;
	}
//	start();
}
function time_start(){
	time_start_index=window.setInterval(start,2);
}
if(documt!=null){
	window.setTimeout(time_start,500);
}

