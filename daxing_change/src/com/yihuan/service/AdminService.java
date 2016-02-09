package com.yihuan.service;

import com.yihuan.util.Result_Mes;

public interface AdminService {
	public Result_Mes checkLogin(Integer id,String username,String password);
	public Result_Mes checkAnswer(String username,String answer);
}
