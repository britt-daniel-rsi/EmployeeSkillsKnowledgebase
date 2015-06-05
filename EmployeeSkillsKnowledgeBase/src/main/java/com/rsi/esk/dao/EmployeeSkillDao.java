package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rsi.esk.domain.EmployeeSkill;

public interface EmployeeSkillDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract Long getMaxId();

	public abstract void save(EmployeeSkill employeeSkill);

	public abstract List<EmployeeSkill> list();

}