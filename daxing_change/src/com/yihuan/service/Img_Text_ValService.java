package com.yihuan.service;

import java.util.List;

import com.yihuan.entity.Img_Text_Val;
import com.yihuan.util.Result_Mes;

public interface Img_Text_ValService {
	/**
	 * ≤‚ ‘
	 * @return
	 */
	
	public Result_Mes findImg_Text_ValByStatus(Integer status);
	public Result_Mes addImg_Text_Val(Img_Text_Val img_Text_Val);
	public Result_Mes findAllImg_Texts();
	public Result_Mes saveImg_Texts(String json_Img_Texts);
	public Result_Mes updateImg_Texts(String json_Img_Texts);
	public Result_Mes deleteImg_Texts(String json_Img_Texts);
	public Result_Mes updateStatuts(String json_Img_Texts);
	
}
