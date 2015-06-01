package com.rsi.esk.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "navigationController", eager = true)
@SessionScoped
public class NavigationController extends BaseController implements Serializable {
    private static final long serialVersionUID = 1L;

    public String moveToListUsersPage() {
        return "listUsers";
    }

    public String moveToSaveUsersPage() {
        return "saveUsers";
    }

    public String moveToSearchUsersPage() {
        return "search";
    }

    public String getTheMoveToListUsersPage() {
        return "listUsers";
    }
    
    public String moveToHomePage() {
    	return "index";
    }
}
