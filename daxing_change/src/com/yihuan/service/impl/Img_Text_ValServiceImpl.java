package com.yihuan.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yihuan.dao.Img_Text_ValDao;
import com.yihuan.entity.Img_Text_Val;
import com.yihuan.service.Img_Text_ValService;
import com.yihuan.service.IndexService;
import com.yihuan.util.Result_Mes;
import com.yihuan.util.Util;

@Service
public class Img_Text_ValServiceImpl implements Img_Text_ValService{

	@Resource
	private Img_Text_ValDao img_Text_ValDao;
	
	@Resource
	private IndexService indexService;
	

	@Transactional(readOnly=true)
	public Result_Mes findImg_Text_ValByStatus(Integer status) {
		Result_Mes result_Mes=new Result_Mes();
		if(status==null){
			status=0;
		}
		if(status==3 || status==4){
			List<Img_Text_Val> img_ts=null;
			try {
				 img_ts=img_Text_ValDao.findImg_Text_ValByClassify(status==3?12:13);
			} catch (Exception e) {
	    		Util.log2Error("通过类别查询发生异常：", e);
				return Util.setResult_Mes4Error("查询错误！",2);
			}
			return Util.setResult_Mes4Query(img_ts);
		}
		List<Object[]> img_Text_Vals=null;
		try {
			img_Text_Vals=img_Text_ValDao.findImg_Text_ValByStatus(status);
		} catch (Exception e) {
			Util.log2Error("通过状态查询发生异常：",e);
			return Util.setResult_Mes4Error("查询错误！",2);
		}
		return Util.setResult_Mes4Query(img_Text_Vals);
	}
	
	@Transactional
	public Result_Mes addImg_Text_Val(Img_Text_Val img_Text_Val){
		Result_Mes result_Mes=new Result_Mes();
		if(img_Text_Val==null || img_Text_Val.getClassify()==null || img_Text_Val.getIdentity_id()==null || img_Text_Val.getQueue()==null || 
				img_Text_Val.getStatus()==null || img_Text_Val.getCustom_title()==null){
			result_Mes.setMessage("插入参数为空！");
			result_Mes.setStatus(1);
		}
		Date date=new Date(System.currentTimeMillis());
		img_Text_Val.setCreate_time(date);
		img_Text_Val.getImg().setModify_time(date);
		int index=img_Text_ValDao.saveImg_Text_Val(img_Text_Val);
		if(index==0){
			result_Mes.setMessage("插入失败！");
			result_Mes.setStatus(2);
		}else{
			result_Mes.setMessage("插入成功！");
			result_Mes.setStatus(0);
		}
		return result_Mes;
	}

	@Transactional
	public Result_Mes deleteImg_Texts(String jsonImgTexts) {
		JSONArray json=JSONArray.fromObject(jsonImgTexts);
		List<Integer> ids=JSONArray.toList(json,Integer.class);
		if(ids==null || ids.size()==0){
			return Util.setResult_Mes4Error("彻底删除内容为空！", 2);
		}
		int index=img_Text_ValDao.deleteImg_Text_Vals(null, ids);
		if(index==0){
			return Util.setResult_Mes4Error("彻底删除失败！", 1);
		}
		if(index>0){
			return Util.setResult_MesAddVal("成功彻底删除"+index+"个", 0,index);
		}
		return null;
	}

	@Transactional(readOnly=true)
	public Result_Mes findAllImg_Texts() {
		Result_Mes result_Mes=new Result_Mes();
		List<Img_Text_Val> img_Text_Vals=img_Text_ValDao.findAll();
		if(img_Text_Vals==null){
			return Util.setResult_Mes4Error("查询失败！", 2);
		}else if(img_Text_Vals.size()==0){
			return Util.setResult_Mes4Error("查询为空！", 1);
		}else if(img_Text_Vals.size()>0){
			result_Mes.setMessage("查询成功！");
			result_Mes.setStatus(0);
			result_Mes.setResult_Val(img_Text_Vals);
		}
		return result_Mes;
	}

