package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.dao.PhoneTypeDao;
import com.rsi.esk.domain.PhoneType;

public class PhoneTypeServiceImpl implements PhoneTypeService{

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
	
}
