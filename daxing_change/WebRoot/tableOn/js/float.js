//通过absolute属性在窗口内固定位置方案
function roll(id,x,y){
	var floatDiv=document.getElementById(id);
	var xPos=document.body.clientWidth;//获得浏览器窗口宽度
	var yPos=document.body.clientHeight;//获得浏览器窗口高度
	var rollTop=document.documentElement.scrollTop==0?document.body.scrollTop:document.documentElement.scrollTop;//根据不同浏览器算滚动条位置
		//scrollTop页面利用滚动条滚动到下方时，隐藏在滚动条上方的页面的高度
	var rollLeft=document.documentElement.scrollLeft==0?document.body.scrollLeft:document.documentElement.scrollLeft;
	var relativeH=floatDiv.offsetHeight;//获得floatDiv的可见高度
	var relativeW=floatDiv.offsetWidth;//获得floatDiv的可见宽度
	var newH=(yPos-parseInt(floatDiv.offsetHeight)-900+rollTop);//根据垂直滚动条的位置设置floatDiv的高度
	var newW=(xPos-parseInt(floatDiv.offsetWidth)-500+rollLeft);//根据横向滚动条的位置设置floatDiv的宽度
	
	console.log($(floatDiv).css('top')+","+parseInt($(floatDiv).css('left')));
	
	if(yPos){
	}
		$(floatDiv).css('top',newH+"px");
		$(floatDiv).css('left',newW+"px");
}


//在窗口内四处飘浮方案
	var indexW=2;
	var indexH=1;
	var floatfly=document.getElementById('float');
	floatfly.style.left='0px';
	floatfly.style.top='190px';
	var indexTime;
function floatFly(){
	indexTime=window.setInterval(step,30);
	floatfly.onmouseover=function() {clearInterval(indexTime)};
	floatfly.onmouseout=function() {indexTime=setInterval(step,30)};
}
function step(){
	if(parseInt(floatfly.style.left)+$(floatfly).width()>=document.body.offsetWidth){
		indexW=-4;
	}
	
	if(parseInt(floatfly.style.left)<=0){
		indexW=4;
	}
	if(parseInt(floatfly.style.top)+$(floatfly).height()>=window.screen.availHeight-80){
		indexH=-3;
	}
	if(parseInt(floatfly.style.top)<=0){
		indexH=3;
	}
	floatfly.style.left=(parseInt(floatfly.style.left)+indexW)+'px';
	floatfly.style.top=(parseInt(floatfly.style.top)+indexH)+'px';
}
//漂移
	floatFly();
	$(function(){
		$('#close img').click(function(){$('#float').remove();});
	});
