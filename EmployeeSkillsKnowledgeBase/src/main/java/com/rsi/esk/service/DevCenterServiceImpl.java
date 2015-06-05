package com.rsi.esk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rsi.esk.dao.DevCenterDao;
import com.rsi.esk.domain.DevCenter;

@Component
public class DevCenterServiceImpl implements DevCenterService {

	@Autowired
	private DevCenterDao devCenterDao;

	@Override
	public List<DevCenter> getAllDevCenters() {
		return devCenterDao.list();
	}

	@Override
	public void addCenter(DevCenter center) {
		devCenterDao.save(center);
	}

	public DevCenterDao getDevCenterDao() {
		return devCenterDao;
	}

	public void setDevCenterDao(DevCenterDao devCenterDao) {
		this.devCenterDao = devCenterDao;
	}
}
