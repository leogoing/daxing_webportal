package com.yihuan.dao;

import java.util.List;

import com.yihuan.entity.Text_Val;

public interface Text_ValDao {
	public List<Object[]> findText_ValByStatus( int status, Integer beginI,Integer pageS);
	public int saveText_Val(Text_Val text_Val);
	public List<Text_Val> findText_ValByClassify(int classify);
	public List<Text_Val> findAll();
	public Object saveUpdateText_Vals(int t,List<Text_Val> it);
	public int deleteText_Vals(Integer status,List<Integer> ids);
}
