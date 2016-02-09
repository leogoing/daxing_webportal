package com.yihuan.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.yihuan.entity.Img_Text_Val;
import com.yihuan.service.Img_Text_ValService;
import com.yihuan.util.BaseLog;
import com.yihuan.util.Result_Mes;

@Controller
@Scope("prototype")
public class Img_Text_ValAction extends ActionSupport{
	
	@Resource
	private Img_Text_ValService img_Text_ValService;
	
	private Result_Mes result_Mes;
	
	private Integer status;
	
	private Img_Text_Val img_Text_Val;
	
	private String json_Img_Texts;
	
	public String getJson_Img_Texts() {
		return json_Img_Texts;
	}

	public void setJson_Img_Texts(String jsonImgTexts) {
		json_Img_Texts = jsonImgTexts;
	}

	public Img_Text_Val getImg_Text_Val() {
		return img_Text_Val;
	}

	public void setImg_Text_Val(Img_Text_Val imgTextVal) {
		img_Text_Val = imgTextVal;
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

	public String findImg_Text_Vals(){
		result_Mes=img_Text_ValService.findImg_Text_ValByStatus(status);
		return SUCCESS;
	}
	
	public String addImg_Text_Val(){
		result_Mes=img_Text_ValService.addImg_Text_Val(img_Text_Val);
		return SUCCESS;
	}
	
	public String findAll(){
		result_Mes=img_Text_ValService.findAllImg_Texts();
		return SUCCESS;
	}
	
	public String save(){
		result_Mes=img_Text_ValService.saveImg_Texts(json_Img_Texts);
		return SUCCESS;
	}
	
	public String update(){
		BaseLog.logger.debug("´«ÈëµÄjson×Ö·û´®:"+json_Img_Texts);
		result_Mes=img_Text_ValService.updateImg_Texts(json_Img_Texts);
		return SUCCESS;
	}
	
	public String firstDelete(){
		result_Mes=img_Text_ValService.updateStatuts(json_Img_Texts);
		return SUCCESS;
	}
	
	public String lastDelete(){
		result_Mes=img_Text_ValService.deleteImg_Texts(json_Img_Texts);
		return SUCCESS;
	}
	
}
