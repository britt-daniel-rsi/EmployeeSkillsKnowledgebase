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

    @SuppressWarnings("rawtypes")
    public Integer getMaxId() {
        Session session = this.sessionFactory.openSession();
        SQLQuery query = session.createSQLQuery(
                "select max(employee_id) from esk.employee");
        List maxIds = query.list();
        System.out.println(maxIds.get(0));
        session.close();

        return (Integer) maxIds.get(0);
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
