package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.domain.DevCenter;

public interface DevCenterService {
	List<DevCenter> getAllDevCenters();
	
	void addCenter(DevCenter center);
}
