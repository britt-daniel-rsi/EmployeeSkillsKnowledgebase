package com.rsi.esk.dao;

import com.rsi.esk.domain.Phone;
import com.rsi.esk.util.NumberUtils;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class PhoneDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("rawtypes")
    public Integer getMaxId() {
        Session session = this.sessionFactory.openSession();
        SQLQuery query = session.createSQLQuery(
                "select max(phoneId) from dbo.phonenumber");
        List maxIds = query.list();
        System.out.println(maxIds.get(0));
        session.close();

        Integer value = (Integer) maxIds.get(0);

        if (NumberUtils.hasInteger(value)) {
            return value;
        }

        return Integer.valueOf(0);
    }

    public void save(Phone phone) {
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
