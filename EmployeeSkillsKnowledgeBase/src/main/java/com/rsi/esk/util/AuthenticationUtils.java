package com.rsi.esk.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.rsi.esk.domain.User;
import com.rsi.esk.domain.UserAuthority;

public final class AuthenticationUtils {

	public static String getUsername() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		String username = principal.toString();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}

		return username;
	}

	public static User toUserDetail(UserDetails userDetail) {
		if (userDetail == null) {
			return null;
		}
		User user = new User();
		user.setUserName(userDetail.getUsername());
		user.setAuthorities(toUserAuthorities(userDetail.getAuthorities()));
		return user;
	}

	// ========== HELPERS =========

	private static Set<UserAuthority> toUserAuthorities(
			Collection<? extends GrantedAuthority> grantedAuthorities) {
		Set<UserAuthority> userAuthorities = new HashSet<>();

		for (GrantedAuthority authority : grantedAuthorities) {
			if (authority instanceof UserAuthority) {
				userAuthorities.add((UserAuthority) authority);
			}
		}

		return userAuthorities;
	}
}