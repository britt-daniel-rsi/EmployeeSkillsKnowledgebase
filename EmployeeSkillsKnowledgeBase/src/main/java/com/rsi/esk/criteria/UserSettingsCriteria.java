package com.rsi.esk.criteria;

import org.springframework.beans.factory.annotation.Autowired;

import com.rsi.esk.service.UserService;


public class UserSettingsCriteria {
	@Autowired
	private UserService userService;
	String passwordCurrent;
	String passwordNew;
	String passwordNewRe;
	String username;

	public String checkCredentials() {
		// I need to get the username from some persistent storage and place it
		// in the input below
		if (userService.validate(username, getPasswordCurrent())) {
			return "success";
		} else {
			return "failure";
		}
	}

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
