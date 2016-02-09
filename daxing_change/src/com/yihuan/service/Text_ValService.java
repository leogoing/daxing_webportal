package com.yihuan.service;

import com.yihuan.entity.Text_Val;
import com.yihuan.util.Result_Mes;

public interface Text_ValService {
	public Result_Mes findText_ValsByStatus(Integer status);
	public Result_Mes addText_Val(Text_Val text_Val);
	public Result_Mes deleteImg_Texts(String jsonTexts);
	public Result_Mes findAllTexts();
	public Result_Mes saveTexts(String jsonTexts);
	public Result_Mes updateTexts(String jsonTexts);
	public Result_Mes updateStatuts(String jsonTexts);
}
