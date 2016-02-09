package com.yihuan.service.impl;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yihuan.dao.ImgDao;
import com.yihuan.entity.Img;
import com.yihuan.service.ImgService;
import com.yihuan.service.IndexService;
import com.yihuan.util.Result_Mes;
import com.yihuan.util.Util;

@Service
public class ImgServiceImpl implements ImgService{
	
	@Resource
	private ImgDao imgDao;
	
	@Resource
	private IndexService indexService;
	
	@Transactional(readOnly=true)
	public Result_Mes findImgsByStatus(Integer status) {
		if(status==null){
			status=0;
		}
		List<Object[]> imgs=null;
		try {
			if(status!=0){
				imgs=imgDao.findByClassify(40);
			}else{
				imgs=imgDao.findImgsByStatus(0);
			}
		} catch (Exception e) {
			Util.log2Error("ͨ���������ҷ����쳣��",e);
			return Util.setResult_Mes4Error("��ѯ����",2);
		}
		return Util.setResult_Mes4Query(imgs);
	}
	
	@Transactional
	public Result_Mes deleteImgs(String jsonImgs,String rootPath) {
		JSONArray json=JSONArray.fromObject(jsonImgs);
		List<Integer> ids=JSONArray.toList(json,Integer.class);
		if(ids==null || ids.size()==0){
			return Util.setResult_Mes4Error("����ɾ������Ϊ�գ�", 2);
		}
		int num=0;
		boolean bor=true;
		try {
			bor=ids.get(ids.size()-1)==(-100);
		} catch (Exception e) {
			bor=false;
		}
		if(bor){
			ids.remove(ids.size()-1);
			List<String> img_paths=imgDao.findImg_paths(ids);
			num=deleteFiles(img_paths, rootPath);
		}
		int index=imgDao.deleteImgs(null, ids);
		if(index==0){
			return Util.setResult_Mes4Error("����ɾ��ʧ�ܣ�", 1);
		}
		if(index>0){
			return Util.setResult_MesAddVal("�ɹ�����ɾ��"+index+"��,ԴͼƬ"+num+"��", 0,index);
		}
		return null;
	}

	@Transactional(readOnly=true)
	public Result_Mes findAllImgs() {
		Result_Mes result_Mes=new Result_Mes();
		List<Img> imgs=imgDao.findAll();
		if(imgs==null){
			return Util.setResult_Mes4Error("��ѯʧ�ܣ�", 2);
		}else if(imgs.size()==0){
			return Util.setResult_Mes4Error("��ѯΪ�գ�", 1);
		}else if(imgs.size()>0){
			result_Mes.setMessage("��ѯ�ɹ���");
			result_Mes.setStatus(0);
			result_Mes.setResult_Val(imgs);
		}
		return result_Mes;
	}

	@Transactional
	public Result_Mes saveImgs(String jsonImgs) {
		System.out.println(jsonImgs);
		JSONArray json=JSONArray.fromObject(jsonImgs);
		List<Img> imgs=JSONArray.toList(json,Img.class);
		if(imgs==null || imgs.size()==0){
			return Util.setResult_Mes4Error("�������Ϊ�գ�", 2);
		}
		List<Integer> idList=new ArrayList<Integer>();
		for(int i=0;i<imgs.size();i++){
			imgs.get(i).setDesc_text(Util.ajaxDecode(imgs.get(i).getDesc_text()));
			imgs.get(i).setModify_time(new Date(System.currentTimeMillis()));
			idList.add(imgs.get(i).getIdentity_id());
		}
		List<Integer> ids=indexService.returnIds(idList);
		if(ids==null || ids.size()!=imgs.size()){
			return Util.setResult_Mes4Error("��ݺŲ�������", 3);
		}
		for(int i=0;i<imgs.size();i++){
			imgs.get(i).setIdentity_id(ids.get(i));
		}
		Object obj=imgDao.saveUpdateImgs(1, imgs);
		if(((List<Integer>)obj).size()==0){
			return Util.setResult_Mes4Error("���ʧ�ܣ�", 1);
		}
		if(((List<Integer>)obj).size()>0){
			return Util.setResult_MesAddVal("�ɹ����"+((List<Integer>)obj).size()+"��", 0,obj);
		}
		return null;
	}

	@Transactional
	public Result_Mes updateImgs(String jsonImgs) {
		JSONArray json=JSONArray.fromObject(jsonImgs);
		List<Img> imgs=JSONArray.toList(json,Img.class);
		if(imgs==null || imgs.size()==0){
			return Util.setResult_Mes4Error("�޸�����Ϊ�գ�", 2);
		}
		List<Integer> idList=new ArrayList<Integer>();
		for(int i=0;i<imgs.size();i++){
			imgs.get(i).setDesc_text(Util.ajaxDecode(imgs.get(i).getDesc_text()));
			imgs.get(i).setModify_time(new Date(System.currentTimeMillis()));
			idList.add(imgs.get(i).getIdentity_id());
		}
		List<Integer> ids=indexService.returnIds(idList);
		if(ids==null || ids.size()!=imgs.size()){
			return Util.setResult_Mes4Error("��ݺŲ�������", 3);
		}
		for(int i=0;i<imgs.size();i++){
			imgs.get(i).setIdentity_id(ids.get(i));
		}
		Object obj=imgDao.saveUpdateImgs(0, imgs);
		if((Integer)obj==0){
			return Util.setResult_Mes4Error("�޸�ʧ�ܣ�", 1);
		}
		if((Integer)obj>0){
			return Util.setResult_MesAddVal("�ɹ��޸�"+(Integer)obj+"��", 0,obj);
		}
		return null;
	}

	@Transactional
	public Result_Mes updateStatuts(String jsonImgs,String rootPath) {
		JSONArray json=JSONArray.fromObject(jsonImgs);
		List<Integer> ids=JSONArray.toList(json,Integer.class);

		if(ids==null || ids.size()==0){
			return Util.setResult_Mes4Error("ɾ������Ϊ�գ�", 2);
		}
		int num=0;
		boolean bor=true;
		try {
			bor=ids.get(ids.size()-1)==(-100);
		} catch (Exception e) {
			Util.log2Error("����json�����������Ͳ�ͬת�������쳣[����]��",e);
			bor=false;
		}
		if(bor){
			ids.remove(ids.size()-1);
			List<String> img_paths=imgDao.findImg_paths(ids);
			num=deleteFiles(img_paths,rootPath);
		}
		int index=imgDao.deleteImgs(-1, ids);
		if(index==0){
			return Util.setResult_Mes4Error("ɾ��ʧ�ܣ�", 1);
		}
		if(index>0){
			return Util.setResult_MesAddVal("�ɹ�ɾ��"+index+"��,ԴͼƬ"+num+"��", 0,index);
		}
		return null;
	}
	
	public int deleteFiles(List<String> img_paths,String rootPath){
		int index=0;
		for(int i=0;i<img_paths.size();i++){
			File file=new File(rootPath+img_paths.get(i).replace("/", File.separator));
			if(file.exists() && file.isFile()){
				if(file.delete()){
					index++;
				}
			}
		}
		return index;
	}
	
}
