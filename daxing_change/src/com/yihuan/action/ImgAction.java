package com.yihuan.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.yihuan.service.ImgService;
import com.yihuan.util.Result_Mes;

@Controller
@Scope("prototype")
public class ImgAction extends ActionSupport{
	
	private Result_Mes result_Mes;
	
	private Integer status;
	
	@Resource
	private ImgService imgService;
	
	private String jsonImgs;
	
	public String getJsonImgs() {
		return jsonImgs;
	}

	public void setJsonImgs(String jsonImgs) {
		this.jsonImgs = jsonImgs;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Result_Mes getResult_Mes() {
		return result_Mes;
	}

	public void setResult_Mes(Result_Mes resultMes) {
		result_Mes = resultMes;
	}

	public String findImgs(){
		result_Mes=imgService.findImgsByStatus(status);
		return SUCCESS;
	}
	
	public String findAll(){
		result_Mes=imgService.findAllImgs();
		return SUCCESS;
	}
	
	public String save(){
		result_Mes=imgService.saveImgs(jsonImgs);
		return SUCCESS;
	}
	
	public String update(){
		result_Mes=imgService.updateImgs(jsonImgs);
		return SUCCESS;
	}
	
	public String firstDelete(){
		result_Mes=imgService.updateStatuts(jsonImgs,ServletActionContext.getRequest().getRealPath("/"));
		return SUCCESS;
	}
	
	public String lastDelete(){
		result_Mes=imgService.deleteImgs(jsonImgs,ServletActionContext.getRequest().getRealPath("/"));
		return SUCCESS;
	}
	
}
