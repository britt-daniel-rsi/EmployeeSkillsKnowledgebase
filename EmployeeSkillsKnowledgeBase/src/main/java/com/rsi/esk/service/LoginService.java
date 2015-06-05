package com.rsi.esk.service;

import com.rsi.esk.dao.LoginDao;

public interface LoginService { //All of this code will be in UserService.
	LoginDao getLoginDao();
    void setLoginDao(LoginDao LoginDao);
	boolean validate(String username, String password);
}
