package com.rsi.esk.dao;

import com.rsi.esk.domain.User;

public interface UserDao {

	Long getMaxId();

	void save(User user);

	User findByUserName(String userName);

}