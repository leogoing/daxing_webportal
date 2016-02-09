package com.yihuan.service;

import java.util.List;

public interface IndexService {
	public List<Integer> returnIds(List<Integer> ids);
	public int refreshId(int id);
}
