package com.rsi.esk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rsi.esk.service.UserService;

@Controller
public class UserSettingsController extends BaseController {
	@Autowired
	private UserService userService;
	String passwordCurrent;
	String passwordNew;
	String passwordNewRe;
	String username;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getPasswordCurrent() {
		return passwordCurrent;
	}

	public void setPasswordCurrent(String passwordCurrent) {
		this.passwordCurrent = passwordCurrent;
	}

	public String getPasswordNew() {
		return passwordNew;
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}

	public String getPasswordNewRe() {
		return passwordNewRe;
	}

	public void setPasswordNewRe(String passwordNewRe) {
		this.passwordNewRe = passwordNewRe;
	}
}
