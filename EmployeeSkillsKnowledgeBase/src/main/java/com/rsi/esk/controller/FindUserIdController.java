package com.rsi.esk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;

@Controller
@RequestMapping(value = BaseController.BASE_MAPPING + BaseController.PAGES_FIND_USER_ID)
public class FindUserIdController extends BaseController {

	@Autowired
	UserService userService;

		public void setUserService(UserService userService) {
		this.userService = userService;
	}

		@RequestMapping(method = RequestMethod.GET)
	    public String view(Map<String, Object> model, Integer id) {
	        List<User> userList = userService.IdSearch(id);  
	        model.put("userList", userList);

	        System.out.println("gaa");
	        return PAGES_FIND_USER_ID;
	    }
}
