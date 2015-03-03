package com.rsi.esk.controller;

import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;
import com.rsi.esk.util.NumberUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@Controller
@ManagedBean(name = "searchController", eager = true)
@RequestScoped
public class SearchController extends BaseController implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManagedProperty(value = "#{userService}")
    private UserService userService;
    List<User> userList;
    String surname;
    Integer id;
    private DateFormat df = new SimpleDateFormat("E, dd MMM yyyy ");
    
    
    public String getBirthDateString(Timestamp birth) {		
		return df.format(birth);
	}
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void search() { 
    	if (NumberUtils.hasInteger(id)) {
            userList = userService.IdSearch(id);
        } else if (!StringUtils.isEmpty(surname)) {
            userList = userService.SurSearch(surname);
        } else {
            userList = userService.getAllUsers();
        }
    }
}
