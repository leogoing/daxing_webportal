package com.yihuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yihuan.dao.IndexDao;
import com.yihuan.service.IndexService;
import com.yihuan.util.BaseLog;

@Service
public class IndexServiceImpl implements IndexService{

	@Resource
	private IndexDao indexDao;
	
	@Transactional
	public int refreshId(int id) {
		return indexDao.updateId(id);
	}

	@Transactional
	public List<Integer> returnIds(List<Integer> ids) {
		if(ids==null){
			return null;
		}
		Integer max=indexDao.findMaxId();
		if(max==null){
			return null;
		}
		BaseLog.logger.info("查询index表当前identity_id值："+max);
		int xx=max;
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<ids.size();i++){
			int id=ids.get(i);
			if(id==-1){
				list.add(++max);
			}else if(id<0){
				return null;
			}else if(id>=0){
				list.add(id);
				if(id>max){
					max=id;
				}
			}
		}
		if(max>xx){
			if(refreshId(max)==0){
				return null;
			}
		}
		return list;
	}
	
}
