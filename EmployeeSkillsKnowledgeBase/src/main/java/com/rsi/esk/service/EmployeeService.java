package com.rsi.esk.service;

import com.rsi.esk.dao.EmployeeDao;
import com.rsi.esk.domain.Employee;

import java.util.List;


public interface EmployeeService {
    EmployeeDao getEmployeeDao();

    void setEmployeeDao(EmployeeDao employeeDao);

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    List<Employee> SurSearch(String surname);

    List<Employee> IdSearch(Integer id);
}
