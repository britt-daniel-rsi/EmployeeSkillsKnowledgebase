package com.rsi.esk.service;

import com.rsi.esk.dao.PhoneDao;
import com.rsi.esk.domain.Phone;

import java.util.List;


public interface PhoneService {
    PhoneDao getPhoneDao();

    void setPhoneDao(PhoneDao phoneDao);

    void save(Phone phone);

    List<Phone> getPhones();
}
