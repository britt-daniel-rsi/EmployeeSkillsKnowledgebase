package com.rsi.esk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rsi.esk.dao.SkillTypeDaoImpl;
import com.rsi.esk.domain.SkillType;

@Component
public class SkillTypeServiceImpl implements SkillTypeService  {

	@Autowired
	private SkillTypeDaoImpl skillTypeDao;
	
	@Override
	public List<SkillType> getAllSkillTypes(){
		return skillTypeDao.list();
	}
	
	@Override
	public void addSkill(SkillType skill){
		skillTypeDao.save(skill);
	}
	
	public void setSkillTypeDao(SkillTypeDaoImpl skillTypeDao){
		this.skillTypeDao = skillTypeDao;
	}
}
