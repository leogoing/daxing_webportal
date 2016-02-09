package com.yihuan.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class Dept implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer classify_num;
	private String data_type;
	private Integer sum;
	private Integer max_queue;
	private Integer min_queue;
	private Integer first_page_sum;
	private String desc_text;
	private Date create_time;
	private String main_local_page_url;
	private Integer queue;
	private Integer page_num;
	
	public Integer getPage_num() {
		return page_num;
	}
	public void setPage_num(Integer pageNum) {
		page_num = pageNum;
	}
	public Integer getQueue() {
		return queue;
	}
	public void setQueue(Integer queue) {
		this.queue = queue;
	}
	/**
	 * 一对多关联
	 * @return
	 */
	private Set<Img> imgs;
	private Set<Img_Text_Val> img_Text_Vals;
	private Set<Text_Val> text_Vals;
	private Set<Title> titles;
	
	public Set<Img> getImgs() {
		return imgs;
	}
	public void setImgs(Set<Img> imgs) {
		this.imgs = imgs;
	}
	public Set<Img_Text_Val> getImg_Text_Vals() {
		return img_Text_Vals;
	}
	public void setImg_Text_Vals(Set<Img_Text_Val> imgTextVals) {
		img_Text_Vals = imgTextVals;
	}
	public Set<Text_Val> getText_Vals() {
		return text_Vals;
	}
	public void setText_Vals(Set<Text_Val> textVals) {
		text_Vals = textVals;
	}
	public Set<Title> getTitles() {
		return titles;
	}
	public void setTitles(Set<Title> titles) {
		this.titles = titles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClassify_num() {
		return classify_num;
	}
	public void setClassify_num(Integer classifyNum) {
		classify_num = classifyNum;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String dataType) {
		data_type = dataType;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public Integer getMax_queue() {
		return max_queue;
	}
	public void setMax_queue(Integer maxQueue) {
		max_queue = maxQueue;
	}
	public Integer getMin_queue() {
		return min_queue;
	}
	public void setMin_queue(Integer minQueue) {
		min_queue = minQueue;
	}

	@Override
	public String toString() {
		return "Dept [classify_num=" + classify_num + ", create_time="
				+ create_time + ", data_type=" + data_type + ", desc_text="
				+ desc_text + ", first_page_sum=" + first_page_sum + ", id="
				+ id + ", img_Text_Vals=" + img_Text_Vals + ", imgs=" + imgs
				+ ", main_local_page_url=" + main_local_page_url
				+ ", max_queue=" + max_queue + ", min_queue=" + min_queue
				+ ", page_num=" + page_num + ", queue=" + queue + ", sum="
				+ sum + ", text_Vals=" + text_Vals + ", titles=" + titles + "]";
	}
	public Integer getFirst_page_sum() {
		return first_page_sum;
	}
	public void setFirst_page_sum(Integer firstPageSum) {
		first_page_sum = firstPageSum;
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
	public String getMain_local_page_url() {
		return main_local_page_url;
	}
	public void setMain_local_page_url(String mainLocalPageUrl) {
		main_local_page_url = mainLocalPageUrl;
	}
}
