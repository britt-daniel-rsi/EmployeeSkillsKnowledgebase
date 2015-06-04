package com.rsi.esk.dao;

import com.rsi.esk.domain.Employee;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class EmployeeDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Employee employee) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(employee);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> list() {
        Session session = this.sessionFactory.openSession();
        List<Employee> personList = session.createQuery("from Employee").list();
        session.close();

        return personList;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> SurnameSearch(String surname) {
        Session session = this.sessionFactory.openSession();
        List<Employee> personList = session.createQuery(
                "from Employee where surname='" + surname + "'").list();
        session.close();

        return personList;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> IdSearch(Integer id) {
        Session session = this.sessionFactory.openSession();
        List<Employee> personList = session.createQuery(
                "from Employee where id='" + id + "'").list();
        session.close();

        return personList;
    }
}
