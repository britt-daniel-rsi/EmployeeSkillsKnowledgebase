package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.domain.EmployeeSkill;

public interface EmployeeSkillService {

	void save(EmployeeSkill employeeSkill);

	List<EmployeeSkill> getEmployeeSkills();

}