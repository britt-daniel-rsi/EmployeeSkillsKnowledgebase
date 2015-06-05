package com.rsi.esk.dao;

import java.util.List;

import com.rsi.esk.domain.User;

public interface UserDao {


	public abstract Long getMaxId();

	public abstract void save(User user);

	public abstract List<User> list();

	public abstract List<User> userNameSearch(String userName);

	public abstract List<User> IdSearch(Long id);

	public abstract Boolean checkPassword(String userName, String password);

}