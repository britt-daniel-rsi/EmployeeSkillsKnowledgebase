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

@Entity
@Table(name = "esk.user")
public class User {
	@Id
	@Column(name = "user_id")
	private Integer id;
	@NotNull
	@Column(name = "user_name")
	private String userName;
	@NotNull
	@Column(name = "user_password")
	private Byte[] userPassword;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "access_level_id", nullable = false)
	private AccessLevel accessLevel;
	@Column(name = "create_timestamp")
	private Date createDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "access_level_id", nullable = false)
	private Employee employee;

	public User() {}

	public User(String userName, Byte[] userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Integer getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public Byte[] getUserPassword() {
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSurname(String userName) {
		this.userName = userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(Byte[] userPassword) {
		this.userPassword = userPassword;
	}
}
