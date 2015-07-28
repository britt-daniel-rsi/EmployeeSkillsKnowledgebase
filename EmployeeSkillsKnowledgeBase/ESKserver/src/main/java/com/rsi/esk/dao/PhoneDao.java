package com.rsi.esk.dao;

import java.util.List;

import com.rsi.esk.domain.Phone;

public interface PhoneDao {
	Long getMaxId();

	void save(Phone phone);


	List<Phone> list();
}
