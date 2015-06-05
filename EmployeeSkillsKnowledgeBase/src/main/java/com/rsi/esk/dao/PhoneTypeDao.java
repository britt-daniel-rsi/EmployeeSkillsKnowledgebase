package com.rsi.esk.dao;

import java.util.List;

import com.rsi.esk.domain.PhoneType;

public interface PhoneTypeDao {
	
	List<PhoneType> list();
	
	PhoneType getPhoneTypeByDescription(String description);
	
	PhoneType getPhoneTypeById(Long id);
}
