package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.dao.DevCenterDaoImpl;
import com.rsi.esk.domain.DevCenter;

public class DevCenterServiceImpl implements DevCenterService {

	
	private DevCenterDaoImpl devCenterDao;

	@Override
	public List<DevCenter> getAllDevCenters() {
		return devCenterDao.list();
	}

	@Override
	public void addCenter(DevCenter center) {
		devCenterDao.save(center);
	}

	public DevCenterDaoImpl getDevCenterDao() {
		return devCenterDao;
	}

	public void setDevCenterDao(DevCenterDaoImpl devCenterDao) {
		this.devCenterDao = devCenterDao;
	}

	
	
	
}
