package com.yihuan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yihuan.dao.MailDao;
import com.yihuan.entity.Mail;
import com.yihuan.util.Util;

@Repository
public class MailDaoImpl implements MailDao{

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public int emptyEmails(String date) {
		final String hql="delete from Mail as m where m.create_time <= '"+date+"'";
		Integer index=hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query=session.createQuery(hql);
				return query.executeUpdate();
			}
		});
		return index==null?0:index;
	}

	public List<Mail> findEmails(String date) {
		List<Mail> mails=hibernateTemplate.find("from Mail as m where m.create_time <= '"+date+"' order by m.create_time");
		return mails;
	}

	public int saveEmail(Mail mail) {
		try {
			hibernateTemplate.save(mail);
		} catch (Exception e) {
			Util.log2Error("插入实体类发生异常：",e);
			return 0;
		}
		return 1;
	}

}
