package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rsi.esk.domain.User;


public class UserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Integer getMaxId() {
		Session session = this.sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select max(contactId) from dbo.contacts");
		List maxIds = query.list();
		System.out.println(maxIds.get(0));
		session.close();		
		return (Integer)maxIds.get(0);
		}

	public void save(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<User> list() {
		Session session = this.sessionFactory.openSession();
		List<User> personList = session.createQuery("from User").list();
		session.close();
		return personList;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> SurnameSearch(String surname){
		Session session = this.sessionFactory.openSession();
		List<User> personList = session.createQuery("from User as user where user.surname='"+surname+"'").list();
		session.close();
		return personList;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> IdSearch(Integer id){
		Session session = this.sessionFactory.openSession();
		List<User> personList = session.createQuery("from User as user where user.id='"+id+"'").list();
		session.close();
		return personList;
	}

}
