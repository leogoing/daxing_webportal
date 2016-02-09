package com.yihuan.service;

import com.yihuan.entity.Mail;
import com.yihuan.util.Result_Mes;

public interface MailService {
	public Result_Mes addMail(Mail mail);
	public Result_Mes findMails(String date);
	public Result_Mes deleteMails(String date);
}
