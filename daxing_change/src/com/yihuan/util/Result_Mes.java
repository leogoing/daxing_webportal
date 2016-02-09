package com.yihuan.util;

import java.io.Serializable;

public class Result_Mes implements Serializable{
	private String message;
	private Integer status;
	private Object result_Val;
	@Override
	public String toString() {
		return "Result_Mes [message=" + message + ", result_Val=" + result_Val
				+ ", status=" + status + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getResult_Val() {
		return result_Val;
	}
	public void setResult_Val(Object resultVal) {
		result_Val = resultVal;
	}
}
