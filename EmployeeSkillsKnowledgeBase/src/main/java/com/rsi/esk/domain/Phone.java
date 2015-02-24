package com.rsi.esk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "dbo.phonenumber")
public class Phone {
    @Id
    @Column(name = "phoneId")
    private Integer Id;
    @NotNull
    @Column(name = "contactId")
    private Integer ContactId;
    @NotNull
    @Column(name = "phonenumber")
    private String number;
    @Column(name = "idphonenumbertype")
    private PhoneType phoneType;

    // dbo.phonenumber

    // phoneId (id, int)
    // contactId (int)
    // phonenumber (string 50)
    // idphonenumbertype (int)
    public Phone() {
    }

    public Phone(Integer contactId, String phoneNumber, PhoneType phoneType) {
        this.ContactId = contactId;
        this.number = phoneNumber;
        this.phoneType = phoneType;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getContactId() {
        return ContactId;
    }

    public void setContactId(Integer contactId) {
        ContactId = contactId;
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
}
