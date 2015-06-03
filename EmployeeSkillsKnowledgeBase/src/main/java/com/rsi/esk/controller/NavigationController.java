package com.rsi.esk.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "navigationController", eager = true)
@SessionScoped
public class NavigationController extends BaseController implements Serializable {
    private static final long serialVersionUID = 1L;

    public String moveToListEmployeesPage() {
        return "listEmployees";
    }

    public String moveToSaveEmployeesPage() {
        return "saveEmployees";
    }

    public String moveToSearchEmployeesPage() {
        return "search";
    }

    public String getTheMoveToListEmployeesPage() {
        return "listEmployees";
    }
    
    public String moveToHomePage() {
    	return "index";
    }
    
    public String moveToLoginPage() {
    	return "login";
    }
}
