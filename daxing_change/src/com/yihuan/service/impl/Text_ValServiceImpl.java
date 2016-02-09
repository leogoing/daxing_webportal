package com.yihuan.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yihuan.dao.Text_ValDao;
import com.yihuan.entity.Text_Val;
import com.yihuan.service.IndexService;
import com.yihuan.service.Text_ValService;
import com.yihuan.util.Result_Mes;
import com.yihuan.util.Util;

@Service
public class Text_ValServiceImpl implements Text_ValService{

	@Resource
	private Text_ValDao text_ValDao;
	
	@Resource
	private IndexService indexService;
	
	@Transactional(readOnly=true)
	public Result_Mes findText_ValsByStatus(Integer status) {
		Result_Mes result_Mes=new Result_Mes();
		Integer beginIndex=null;
		Integer pageSize=null;
		if(status==null){
			status=0;
		}
		if(status==0){
			beginIndex=0;
			pageSize=3;
		}
		if(status==5 || status==6){
			List<Text_Val> text_Vals=null;
			try {
				text_Vals=text_ValDao.findText_ValByClassify(status==5?14:9);
			} catch (Exception e) {
				Util.log2Error("通过类型查询发生异常：",e);
				return Util.setResult_Mes4Error("查询错误！",2);
			}
			return Util.setResult_Mes4Query(text_Vals);
		}
		List<Object[]> text_Vals=null;
		try {
			text_Vals=text_ValDao.findText_ValByStatus(status,beginIndex,pageSize);
		} catch (Exception e) {
			Util.log2Error("通过状态查询发生异常：",e);
			return Util.setResult_Mes4Error("查询错误！",2);
		}
		return Util.setResult_Mes4Query(text_Vals);
	}
	
	@Transactional
	public Result_Mes addText_Val(Text_Val text_Val){
		Result_Mes result_Mes=new Result_Mes();
		if(text_Val==null || text_Val.getClassify()==0 || text_Val.getCustom_title()==null || text_Val.getIdentity_id()==null){
			return Util.setResult_Mes4Error("内容缺少参数！", 2);
		}
		text_Val.setCreate_time(new Date(System.currentTimeMillis()));
		Integer status=text_Val.getStatus();
		text_Val.setStatus(status==null?1:status);
		text_Val.setContent_text(text_Val.getContent_text().replace("\r\n", "<br/>").replace(" ", "&nbsp;"));
		int index=text_ValDao.saveText_Val(text_Val);
		String mess=null;
		int status_Mes=-1;
		if(index==0){
			mess="添加错误！";
			status_Mes=1;
		}else{
			mess="添加成功！";
			status_Mes=0;
		}
		return Util.setResult_Mes4Error(mess, status_Mes);
	}

	@Transactional
	public Result_Mes deleteImg_Texts(String jsonTexts) {
		JSONArray json=JSONArray.fromObject(jsonTexts);
		List<Integer> ids=JSONArray.toList(json,Integer.class);
		if(ids==null || ids.size()==0){
			return Util.setResult_Mes4Error("彻底删除内容为空！", 2);
		}
		int index=text_ValDao.deleteText_Vals(null, ids);
		if(index==0){
			return Util.setResult_Mes4Error("彻底删除失败！", 1);
		}
		if(index>0){
			return Util.setResult_MesAddVal("成功彻底删除"+index+"个", 0,index);
		}
		return null;
	}

	@Transactional(readOnly=true)
	public Result_Mes findAllTexts() {
		Result_Mes result_Mes=new Result_Mes();
		List<Text_Val> text_Vals=text_ValDao.findAll();
		if(text_Vals==null){
			return Util.setResult_Mes4Error("查询失败！", 2);
		}else if(text_Vals.size()==0){
			return Util.setResult_Mes4Error("查询为空！", 1);
		}else if(text_Vals.size()>0){
			result_Mes.setMessage("查询成功！");
			result_Mes.setStatus(0);
			result_Mes.setResult_Val(text_Vals);
		}
		return result_Mes;
	}

