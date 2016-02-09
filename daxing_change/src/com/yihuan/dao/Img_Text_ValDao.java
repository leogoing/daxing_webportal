package com.yihuan.dao;

import java.util.List;

import com.yihuan.entity.Img_Text_Val;

public interface Img_Text_ValDao {
	public List<Object[]> findImg_Text_ValByStatus(int status);
	public List<Img_Text_Val> findImg_Text_ValByClassify(int classify);
	public int saveImg_Text_Val(Img_Text_Val img_Text_Val);
	public int deleteImg_Text_Vals(Integer status,List<Integer> ids);
	public Object saveUpdateImg_Text_Vals(int t,List<Img_Text_Val> it);
	public List<Img_Text_Val> findAll();
}
