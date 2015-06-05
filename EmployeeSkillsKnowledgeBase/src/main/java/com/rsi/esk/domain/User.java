package com.rsi.esk.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.rsi.esk.util.EncryptionUtils;

@Entity
@Table(name = "esk_user", schema = "esk")
public class User {
	@Id
	@Column(name = "user_id")
	private Long id;
	@NotNull
	@Column(name = "user_name")
	private String userName;
	@NotNull
	@Column(name = "user_password")
	private byte[] userPassword;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "access_level_id", nullable = false)
	private transient AccessLevel accessLevel;
	@Column(name = "create_timestamp")
	private Date createDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	private transient String passwordString;

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public byte[] getUserPassword() {
		return userPassword;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSurname(String userName) {
		this.userName = userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(byte[] userPassword) {
		this.userPassword = userPassword;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) throws Exception {
		this.passwordString = passwordString;
		setUserPassword(EncryptionUtils.SHA1(passwordString));
	}
}
