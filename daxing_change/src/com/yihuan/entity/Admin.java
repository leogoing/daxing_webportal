package com.yihuan.entity;

import java.io.Serializable;

public class Admin implements Serializable{
	private Integer id;
	private String username;
	private String password;
	private Integer power;
	private String forget_question;
	private String forget_answer;
	
	@Override
	public String toString() {
		return "Admin [forget_answer=" + forget_answer + ", forget_question="
				+ forget_question + ", id=" + id + ", password=" + password
				+ ", power=" + power + ", username=" + username + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public String getForget_question() {
		return forget_question;
	}
	public void setForget_question(String forgetQuestion) {
		forget_question = forgetQuestion;
	}
	public String getForget_answer() {
		return forget_answer;
	}
	public void setForget_answer(String forgetAnswer) {
		forget_answer = forgetAnswer;
	}
}	
