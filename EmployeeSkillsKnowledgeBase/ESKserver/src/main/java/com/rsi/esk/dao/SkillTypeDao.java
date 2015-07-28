package com.rsi.esk.dao;

import java.util.List;

import com.rsi.esk.domain.SkillType;

public interface SkillTypeDao {

	List<SkillType> list();

	void save(SkillType skillType);

}