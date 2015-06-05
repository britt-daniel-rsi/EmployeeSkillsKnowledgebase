package com.rsi.esk.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.rsi.esk.util.EncryptionUtils;

@Entity
@Table(name = "esk.esk_user")
public class User {
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @NotNull
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private byte[] userPassword;
    @NotNull
	@Column(name = "access_level_id")
    private Integer accessLevelId;
    @Column(name = "employee_id")
    private Integer employeeId;
    @NotNull
    @Column(name = "create_timestamp")
    private Date createDate;
    private transient String passwordString; 
    
   
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte[] getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(byte[] userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getAccessLevelId() {
		return accessLevelId;
	}

	public void setAccessLevelId(Integer accessLevelId) {
		this.accessLevelId = accessLevelId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) throws Exception{
		this.passwordString = passwordString;
		setUserPassword(EncryptionUtils.SHA1(passwordString));
	}
	
	
	
}
