package com.rsi.esk.dao;

import com.rsi.esk.domain.User;

public interface UserDao extends BaseDao<User>{

	User findByUserName(String userName);

	Long count();

}