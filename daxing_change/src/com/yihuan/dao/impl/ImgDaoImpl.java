package com.yihuan.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yihuan.dao.ImgDao;
import com.yihuan.entity.Img;
import com.yihuan.util.Util;

@Repository
public class ImgDaoImpl implements ImgDao{
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public List<Object[]> findImgsByStatus(int status) {
		List<Object[]> imgs=hibernateTemplate.find(
				"select i.classify,i.queue,i.identity_id,i.img_path,i.url,i.id,i.page_num from Img as i where i.status="+status
				+"order by i.classify asc,i.queue desc");
		return imgs;
	}
	
	public List<Object[]> findByClassify(int classify){
		List<Object[]> imgs=hibernateTemplate.find(
				"select i.classify,i.identity_id,i.img_path from Img as i where i.classify="+classify+" and i.status!=-1 order by i.classify asc,i.queue desc");
		return imgs;
	}

	public int deleteImgs(Integer status, List<Integer> ids) {
		final String hql;
		final List<Integer> id=ids;
		if(status==null){
			hql="delete from Img as i where i.id in(";
		}else{
			hql="update Img as i set i.status="+status+" where i.id in(";
		}
		return hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String h=hql;
				boolean flog=true;
				int sum=0;
				for(int i=0;i<id.size();i++){
					if(flog){
						h+=id.get(i);
					}else{
						h+=","+id.get(i);
					}
					flog=false;
					if(i!=0 && i%5==0){
						h+=")";
						Query query=session.createQuery(h);
						try {
							sum+=query.executeUpdate();
						} catch (Exception e) {
							Util.log2Error("执行批量修改发生异常：",e);
							return sum;
						}
						h=hql;
						flog=true;
					}
				}
				if(!hql.equals(h)){
					h+=")";
					Query query=session.createQuery(h);
					sum+=query.executeUpdate();
				}
				return sum;
			}
		});
	}

	public List<Img> findAll() {
		List<Img> imgs=hibernateTemplate.find("from Img as i order by i.status desc,i.classify asc");
		return imgs;
	}

	public Object saveUpdateImgs(int t, List<Img> it) {
		final List<Img> imgs=it;
		final boolean type=(t==1);
		return hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				int index=0;
				List<Integer> arr=new ArrayList<Integer>();
				for(int i=0;i<imgs.size();i++){
					if(type){
						Serializable id=session.save(imgs.get(i));
						arr.add((Integer)id);
						}else{
							session.update(imgs.get(i));
					}
					if(i!=0 && i%5==0){
						try {
							session.flush();
							index=i;
						} catch (Exception e) {
							Util.log2Error("清理session缓存发生异常：",e);
							return type?arr:index;
						}
					}
				}
				session.flush();
				index+=imgs.size()%5;
				return type?arr:index;
			}
			
		});
	}

	public List<String> findImg_paths(List<Integer> id) {
		final List<Integer> ids=id;
		final String hql="select i.img_path from Img as i where i.id=";
		return hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<String> img_paths=new ArrayList<String>();
				for(int i=0;i<ids.size();i++){
					Query query=session.createQuery(hql+ids.get(i));
					img_paths.add((String)query.uniqueResult());
				}
				return img_paths;
			}
			
		});
	}
	
}
