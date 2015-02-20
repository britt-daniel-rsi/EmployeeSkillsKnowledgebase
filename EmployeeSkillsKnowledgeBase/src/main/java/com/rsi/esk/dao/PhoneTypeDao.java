package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rsi.esk.domain.PhoneType;

public class PhoneTypeDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<PhoneType> list() {
		Session session = this.sessionFactory.openSession();
		List<PhoneType> phoneList = session.createQuery("from PhoneType").list();
		session.close();
		return phoneList;
	}
}
