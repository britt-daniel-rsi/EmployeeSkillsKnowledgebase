package com.rsi.esk.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;

@ManagedBean(name = "listUserController", eager = true)
@Controller
@Scope("request")
public class ListUserController extends BaseController {

	@ManagedProperty(value="#{userService}")
	UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUserList() {
		return userService.getAllUsers();
	}
}
