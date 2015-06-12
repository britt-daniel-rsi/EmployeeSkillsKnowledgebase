package com.rsi.esk.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rsi.esk.criteria.EmployeeSearchCriteria;
import com.rsi.esk.domain.Employee;
import com.rsi.esk.util.NumberUtils;

@Transactional
@Repository
public class EmployeeDaoImpl extends HibernateDao implements EmployeeDao {


    @SuppressWarnings("rawtypes")
    public Long getMaxId() {
        Session session = getSessionFactory().openSession();
        SQLQuery query = session.createSQLQuery(
                "select max(employee_id) from esk.employee");
        List maxIds = query.list();
        System.out.println(maxIds.get(0));
        session.close();

        return (Long) maxIds.get(0);
    }

    public void save(Employee employee) {
        Session session = getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();
        session.persist(employee);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> list() {
        Session session = getSessionFactory().openSession();
        List<Employee> personList = session.createQuery("from Employee").list();
        session.close();

        return personList;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> SurnameSearch(String surname) {
        Session session = getSessionFactory().openSession();
        List<Employee> personList = session.createQuery(
                "from Employee where surname='" + surname + "'").list();
        session.close();

        return personList;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> IdSearch(Long id) {
        Session session = getSessionFactory().openSession();

        List<Employee> personList = session.createQuery(
                "from Employee where id='" + id + "'").list();
        session.close();

        return personList;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> search(EmployeeSearchCriteria searchCriteria) {
		Session session = getSessionFactory().openSession();
		
		Criteria criteria = buildEmployeeCriteria(searchCriteria, session);
		
		List<Employee> personList = criteria.list();
		
		session.close();
		
		return personList;
	}

	private Criteria buildEmployeeCriteria(EmployeeSearchCriteria searchCriteria, Session session) {
		Criteria criteria = session.createCriteria(Employee.class);
		
		if(searchCriteria != null) {
			if(NumberUtils.hasLong(searchCriteria.getId())) {
				criteria.add(Restrictions.eq("id", searchCriteria.getId()));
			}
			
			if(StringUtils.isNotBlank(searchCriteria.getSurname())) {
				criteria.add(Restrictions.eq("surname", searchCriteria.getSurname()));
			}
			
			if(searchCriteria.getCreateDate() != null) {
				criteria.add(Restrictions.eq("createDate", searchCriteria.getCreateDate()));
			}
			
			if(searchCriteria.getBirthDate() != null) {
				criteria.add(Restrictions.eq("birthDate", searchCriteria.getBirthDate()));
			}
		}
		
		return criteria;
	}
	
}
