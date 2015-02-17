package com.rsi.esk.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;

@Controller
@RequestMapping(value = "/" + BaseController.PAGES_SAVE_USER)
public class SaveUserController extends BaseController{
	
	private String pageName = "stir";	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();
        model.put("userForm", userForm);
        model.put("pageName", pageName);
        
         
        List<String> professionList = new ArrayList<>();
        professionList.add("Developer");
        professionList.add("Designer");
        professionList.add("IT Manager");
        model.put("professionList", professionList);
         
        return PAGES_SAVE_USER;
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user, BindingResult result,
            SessionStatus state, Map<String, Object> model) {
         
        // implement your own registration logic here...
         
         userService.addUser(user);
        // for testing purpose:
//        System.out.println("username: " + user.getUsername());
//        System.out.println("password: " + user.getPassword());
//        System.out.println("email: " + user.getEmail());
//        System.out.println("birth date: " + user.getBirthDate());
//        System.out.println("profession: " + user.getProfession());
         
        return PAGES_REGISTRATION_SUCCESS;
    }
	
}
