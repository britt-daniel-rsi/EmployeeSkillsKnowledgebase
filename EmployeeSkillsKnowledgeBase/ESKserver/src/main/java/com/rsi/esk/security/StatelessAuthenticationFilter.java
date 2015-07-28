package com.rsi.esk.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.rsi.esk.service.TokenAuthenticationService;
import com.rsi.esk.util.Constants;

@Component(value = Constants.SECURITY_STATELESS_AUTH_FILTER)
public class StatelessAuthenticationFilter extends GenericFilterBean {

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	SecurityContextHolder.getContext().setAuthentication(
                tokenAuthenticationService.getAuthentication((HttpServletRequest) request));

        chain.doFilter(request, response); // continue always
    }
}
