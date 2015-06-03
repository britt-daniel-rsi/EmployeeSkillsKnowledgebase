package com.rsi.esk.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty; 

import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.DevCenter;
import com.rsi.esk.service.DevCenterService;


@Controller
@ManagedBean(name = "devCenterController", eager = true)
public class DevCenterController extends BaseController {
	
	@ManagedProperty(value = "#{devCenterService}")
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
