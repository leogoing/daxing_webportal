package com.yihuan.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yihuan.dao.AdminDao;
import com.yihuan.entity.Admin;
import com.yihuan.util.BaseLog;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public List<Admin> findAdmin(Object obj) {
		String hql="from Admin as a where ";
		if(obj instanceof Integer){
			Integer id=(Integer)obj;
			hql+="a.id="+id;
		}else if(obj instanceof String){
			String username=(String)obj;
			hql+="a.username='"+username+"'";
		}
		List<Admin> admin=hibernateTemplate.find(hql);
		return admin;
	}

	public int resetAdmin(Integer id, String username, String password) {
		List<Admin> admins=findAdmin(id);
		BaseLog.logger.debug("≤È—Ø”√ªß£∫"+admins);
		if(admins==null || admins.size()==0){
			return 1;
		}
		if(admins!=null && admins.get(0).getPower()!=0){
			hibernateTemplate.update(admins.get(0));
		}
		return 0;
	}

}
