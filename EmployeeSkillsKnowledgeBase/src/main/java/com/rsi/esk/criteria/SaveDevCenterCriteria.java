package com.rsi.esk.criteria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rsi.esk.domain.DevCenter;
import com.rsi.esk.service.DevCenterService;



public class SaveDevCenterCriteria {
	
	
	@Autowired
	private DevCenterService devCenterService;
	
	private DevCenter center = new DevCenter();

	public List<DevCenter> getDevCenterList() {
		return devCenterService.getAllDevCenters();
	}

	public DevCenterService getDevCenterService() {
		return devCenterService;
	}

	public void setDevCenterService(DevCenterService devCenterService) {
		this.devCenterService = devCenterService;
	}

	public DevCenter getCenter() {
		return center;
	}

	public void setCenter(DevCenter center) {
		this.center = center;
	}
	
	public void saveCenter() {
		devCenterService.addCenter(center);
	}
}
