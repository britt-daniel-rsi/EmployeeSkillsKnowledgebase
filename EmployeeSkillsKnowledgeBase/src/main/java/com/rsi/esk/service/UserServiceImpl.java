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
	
	@Override
	public Long save(User user) {
		userDao.save(user);
		
		return user.getId();
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id);
	}
		
}
