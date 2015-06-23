package com.rsi.esk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .httpBasic().and()
	      .authorizeRequests()
	      .antMatchers("/index.html", "/home.html", "/login.html", "/","/user/save").permitAll().anyRequest()
	      .authenticated().and().logout().and().csrf().disable();
	      //.and()
	      //.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
	      //.csrf().csrfTokenRepository(csrfTokenRepository());
  }

//  private CsrfTokenRepository csrfTokenRepository() {
//    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//    repository.setHeaderName("X-XSRF-TOKEN");
//    return repository;
//  }
}
