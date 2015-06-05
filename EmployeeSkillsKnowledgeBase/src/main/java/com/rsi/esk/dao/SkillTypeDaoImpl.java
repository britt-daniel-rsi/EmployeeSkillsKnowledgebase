package com.rsi.esk.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rsi.esk.domain.SkillType;

public class SkillTypeDaoImpl implements SkillTypeDao{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
	@SuppressWarnings("unchecked")
    public List<SkillType> list() {
        Session session = this.sessionFactory.openSession();
        List<SkillType> skillList = session.createQuery("from SkillType").list();
        session.close();

        return skillList;
    }
    
  
	public SkillType getSkillTypeByDescription(String description) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery(
                "from SkillType where type = :skillType");
        query.setParameter("skillType", description);

        return (SkillType) (query.uniqueResult());
    }

  
	public SkillType getSkillTypeById(Long id) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery(
                "from SkillType where idskilltype = :skillTypeId");
        query.setParameter("skillTypeId", id);

        return (SkillType) (query.uniqueResult());
    }
	
	@Override
    public void save(SkillType skillType) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(skillType);
        tx.commit();
        session.close();
    }

}
