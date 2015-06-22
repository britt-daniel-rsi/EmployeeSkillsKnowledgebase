package com.rsi.esk.dao;

import java.util.List;

import com.rsi.esk.domain.User;

public interface UserDao {

	Long getMaxId();

	void save(User user);

	List<User> list();

	User findByUserName(String userName);

	List<User> IdSearch(Long id);

}