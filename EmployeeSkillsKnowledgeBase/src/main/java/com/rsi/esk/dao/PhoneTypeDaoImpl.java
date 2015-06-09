package com.rsi.esk.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rsi.esk.domain.PhoneType;

@Transactional
@Repository
public class PhoneTypeDaoImpl extends HibernateDao implements PhoneTypeDao {


    @SuppressWarnings("unchecked")
    public List<PhoneType> list() {
        Session session = getSessionFactory().openSession();
        List<PhoneType> phoneList = session.createQuery("from PhoneType").list();
        session.close();

        return phoneList;
    }

    public PhoneType getPhoneTypeByDescription(String description) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(
                "from PhoneType where phone_type_desc = :description");
        query.setParameter("description", description);

        return (PhoneType) (query.uniqueResult());
    }

    public PhoneType getPhoneTypeById(Long id) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(
                "from PhoneType where phone_type_id = :id");
        query.setParameter("id", id);

        return (PhoneType) (query.uniqueResult());
    }
}
