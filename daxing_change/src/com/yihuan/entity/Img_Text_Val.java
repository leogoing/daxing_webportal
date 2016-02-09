package com.yihuan.entity;

import java.io.Serializable;
import java.sql.Date;

public class Img_Text_Val implements Serializable,Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer classify;
	private Integer queue;
	private Integer identity_id;
	private Integer status;
	private String custom_title;
	private String text_val;
	private String url;
	private Date create_time;
	private Date last_modify_time;
	private String desc_text;
	private Integer page_num;
	

	/**
	 * 关联img
	 * @return
	 */
	private Img img;
	
	/**
	 * 关联text_Val
	 * @return
	 */
	private Text_Val text_Val;
	
	/**
	 * 关联dept
	 * @return
	 */
	//private Dept dept;
	
	public Integer getPage_num() {
		return page_num;
	}
	public void setPage_num(Integer pageNum) {
		page_num = pageNum;
	}
	
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
	public Img getImg() {
		return img;
	}
	public void setImg(Img img) {
		this.img = img;
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
		this.identity_id = identityId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCustom_title() {
		return custom_title;
	}
	public void setCustom_title(String customTitle) {
		custom_title = customTitle;
	}
	public String getText_val() {
		return text_val;
	}
	public void setText_val(String textVal) {
		text_val = textVal;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getDesc_text() {
		return desc_text;
	}
	public void setDesc_text(String descText) {
		desc_text = descText;
	}
	@Override
	public String toString() {
		return "Img_Text_Val [classify=" + classify + ", create_time="
				+ create_time + ", custom_title=" + custom_title + ", dept="
				+ /*dept +*/ ", desc_text=" + desc_text + ", id=" + id
				+ ", identity_id=" + identity_id + ", img=" + img
				+ ", last_modify_time=" + last_modify_time + ", page_num="
				+ page_num + ", queue=" + queue + ", status=" + status
				+ ", text_Val=" + text_Val + ", text_val=" + text_val
				+ ", url=" + url + "]";
	}
	
}
