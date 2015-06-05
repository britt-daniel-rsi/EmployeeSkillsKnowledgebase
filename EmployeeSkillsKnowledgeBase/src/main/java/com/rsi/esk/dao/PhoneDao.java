package com.rsi.esk.dao;

import java.util.List;

import com.rsi.esk.domain.Phone;

public interface PhoneDao  {
	Integer getMaxId();
	
	void save(Phone phone);
	
	List<Phone> list();
}
