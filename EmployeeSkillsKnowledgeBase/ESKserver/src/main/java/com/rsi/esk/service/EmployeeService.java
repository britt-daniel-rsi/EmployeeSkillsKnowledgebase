package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.domain.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	List<Employee> SurSearch(String surname);

	List<Employee> IdSearch(Long id);
}
