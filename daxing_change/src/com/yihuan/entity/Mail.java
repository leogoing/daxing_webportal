package com.yihuan.entity;

import java.io.Serializable;
import java.sql.Date;

public class Mail implements Serializable{
	private Integer id;
	private String name;
	private String qq_num;
	private String email;
	private String phone;
	private String message_val;
	private String job;
	private String ip;
	private Date create_time;
	
	@Override
	public String toString() {
		return "留言信息： \n" +
				"对方邮箱： " +email + "；\n" +
				"留言编号： " + id + "；\n" +
				"留言者IP： " + ip + "；\n" +
				"留言者职业： "+ job + "；\n" +
				"留言内容： " + message_val + "；\n" +
				"留言者姓名：" + name+ "；\n" +
				"留言者电话：" + phone + "；\n" +
				"留言者qq： " + qq_num + "；\n"+
				"留言时间： "+create_time;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date createTime) {
		create_time = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQq_num() {
		return qq_num;
	}
	public void setQq_num(String qqNum) {
		qq_num = qqNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMessage_val() {
		return message_val;
	}
	public void setMessage_val(String messageVal) {
		message_val = messageVal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
