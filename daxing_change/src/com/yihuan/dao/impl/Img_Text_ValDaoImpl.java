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

import com.yihuan.dao.Img_Text_ValDao;
import com.yihuan.entity.Img_Text_Val;
import com.yihuan.util.BaseLog;
import com.yihuan.util.Util;

@Repository
public class Img_Text_ValDaoImpl implements Img_Text_ValDao{

	@Resource
	private HibernateTemplate hibernateTemplate;
	

	public List<Object[]> findImg_Text_ValByStatus(int status) {
		
		List<Object[]> img_Text_Vals=hibernateTemplate.find("select i.classify,i.queue,i.img.identity_id,i.custom_title,i.url,i.img.img_path,i.text_val,i.id,i.page_num " +
																"from Img_Text_Val as i where i.status="+status+" order by i.classify asc,i.queue desc");
		return img_Text_Vals;
	}

	public List<Img_Text_Val> findImg_Text_ValByClassify(int classify) {
		List<Img_Text_Val> img_Text_Vals=hibernateTemplate.find(
								"from Img_Text_Val as i where i.classify like '"+classify+"%' and i.status!=-1 order by i.classify asc,i.queue desc");
		return img_Text_Vals;
	}

	public List<Img_Text_Val> findAll(){
		List<Img_Text_Val> img_Text_Vals=hibernateTemplate.find("from Img_Text_Val as i order by i.status desc,i.classify asc");
		return img_Text_Vals;
	}
	
	public Object saveUpdateImg_Text_Vals(int t,List<Img_Text_Val> it){
		final List<Img_Text_Val> img_Text_Vals=it;
		final boolean type=(t==1);
		return hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				int index=0;
				List<Integer> arr=new ArrayList<Integer>();
				for(int i=0;i<img_Text_Vals.size();i++){
					if(type){
						Serializable id=session.save(img_Text_Vals.get(i));
						arr.add((Integer)id);
						}else{
							Query query=session.createQuery("select i.create_time from Img_Text_Val as i where id="+img_Text_Vals.get(i).getId());
							List<Date> time=query.list();
							img_Text_Vals.get(i).setCreate_time(time.get(0));
							session.update(img_Text_Vals.get(i));
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
				index+=img_Text_Vals.size()%5;
				return type?arr:index;
			}
			
		});
	}
	
	public int deleteImg_Text_Vals(Integer status,List<Integer> ids){
		final String hql;
		final List<Integer> id=ids;
		if(status==null){
			hql="delete from Img_Text_Val as i where i.id in(";
		}else{
			hql="update Img_Text_Val as i set i.status="+status+" where i.id in(";
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
	
	
	

	public int saveImg_Text_Val(Img_Text_Val img_Text_Val) {
		try {
			hibernateTemplate.save(img_Text_Val);
		} catch (Exception e) {
			Util.log2Error("插入实体类发生异常：",e);
			return 0;
		}
		return 1;
	}
	
}
