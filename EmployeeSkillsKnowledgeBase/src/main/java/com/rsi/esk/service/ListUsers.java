package com.rsi.esk.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.rsi.esk.domain.User;
import com.rsi.esk.service.SerializationHandler;

@ManagedBean
@ViewScoped
public class ListUsers extends SerializationHandler{
	private static final long serialVersionUID = 1L;

	@Autowired
	transient UserService userService;
	
	public List<User> listUsers(){
		return userService.getAllUsers();
	}
}
