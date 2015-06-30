package com.rsi.esk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;

import com.rsi.esk.dao.UserDao;
import com.rsi.esk.domain.User;
import com.rsi.esk.util.NumberUtils;

@Component()
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
	public Long saveOrUpdate(User user) {
		if (!NumberUtils.hasLong(user.getId())) {
			user.setId(userDao.getNextId());
		}
		StandardPasswordEncoder pwe = new StandardPasswordEncoder();
		String password = user.getUserPassword();
		user.setUserPassword(pwe.encode(password));
		userDao.saveOrUpdate(user);

		return user.getId();
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id);
	}

}
