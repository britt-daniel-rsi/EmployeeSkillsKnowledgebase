package com.rsi.esk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


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
    @Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}")
    @Column(name = "phonenumber")
    private String number;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idphonenumbertype")
    private PhoneType phoneType;
    
    public Phone() {
    }

    public Phone(String phoneNumber, PhoneType phoneType) {        
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
