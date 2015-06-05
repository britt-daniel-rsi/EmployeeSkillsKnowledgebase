package com.rsi.esk.service;

import java.util.Calendar;
import java.util.List;

import com.rsi.esk.dao.EmployeeDao;
import com.rsi.esk.domain.Employee;



public class EmployeeServiceImpl implements EmployeeService {
	
    private EmployeeDao employeeDao;

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void addEmployee(Employee employee) {
        //		if(employee.getId() != null && employee.getId() > 0) {
        employee.setId(employeeDao.getMaxId() + 1);
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
