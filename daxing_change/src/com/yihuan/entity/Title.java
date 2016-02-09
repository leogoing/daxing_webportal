package com.yihuan.entity;

import java.io.Serializable;
import java.sql.Date;

public class Title implements Serializable,Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer classify;
	private Integer queue;
	private Integer identity_id;
	private Integer status;
	private String title_val;
	private String url;
	private String desc_text;
	private Date modify_time;
	private Integer page_num;
	
	public Integer getPage_num() {
		return page_num;
	}
	public void setPage_num(Integer pageNum) {
		page_num = pageNum;
	}
	/**
	 * 关联text_Val
	 * @return
	 */
	private Text_Val text_Val;
	
	/**
	 * 关联dept
	 * @return
	 */
//	private Dept dept;
	
//	public Dept getDept() {
//		return dept;
//	}
//	public void setDept(Dept dept) {
//		this.dept = dept;
//	}
	public Text_Val getText_Val() {
		return text_Val;
	}
	public void setText_Val(Text_Val textVal) {
		text_Val = textVal;
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
	public Integer getIdentity_id() {
		return identity_id;
	}
	public void setIdentity_id(Integer identityId) {
		identity_id = identityId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTitle_val() {
		return title_val;
	}
	public void setTitle_val(String titleVal) {
		title_val = titleVal;
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
		return "Title [classify=" + classify + ", dept=" + /*dept
				+*/ ", desc_text=" + desc_text + ", id=" + id + ", identity_id="
				+ identity_id + ", modify_time=" + modify_time + ", page_num="
				+ page_num + ", queue=" + queue + ", status=" + status
				+ ", text_Val=" + text_Val + ", title_val=" + title_val
				+ ", url=" + url + "]";
	}
}