	@Transactional
	public Result_Mes saveImg_Texts(String jsonImgTexts) {
		JSONArray json=JSONArray.fromObject(jsonImgTexts);
		List<Img_Text_Val> img_Text_Vals=JSONArray.toList(json,Img_Text_Val.class);
		if(img_Text_Vals==null || img_Text_Vals.size()==0){
			return Util.setResult_Mes4Error("添加内容为空！", 2);
		}
		List<Integer> idList=new ArrayList<Integer>();
		for(int i=0;i<img_Text_Vals.size();i++){
			img_Text_Vals.get(i).setText_val(Util.ajaxDecode(img_Text_Vals.get(i).getText_val()));
			img_Text_Vals.get(i).setCustom_title(Util.ajaxDecode(img_Text_Vals.get(i).getCustom_title()));
			img_Text_Vals.get(i).setDesc_text(Util.ajaxDecode(img_Text_Vals.get(i).getDesc_text()));
			img_Text_Vals.get(i).setCreate_time(new Date(System.currentTimeMillis()));
			img_Text_Vals.get(i).setLast_modify_time(null);
			idList.add(img_Text_Vals.get(i).getIdentity_id());
		}
		List<Integer> ids=indexService.returnIds(idList);
		if(ids==null || ids.size()!=img_Text_Vals.size()){
			return Util.setResult_Mes4Error("身份号参数错误！", 3);
		}
		for(int i=0;i<img_Text_Vals.size();i++){
			img_Text_Vals.get(i).setIdentity_id(ids.get(i));
		}
		
		Object obj=img_Text_ValDao.saveUpdateImg_Text_Vals(1, img_Text_Vals);
		if(((List<Integer>)obj).size()==0){
			return Util.setResult_Mes4Error("添加失败！", 1);
		}
		if(((List<Integer>)obj).size()>0){
			return Util.setResult_MesAddVal("成功添加"+((List<Integer>)obj).size()+"个", 0,obj);
		}
		return null;
	}

	@Transactional
	public Result_Mes updateImg_Texts(String jsonImgTexts) {
		JSONArray json=JSONArray.fromObject(jsonImgTexts);
		List<Img_Text_Val> img_Text_Vals=JSONArray.toList(json,Img_Text_Val.class);
		if(img_Text_Vals==null || img_Text_Vals.size()==0){
			return Util.setResult_Mes4Error("修改内容为空！", 2);
		}
		List<Integer> idList=new ArrayList<Integer>();
		for(int i=0;i<img_Text_Vals.size();i++){
			img_Text_Vals.get(i).setText_val(Util.ajaxDecode(img_Text_Vals.get(i).getText_val()));
			img_Text_Vals.get(i).setCustom_title(Util.ajaxDecode(img_Text_Vals.get(i).getCustom_title()));
			img_Text_Vals.get(i).setDesc_text(Util.ajaxDecode(img_Text_Vals.get(i).getDesc_text()));
			img_Text_Vals.get(i).setLast_modify_time(new Date(System.currentTimeMillis()));
			idList.add(img_Text_Vals.get(i).getIdentity_id());
		}
		List<Integer> ids=indexService.returnIds(idList);
		if(ids==null || ids.size()!=img_Text_Vals.size()){
			return Util.setResult_Mes4Error("身份号参数错误！", 3);
		}
		for(int i=0;i<img_Text_Vals.size();i++){
			img_Text_Vals.get(i).setIdentity_id(ids.get(i));
		}
		Object obj=img_Text_ValDao.saveUpdateImg_Text_Vals(0, img_Text_Vals);
		if((Integer)obj==0){
			return Util.setResult_Mes4Error("修改失败！", 1);
		}
		if((Integer)obj>0){
			return Util.setResult_MesAddVal("成功修改"+(Integer)obj+"个", 0,obj);
		}
		return null;
	}

	@Transactional
	public Result_Mes updateStatuts(String jsonImgTexts) {
		JSONArray json=JSONArray.fromObject(jsonImgTexts);
		List<Integer> ids=JSONArray.toList(json,Integer.class);
		if(ids==null || ids.size()==0){
			return Util.setResult_Mes4Error("删除内容为空！", 2);
		}
		int index=img_Text_ValDao.deleteImg_Text_Vals(-1, ids);
		if(index==0){
			return Util.setResult_Mes4Error("删除失败！", 1);
		}
		if(index>0){
			return Util.setResult_MesAddVal("成功删除"+index+"个", 0,index);
		}
		return null;
	}
	
}
