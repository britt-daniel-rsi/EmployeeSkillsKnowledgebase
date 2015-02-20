package com.rsi.esk.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.Phone;
import com.rsi.esk.domain.PhoneType;
import com.rsi.esk.domain.User;
import com.rsi.esk.service.PhoneTypeServiceImpl;
import com.rsi.esk.service.UserService;

@Controller
@ManagedBean(name = "saveUserController", eager = true)
@SessionScoped
public class SaveUserController extends BaseController implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	@ManagedProperty(value = "#{phoneTypeService}")
	private PhoneTypeServiceImpl phoneTypeService;
	
	private String username;
	private String surname;
	private String sex;
	private Date birthDate;
	
	private List<Phone> phones;
	
	private Map<String,PhoneType> phoneTypes;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	 @PostConstruct
	    public void init() {
	       phones = new ArrayList<Phone>();
	       phones.add(new Phone());
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

	public Map<String,PhoneType> getPhoneTypes() {
		if(phoneTypes == null) {
			List<PhoneType> phoneTypeList = phoneTypeService.getPhoneTypes();
			phoneTypes = new HashMap<String, PhoneType>();
			for(PhoneType type: phoneTypeList) {
				phoneTypes.put(type.getDescription(), type);
			}
		}
		return phoneTypes;
	}

	public void setPhoneTypes(Map<String,PhoneType> phoneTypes) {
		this.phoneTypes = phoneTypes;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	public void extendPhones() {
		phones.add(new Phone());
	}

	public PhoneTypeServiceImpl getPhoneTypeService() {
		return phoneTypeService;
	}

	public void setPhoneTypeService(PhoneTypeServiceImpl phoneTypeService) {
		this.phoneTypeService = phoneTypeService;
	}

}
