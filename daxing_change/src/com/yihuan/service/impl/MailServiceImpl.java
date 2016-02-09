package com.yihuan.service.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yihuan.dao.MailDao;
import com.yihuan.entity.Mail;
import com.yihuan.service.MailService;
import com.yihuan.util.Result_Mes;
import com.yihuan.util.SendEmail;
import com.yihuan.util.Util;

@Service
public class MailServiceImpl implements MailService{

	@Resource
	private MailDao mailDao;
	
	@Resource
	private JavaMailSender mailSender;
	
	@Transactional(noRollbackFor=Exception.class)
	public Result_Mes addMail(Mail mail) {
		Result_Mes result_Mes=new Result_Mes();
		if(mail==null || mail.getName()==null || mail.getMessage_val()==null){
			result_Mes.setMessage("����Ϊ�գ�");
			result_Mes.setStatus(1);
			return result_Mes;
		}
		mail.setCreate_time(new Date(System.currentTimeMillis()));
		int index=mailDao.saveEmail(mail);
		SendEmail sendEmail=new SendEmail();
		int i=sendEmail.sendEmail(mail.toString(), mailSender);
		if(index==1 || i==0){
			result_Mes.setMessage("���Գɹ���");
			result_Mes.setStatus(0);
		}else if(index==1 && i==1){
			result_Mes.setMessage("����ʧ�ܣ�");
			result_Mes.setStatus(1);
		}
		return result_Mes;
	}

	@Transactional
	public Result_Mes deleteMails(String date) {
		if(date==null || "".equals(date)){
			return Util.setResult_Mes4Error("����Ϊ�գ�", 1);
		}
		int index=mailDao.emptyEmails(date);
		return Util.setResult_Mes4Error("�ѳɹ�ɾ��"+index+"��", 0);
	}

	@Transactional(readOnly=true)
	public Result_Mes findMails(String date) {
		if(date==null || "".equals(date)){
			return Util.setResult_Mes4Error("����Ϊ�գ�", 1);
		}
		List<Mail> mails=mailDao.findEmails(date);
		if(mails==null || mails.size()==0){
			return Util.setResult_Mes4Error("��ѯΪ�գ�", 2);
		}else{
			Result_Mes result_Mes=new Result_Mes();
			result_Mes.setMessage("��ѯ�ɹ���");
			result_Mes.setStatus(0);
			result_Mes.setResult_Val(mails);
			return result_Mes;
		}
	}
	
}
