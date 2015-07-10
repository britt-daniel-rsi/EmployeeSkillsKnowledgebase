package com.rsi.esk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "esk", name = "employee")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "employee_id")
	private Long id;
	@NotNull
	@Column(name = "name")
	private String name;
	@NotNull
	@Column(name = "surname")
	private String surname;
	@NotNull
	@Column(name = "birthdate")
	private Date birthDate;
	@Column(name = "sex")
	private String sex;
	@ManyToOne
	@JoinColumn(name = "dev_center_id")
	private DevCenter devCenter;
	@Column(name = "description")
	private String description;
	@Column(name = "create_timestamp")
	private Date createDate;
	@OneToMany( mappedBy = "employee")
	private List<Phone> phoneList;

	public Employee() {
	}

	public Employee(String name, String surname, String sex, Date birthDate) {
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.birthDate = birthDate;
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

	public Long getId() {
		return id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DevCenter getDevCenter() {
		return devCenter;
	}

	public void setDevCenter(DevCenter devCenter) {
		this.devCenter = devCenter;
	}

	public List<Phone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}
}
