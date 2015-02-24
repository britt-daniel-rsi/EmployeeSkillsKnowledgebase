package com.rsi.esk.service;

import java.io.Serializable;
import java.util.List;

import com.rsi.esk.dao.PhoneDao;
import com.rsi.esk.domain.Phone;

public class PhoneServiceImpl implements PhoneService, Serializable {
	private static final long serialVersionUID = 1L;
	
	private PhoneDao phoneDao;

	public PhoneDao getPhoneDao() {
		return phoneDao;
	}
	public void setPhoneDao(PhoneDao phoneDao) {
		this.phoneDao = phoneDao;
	}

	public void save(Phone phone) {
		phone.setId(phoneDao.getMaxId() + 1);
		
		System.out.println(phone.getId());
		getPhoneDao().save(phone);
	}
	
	public List<Phone> getPhones() {
		return getPhoneDao().list();
	}	
}
