package com.rsi.esk.controller;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;


@Controller
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

	public String moveToDevCentersPage() {  	
		return "devCenters";
	}

	public String moveToSaveDevCenterPage() {
		return "saveDevCenter";
	}
	
	public String moveToAdminPage() {
		return "admin";
	}
		
	public String moveToUserSettingsPage() {
		return "userSettings";
	}
}
