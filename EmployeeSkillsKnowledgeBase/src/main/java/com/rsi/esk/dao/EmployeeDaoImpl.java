package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rsi.esk.domain.Employee;

@Transactional
@Repository
public class EmployeeDaoImpl extends HibernateDao implements EmployeeDao {


    @SuppressWarnings("rawtypes")
    public Long getMaxId() {
        Session session = getSessionFactory().getCurrentSession();
        SQLQuery query = session.createSQLQuery(
                "select max(employee_id) from esk.employee");
        List maxIds = query.list();
        System.out.println(maxIds.get(0));
        session.close();

        return (Long) maxIds.get(0);
    }

    public void save(Employee employee) {
        Session session = getSessionFactory().getCurrentSession();

        Transaction tx = session.beginTransaction();
        session.persist(employee);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> list() {
        Session session = getSessionFactory().getCurrentSession();
        List<Employee> personList = session.createQuery("from Employee").list();
        session.close();

        return personList;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> SurnameSearch(String surname) {
        Session session = getSessionFactory().getCurrentSession();
        List<Employee> personList = session.createQuery(
                "from Employee where surname='" + surname + "'").list();
        session.close();

        return personList;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> IdSearch(Long id) {
        Session session = getSessionFactory().getCurrentSession();

        List<Employee> personList = session.createQuery(
                "from Employee where id='" + id + "'").list();
        session.close();

        return personList;
    }
	
}
