package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rsi.esk.domain.User;

@Transactional
@Repository
public class UserDaoImpl extends HibernateDao implements UserDao {

	@Override
	@SuppressWarnings("rawtypes")
	public Long getMaxId() {
		Session session = getSessionFactory().openSession();
		SQLQuery query = session
				.createSQLQuery("select max(user_id) from esk.user");
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
	public User findByUserName(String userName) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		User user = (User) (criteria.uniqueResult());

		return user;
	}

}
