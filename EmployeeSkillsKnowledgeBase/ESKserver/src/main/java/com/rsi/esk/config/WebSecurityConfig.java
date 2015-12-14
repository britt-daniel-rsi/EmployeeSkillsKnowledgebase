package com.rsi.esk.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.rsi.esk.security.StatelessAuthenticationFilter;
import com.rsi.esk.security.StatelessTokenAuthenticationFilter;
import com.rsi.esk.security.UnauthorizedEntryPoint;

@EnableWebSecurity
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    private static final String LOGOUT_URL = "/auth/logout";
    private static final String LOGOUT_SUCCESS_URL = "/auth/logout/validate?status=success";
	
    @Autowired
    private UnauthorizedEntryPoint unauthorisedEntryPoint;

    @Autowired
    private StatelessAuthenticationFilter statelessAuthenticationFilter;

    @Autowired
    private StatelessTokenAuthenticationFilter statelessTokenAuthenticationFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable();
//		.formLogin().loginPage("/#/login").permitAll()
//		.and()
        //.httpBasic()
         //   .authenticationEntryPoint(unauthorisedEntryPoint)
         //   .and()
        //.authorizeRequests()
            //.antMatchers("/**","**/*.html", "**/*.js", "**/*.css", "/webjars/**", "/index", "/home", "/login", "/", "/ESK/jersey/user/save","/user")
        //.permitAll();
//            .and()
//        .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//        .logout()
//            .logoutUrl(LOGOUT_URL)
//            .logoutSuccessUrl(LOGOUT_SUCCESS_URL)
//            .invalidateHttpSession(true)
//            .deleteCookies("JSESSIONID")
//            .and()
//        .addFilterBefore(statelessAuthenticationFilter, BasicAuthenticationFilter.class)
//        .addFilterAfter(statelessTokenAuthenticationFilter, BasicAuthenticationFilter.class);
	}


}
