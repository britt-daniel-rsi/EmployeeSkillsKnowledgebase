package com.rsi.esk.dao;

public interface LoginDao {
	boolean matchUserToPass(String username, String password);
}
