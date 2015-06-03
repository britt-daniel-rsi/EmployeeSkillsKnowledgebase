package com.rsi.esk.controller;

import com.rsi.esk.converter.PhoneTypeConverter;
import com.rsi.esk.domain.Phone;
import com.rsi.esk.domain.PhoneType;
import com.rsi.esk.domain.Employee;
import com.rsi.esk.service.PhoneService;
import com.rsi.esk.service.PhoneTypeService;
import com.rsi.esk.service.EmployeeService;

import org.springframework.stereotype.Controller;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


@Controller
@ManagedBean(name = "saveEmployeeController", eager = true)
@ViewScoped
public class SaveEmployeeController extends BaseController implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManagedProperty(value = "#{employeeService}")
    private EmployeeService employeeService;
    @ManagedProperty(value = "#{phoneTypeService}")
    private PhoneTypeService phoneTypeService;
    @ManagedProperty(value = "#{phoneService}")
    private PhoneService phoneService;
    @ManagedProperty(value = "#{phoneTypeConverter}")
    private PhoneTypeConverter phoneTypeConverter;
    private String name;
    private String surname;
    private String sex;
    private Date birthDate;
    private List<Phone> phones;
    private Map<String, PhoneType> phoneTypes;

    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    public void setPhoneTypeConverter(PhoneTypeConverter phoneTypeConverter) {
        this.phoneTypeConverter = phoneTypeConverter;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostConstruct
    public void init() {
        if (phones == null) {
            phones = new ArrayList<Phone>();
            phones.add(new Phone());
        }
    }

    public String getSaveMessage() {
    	System.out.println("Save Employee clicked!");
        try {
            Employee employee = new Employee(name, surname, sex, birthDate);

            System.out.println(phones.get(0).getPhoneType().getId());
            employeeService.addEmployee(employee);

            for (Phone phone : phones) {
                phone.setEmployee(employee);
                phoneService.save(phone);
            }
        } catch (Exception e) {
        	System.out.println("Error!");
            return "";
        }

        return "Employee Save Successful";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public Map<String, PhoneType> getPhoneTypes() {
        if (phoneTypes == null) {
            List<PhoneType> phoneTypeList = phoneTypeService.getPhoneTypes();
            phoneTypes = new HashMap<String, PhoneType>();

            for (PhoneType type : phoneTypeList) {
                phoneTypes.put(type.getDescription(), type);
            }
        }

        return phoneTypes;
    }

    public void setPhoneTypes(Map<String, PhoneType> phoneTypes) {
        this.phoneTypes = phoneTypes;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public PhoneTypeService getPhoneTypeService() {
        return phoneTypeService;
    }

    public void setPhoneTypeService(PhoneTypeService phoneTypeService) {
        this.phoneTypeService = phoneTypeService;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String extendPhones() {
    	System.out.println("Extend was clicked!");
        phones.add(new Phone());

        return null;
    }
}
