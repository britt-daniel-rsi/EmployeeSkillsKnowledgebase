package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.rsi.esk.domain.User;

@Transactional
@Repository
public class UserDaoImpl extends HibernateDao implements UserDao{


	@Override
	@SuppressWarnings("rawtypes")
    public Long getMaxId() {
        Session session = getSessionFactory().openSession();
        SQLQuery query = session.createSQLQuery(
                "select max(user_id) from esk.user");
        List maxIds = query.list();
        System.out.println(maxIds.get(0));
        session.close();

        return (Long) maxIds.get(0);
    }

	@Override
	public void save(User user) {
        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = getSessionFactory().openSession();
        List<User> userList = session.createQuery("from User").list();
        session.close();

        return userList;
    }

	@Override
	@SuppressWarnings("unchecked")
    public User findByUserName(String userName) {
        Session session = getSessionFactory().openSession();
        List<User> userList = session.createQuery(
                "from User where userName='" + userName + "'").list();
        session.close();
        if(!CollectionUtils.isEmpty(userList)) {
        	return userList.get(0);
        }
        return null;
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<User> IdSearch(Long id) {
        Session session = getSessionFactory().openSession();
        List<User> userList = session.createQuery(
                "from User where id='" + id + "'").list();
        session.close();

        return userList;
    }


    


}
