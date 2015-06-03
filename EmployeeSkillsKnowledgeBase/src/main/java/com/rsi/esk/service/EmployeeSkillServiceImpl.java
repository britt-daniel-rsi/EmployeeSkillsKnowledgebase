package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.dao.EmployeeSkillDao;
import com.rsi.esk.dao.EmployeeSkillDaoImpl;
import com.rsi.esk.domain.EmployeeSkill;

public class EmployeeSkillServiceImpl implements EmployeeSkillService {
	
    private EmployeeSkillDao employeeSkillDao;

    @Override
	public void save(EmployeeSkill employeeSkill) {
    	employeeSkill.setId(employeeSkillDao.getMaxId() + 1);

        System.out.println(employeeSkill.getId());
        getEmployeeSkillDao().save(employeeSkill);
    }

    @Override
	public List<EmployeeSkill> getEmployeeSkills() {
        return getEmployeeSkillDao().list();
    }

	public EmployeeSkillDao getEmployeeSkillDao() {
		return employeeSkillDao;
	}

	public void setEmployeeSkillDao(EmployeeSkillDao employeeSkillDao) {
		this.employeeSkillDao = employeeSkillDao;
	}
}
