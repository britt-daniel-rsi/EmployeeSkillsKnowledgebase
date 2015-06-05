package com.rsi.esk.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rsi.esk.domain.SkillType;

@Transactional
@Repository
public class SkillTypeDaoImpl extends HibernateDao implements SkillTypeDao{
    
    @Override
	@SuppressWarnings("unchecked")
    public List<SkillType> list() {
        Session session = getSessionFactory().openSession();
        List<SkillType> skillList = session.createQuery("from SkillType").list();
        session.close();

        return skillList;
    }
    
  
	public SkillType getSkillTypeByDescription(String description) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(
                "from SkillType where type = :skillType");
        query.setParameter("skillType", description);

        return (SkillType) (query.uniqueResult());
    }

  
	public SkillType getSkillTypeById(Long id) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(
                "from SkillType where idskilltype = :skillTypeId");
        query.setParameter("skillTypeId", id);

        return (SkillType) (query.uniqueResult());
    }
	
	@Override
    public void save(SkillType skillType) {
        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(skillType);
        tx.commit();
        session.close();
    }

}
