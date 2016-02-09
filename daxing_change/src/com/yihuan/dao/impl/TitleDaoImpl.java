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

import com.yihuan.dao.TitleDao;
import com.yihuan.entity.Title;
import com.yihuan.util.BaseLog;
import com.yihuan.util.Util;

@Repository
public class TitleDaoImpl implements TitleDao{

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public List<Object[]> findTitlesByStatus(int status) {
		String hql=null;
		if(status==0){
			hql="select t.classify,t.queue,t.identity_id,t.title_val,t.url,t.modify_time,t.id,t.page_num from Title as t where t.status="+status;
		}
		List<Object[]> titles=hibernateTemplate.find(hql+" order by t.classify asc,t.queue desc");
		return titles;
	}
	
	public List<Title> findTitlesByClassify(int classify){
		String hql="from Title as t where t.classify like '"+classify+"%'";
		List<Title> title=hibernateTemplate.find(hql+" and t.status!=-1 order by t.classify,t.queue desc");
		return title;
	}
	
	public List<Title> findAll(){
		List<Title> titles=hibernateTemplate.find("from Title as t order by t.status desc,t.classify asc");
		return titles;
	}
	
	public Object saveUpdateTitles(int t,List<Title> ts){
		final List<Title> titles=ts;
		final boolean type=(t==1);
		return hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				int index=0;
				List<Integer> arr=new ArrayList<Integer>();
				for(int i=0;i<titles.size();i++){
					if(type){
						System.out.println(titles.get(0));
						Serializable id=session.save(titles.get(i));
						arr.add((Integer)id);
					}else{
						session.update(titles.get(i));
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
				index+=titles.size()%5;
				return type?arr:index;
			}
			
		});
	}
	
	public int deleteTitles(Integer status,List<Integer> ids){
		final String hql;
		final List<Integer> id=ids;
		if(status==null){
			hql="delete from Title as t where t.id in(";
		}else{
			hql="update Title as t set t.status="+status+" where t.id in(";
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
	
}
