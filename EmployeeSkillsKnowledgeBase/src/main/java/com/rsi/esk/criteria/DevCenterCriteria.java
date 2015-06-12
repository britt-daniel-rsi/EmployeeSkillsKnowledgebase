package com.rsi.esk.criteria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rsi.esk.domain.DevCenter;
import com.rsi.esk.service.DevCenterService;


public class DevCenterCriteria {
	
	@Autowired
	private DevCenterService devCenterService;

	public List<DevCenter> getDevCenterList() {
		return devCenterService.getAllDevCenters();
	}

	public DevCenterService getDevCenterService() {
		return devCenterService;
	}

	public void setDevCenterService(DevCenterService devCenterService) {
		this.devCenterService = devCenterService;
	}
}
