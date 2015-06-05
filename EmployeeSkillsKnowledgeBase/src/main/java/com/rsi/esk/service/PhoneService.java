package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.domain.Phone;


public interface PhoneService {

    void save(Phone phone);

    List<Phone> getPhones();
}
