package com.rsi.esk.service;

import java.util.List;

import com.rsi.esk.domain.SkillType;

public interface SkillTypeService {

	List<SkillType> getAllSkillTypes();

	void addSkill(SkillType skill);

}