	@Transactional
	public Result_Mes saveTexts(String jsonTexts) {
		JSONArray json=JSONArray.fromObject(jsonTexts);
		List<Text_Val> text_Vals=JSONArray.toList(json,Text_Val.class);
		if(text_Vals==null || text_Vals.size()==0){
			return Util.setResult_Mes4Error("添加内容为空！", 2);
		}
		List<Integer> idList=new ArrayList<Integer>();
		for(int i=0;i<text_Vals.size();i++){
			text_Vals.get(i).setContent_text(Util.ajaxDecode(text_Vals.get(i).getContent_text()).replace("&", "<br/>").replace(" ", "&nbsp;"));
			text_Vals.get(i).setCustom_title(Util.ajaxDecode(text_Vals.get(i).getCustom_title()));
			text_Vals.get(i).setDesc_text(Util.ajaxDecode(text_Vals.get(i).getDesc_text()));
			text_Vals.get(i).setCreate_time(new Date(System.currentTimeMillis()));
			text_Vals.get(i).setLast_modify_time(null);
			idList.add(text_Vals.get(i).getIdentity_id());
		}
		List<Integer> ids=indexService.returnIds(idList);
		if(ids==null || ids.size()!=text_Vals.size()){
			return Util.setResult_Mes4Error("身份号参数错误！", 3);
		}
		for(int i=0;i<text_Vals.size();i++){
			text_Vals.get(i).setIdentity_id(ids.get(i));
		}
		Object obj=text_ValDao.saveUpdateText_Vals(1, text_Vals);
		if(((List<Integer>)obj).size()==0){
			return Util.setResult_Mes4Error("添加失败！", 1);
		}
		if(((List<Integer>)obj).size()>0){
			return Util.setResult_MesAddVal("成功添加"+((List<Integer>)obj).size()+"个", 0,obj);
		}
		return null;
	}

	@Transactional
	public Result_Mes updateStatuts(String jsonTexts) {
		JSONArray json=JSONArray.fromObject(jsonTexts);
		List<Integer> ids=JSONArray.toList(json,Integer.class);
		if(ids==null || ids.size()==0){
			return Util.setResult_Mes4Error("删除内容为空！", 2);
		}
		int index=text_ValDao.deleteText_Vals(-1, ids);
		if(index==0){
			return Util.setResult_Mes4Error("删除失败！", 1);
		}
		if(index>0){
			return Util.setResult_MesAddVal("成功删除"+index+"个", 0,index);
		}
		return null;
	}

	@Transactional
	public Result_Mes updateTexts(String jsonTexts) {
		JSONArray json=JSONArray.fromObject(jsonTexts);
		List<Text_Val> text_Vals=JSONArray.toList(json,Text_Val.class);
		if(text_Vals==null || text_Vals.size()==0){
			return Util.setResult_Mes4Error("修改内容为空！", 2);
		}
		List<Integer> idList=new ArrayList<Integer>();
		for(int i=0;i<text_Vals.size();i++){
			text_Vals.get(i).setContent_text(Util.ajaxDecode(text_Vals.get(i).getContent_text()).replace("&h", "<br/>").replace(" ", "&nbsp;").replace("\r\n", ""));
			text_Vals.get(i).setCustom_title(Util.ajaxDecode(text_Vals.get(i).getCustom_title()));
			text_Vals.get(i).setDesc_text(Util.ajaxDecode(text_Vals.get(i).getDesc_text()));
			text_Vals.get(i).setLast_modify_time(new Date(System.currentTimeMillis()));
			idList.add(text_Vals.get(i).getIdentity_id());
		}
		List<Integer> ids=indexService.returnIds(idList);
		if(ids==null || ids.size()!=text_Vals.size()){
			return Util.setResult_Mes4Error("身份号参数错误！", 3);
		}
		for(int i=0;i<text_Vals.size();i++){
			text_Vals.get(i).setIdentity_id(ids.get(i));
		}
		Object obj=text_ValDao.saveUpdateText_Vals(0, text_Vals);
		if((Integer)obj==0){
			return Util.setResult_Mes4Error("修改失败！", 1);
		}
		if((Integer)obj>0){
			return Util.setResult_MesAddVal("成功修改"+(Integer)obj+"个", 0,obj);
		}
		return null;
	}

}
