package com.rsi.esk.dao;


public interface LoginDao {
	public boolean matchUserToPass(String username, String password);
}
