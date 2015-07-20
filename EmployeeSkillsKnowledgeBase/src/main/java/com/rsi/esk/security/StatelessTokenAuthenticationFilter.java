package com.rsi.esk.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.rsi.esk.service.TokenAuthenticationService;
import com.rsi.esk.util.Constants;


@Component(value = Constants.SECURITY_STATELESS_TOKEN_AUTH_FILTER)
public class StatelessTokenAuthenticationFilter extends GenericFilterBean {

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null) {
            tokenAuthenticationService
                    .addAuthentication((HttpServletResponse) response, SecurityContextHolder.getContext().getAuthentication());
        }

        chain.doFilter(request, response); // continue always
    }
}
