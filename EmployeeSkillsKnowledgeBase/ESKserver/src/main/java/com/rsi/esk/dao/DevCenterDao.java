package com.rsi.esk.dao;

import java.util.List;

import com.rsi.esk.domain.DevCenter;

public interface DevCenterDao {
	
	void save(DevCenter center);
	
	List<DevCenter> list();
}
