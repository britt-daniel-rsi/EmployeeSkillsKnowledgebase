package com.rsi.esk.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.rsi.esk.domain.User;
import com.rsi.esk.security.TokenHandler;
import com.rsi.esk.util.AuthenticationUtils;

@Service
public class TokenAuthenticationServiceImpl implements
		TokenAuthenticationService {

	private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";

	private final TokenHandler tokenHandler;

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public TokenAuthenticationServiceImpl(@Value("${token.secret}") String tokenSecret) {
		tokenHandler = new TokenHandler(
				DatatypeConverter.parseBase64Binary(tokenSecret));
	}

	@Override
	public void addAuthentication(HttpServletResponse response,
			Authentication authentication) {

		final UserDetails user = (UserDetails) authentication.getPrincipal();
		response.addHeader(AUTH_HEADER_NAME, tokenHandler
				.createTokenForUser(AuthenticationUtils.toUserDetail(user)));
	}

	@Override
	public Authentication getAuthentication(HttpServletRequest request) {
		final String token = request.getHeader(AUTH_HEADER_NAME);

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();

		if (authentication == null) {
			if (token != null) {
				final User user = tokenHandler.parseUserFromToken(token);
				if (user != null) {
					User details = userService.loadUserByUsername(user
							.getUserName());
					authentication = new UsernamePasswordAuthenticationToken(
							details, null, details.getAuthorities());
				}
			}
		}

		return authentication;
	}
}
