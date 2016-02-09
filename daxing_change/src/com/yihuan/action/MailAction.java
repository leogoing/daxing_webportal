package com.yihuan.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.yihuan.entity.Mail;
import com.yihuan.service.MailService;
import com.yihuan.util.BaseLog;
import com.yihuan.util.Result_Mes;
import com.yihuan.util.Util;

@Controller
@Scope("prototype")
public class MailAction extends ActionSupport{
	
	@Resource
	private MailService mailService;
	
	private Mail mail;
	
	private Result_Mes result_Mes;
	
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Result_Mes getResult_Mes() {
		return result_Mes;
	}

	public void setResult_Mes(Result_Mes resultMes) {
		result_Mes = resultMes;
	}

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}
	
	public String send(){
		try {
			result_Mes=mailService.addMail(mail);
		} catch (Exception e) {
			Util.log2Error("Ã·Ωª¡Ù—‘“Ï≥££∫", e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String find(){
		BaseLog.logger.debug("date:"+date);
		result_Mes=mailService.findMails(date);
		return SUCCESS;
	}
	
	public String delete(){
		result_Mes=mailService.deleteMails(date);
		return SUCCESS;
	}
	
}
