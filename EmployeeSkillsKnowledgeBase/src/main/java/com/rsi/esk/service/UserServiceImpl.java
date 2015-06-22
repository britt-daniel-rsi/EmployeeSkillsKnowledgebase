package com.rsi.esk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rsi.esk.dao.UserDao;
import com.rsi.esk.domain.User;


@Component
public class UserServiceImpl implements UserService {
@Autowired
    private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}
	

	
}
