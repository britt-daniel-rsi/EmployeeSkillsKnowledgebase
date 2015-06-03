package com.rsi.esk.dao;

import java.util.List;

import com.rsi.esk.domain.DevCenter;

public interface DevCenterDao {
	
	public void save(DevCenter center);
	
	public List<DevCenter> list();
}
