package com.rsi.esk.service;

import com.rsi.esk.dao.LoginDao;
import com.rsi.esk.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {//All of this code will be in UserService.
	private LoginDao loginDao = new LoginDaoImpl();
	@Override
	public LoginDao getLoginDao() {
		return loginDao;
	}
	@Override
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	@Override
	public boolean validate(String username, String password) {
		if(username.equals("") || username == null || password.equals("") || password == null){
			return false;
		}
		return getLoginDao().matchUserToPass(username, password);
	}
}
