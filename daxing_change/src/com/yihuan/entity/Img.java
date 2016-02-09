package com.yihuan.entity;

import java.io.Serializable;
import java.sql.Date;

public class Img implements Serializable,Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer classify;
	private Integer queue;
	private Integer status;
	private String img_path;
	private String url;
	private String desc_text;
	private Date modify_time;
	private Integer identity_id;
	private Integer page_num;
	
	public Integer getPage_num() {
		return page_num;
	}
	public void setPage_num(Integer pageNum) {
		page_num = pageNum;
	}
	/**
	 * ¹ØÁªdept
	 * @return
	 */
	//private Dept dept;
	
//	public Dept getDept() {
//		return dept;
//	}
//	public void setDept(Dept dept) {
//		this.dept = dept;
//	}
	public Integer getIdentity_id() {
		return identity_id;
	}
	public void setIdentity_id(Integer identityId) {
		this.identity_id = identityId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClassify() {
		return classify;
	}
	public void setClassify(Integer classify) {
		this.classify = classify;
	}
	public Integer getQueue() {
		return queue;
	}
	public void setQueue(Integer queue) {
		this.queue = queue;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String imgPath) {
		img_path = imgPath;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesc_text() {
		return desc_text;
	}
	public void setDesc_text(String descText) {
		desc_text = descText;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modifyTime) {
		modify_time = modifyTime;
	}
	@Override
	public String toString() {
		return "Img [classify=" + classify + ", dept=" + /*dept +*/ ", desc_text="
				+ desc_text + ", id=" + id + ", identity_id=" + identity_id
				+ ", img_path=" + img_path + ", modify_time=" + modify_time
				+ ", page_num=" + page_num + ", queue=" + queue + ", status="
				+ status + ", url=" + url + "]";
	}
	
}
