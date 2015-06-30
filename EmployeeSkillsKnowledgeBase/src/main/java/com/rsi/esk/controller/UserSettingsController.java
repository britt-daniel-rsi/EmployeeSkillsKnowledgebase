package com.rsi.esk.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;

@Component
@RestController
@Path("/user")
public class UserSettingsController extends BaseController {
	@Autowired
	private UserService userService;
	
	@POST
	@Path("/save")
	public Response save(User user) {
		Long userId = userService.saveOrUpdate(user);
		
		URI location = uriInfo.getAbsolutePathBuilder().path("{id}").resolveTemplate("id", userId).build();
		return Response.created(location).build();
	}
	
	@GET
	@Path("/find")
    @Produces({"application/json"})
	public User findById(@QueryParam("id") Long id) {
		return userService.findById(id);
	}
	
	@GET
	@Path("/list")
	@Produces({"application/json"})
	public List<User> listUsers() {
		return userService.list();
	}

}
