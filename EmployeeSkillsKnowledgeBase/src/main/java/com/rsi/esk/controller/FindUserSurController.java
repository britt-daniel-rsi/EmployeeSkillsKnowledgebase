package com.rsi.esk.controller;

import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = BaseController.BASE_MAPPING +
BaseController.PAGES_FIND_USER_SUR)
public class FindUserSurController extends BaseController {
    @Autowired
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String view(Map<String, Object> model, String surname) {
        List<User> userList = userService.SurSearch(surname);
        model.put("userList", userList);

        System.out.println("gaa");

        return PAGES_FIND_USER_SUR;
    }
}
