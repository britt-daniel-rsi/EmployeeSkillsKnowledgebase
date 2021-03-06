package com.rsi.esk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(schema = "esk", name = "employee_phone")
public class Phone {
	@Id
	@Column(name = "phone_id", unique = true, nullable = false)
	private Long Id;
	@NotNull
	@Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}")
	@Column(name = "phone_number")
	private String number;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "phone_type_id")
	private PhoneType phoneType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	public Phone() {
	}

	public Phone(String phoneNumber, PhoneType phoneType) {
		this.number = phoneNumber;
		this.phoneType = phoneType;
	}

	public Phone(String phoneNumber) { // Constructor for test
		this.number = phoneNumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
}
