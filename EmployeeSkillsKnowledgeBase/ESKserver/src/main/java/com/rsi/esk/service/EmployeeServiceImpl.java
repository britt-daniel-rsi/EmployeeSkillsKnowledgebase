package com.rsi.esk.service;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rsi.esk.dao.EmployeeDao;
import com.rsi.esk.domain.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService, Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void addEmployee(Employee employee) {
		employee.setCreateDate(Calendar.getInstance().getTime());
		System.out.println(employee.getId());
		employeeDao.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeDao.list();
	}

	public List<Employee> SurSearch(String surname) {
		return employeeDao.SurnameSearch(surname);
	}

	public List<Employee> IdSearch(Long id) {
		return employeeDao.IdSearch(id);
	}

}
