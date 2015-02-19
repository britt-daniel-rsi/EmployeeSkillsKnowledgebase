package com.rsi.esk.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="navigationController", eager=true)
@RequestScoped
public class NavigationController extends BaseController {

	public String moveToListUsersPage() {
		return "listUsers";
	}
	
	public String moveToSaveUsersPage() {
		return "saveUsers";
	}
	
	public String moveToSearchUsersPage() {
		return "searchUsers";
	}
	
}
