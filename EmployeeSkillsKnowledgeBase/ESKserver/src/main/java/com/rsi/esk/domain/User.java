package com.rsi.esk.domain;

import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "esk_user", schema = "esk")
public class User implements UserDetails{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "user_id")
	private Long id;

	@Column(name = "create_timestamp")
	private Date createDate;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@NotNull
	@JsonIgnore
	@Column(name = "user_password")
	private String userPassword;

	@NotNull
	@Size(min = 4, max = 30)
	@Column(name = "user_name")
	private String userName;
	
	@NotNull
	@Column(name="status")
	private Long status;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<UserAuthority> authorities;
	
	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public void setAuthorities(Set<UserAuthority> authorities) {
		this.authorities = authorities;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Set<UserAuthority> getAuthorities() {
		return authorities;
	}

	// Use Roles as external API
	public Set<UserRole> getRoles() {
		Set<UserRole> roles = EnumSet.noneOf(UserRole.class);
		if (authorities != null) {
			for (UserAuthority authority : authorities) {
				roles.add(UserRole.valueOf(authority));
			}
		}
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		for (UserRole role : roles) {
			grantRole(role);
		}
	}

	public void grantRole(UserRole role) {
		if (authorities == null) {
			authorities = new HashSet<UserAuthority>();
		}
		authorities.add(role.asAuthorityFor(this));
	}

	public void revokeRole(UserRole role) {
		if (authorities != null) {
			authorities.remove(role.asAuthorityFor(this));
		}
	}

	public boolean hasRole(UserRole role) {
		return authorities.contains(role.asAuthorityFor(this));
	}

	public String toString() {
		return getClass().getSimpleName() + ": " + getUserName();
	}

	@JsonIgnore
	public String getUserPassword() {
		return userPassword;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return userPassword;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
