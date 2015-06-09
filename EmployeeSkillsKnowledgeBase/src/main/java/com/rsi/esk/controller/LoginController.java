package com.rsi.esk.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rsi.esk.service.UserService;

@Controller
public class LoginController{
	private String username;
	private String password;
	@Autowired
	private UserService login; //This will be a UserService
	public UserService getLogin() {
		return login;
	}
	public void setLogin(UserService login) {
		this.login = login;
	}
	public String checkCredentials(){
		if(login.validate(getUsername(), getPassword())){
			return "success";
		}
		else{
			return "failure";
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
