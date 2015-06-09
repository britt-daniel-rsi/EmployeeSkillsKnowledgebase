package com.rsi.esk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.DevCenter;
import com.rsi.esk.service.DevCenterService;


@Controller
public class SaveDevCenterController extends BaseController {
	
	
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
