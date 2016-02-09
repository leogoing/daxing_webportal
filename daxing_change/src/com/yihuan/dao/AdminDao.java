package com.yihuan.dao;

import java.util.List;

import com.yihuan.entity.Admin;

public interface AdminDao {
	public List<Admin> findAdmin(Object obj);
	public int resetAdmin(Integer id,String username,String password);
}
