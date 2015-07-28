package com.rsi.esk.service;

import com.rsi.esk.domain.PhoneType;

import java.util.List;


public interface PhoneTypeService {
    List<PhoneType> getPhoneTypes();

    PhoneType getPhoneTypeByDescription(String description);

    PhoneType getPhoneTypeById(Long id);
}
