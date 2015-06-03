package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.dao.EmployeeSkillDao;
import com.rsi.esk.domain.EmployeeSkill;

public interface EmployeeSkillService {

	public abstract EmployeeSkillDao getEmployeeSkillDao();

	public abstract void setEmployeeSkillDao(EmployeeSkillDao employeeSkillDao);

	public abstract void save(EmployeeSkill employeeSkill);

	public abstract List<EmployeeSkill> getEmployeeSkills();

}