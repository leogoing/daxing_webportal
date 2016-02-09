package com.yihuan.dao;
import java.sql.Date;
import java.util.List;

import com.yihuan.entity.Mail;
public interface MailDao {
	public int saveEmail(Mail mail);
	public List<Mail> findEmails(String date);
	public int emptyEmails(String date);
}
