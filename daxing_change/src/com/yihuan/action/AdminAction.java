package com.yihuan.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yihuan.service.AdminService;
import com.yihuan.util.BaseLog;
import com.yihuan.util.Result_Mes;

@Controller
public class AdminAction extends ActionSupport{
	
	@Resource
	private AdminService adminService;
	
	private String username;
	
	private String password;
	
	private Integer id;
	
	private String forget_answer;
	
	private Result_Mes result_Mes;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getForget_answer() {
		return forget_answer;
	}

	public void setForget_answer(String forgetAnswer) {
		forget_answer = forgetAnswer;
	}

	public Result_Mes getResult_Mes() {
		return result_Mes;
	}

	public void setResult_Mes(Result_Mes resultMes) {
		result_Mes = resultMes;
	}
	
	public String checkLogin(){
		BaseLog.logger.debug("进入检查登录checkLogin。。。");
		result_Mes=adminService.checkLogin(id, username, password);
		if(result_Mes.getStatus()==0){
			ActionContext.getContext().getSession().put("username", username);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String checkAnswer(){
		BaseLog.logger.debug("进入检查用户问题checkAnswer。。。");
		result_Mes=adminService.checkAnswer(username, forget_answer);
		System.out.println(result_Mes);
		return SUCCESS;
	}
	
}
