package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.dao.EmployeeSkillDao;
import com.rsi.esk.domain.EmployeeSkill;

public interface EmployeeSkillService {

	public void save(EmployeeSkill employeeSkill);

	public List<EmployeeSkill> getEmployeeSkills();

}