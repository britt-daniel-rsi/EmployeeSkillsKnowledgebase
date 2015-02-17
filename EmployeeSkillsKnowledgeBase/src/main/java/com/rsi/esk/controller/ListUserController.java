package com.rsi.esk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;

@Component
@Scope("session")
//@Controller
//@RequestMapping(value = BaseController.BASE_MAPPING + BaseController.PAGES_LIST_USERS)
public class ListUserController extends BaseController {

	@Autowired
	UserService userService;

		public void setUserService(UserService userService) {
		this.userService = userService;
	}

//		@RequestMapping(method = RequestMethod.GET)
//	    public String view(Map<String, Object> model) {
//	        List<User> userList = userService.getAllUsers();  
//	        model.put("userList", userList);
//
//	        System.out.println("gaa");
//	        return PAGES_LIST_USERS;
//	    }
		public List<User> listUsers() {
	        return userService.getAllUsers();
		}
}
