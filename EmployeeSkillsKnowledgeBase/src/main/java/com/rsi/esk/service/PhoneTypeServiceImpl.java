package com.rsi.esk.service;

import com.rsi.esk.dao.PhoneTypeDao;
import com.rsi.esk.domain.PhoneType;

import java.util.List;


public class PhoneTypeServiceImpl implements PhoneTypeService {
    private PhoneTypeDao phoneTypeDao;

    public List<PhoneType> getPhoneTypes() {
        return phoneTypeDao.list();
    }

    public PhoneTypeDao getPhoneTypeDao() {
        return phoneTypeDao;
    }

    public void setPhoneTypeDao(PhoneTypeDao phoneTypeDao) {
        this.phoneTypeDao = phoneTypeDao;
    }

    public PhoneType getPhoneTypeByDescription(String description) {
        return phoneTypeDao.getPhoneTypeByDescription(description);
    }

    public PhoneType getPhoneTypeById(Long id) {
        return phoneTypeDao.getPhoneTypeById(id);
    }
}
