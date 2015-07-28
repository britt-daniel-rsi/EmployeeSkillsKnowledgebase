package com.rsi.esk.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rsi.esk.domain.User;


public interface UserService extends UserDetailsService {

    User loadUserByUserId(String userId);
    User loadUserByUsername(String username);

	Long saveOrUpdate(User user);
	
	List<User> list();

	Long count();
}