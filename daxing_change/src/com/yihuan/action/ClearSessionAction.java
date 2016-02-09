package com.yihuan.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class ClearSessionAction extends ActionSupport{

	private String username;
	
	public String clearSession(){
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
