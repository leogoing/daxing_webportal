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

import com.yihuan.dao.IndexDao;
import com.yihuan.entity.Index;

@Repository
public class IndexDaoImpl implements IndexDao{

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public int updateId(int id) {
		return	hibernateTemplate.bulkUpdate("update Index set identity_id="+id);
	}

	public Integer findMaxId() {
		List<Index> index=hibernateTemplate.find("from Index");
		return index.get(0).getIdentity_id();
	}
	
}
