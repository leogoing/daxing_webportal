package com.yihuan.dao.impl;

import java.io.Serializable;
import java.sql.Date;
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

import com.yihuan.dao.Text_ValDao;
import com.yihuan.entity.Text_Val;
import com.yihuan.util.BaseLog;
import com.yihuan.util.Util;

@Repository
public class Text_ValDaoImpl implements Text_ValDao{

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public List<Object[]> findText_ValByStatus(int stat,Integer beginI,Integer pageS) {
		if(stat==0){
			final int beginIndex=beginI;
			final int pageSize=pageS;
			final int status=stat;
			List<Object[]> list = (List<Object[]>)hibernateTemplate.execute(
					new HibernateCallback(){
						public Object doInHibernate(Session session) throws HibernateException, SQLException {
							String hql = "select t.classify,t.queue,t.identity_id,t.content_text,t.custom_title,t.id from Text_Val as t where t.status="
												+status+"order by t.classify asc,t.queue desc";
							Query query=session.createQuery(hql);
							
							//设置分页参数
							query.setFirstResult(beginIndex);
							query.setMaxResults(pageSize);
							return query.list();
						}
						
					});
			return list;
		}
		List<Object[]> text_Vals=hibernateTemplate.find(
				"select t.classify,t.queue,t.identity_id,t.content_text,t.custom_title,t.id from Text_Val as t where t.status="+stat
				+" order by t.classify asc,t.queue desc");
		return text_Vals;
	}

	public int saveText_Val(Text_Val text_Val) {
		try {
			hibernateTemplate.save(text_Val);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public List<Text_Val> findText_ValByClassify(int classify) {
		List<Text_Val> text_vals=hibernateTemplate.find("from Text_Val as t where t.classify like '"+classify+"%' and t.status!=-1 order by t.classify asc,t.queue desc");
		return text_vals;
	}

	public int deleteText_Vals(Integer status, List<Integer> ids) {
		final String hql;
		final List<Integer> id=ids;
		if(status==null){
			hql="delete from Text_Val as t where t.id in(";
		}else{
			hql="update Text_Val as t set t.status="+status+" where t.id in(";
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
		System.out.println(h);
				if(!hql.equals(h)){
					h+=")";
					Query query=session.createQuery(h);
					sum+=query.executeUpdate();
				}
				return sum;
			}
		});
	}

	public List<Text_Val> findAll() {
		List<Text_Val> text_Vals=hibernateTemplate.find("from Text_Val as t order by t.status desc,t.classify asc");
		return text_Vals;
	}

	public Object saveUpdateText_Vals(int t, List<Text_Val> it) {
		final List<Text_Val> text_Vals=it;
		final boolean type=(t==1);
		return hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				int index=0;
				List<Integer> arr=new ArrayList<Integer>();
				for(int i=0;i<text_Vals.size();i++){
					if(type){
						System.out.println(text_Vals.get(0));
						Serializable id=session.save(text_Vals.get(i));
						arr.add((Integer)id);
						}else{
							Query query=session.createQuery("select t.create_time from Text_Val as t where t.id="+text_Vals.get(i).getId());
							List<Date> time=query.list();
							text_Vals.get(i).setCreate_time(time.get(0));
							session.update(text_Vals.get(i));
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
				index+=text_Vals.size()%5;
				return type?arr:index;
			}
			
		});
	}
	
	
}
