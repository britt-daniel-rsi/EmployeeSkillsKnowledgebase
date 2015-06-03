package com.rsi.esk.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty; 

import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.DevCenter;
import com.rsi.esk.service.DevCenterService;


@Controller
@ManagedBean(name = "saveDevCenterController", eager = true)
public class SaveDevCenterController extends BaseController {
	
	
	@ManagedProperty(value = "#{devCenterService}")
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
