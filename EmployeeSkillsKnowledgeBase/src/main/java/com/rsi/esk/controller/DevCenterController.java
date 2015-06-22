package com.rsi.esk.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.rsi.esk.domain.DevCenter;
import com.rsi.esk.service.DevCenterService;

@Component
@Path("/devCenterList")
@RestController
public class DevCenterController {
	
	@Autowired
	private DevCenterService devCenterService;

	@GET
    @Produces({"application/json"})
	//@RequestMapping(value="/spring-listDevCenter", produces="application/json")
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
