package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.domain.User;

public interface UserService {

	void addUser(User user);

	List<User> getAllUsers();

	List<User> userNameSearch(String userName);

	List<User> IdSearch(Long id);

	boolean validate(String username, String password);

}