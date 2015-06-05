package com.rsi.esk.dao;

import java.util.List;

import com.rsi.esk.domain.User;

public interface UserDao {

	Long getMaxId();

	void save(User user);

	List<User> list();

	List<User> userNameSearch(String userName);

	Boolean checkPassword(String userName, String password);

	List<User> IdSearch(Long id);

}