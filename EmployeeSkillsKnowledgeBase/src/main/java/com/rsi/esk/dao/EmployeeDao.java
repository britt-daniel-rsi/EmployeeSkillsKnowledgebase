package com.rsi.esk.dao;

import java.util.List;

import com.rsi.esk.domain.Employee;

public interface EmployeeDao {

	Long getMaxId();

	void save(Employee employee);

	List<Employee> list();

	List<Employee> SurnameSearch(String surname);

	List<Employee> IdSearch(Long id);

}
