package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.dao.PhoneDao;
import com.rsi.esk.dao.PhoneTypeDao;
import com.rsi.esk.domain.Phone;

public interface PhoneService {
	
	PhoneDao getPhoneDao();
	
	void setPhoneDao (PhoneDao phoneDao);	
	
	void save(Phone phone);
	
	List<Phone> getPhones();
}
