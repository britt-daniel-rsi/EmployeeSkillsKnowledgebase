package com.rsi.esk.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.Employee;
import com.rsi.esk.domain.SkillType;
import com.rsi.esk.service.EmployeeService;
import com.rsi.esk.service.SkillTypeService;

//TODO change to userServices not employee

@Controller
@ManagedBean(name = "adminController", eager = true)
public class AdminController extends BaseController{
	@ManagedProperty(value = "#{skillTypeService}")
	private SkillTypeService skillTypeService;
    @ManagedProperty(value = "#{employeeService}")
    private EmployeeService employeeService;
    private Employee employee;
    private SkillType skillType;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setSkillTypeService(SkillTypeService skillTypeService) {
        this.skillTypeService = skillTypeService;
    }

    public void addEmployee(Employee employee){
    	this.employee = employee;
    }
    
	public void addSkill(SkillType skillType){
		this.skillType = skillType;
	}
	
}
