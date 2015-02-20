package com.rsi.esk.domain;

public class Phone {
	//dbo.phonenumber
	
	//phoneId  (id, int)
	//contactId (int)
	//phonenumber (string 50)
	//idphonenumbertype (int)


	private String number;
	private PhoneType phoneType;

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



}
