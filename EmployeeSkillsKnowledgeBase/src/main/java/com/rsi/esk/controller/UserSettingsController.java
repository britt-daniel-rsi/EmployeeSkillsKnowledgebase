package com.rsi.esk.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.stereotype.Controller;

import com.rsi.esk.service.UserService;


@Controller
@ManagedBean(name = "userController", eager = true)
public class UserSettingsController extends BaseController{
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	String passwordCurrent;
	String passwordNew;
	String passwordNewRe;
	String username;
	
	public String checkCredentials(){
		//I need to get the username from some persistent storage and place it in the input below
		if(userService.validate(username, getPasswordCurrent())){
			return "success";
		}
		else{
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
