package com.yihuan.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.yihuan.service.ImgService;
import com.yihuan.service.Img_Text_ValService;
import com.yihuan.service.Text_ValService;
import com.yihuan.service.TitleService;
import com.yihuan.util.BaseLog;
import com.yihuan.util.Result_Mes;

@Controller
@Scope("prototype")
public class MainAction extends ActionSupport{
	
	@Resource
	private ImgService imgService;
	@Resource
	private TitleService titleService;
	@Resource
	private Text_ValService text_ValService;
	@Resource
	private Img_Text_ValService img_Text_ValService;
	
	public Result_Mes getResult_Mes_IT() {
		return result_Mes_IT;
	}

	public void setResult_Mes_IT(Result_Mes resultMesIT) {
		result_Mes_IT = resultMesIT;
	}

	private Result_Mes result_Mes_Img;
	
	private Result_Mes result_Mes_Title;
	
	private Result_Mes result_Mes_Text;
	
	private Result_Mes result_Mes_IT;
	
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Result_Mes getResult_Mes_Img() {
		return result_Mes_Img;
	}

	public void setResult_Mes_Img(Result_Mes resultMesImg) {
		result_Mes_Img = resultMesImg;
	}

	public Result_Mes getResult_Mes_Title() {
		return result_Mes_Title;
	}

	public void setResult_Mes_Title(Result_Mes resultMesTitle) {
		result_Mes_Title = resultMesTitle;
	}

	public Result_Mes getResult_Mes_Text() {
		return result_Mes_Text;
	}

	public void setResult_Mes_Text(Result_Mes resultMesText) {
		result_Mes_Text = resultMesText;
	}
	
	public String main(){
		BaseLog.logger.info("---------------进入main...-------------");
		String success=null;
		boolean booleanI=true,booleanT=true,booleanIT=true,booleanTI=true;
		if(status==null){
			status=0;
		}
		switch (status) {
		case 0:	booleanIT=false;booleanT=false;success="success";
			break;
		case 1:booleanTI=false;booleanIT=false;success="success1";
			break;
		case 2:booleanT=false;booleanIT=false;booleanI=false;success="success2";
			break;
		case 3:booleanTI=false;booleanT=false;success="success3";
			break;
		case 4:booleanTI=false;booleanT=false;success="success4";
			break;
		case 5:booleanTI=false;booleanIT=false;success="success5";
			break;
		case 6:booleanTI=false;booleanT=false;booleanIT=false;success="success6";
			break;
		default:	booleanIT=false;booleanT=false;success="success";
		}
		
		result_Mes_Img=booleanI?imgService.findImgsByStatus(status):null;
		result_Mes_Title=booleanTI?titleService.findTitlesByStatus(status):null;
		result_Mes_Text=booleanT?text_ValService.findText_ValsByStatus(status):null;
		result_Mes_IT=booleanIT?img_Text_ValService.findImg_Text_ValByStatus(status):null;
		BaseLog.logger.info(result_Mes_Title);
		BaseLog.logger.info("--------------执行完main...--------------return:"+success);
		return success;
	}
}
