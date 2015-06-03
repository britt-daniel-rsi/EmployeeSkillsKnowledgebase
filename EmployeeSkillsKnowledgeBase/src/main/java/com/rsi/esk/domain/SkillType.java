package com.rsi.esk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "esk.skill_type")
public class SkillType {
	@Id
	@Column(name = "skill_type_id", unique = true, nullable = false)
	private Integer Id;
	@NotNull
	@Column(name = "skill_type_desc")
	private String skillName;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
