package com.rsi.esk.service;

import com.rsi.esk.domain.Employee;
import com.rsi.esk.service.SerializationHandler;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class ListEmployees extends SerializationHandler {
    private static final long serialVersionUID = 1L;
    @Autowired
    transient EmployeeService employeeService;

    public List<Employee> listEmployees() {
        return employeeService.getAllEmployees();
    }
}
