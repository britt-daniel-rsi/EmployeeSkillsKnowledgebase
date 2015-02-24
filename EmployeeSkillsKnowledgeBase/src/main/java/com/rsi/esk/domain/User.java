package com.rsi.esk.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="dbo.contacts")
public class User {
	public User() {
			}
	public User(String username, String surname, String sex, Date birthDate) {
		this.username=username;
		this.surname=surname;
		this.sex=sex;
		this.birthDate=birthDate;
	}
	@Id
	@Column(name="contactId",length=50)
	private Integer id;

	@NotNull
	@Column(name="name")
	private String username;
    
	@NotNull
	@Column(name="surname",length=50)
	private String surname;
	
    public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@NotNull
	@Column(name="birthdate")
    private Date birthDate;
    
    @Column(name="contactCreateDate")
    private Date createDate;
    
    @Column(name="sex",length=1)
	private String sex;
    
    @Column(name="contactdesc")
    private String phoneTypeDesc;

//    private String password;
//    private String email;
//    private String profession;
    
	public String getPhoneTypeDesc() {
		return phoneTypeDesc;
	}
	public void setPhoneTypeDesc(String phoneTypeDesc) {
		this.phoneTypeDesc = phoneTypeDesc;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getId() {
		return id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
//	public String getProfession() {
//		return profession;
//	}
//	public void setProfession(String profession) {
//		this.profession = profession;
//	}
}
