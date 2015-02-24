package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rsi.esk.domain.Phone;

public class PhoneDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Integer getMaxId() {
		Session session = this.sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select max(contactId) from dbo.phonenumber");
		List maxIds = query.list();
		System.out.println(maxIds.get(0));
		session.close();
		
		return (Integer)maxIds.get(0);
		}
		
	public void save(Phone phone){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(phone);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Phone> list() {
		Session session = this.sessionFactory.openSession();
		List<Phone> phoneList = session.createQuery("from Phone").list();
		session.close();
		return phoneList;
	}
	
}