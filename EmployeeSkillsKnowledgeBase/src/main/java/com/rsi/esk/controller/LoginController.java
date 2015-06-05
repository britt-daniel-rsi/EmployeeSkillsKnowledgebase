package com.rsi.esk.controller;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.stereotype.Controller;

import com.rsi.esk.service.LoginService;

@Controller
@ManagedBean(name = "loginController", eager = true)
public class LoginController extends BaseController implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	@ManagedProperty("#{loginService}")
	private LoginService login; //This will be a UserService
	public LoginService getLogin() {
		return login;
	}
	public void setLogin(LoginService login) {
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
