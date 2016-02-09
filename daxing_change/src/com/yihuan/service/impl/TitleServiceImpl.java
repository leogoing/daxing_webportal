package com.yihuan.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yihuan.dao.TitleDao;
import com.yihuan.entity.Title;
import com.yihuan.service.IndexService;
import com.yihuan.service.TitleService;
import com.yihuan.util.BaseLog;
import com.yihuan.util.Result_Mes;
import com.yihuan.util.Util;

@Service
public class TitleServiceImpl implements TitleService{

	@Resource
	private TitleDao titleDao;
	
	@Resource
	private IndexService indexService;
	
	@Transactional(readOnly=true)
	public Result_Mes findTitlesByStatus(Integer status) {
		Result_Mes result_Mes=new Result_Mes();
		if(status==null){
			status=0;
		}
		if(status==2){
			List<Title> title=null;
			try {
				title=titleDao.findTitlesByClassify(5);
				System.out.println("service#############################################\n"+title);
			} catch (Exception e) {
				Util.log2Error("通过类型查询发生异常：",e);
				return Util.setResult_Mes4Error("查询错误！",2);
			}
			
			return Util.setResult_Mes4Query(title);
		}else{
		List<Object[]> titles=null;
		try {
			titles=titleDao.findTitlesByStatus(status);
		} catch (Exception e) {
			Util.log2Error("通过状态查询发生异常：",e);
			return Util.setResult_Mes4Error("查询错误！",2);
		}
		return Util.setResult_Mes4Query(titles);
		}
	}

	@Transactional(readOnly=true)
	public Result_Mes findAllTitles() {
		Result_Mes result_Mes=new Result_Mes();
		List<Title> titles=titleDao.findAll();
		if(titles==null){
			return Util.setResult_Mes4Error("查询失败！", 2);
		}else if(titles.size()==0){
			return Util.setResult_Mes4Error("查询为空！", 1);
		}else if(titles.size()>0){
			result_Mes.setMessage("查询成功！");
			result_Mes.setStatus(0);
			result_Mes.setResult_Val(titles);
		}
		return result_Mes;
	}
	
	@Transactional
	public Result_Mes updateTitles(String json_Titles){
		JSONArray json=JSONArray.fromObject(json_Titles);
		List<Title> titles=JSONArray.toList(json,Title.class);
		if(titles==null || titles.size()==0){
			return Util.setResult_Mes4Error("修改内容为空！", 2);
		}
		List<Integer> idList=new ArrayList<Integer>();
		for(int i=0;i<titles.size();i++){
			titles.get(i).setTitle_val(Util.ajaxDecode(titles.get(i).getTitle_val()));
			titles.get(i).setDesc_text(Util.ajaxDecode(titles.get(i).getDesc_text()));
			titles.get(i).setModify_time(new Date(System.currentTimeMillis()));
			idList.add(titles.get(i).getIdentity_id());
		}
		List<Integer> ids=indexService.returnIds(idList);
		if(ids==null || ids.size()!=titles.size()){
			return Util.setResult_Mes4Error("身份号参数错误！", 3);
		}
		for(int i=0;i<titles.size();i++){
			titles.get(i).setIdentity_id(ids.get(i));
		}
		Object obj=titleDao.saveUpdateTitles(0, titles);
		if((Integer)obj==0){
			return Util.setResult_Mes4Error("修改失败！", 1);
		}
		if((Integer)obj>0){
			return Util.setResult_MesAddVal("成功修改"+(Integer)obj+"个", 0,obj);
		}
		return null;
	}
	
	@Transactional
	public Result_Mes addTitles(String json_Titles){
		BaseLog.logger.info("传入json字符串："+json_Titles);
		JSONArray json=JSONArray.fromObject(json_Titles);
		List<Title> titles=JSONArray.toList(json,Title.class);
		if(titles==null || titles.size()==0){
			return Util.setResult_Mes4Error("添加内容为空！", 2);
		}
		List<Integer> idList=new ArrayList<Integer>();
		for(int i=0;i<titles.size();i++){
			titles.get(i).setTitle_val(Util.ajaxDecode(titles.get(i).getTitle_val()));
			titles.get(i).setDesc_text(Util.ajaxDecode(titles.get(i).getDesc_text()));
			titles.get(i).setModify_time(new Date(System.currentTimeMillis()));
			idList.add(titles.get(i).getIdentity_id());
		}
		List<Integer> ids=indexService.returnIds(idList);
		if(ids==null || ids.size()!=titles.size()){
			return Util.setResult_Mes4Error("身份号参数错误！", 3);
		}

		for(int i=0;i<titles.size();i++){
			titles.get(i).setIdentity_id(ids.get(i));
		}
		BaseLog.logger.debug("自定义生成identity_id数组："+ids);
		Object obj=titleDao.saveUpdateTitles(1, titles);
		if(((List<Integer>)obj).size()==0){
			return Util.setResult_Mes4Error("添加失败！", 1);
		}
		if(((List<Integer>)obj).size()>0){
			return Util.setResult_MesAddVal("成功添加"+((List<Integer>)obj).size()+"个", 0,obj);
		}
		return null;
	}
	
	@Transactional
	public Result_Mes updateStatus(String id){
		JSONArray json=JSONArray.fromObject(id);
		List<Integer> ids=JSONArray.toList(json,Integer.class);
		System.out.println("service>>> "+ids);
		if(ids==null || ids.size()==0){
			return Util.setResult_Mes4Error("删除内容为空！", 2);
		}
		int index=titleDao.deleteTitles(-1, ids);
		if(index==0){
			return Util.setResult_Mes4Error("删除失败！", 1);
		}
		if(index>0){
			return Util.setResult_MesAddVal("成功删除"+index+"个", 0,index);
		}
		return null;
	}
	
	@Transactional
	public Result_Mes deleteTitles(String id){
		JSONArray json=JSONArray.fromObject(id);
		List<Integer> ids=JSONArray.toList(json,Integer.class);
		if(ids==null || ids.size()==0){
			return Util.setResult_Mes4Error("彻底删除内容为空！", 2);
		}
		int index=titleDao.deleteTitles(null, ids);
		if(index==0){
			return Util.setResult_Mes4Error("彻底删除失败！", 1);
		}
		if(index>0){
			return Util.setResult_MesAddVal("成功彻底删除"+index+"个", 0,index);
		}
		return null;
	}
	
}
