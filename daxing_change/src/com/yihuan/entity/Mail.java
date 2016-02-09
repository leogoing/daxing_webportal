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
		return "������Ϣ�� \n" +
				"�Է����䣺 " +email + "��\n" +
				"���Ա�ţ� " + id + "��\n" +
				"������IP�� " + ip + "��\n" +
				"������ְҵ�� "+ job + "��\n" +
				"�������ݣ� " + message_val + "��\n" +
				"������������" + name+ "��\n" +
				"�����ߵ绰��" + phone + "��\n" +
				"������qq�� " + qq_num + "��\n"+
				"����ʱ�䣺 "+create_time;
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
