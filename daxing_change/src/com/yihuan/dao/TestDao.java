package com.yihuan.dao;

import java.util.List;

import com.yihuan.entity.Test;

public interface TestDao {
	public List<Test> findAll();
	public int update();
}
