package com.rsi.esk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.dom4j.tree.AbstractEntity;

@Entity
@Table(schema = "esk", name = "skill_type")
public class SkillType extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "skill_type_id", unique = true, nullable = false)
	private Long Id;
	@NotNull
	@Column(name = "skill_type_desc")
	private String skillName;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
