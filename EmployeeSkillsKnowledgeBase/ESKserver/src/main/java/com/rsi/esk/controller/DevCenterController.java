package com.rsi.esk.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.rsi.esk.domain.DevCenter;
import com.rsi.esk.service.DevCenterService;

@Component
@Path("/devCenter")
@RestController
public class DevCenterController extends BaseController{
	
	@Autowired
	private DevCenterService devCenterService;

	@GET
    @Produces({"application/json"})
	//@RequestMapping(value="/spring-listDevCenter", produces="application/json")
	public List<DevCenter> getDevCenterList() {
		return devCenterService.getAllDevCenters();
	}
	
	@POST
	@Path("/save")
	public Response saveCenter(DevCenter devCenter) {
		Long devCenterId = devCenterService.save(devCenter);

		URI location = uriInfo.getAbsolutePathBuilder().path("{id}").resolveTemplate("id", devCenterId).build();
		return Response.created(location).build();
	}

	public DevCenterService getDevCenterService() {
		return devCenterService;
	}

	public void setDevCenterService(DevCenterService devCenterService) {
		this.devCenterService = devCenterService;
	}
}
