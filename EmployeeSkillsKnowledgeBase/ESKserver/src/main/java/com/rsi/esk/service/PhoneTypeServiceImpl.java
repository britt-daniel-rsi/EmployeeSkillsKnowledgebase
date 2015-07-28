package com.rsi.esk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rsi.esk.dao.PhoneTypeDao;
import com.rsi.esk.domain.PhoneType;

@Component
public class PhoneTypeServiceImpl implements PhoneTypeService {
	
	@Autowired
    private PhoneTypeDao phoneTypeDao;

    public List<PhoneType> getPhoneTypes() {
        return phoneTypeDao.list();
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
