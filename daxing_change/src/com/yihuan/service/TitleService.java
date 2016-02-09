package com.yihuan.service;

import java.util.List;

import com.yihuan.entity.Title;
import com.yihuan.util.Result_Mes;

public interface TitleService {
	public Result_Mes findTitlesByStatus(Integer status);
	public Result_Mes findAllTitles();
	public Result_Mes updateTitles(String json_Titles);
	public Result_Mes addTitles(String titles);
	public Result_Mes updateStatus(String ids);
	public Result_Mes deleteTitles(String ids);
}
