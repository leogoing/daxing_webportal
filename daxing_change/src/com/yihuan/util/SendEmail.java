package com.yihuan.util;


import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class SendEmail {
	
	
	public int sendEmail(String message,JavaMailSender mailSender){
		Result_Mes result_Mes=new Result_Mes();
         SimpleMailMessage mail = new SimpleMailMessage();    
         mail.setFrom("m13161994552@163.com");    
         mail.setTo("liwang1994@sina.cn");    
         mail.setSubject(" ��ҵ����  ");    
         mail.setText(message);    
         try {
        	 mailSender.send(mail);
		} catch (Exception e) {
			Util.log2Error("�����ʼ��쳣��", e);
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");    
        JavaMailSender mailSender= (JavaMailSender) context.getBean("mailSender");
        SimpleMailMessage mail = new SimpleMailMessage();    
        mail.setFrom("m13161994552@163.com");    
        mail.setTo("81391276@qq.com");    
        mail.setSubject(" ����spring Mail");    
        mail.setText("hello---java");    
        mailSender.send(mail);  
	}
	
}
