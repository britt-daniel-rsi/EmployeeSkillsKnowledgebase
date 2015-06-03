package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.domain.DevCenter;

public interface DevCenterService {
	public List<DevCenter> getAllDevCenters();
	
	public void addCenter(DevCenter center);
}
