package com.rsi.esk.criteria;

import org.springframework.beans.factory.annotation.Autowired;

import com.rsi.esk.domain.Employee;
import com.rsi.esk.domain.SkillType;
import com.rsi.esk.service.EmployeeService;
import com.rsi.esk.service.SkillTypeService;

//TODO change to userServices not employee

public class AdminCriteria{
	@Autowired
	private SkillTypeService skillTypeService;
	@Autowired
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
