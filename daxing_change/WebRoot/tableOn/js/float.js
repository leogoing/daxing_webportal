//ͨ��absolute�����ڴ����ڹ̶�λ�÷���
function roll(id,x,y){
	var floatDiv=document.getElementById(id);
	var xPos=document.body.clientWidth;//�����������ڿ��
	var yPos=document.body.clientHeight;//�����������ڸ߶�
	var rollTop=document.documentElement.scrollTop==0?document.body.scrollTop:document.documentElement.scrollTop;//���ݲ�ͬ������������λ��
		//scrollTopҳ�����ù������������·�ʱ�������ڹ������Ϸ���ҳ��ĸ߶�
	var rollLeft=document.documentElement.scrollLeft==0?document.body.scrollLeft:document.documentElement.scrollLeft;
	var relativeH=floatDiv.offsetHeight;//���floatDiv�Ŀɼ��߶�
	var relativeW=floatDiv.offsetWidth;//���floatDiv�Ŀɼ����
	var newH=(yPos-parseInt(floatDiv.offsetHeight)-900+rollTop);//���ݴ�ֱ��������λ������floatDiv�ĸ߶�
	var newW=(xPos-parseInt(floatDiv.offsetWidth)-500+rollLeft);//���ݺ����������λ������floatDiv�Ŀ��
	
	console.log($(floatDiv).css('top')+","+parseInt($(floatDiv).css('left')));
	
	if(yPos){
	}
		$(floatDiv).css('top',newH+"px");
		$(floatDiv).css('left',newW+"px");
}


//�ڴ������Ĵ�Ʈ������
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
//Ư��
	floatFly();
	$(function(){
		$('#close img').click(function(){$('#float').remove();});
	});
