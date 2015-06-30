package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rsi.esk.domain.EmployeeSkill;
import com.rsi.esk.util.NumberUtils;

@Transactional
@Repository
public class EmployeeSkillDaoImpl implements EmployeeSkillDao {
    private SessionFactory sessionFactory;

    @Override
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
	@SuppressWarnings("rawtypes")
    public Long getMaxId() {
        Session session = this.sessionFactory.openSession();
        SQLQuery query = session.createSQLQuery(
                "select max(employee_skill_id) from esk.employee_skill_xref");
        List maxIds = query.list();
        System.out.println(maxIds.get(0));
        session.close();

        Long value = (Long) maxIds.get(0);

        if (NumberUtils.hasLong(value)) {
            return value;
        }

        return Long.valueOf(0);
    }

    @Override
	public void save(EmployeeSkill employeeSkill) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(employeeSkill);
        tx.commit();
        session.close();
    }

    @Override
	@SuppressWarnings("unchecked")
    public List<EmployeeSkill> list() {
        Session session = this.sessionFactory.openSession();
        List<EmployeeSkill> employeeSkillList = session.createQuery("from EmployeeSkill").list();
        session.close();
        return employeeSkillList;
    }
}
