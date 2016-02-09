package com.yihuan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yihuan.dao.AdminDao;
import com.yihuan.entity.Admin;
import com.yihuan.service.AdminService;
import com.yihuan.util.Result_Mes;
import com.yihuan.util.Util;

@Service
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminDao adminDao;
	
	@Transactional(readOnly=true)
	public Result_Mes checkAnswer(String username, String answer) {
		Result_Mes result_Mes=null;
		if(username==null || "".equals(username) || answer==null || "".equals(answer)){
			return Util.setResult_Mes4Error("输入参数为空！", 1);
		}
		List<Admin> admin=adminDao.findAdmin(username);
		
		answer=Util.ajaxDecode(answer);
		
		if(admin==null || admin.size()==0 ||!answer.equals(admin.get(0).getForget_answer())){
			result_Mes=Util.setResult_Mes4Error("验证失败！", 1);
		}else if(answer.equals(admin.get(0).getForget_answer())){
			result_Mes=Util.setResult_Mes4Error("验证成功！", 0);
			result_Mes.setResult_Val(admin.get(0).getId());
		}
		return result_Mes;
	}

	@Transactional
	public Result_Mes checkLogin(Integer id, String username, String password) {
		String mes=null;
		Integer status=-1;
		if(username==null || "".equals(username) || password==null || "".equals(password)){
			return Util.setResult_Mes4Error("输入参数为空！", 1);
		}
		if(id==null || id==-1){
			List<Admin> admin=adminDao.findAdmin(username);
			if(admin==null || admin.size()==0 ||!password.equals(admin.get(0).getPassword())){
				mes="验证失败！";status=1;
			}else if(password.equals(admin.get(0).getPassword())){
				mes="验证成功！";status=0;
			}
		}else{
			int index=adminDao.resetAdmin(id, username, password);
			if(index==0){
				mes="重置登陆成功！";status=0;
			}else{
				mes="重置失败！";status=1;
			}
		}
		return Util.setResult_Mes4Error(mes, status);
	}
	
}
