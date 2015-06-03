package com.rsi.esk.controller;

import com.rsi.esk.domain.Employee;
import com.rsi.esk.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = BaseController.BASE_MAPPING +
BaseController.PAGES_FIND_EMPLOYEE_SUR)
public class FindEmployeeSurController extends BaseController {
    @Autowired
    EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String view(Map<String, Object> model, String surname) {
        List<Employee> employeeList = employeeService.SurSearch(surname);
        model.put("employeeList", employeeList);

        System.out.println("gaa");

        return PAGES_FIND_EMPLOYEE_SUR;
    }
}
