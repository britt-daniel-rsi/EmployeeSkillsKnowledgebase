package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rsi.esk.domain.User;

@Transactional
@Repository
public class UserDaoImpl extends HibernateDao implements UserDao{


	@Override
    public Long getNextId() {
        Session session = getSessionFactory().getCurrentSession();
        
        Criteria criteria = session.createCriteria(User.class)
        		.setProjection(Projections.max("id"));
        Long maxId = (Long)criteria.uniqueResult();
        session.close();

        return maxId;
    }

	@Override
	public void saveOrUpdate(User user) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);

        tx.commit();
        session.close();
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = getSessionFactory().getCurrentSession();
        List<User> userList = session.createCriteria(User.class).list();
        session.close();

        return userList;
    }

	@Override
    public User findByUserName(String userName) {
        Session session = getSessionFactory().getCurrentSession();
        
        Criteria criteria = session.createCriteria(User.class)
        		.add(Restrictions.eq("userName",userName));
        
        User user = (User)(criteria.uniqueResult());
        session.close();
        return user;
    }

	@Override
	public User findById(Long id) {
		Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        
        criteria.add(Restrictions.eq("id", id));
        

        return (User)(criteria.uniqueResult());
	}
  
}
