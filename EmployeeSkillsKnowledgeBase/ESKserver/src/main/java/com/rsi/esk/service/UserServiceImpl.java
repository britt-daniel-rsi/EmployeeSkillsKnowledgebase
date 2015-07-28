package com.rsi.esk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rsi.esk.dao.UserDao;
import com.rsi.esk.domain.User;
import com.rsi.esk.util.NumberUtils;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User loadUserByUsername(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public Long saveOrUpdate(User user) {
		if (!NumberUtils.hasLong(user.getId())) {
			user.setId(userDao.getNextId());
		}
		
		userDao.saveOrUpdate(user);

		return user.getId();
	}

	@Override
	public User loadUserByUserId(String id) {
		return userDao.findById(Long.parseLong(id));
	}
	
	@Override
	public List<User> list() {
		return userDao.list();
	}

	
	@Override
	public Long count() {
		return userDao.count();
	}

}
