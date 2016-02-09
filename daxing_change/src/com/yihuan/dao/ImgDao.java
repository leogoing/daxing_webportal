package com.yihuan.dao;

import java.util.List;

import com.yihuan.entity.Img;

public interface ImgDao {
	public List<Object[]> findImgsByStatus(int status);
	public List<Img> findAll();
	public Object saveUpdateImgs(int t,List<Img> it);
	public int deleteImgs(Integer status,List<Integer> ids);
	public List<String> findImg_paths(List<Integer> ids);
	public List<Object[]> findByClassify(int classify);
}
