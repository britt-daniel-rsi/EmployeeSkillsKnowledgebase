package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rsi.esk.domain.User;

public interface UserDao {

	void setSessionFactory(SessionFactory sessionFactory);

	Integer getMaxId();

	void save(User user);

	List<User> list();

	List<User> userNameSearch(String userName);

	List<User> IdSearch(Integer id);
	
}