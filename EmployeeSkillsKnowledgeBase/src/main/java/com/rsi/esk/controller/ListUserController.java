package com.rsi.esk.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.commons.collections.MultiMap;
import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.Phone;
import com.rsi.esk.domain.PhoneType;
import com.rsi.esk.domain.User;
import com.rsi.esk.service.PhoneService;
import com.rsi.esk.service.PhoneTypeService;
import com.rsi.esk.service.UserService;

@Controller
@ManagedBean(name="listUserController", eager=true)
public class ListUserController extends BaseController implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{userService}")
	private UserService userService;
	@ManagedProperty(value="#{phoneService}")
	private PhoneService phoneService;
	@ManagedProperty(value = "#{phoneTypeService}")
	private PhoneTypeService phoneTypeService;
	
	private List<Phone> phoneList;
	private Map<String, PhoneType> phoneTypes;
	private String birthDateString;
	private DateFormat df = new SimpleDateFormat("E, dd MMM yyyy ");
	

	public String getBirthDateString(Timestamp birth) {		
		return df.format(birth);
	}
	public String getBirthDateString(Date birth) {
		
		return df.format(birth);
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setPhoneService(PhoneService phoneService) {
		this.phoneService = phoneService;
	}
	public void setPhoneTypeService(PhoneTypeService phoneTypeService) {
		this.phoneTypeService = phoneTypeService;
	}
	public List<User> getUserList() {
		return userService.getAllUsers();
	}
	public List<Phone> getPhoneList() {		
		phoneList = phoneService.getPhones();
		return phoneList;
	}
	public List<Object> getComboList() {
		List<Object> comboList = new ArrayList<Object>();
		comboList.addAll(getUserList());
		comboList.addAll(getPhoneList());
		return comboList;
	}
	 public Map<String, PhoneType> getPhoneTypes() {
	        if (phoneTypes == null) {
	            List<PhoneType> phoneTypeList = phoneTypeService.getPhoneTypes();
	            phoneTypes = new HashMap<String, PhoneType>();

	            for (PhoneType type : phoneTypeList) {
	                phoneTypes.put(type.getDescription(), type);
	            }
	        }

	        return phoneTypes;
	    }
	
}
