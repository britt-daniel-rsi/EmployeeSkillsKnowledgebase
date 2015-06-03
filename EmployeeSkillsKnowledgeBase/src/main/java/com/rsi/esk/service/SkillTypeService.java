package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.dao.SkillTypeDaoImpl;
import com.rsi.esk.domain.SkillType;

public interface SkillTypeService {

	public abstract List<SkillType> getAllSkillTypes();

	public abstract void addSkill(SkillType skill);

	public abstract SkillTypeDaoImpl getSkillTypeDao();

	public abstract void setSkillTypeDao(SkillTypeDaoImpl skillTypeDao);

}