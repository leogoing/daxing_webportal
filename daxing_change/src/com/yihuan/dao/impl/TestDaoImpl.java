package com.yihuan.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yihuan.dao.TestDao;
import com.yihuan.entity.Img;
import com.yihuan.entity.Test;


@Repository
public class TestDaoImpl implements TestDao{

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public List<Test> findAll() {
		
		return null;
	}

	public int update(){
		Img img=new Img();
		img.setId(3);
		img.setClassify(1);
		img.setIdentity_id(6);
		img.setImg_path("__000000___");
		img.setStatus(0);
		img.setQueue(2);
		img.setModify_time(new Date(110000000));
		try {
//			hibernateTemplate.update(img);
			hibernateTemplate.save(img);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
}
