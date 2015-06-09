package com.rsi.esk.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.Employee;
import com.rsi.esk.domain.SkillType;
import com.rsi.esk.domain.User;
import com.rsi.esk.service.SkillTypeService;
import com.rsi.esk.service.UserService;

//TODO change to userServices not employee

@Controller
@ManagedBean(name = "adminController", eager = true)
public class AdminController extends BaseController{
	@ManagedProperty(value = "#{skillTypeService}")
	private SkillTypeService skillTypeService;
    @ManagedProperty(value = "#{userService}")
    private UserService userService;
    private Employee employee;
    private SkillType skillType;
	private User user;
	private String userName;
	private String password;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setSkillTypeService(SkillTypeService skillTypeService) {
        this.skillTypeService = skillTypeService;
    }

	public void addUser(User user) {
		this.user=user;
    }

	public void addSkill(SkillType skill){
		this.skillType = skillType;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;//user.setUserName(userName);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;//user.setPassword(password);
	}
}
