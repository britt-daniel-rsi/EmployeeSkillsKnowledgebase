package com.rsi.esk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rsi.esk.dao.EmployeeSkillDao;
import com.rsi.esk.domain.EmployeeSkill;

@Component
public class EmployeeSkillServiceImpl implements EmployeeSkillService {
	
	@Autowired
    private EmployeeSkillDao employeeSkillDao;

    @Override
	public void save(EmployeeSkill employeeSkill) {
    	employeeSkill.setId(employeeSkillDao.getMaxId() + 1);

        System.out.println(employeeSkill.getId());
        employeeSkillDao.save(employeeSkill);
    }

    @Override
	public List<EmployeeSkill> getEmployeeSkills() {
        return employeeSkillDao.list();
    }

	public void setEmployeeSkillDao(EmployeeSkillDao employeeSkillDao) {
		this.employeeSkillDao = employeeSkillDao;
	}
}
