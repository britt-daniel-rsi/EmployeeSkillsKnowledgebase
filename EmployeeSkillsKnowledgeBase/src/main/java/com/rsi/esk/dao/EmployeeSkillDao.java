package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rsi.esk.domain.EmployeeSkill;

public interface EmployeeSkillDao {

	void setSessionFactory(SessionFactory sessionFactory);

	Integer getMaxId();

	void save(EmployeeSkill employeeSkill);

	List<EmployeeSkill> list();

}