$('.update_button').each(function(i){
	if($(this).attr('href')==null || $(this).attr('href').length<=6){
		$(this).attr('href',$(this).next('.link_hide').val());
	}
});
	//������λ
	//window.setInterval("roll('float',1600,1100)",5);
	var width=window.screen.width-18;
	$('.foot,.logo,.nav').css('width',width+'px');
	
//����ƹ�������
var demo=document.getElementById('roll_imgs');
var demo1=document.getElementById('demo_self');
var demo2=document.getElementById('demo_copy');
var speed=50
demo2.innerHTML=demo1.innerHTML//��������һ����������
function Marquee(){
if(demo2.offsetLeft-demo.scrollLeft<=0)//���ǰ����������Ŀɼ����С�ڱ���������ʧ�ĸ߶�
demo.scrollLeft-=demo1.offsetWidth//�����ù�����Ϊ��������ݵĿɼ��߶�
else{
demo.scrollLeft++//�������ù�������һ
}
}
var MyMar=setInterval(Marquee,speed)//���ö�ʱ��
demo.onmouseover=function() {clearInterval(MyMar)}//�������ֹͣ��ʱ��
demo.onmouseout=function() {MyMar=setInterval(Marquee,speed)}//����Ƴ�������ʱ��
