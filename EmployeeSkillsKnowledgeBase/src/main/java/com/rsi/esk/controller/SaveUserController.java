package com.rsi.esk.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;

@Controller
@ManagedBean(name = "saveUserController", eager = true)
@SessionScoped
public class SaveUserController extends BaseController implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	private String username;
	private String surname;
	private String sex;
	private Date birthDate;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getSaveMessage() {
		try {
			User user = new User(username, surname, sex, birthDate);

			userService.addUser(user);
		} catch (Exception e) {
			return "";
		}
		return "User Save Successful";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public UserService getUserService() {
		return userService;
	}

}
