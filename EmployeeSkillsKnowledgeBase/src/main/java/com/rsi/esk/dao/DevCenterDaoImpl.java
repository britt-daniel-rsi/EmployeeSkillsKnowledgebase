package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rsi.esk.domain.DevCenter;

public class DevCenterDaoImpl implements DevCenterDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
	public List<DevCenter> list() {

        Session session = this.sessionFactory.openSession();
        List<DevCenter> personList = session.createQuery("from DevCenter").list();
        session.close();

        return personList;
    }

	public void save(DevCenter center) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(center);
        tx.commit();
        session.close();
		
	}

}
