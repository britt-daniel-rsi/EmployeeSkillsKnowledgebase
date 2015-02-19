package com.rsi.esk.controller;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.stereotype.Controller;

import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;
import com.rsi.esk.domain.User;
import com.rsi.esk.service.UserService;

@Controller
@ManagedBean(name="saveUserController", eager=true)
public class SaveUserController extends BaseController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{userService}")
	private UserService userService;
	
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String addUser() {
		try{
			User user = new User(username, surname, sex, birthDate);
			userService.addUser(user);
		}
		catch(Exception e){
			System.err.println("Not all attributes set...");
		}
		return "listUsers";
	}
	
	private String username;
	private String surname;
	private String sex;
	private Date birthDate;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	/*private String pageName = "stir";	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();
        model.put("userForm", userForm);
        model.put("pageName", pageName);
        
         
        List<String> professionList = new ArrayList<>();
        professionList.add("Developer");
        professionList.add("Designer");
        professionList.add("IT Manager");
        model.put("professionList", professionList);
         
        return PAGES_SAVE_USER;
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user, BindingResult result,
            SessionStatus state, Map<String, Object> model) {
         
        // implement your own registration logic here...
         
         userService.addUser(user);
        // for testing purpose:
//        System.out.println("username: " + user.getUsername());
//        System.out.println("password: " + user.getPassword());
//        System.out.println("email: " + user.getEmail());
//        System.out.println("birth date: " + user.getBirthDate());
//        System.out.println("profession: " + user.getProfession());
         
        return PAGES_REGISTRATION_SUCCESS;
    }*/
	
}
