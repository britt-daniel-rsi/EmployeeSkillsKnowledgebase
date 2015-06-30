package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.domain.User;


public interface UserService {

	User findByUserName(String userName);
	
	User findById(Long id);
	
	Long saveOrUpdate(User user);
	
	List<User> list();
}