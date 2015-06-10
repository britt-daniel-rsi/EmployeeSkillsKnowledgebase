package com.rsi.esk.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.Employee;
import com.rsi.esk.domain.Phone;
import com.rsi.esk.domain.PhoneType;
import com.rsi.esk.service.EmployeeService;
import com.rsi.esk.service.PhoneService;
import com.rsi.esk.service.PhoneTypeService;


@Controller
public class ListEmployeeController extends BaseController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private PhoneTypeService phoneTypeService;
    private List<Phone> phoneList;
    private Map<String, PhoneType> phoneTypes;
    private DateFormat df = new SimpleDateFormat("E, dd MMM yyyy ");

    public String getBirthDateString(Timestamp birth) {
        return df.format(birth);
    }

    public String getBirthDateString(Date birth) {
        return df.format(birth);
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    public void setPhoneTypeService(PhoneTypeService phoneTypeService) {
        this.phoneTypeService = phoneTypeService;
    }

    public List<Employee> getEmployeeList() {
        return employeeService.getAllEmployees();
    }

    public List<Phone> getPhoneList() {
    	if(phoneList == null) {
            phoneList = phoneService.getPhones();
    	}

        return phoneList;
    }

    public List<Object> getComboList() {
        List<Object> comboList = new ArrayList<Object>();
        comboList.addAll(getEmployeeList());
        comboList.addAll(getPhoneList());

        return comboList;
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
    
    
}
