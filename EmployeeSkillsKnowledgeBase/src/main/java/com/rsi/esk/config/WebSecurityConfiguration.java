package com.rsi.esk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rsi.esk.service.UserService;

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
 
  @Autowired
  UserService userService;
 
  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService());
  }
 
  @Bean
  UserDetailsService userDetailsService() {
    return new UserDetailsService() {
 
      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.rsi.esk.domain.User user = userService.findByUserName(username);
        if(user != null) {
        return new User(user.getUserName(), user.getUserPassword(), true, true, true, true,
                AuthorityUtils.createAuthorityList("USER"));
        } else {
          throw new UsernameNotFoundException("could not find the user '"
                  + username + "'");
        }
      }
      
    };
  }
}
