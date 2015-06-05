package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.dao.LoginDao;
import com.rsi.esk.dao.UserDao;
import com.rsi.esk.domain.User;

public interface UserService {

	public abstract UserDao getUserDao();

	public abstract void setUserDao(UserDao userDao);

	public abstract void addUser(User user);

	public abstract List<User> getAllUsers();

	public abstract List<User> userNameSearch(String userName);

	public abstract List<User> IdSearch(Integer id);

	public LoginDao getLoginDao();
    public void setLoginDao(LoginDao LoginDao);
	public boolean validate(String username, String password);
}