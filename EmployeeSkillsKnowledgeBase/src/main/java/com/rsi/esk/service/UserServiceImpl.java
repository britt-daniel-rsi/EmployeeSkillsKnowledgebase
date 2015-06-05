package com.rsi.esk.service;

import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;

import com.rsi.esk.dao.UserDao;
import com.rsi.esk.domain.User;

public class UserServiceImpl implements UserService {
	
    private UserDao userDao;

	@Override
	public UserDao getUserDao() {
        return userDao;
    }

	@Override
	public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

	@Override
	public void addUser(User user) {
        user.setId(userDao.getMaxId() + 1);
        System.out.println(user.getId());
        getUserDao().save(user);
    }

	@Override
	public List<User> getAllUsers() {
        return getUserDao().list();
    }

	@Override
	public List<User> userNameSearch(String userName) {
        return getUserDao().userNameSearch(userName);
    }

	@Override
	public List<User> IdSearch(Integer id) {
        return getUserDao().IdSearch(id);
    }

	@Override
	public boolean validate(String username, String password) {
		if(password.equals("") || password == null){
			return false;
		}
		if(getUserDao().checkPassword(username, password)){
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
