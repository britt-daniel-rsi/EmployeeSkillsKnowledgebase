package com.rsi.esk.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.dom4j.tree.AbstractEntity;

@Entity
@Table(name = "esk_user", schema = "esk")
public class User extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "user_id")
	private Long id;
	@NotNull
	@Column(name = "user_name")
	private String userName;
	@NotNull
	@Column(name = "user_password")
	private String userPassword;
	
	@OneToMany(mappedBy = "user")
	private Set<UserRole> roles;

	@Column(name = "create_timestamp")
	private Date createDate;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

}
