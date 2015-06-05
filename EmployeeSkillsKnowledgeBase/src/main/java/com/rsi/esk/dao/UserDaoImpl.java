package com.rsi.esk.dao;

import com.rsi.esk.domain.User;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	@SuppressWarnings("rawtypes")
    public Integer getMaxId() {
        Session session = this.sessionFactory.openSession();
        SQLQuery query = session.createSQLQuery(
                "select max(user_id) from esk.user");
        List maxIds = query.list();
        System.out.println(maxIds.get(0));
        session.close();

        return (Integer) maxIds.get(0);
    }

	@Override
	public void save(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("from User").list();
        session.close();

        return userList;
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<User> userNameSearch(String userName) {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery(
                "from User where userName='" + userName + "'").list();
        session.close();

        return userList;
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<User> IdSearch(Integer id) {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery(
                "from User where id='" + id + "'").list();
        session.close();

        return userList;
    }
}
