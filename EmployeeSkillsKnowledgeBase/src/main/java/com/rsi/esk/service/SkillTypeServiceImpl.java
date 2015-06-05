package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.dao.SkillTypeDaoImpl;
import com.rsi.esk.domain.SkillType;
public class SkillTypeServiceImpl implements SkillTypeService  {

	private SkillTypeDaoImpl skillTypeDao;
	
	@Override
	public List<SkillType> getAllSkillTypes(){
		return skillTypeDao.list();
	}
	
	@Override
	public void addSkill(SkillType skill){
		skillTypeDao.save(skill);
	}
	
	@Override
	public SkillTypeDaoImpl getSkillTypeDao(){
		return skillTypeDao;
	}
	
	public void setSkillTypeDao(SkillTypeDaoImpl skillTypeDao){
		this.skillTypeDao = skillTypeDao;
	}
}
