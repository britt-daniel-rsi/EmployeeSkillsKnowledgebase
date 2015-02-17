package com.rsi.esk.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsi.esk.dao.UserDao;
import com.rsi.esk.domain.User;

//@Component
@Service
public class UserService {
	
	private UserDao userDao;
	 
	public UserDao getUserDao() {
	return userDao;
	}
	 
	@Autowired
	public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
	}
	 
	public void addUser(User user) {
	//if(user.getId() != null && user.getId() > 0) {
	user.setId(userDao.getMaxId()+ 1);
	user.setCreateDate(Calendar.getInstance().getTime());	
	System.out.println(user.getId());
	getUserDao().save(user);
	}
	 
	public List<User> getAllUsers() {
	return getUserDao().list();
	}
	
	public List<User> SurSearch(String surname) {
		return getUserDao().SurnameSearch(surname);
		}
	
	public List<User> IdSearch(Integer id) {
		return getUserDao().IdSearch(id);
		}
	
}
