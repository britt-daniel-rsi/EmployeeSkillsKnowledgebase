package com.rsi.esk.service;

import com.rsi.esk.dao.EmployeeDao;
import com.rsi.esk.domain.Employee;

import java.io.Serializable;

import java.util.Calendar;
import java.util.List;


public class EmployeeServiceImpl implements EmployeeService, Serializable {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void addEmployee(Employee employee) {
        employee.setCreateDate(Calendar.getInstance().getTime());
        System.out.println(employee.getId());
        getEmployeeDao().save(employee);
    }

    public List<Employee> getAllEmployees() {
        return getEmployeeDao().list();
    }

    public List<Employee> SurSearch(String surname) {
        return getEmployeeDao().SurnameSearch(surname);
    }

    public List<Employee> IdSearch(Integer id) {
        return getEmployeeDao().IdSearch(id);
    }
}
