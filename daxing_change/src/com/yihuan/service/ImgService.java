package com.yihuan.service;

import com.yihuan.util.Result_Mes;

public interface ImgService {
	public Result_Mes findImgsByStatus(Integer status);
	public Result_Mes deleteImgs(String jsonImgs,String rootPath);
	public Result_Mes findAllImgs();
	public Result_Mes saveImgs(String jsonImgs);
	public Result_Mes updateImgs(String jsonImgs);
	public Result_Mes updateStatuts(String jsonImgs,String rootPath);
}
