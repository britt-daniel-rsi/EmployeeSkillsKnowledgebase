package com.rsi.esk.controller;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

public class BaseController {
    public static final String BASE_MAPPING = "/";
    public static final String PAGES_SAVE_EMPLOYEE = "saveEmployee";
    public static final String PAGES_REGISTRATION_SUCCESS = "registrationSuccess";
    public static final String PAGES_LIST_EMPLOYEES = "listEmployees";
    public static final String PAGES_FIND_EMPLOYEE_SUR = "FindEmployeeSur";
    public static final String PAGES_FIND_EMPLOYEE_ID = "FindEmployeeId";
    public static final String PAGES_SEARCH = "search";
    public static final String PAGES_ADMIN = "Admin";
    
	@Context
	protected UriInfo uriInfo;
}
