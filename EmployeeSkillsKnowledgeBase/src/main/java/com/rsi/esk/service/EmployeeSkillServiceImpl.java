package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.dao.EmployeeSkillDao;
import com.rsi.esk.domain.EmployeeSkill;

public class EmployeeSkillServiceImpl implements EmployeeSkillService{
    private EmployeeSkillDao employeeSkillDao;

    @Override
	public EmployeeSkillDao getEmployeeSkillDao() {
        return employeeSkillDao;
    }

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

	@Override
	public void setEmployeeSkillDao(EmployeeSkillDao employeeSkillDao) {
		// TODO Auto-generated method stub
		
	}
}
