package com.rsi.esk.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.rsi.esk.dao")
public class DaoConfig {

	@Bean
	public EmployeeDao employeeDao() {
		return new EmployeeDaoImpl();
	}

	@Bean
	public EmployeeSkillDao employeeSkillDao() {
		return new EmployeeSkillDaoImpl();
	}

	@Bean
	public DevCenterDao devCenterDao() {
		return new DevCenterDaoImpl();
	}

	@Bean
	public PhoneTypeDao phoneTypeDao() {
		return new PhoneTypeDaoImpl();
	}

	@Bean
	public SkillTypeDao skillTypeDao() {
		return new SkillTypeDaoImpl();
	}

	@Bean
	public PhoneDao phoneDao() {
		return new PhoneDaoImpl();
	}
}

