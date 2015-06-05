package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.dao.LoginDao;
import com.rsi.esk.dao.UserDao;
import com.rsi.esk.domain.User;

public interface UserService {

	UserDao getUserDao();

	void setUserDao(UserDao userDao);

	void addUser(User user);

	List<User> getAllUsers();

	List<User> userNameSearch(String userName);

	List<User> IdSearch(Integer id);

	LoginDao getLoginDao();

	void setLoginDao(LoginDao LoginDao);

	boolean validate(String username, String password);
}