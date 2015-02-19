package com.rsi.esk.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;

@Controller
@ManagedBean(name="listUserController", eager=true)
public class ListUserController extends BaseController implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{userService}")
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUserList() {
		return userService.getAllUsers();
	}
}
