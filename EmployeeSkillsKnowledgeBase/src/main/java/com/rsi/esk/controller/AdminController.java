package com.rsi.esk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.SkillType;
import com.rsi.esk.domain.User;
import com.rsi.esk.service.SkillTypeService;
import com.rsi.esk.service.UserService;

@Controller
public class AdminController extends BaseController {
	@Autowired
	private SkillTypeService skillTypeService;

	@Autowired
	private UserService userService;
	
	private SkillType skillType = new SkillType();
	private User user = new User();

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setSkillTypeService(SkillTypeService skillTypeService) {
		this.skillTypeService = skillTypeService;
	}

	public void addUser(User user) {
		userService.addUser(user);
	}

	public void addSkill() {
		skillTypeService.addSkill(skillType);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public SkillTypeService getSkillTypeService() {
		return skillTypeService;
	}

	public UserService getUserService() {
		return userService;
	}

}
