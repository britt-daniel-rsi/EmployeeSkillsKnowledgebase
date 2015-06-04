package com.rsi.esk.controller;

import com.rsi.esk.converter.DevCenterConverter;
import com.rsi.esk.converter.PhoneTypeConverter;
import com.rsi.esk.domain.DevCenter;
import com.rsi.esk.domain.Phone;
import com.rsi.esk.domain.PhoneType;
import com.rsi.esk.domain.Employee;
import com.rsi.esk.service.DevCenterService;
import com.rsi.esk.service.PhoneService;
import com.rsi.esk.service.PhoneTypeService;
import com.rsi.esk.service.EmployeeService;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@Controller
@ManagedBean(name = "saveEmployeeController", eager = true)
@SessionScoped
public class SaveEmployeeController extends BaseController {
    @ManagedProperty(value = "#{employeeService}")
    private EmployeeService employeeService;
    @ManagedProperty(value = "#{phoneTypeService}")
    private PhoneTypeService phoneTypeService;
    @ManagedProperty(value = "#{phoneService}")
    private PhoneService phoneService;
    @ManagedProperty(value="#{devCenterService}")
    private DevCenterService devCenterService;
    
    private Employee employee = new Employee();
    private List<Phone> phones;
    private Map<String, PhoneType> phoneTypes;
    
    private List<DevCenter> devCenters;
    private Map<String, DevCenter> devCenterMap;

    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
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

    public void saveEmployee() {
    	System.out.println("Save Employee clicked!");
        try {
            employeeService.addEmployee(employee);

            for (Phone phone : phones) {
                phone.setEmployee(employee);
                phoneService.save(phone);
            }
        } catch (Exception e) {
        	System.out.println("Error!");
        }
    }
    
    public List<DevCenter> getDevCenters() {
    	if(devCenters == null) {
    		devCenters = devCenterService.getAllDevCenters();
    	}
    	return devCenters;
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
    
    public Map<String, DevCenter> getDevCenterMap() {
    	if(devCenterMap == null) {
    		devCenterMap = new HashMap<String, DevCenter>();
    		for (DevCenter center : getDevCenters()) {
    			devCenterMap.put(center.getName(), center);
    		}
    	}
    	return devCenterMap;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public DevCenterService getDevCenterService() {
		return devCenterService;
	}

	public void setDevCenterService(DevCenterService devCenterService) {
		this.devCenterService = devCenterService;
	}
	
	public DevCenterConverter getDevCenterConverter() {
		return new DevCenterConverter(getDevCenters());
	}
	
	public PhoneTypeConverter getPhoneTypeConverter() {
		return new PhoneTypeConverter(getPhoneTypeService());
	}
}
