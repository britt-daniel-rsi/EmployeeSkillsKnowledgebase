package com.rsi.esk.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rsi.esk.dao.PhoneDao;
import com.rsi.esk.domain.Phone;

@Component
public class PhoneServiceImpl implements PhoneService, Serializable {
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private PhoneDao phoneDao;

    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    public void save(Phone phone) {
        phone.setId(phoneDao.getMaxId() + 1);

        System.out.println(phone.getId());
        phoneDao.save(phone);
    }

    public List<Phone> getPhones() {
        return phoneDao.list();
    }
}
