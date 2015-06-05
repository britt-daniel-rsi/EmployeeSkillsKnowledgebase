package com.rsi.esk.service;

import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;

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
	public void addUser(User user) {
        user.setId(userDao.getMaxId() + 1);
        System.out.println(user.getId());
        userDao.save(user);
    }

	@Override
	public List<User> getAllUsers() {
        return userDao.list();
    }

	@Override
	public List<User> userNameSearch(String userName) {
        return userDao.userNameSearch(userName);
    }

	@Override
	public List<User> IdSearch(Long id) {
        return userDao.IdSearch(id);
    }


	@Override
	public boolean validate(String username, String password) {
		if(password.equals("") || password == null){
			return false;
		}
		if(userDao.checkPassword(username, password)){
			//Establish a session
			ExternalContext externalContext = null;
			@SuppressWarnings("null")
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put("User", sessionMap);
			return true;
		}
		else{

			return false;
		}
		
	}
}
