package com.rsi.esk.dao;

import com.rsi.esk.domain.PhoneType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


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

    public PhoneType getPhoneTypeByDescription(String description) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery(
                "from PhoneType where phone_type_desc = :description");
        query.setParameter("description", description);

        return (PhoneType) (query.uniqueResult());
    }

    public PhoneType getPhoneTypeById(Long id) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery(
                "from PhoneType where phone_type_id = :id");
        query.setParameter("id", id);

        return (PhoneType) (query.uniqueResult());
    }
}
