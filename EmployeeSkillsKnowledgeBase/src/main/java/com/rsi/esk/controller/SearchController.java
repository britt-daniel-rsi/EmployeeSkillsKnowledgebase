package com.rsi.esk.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.rsi.esk.domain.SearchCriteria;
import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;
import com.rsi.esk.util.NumberUtils;

@Controller
@RequestMapping(value = BaseController.BASE_MAPPING + BaseController.PAGES_SEARCH)
public class SearchController extends BaseController {

	@Autowired
	UserService userService;

		public void setUserService(UserService userService) {
		this.userService = userService;
	}
		@RequestMapping(method = RequestMethod.GET)
		public String search(Map<String, Object> model) {
			SearchCriteria search = new SearchCriteria();
			List<User> userList = new ArrayList<User>();  
	        model.put("userList", userList);
			model.put("search", search);
			return PAGES_SEARCH;
		}
		
		@RequestMapping(method = RequestMethod.POST)
	    public String view(@ModelAttribute("search") SearchCriteria search, BindingResult result,
	            SessionStatus state, Map<String, Object> model) {
			List<User> userList = new ArrayList<User>();
			NumberUtils num = new NumberUtils();
			if(num.hasInteger(search.getId()) == true) {
				userList=userService.IdSearch(search.getId());
			}
			else if(StringUtils.isNotEmpty(search.getSurname())) {
				userList=userService.SurSearch(search.getSurname());
			}
			else {
				userList=userService.getAllUsers();
			}
			model.put("userList", userList);
	        return PAGES_SEARCH;
	    }
}