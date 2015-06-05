package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rsi.esk.domain.DevCenter;

@Transactional
@Repository
public class DevCenterDaoImpl extends HibernateDao implements DevCenterDao {

    
    @SuppressWarnings("unchecked")
	public List<DevCenter> list() {

        Session session = getSessionFactory().openSession();
        List<DevCenter> personList = session.createQuery("from DevCenter").list();
        session.close();

        return personList;
    }

	public void save(DevCenter center) {
        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(center);
        tx.commit();
        session.close();
		
	}

}
