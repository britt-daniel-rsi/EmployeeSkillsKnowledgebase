package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rsi.esk.domain.Phone;
import com.rsi.esk.util.NumberUtils;

@Transactional
@Repository
public class PhoneDaoImpl extends HibernateDao implements PhoneDao {

	@SuppressWarnings("rawtypes")
	public Long getMaxId() {
		Session session = getSessionFactory().openSession();
		SQLQuery query = session
				.createSQLQuery("select max(phone_id) from esk.employee_phone");
		List maxIds = query.list();
		System.out.println(maxIds.get(0));
		session.close();

		Long value = (Long) maxIds.get(0);

		if (NumberUtils.hasLong(value)) {
			return value;
		}

		return Long.valueOf(0);
	}

	public void save(Phone phone) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(phone);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Phone> list() {
		Session session = getSessionFactory().openSession();
		List<Phone> phoneList = session.createQuery("from Phone").list();
		session.close();

		return phoneList;
	}
}
