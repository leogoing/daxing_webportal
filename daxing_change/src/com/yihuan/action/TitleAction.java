package com.yihuan.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.yihuan.entity.Img_Text_Val;
import com.yihuan.entity.Title;
import com.yihuan.service.TitleService;
import com.yihuan.util.BaseLog;
import com.yihuan.util.Result_Mes;

@Controller
@Scope("prototype")
public class TitleAction extends ActionSupport{
	
	@Resource
	private TitleService titleService;
	
	private Result_Mes result_Mes;
	
	private Title title;
	
	private Integer status;
	
	private List<Title> titles;
	
	private String json;

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	private Img_Text_Val img_Text_Val;
	
	public Img_Text_Val getImg_Text_Val() {
		return img_Text_Val;
	}

	public void setImg_Text_Val(Img_Text_Val imgTextVal) {
		img_Text_Val = imgTextVal;
	}

	public Result_Mes getResult_Mes() {
		return result_Mes;
	}

	public void setResult_Mes(Result_Mes resultMes) {
		result_Mes = resultMes;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String findTitles(){
		result_Mes=titleService.findTitlesByStatus(status);
		return SUCCESS;
	}

	public String findAll(){
		result_Mes=titleService.findAllTitles();
		return SUCCESS;
	}
	
	public String update(){
		BaseLog.logger.debug("接收的json："+json);
		result_Mes=titleService.updateTitles(json);
		BaseLog.logger.debug("处理得到的结果集："+result_Mes);
		return SUCCESS;
	}
	
	public String add(){
		result_Mes=titleService.addTitles(json);
		return SUCCESS;
	}
	
	public String firstDelete(){
		result_Mes=titleService.updateStatus(json);
		return SUCCESS;
	}
	
	public String lastDelete(){
		result_Mes=titleService.deleteTitles(json);
		return SUCCESS;
	}
	
}
