package com.rsi.esk.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.rsi.esk.dao.UserDao;
import com.rsi.esk.domain.UserRole;

@Component("userService")
public class UserServiceImpl implements UserDetailsService {

	
	@Autowired
    private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		com.rsi.esk.domain.User user = userDao.findByUserName(userName);
		
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());
		
		return buildUserForAuthentication(user, authorities);
	}
	
	private UserDetails buildUserForAuthentication(com.rsi.esk.domain.User user, 
			List<GrantedAuthority> authorities) {
			return new User(user.getUserName(), user.getUserPassword(), 
				user.isActive(), true, true, true, authorities);
		}
	 
		private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
	 
			Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	 
			// Build user's authorities
			for (UserRole userRole : userRoles) {
				setAuths.add(new SimpleGrantedAuthority(userRole.getAccessLevel().getDescription()));
			}
	 
			List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
	 
			return Result;
		}
}
