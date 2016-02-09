package com.yihuan.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.yihuan.entity.Text_Val;
import com.yihuan.service.Text_ValService;
import com.yihuan.util.BaseLog;
import com.yihuan.util.Result_Mes;

@Controller
@Scope("prototype")
public class Text_ValAction extends ActionSupport{
	
	@Resource
	private Text_ValService text_ValService;
	
	private Result_Mes result_Mes;
	
	private Integer status;
	
	private Text_Val text_Val;
	
	private String text;
	
	private String jsonTexts;

	public String getJsonTexts() {
		return jsonTexts;
	}

	public void setJsonTexts(String jsonTexts) {
		this.jsonTexts = jsonTexts;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Text_Val getText_Val() {
		return text_Val;
	}

	public void setText_Val(Text_Val textVal) {
		text_Val = textVal;
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
	
	public String findText_Vals(){
		result_Mes=text_ValService.findText_ValsByStatus(status);
		return SUCCESS;
	}
	
	public String addText_Val(){
		BaseLog.logger.debug("½øÈëÌí¼Óaction¡£¡£¡£");
		System.out.println(text_Val.getContent_text());
		result_Mes=text_ValService.addText_Val(text_Val);
		return SUCCESS;
	}
	
	public String save(){
		result_Mes=text_ValService.saveTexts(jsonTexts);
		return SUCCESS;
	}
	
	public String update(){
		result_Mes=text_ValService.updateTexts(jsonTexts);
		return SUCCESS;
	}
	
	public String firstDelete(){
		result_Mes=text_ValService.updateStatuts(jsonTexts);
		return SUCCESS;
	}
	
	public String lastDelete(){
		result_Mes=text_ValService.deleteImg_Texts(jsonTexts);
		return SUCCESS;
	}
	
	public String findAll(){
		result_Mes=text_ValService.findAllTexts();
		return SUCCESS;
	}
	
}
