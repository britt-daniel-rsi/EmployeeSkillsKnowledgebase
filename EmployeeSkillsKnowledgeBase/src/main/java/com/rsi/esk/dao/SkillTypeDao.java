package com.rsi.esk.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rsi.esk.domain.SkillType;

public interface SkillTypeDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract List<SkillType> list();

	public abstract SkillType getSkillTypeByDescription(String description);

	public abstract SkillType getSkillTypeById(Long id);

	public abstract void save(SkillType skillType);

}