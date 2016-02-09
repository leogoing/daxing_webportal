package com.yihuan.dao;

import java.util.List;

import com.yihuan.entity.Title;

public interface TitleDao {
	public List<Object[]> findTitlesByStatus(int status);
	public List<Title> findTitlesByClassify(int classify);
	public List<Title> findAll();
	public Object saveUpdateTitles(int t,List<Title> titles);
	public int deleteTitles(Integer status,List<Integer> ids);
	
}
