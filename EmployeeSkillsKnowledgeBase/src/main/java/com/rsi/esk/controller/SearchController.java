package com.rsi.esk.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.RequestScoped;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.Employee;
import com.rsi.esk.service.EmployeeService;
import com.rsi.esk.util.NumberUtils;


@Controller
@RequestScoped
public class SearchController extends BaseController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private EmployeeService employeeService;
    List<Employee> employeeList;
    String surname;
    Long id;
    private DateFormat df = new SimpleDateFormat("E, dd MMM yyyy ");

    public String getBirthDateString(Timestamp birth) {
        return df.format(birth);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String search() {
        if (NumberUtils.hasLong(id)) {
            employeeList = employeeService.IdSearch(id);
        } else if (!StringUtils.isEmpty(surname)) {
            employeeList = employeeService.SurSearch(surname);
        } else {
            employeeList = employeeService.getAllEmployees();
        }
        return "success";
    }
}
