package com.yihuan.entity;

import java.io.Serializable;
import java.sql.Date;

public class Text_Val implements Serializable,Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer classify;
	private Integer queue;
	private Integer identity_id;
	private Integer status;
	private String content_text;
	private String custom_title;
	private String desc_text;
	private Date create_time;
	private Date last_modify_time;
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
//	private Dept dept;
	
//	public Dept getDept() {
//		return dept;
//	}
//	public void setDept(Dept dept) {
//		this.dept = dept;
//	}
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
	public String getContent_text() {
		return content_text;
	}
	public void setContent_text(String contentText) {
		content_text = contentText;
	}
	public String getCustom_title() {
		return custom_title;
	}
	public void setCustom_title(String customTitle) {
		custom_title = customTitle;
	}
	public String getDesc_text() {
		return desc_text;
	}
	public void setDesc_text(String descText) {
		desc_text = descText;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date createTime) {
		create_time = createTime;
	}
	public Date getLast_modify_time() {
		return last_modify_time;
	}
	public void setLast_modify_time(Date lastModifyTime) {
		last_modify_time = lastModifyTime;
	}
	public Integer getIdentity_id() {
		return identity_id;
	}
	public void setIdentity_id(Integer identityId) {
		identity_id = identityId;
	}
	@Override
	public String toString() {
		return "Text_Val [classify=" + classify + ", content_text="
				+ content_text + ", create_time=" + create_time
				+ ", custom_title=" + custom_title + ", dept=" + /*dept
				+*/ ", desc_text=" + desc_text + ", id=" + id + ", identity_id="
				+ identity_id + ", last_modify_time=" + last_modify_time
				+ ", page_num=" + page_num + ", queue=" + queue + ", status="
				+ status + "]";
	}
}
